package com.example.movies.controller;

import com.example.movies.entity.Movie;
import com.example.movies.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

  private final MovieService movieService;

  public MovieController(MovieService movieService) {
    this.movieService = movieService;
  }

  @GetMapping
  public List<Movie> list() {
    return movieService.list();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Movie> get(@PathVariable Long id) {
    return movieService.get(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<Movie> create(@Valid @RequestBody Movie movie) {
    return ResponseEntity.ok(movieService.save(movie));
  }

  @GetMapping("/search")
  public List<Movie> search(@RequestParam("q") String query) {
    return movieService.search(query);
  }

  @GetMapping("/top-rated")
  public List<Movie> topRated() {
    return movieService.topRated();
  }

  // small helper for recommender service
  @GetMapping("/by-genre")
  public List<Movie> byGenre(@RequestParam("genre") String genre) {
    return movieService.byGenre(genre);
  }
}
