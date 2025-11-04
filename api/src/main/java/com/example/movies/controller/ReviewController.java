package com.example.movies.controller;

import com.example.movies.entity.Review;
import com.example.movies.service.ReviewService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

  private final ReviewService reviewService;

  public ReviewController(ReviewService reviewService) {
    this.reviewService = reviewService;
  }

  @PostMapping
  public ResponseEntity<Review> add(@RequestParam("movieId") Long movieId,
                                    @Valid @RequestBody Review review) {
    return ResponseEntity.ok(reviewService.add(movieId, review));
  }

  @GetMapping
  public List<Review> list(@RequestParam("movieId") Long movieId) {
    return reviewService.forMovie(movieId);
  }
}
