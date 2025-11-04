from fastapi import FastAPI, HTTPException
from fastapi.responses import JSONResponse
import httpx
import os

app = FastAPI(title="Recommender Service", version="1.0.0")

API_BASE = os.getenv("API_BASE_URL", "http://api:8080")

@app.get("/health")
def health():
    return {"status": "ok"}

@app.get("/recommend")
async def recommend(movieId: int):
    """
    Very simple recommender:
    1) fetch the seed movie from API
    2) fetch all movies from API
    3) recommend up to 5 movies of the same genre, ordered by rating desc, excluding the seed
    """
    async with httpx.AsyncClient(timeout=10.0) as client:
        # get the seed movie
        m = await client.get(f"{API_BASE}/api/movies/{movieId}")
        if m.status_code == 404:
            raise HTTPException(status_code=404, detail="Seed movie not found")
        m.raise_for_status()
        movie = m.json()

        # get all and filter
        r = await client.get(f"{API_BASE}/api/movies")
        r.raise_for_status()
        all_movies = r.json()

    genre = (movie.get("genre") or "").strip().lower()
    seed_id = movie.get("id")
    candidates = [
        mm for mm in all_movies
        if mm.get("id") != seed_id and (mm.get("genre") or "").strip().lower() == genre
    ]
    # sort by rating desc, None -> 0
    candidates.sort(key=lambda x: (x.get("rating") or 0.0), reverse=True)
    return JSONResponse({
        "movieId": seed_id,
        "seedTitle": movie.get("title"),
        "genre": movie.get("genre"),
        "recommendations": candidates[:5]
    })
