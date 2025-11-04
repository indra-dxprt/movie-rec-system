package com.example.movies.service;

import com.example.movies.entity.Movie;
import com.example.movies.entity.Review;
import com.example.movies.repository.MovieRepository;
import com.example.movies.repository.ReviewRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReviewService {
  private final ReviewRepository reviewRepo;
  private final MovieRepository movieRepo;

  public ReviewService(ReviewRepository reviewRepo, MovieRepository movieRepo) {
    this.reviewRepo = reviewRepo;
    this.movieRepo = movieRepo;
  }

  public Review add(Long movieId, Review r) {
    Movie m = movieRepo.findById(movieId)
        .orElseThrow(() -> new IllegalArgumentException("Movie not found: " + movieId));
    r.setMovie(m);
    return reviewRepo.save(r);
  }

  public List<Review> forMovie(Long movieId) {
    return reviewRepo.findByMovie_Id(movieId);
  }
}
