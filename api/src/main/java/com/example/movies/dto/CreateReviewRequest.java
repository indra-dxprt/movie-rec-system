package com.example.movies.dto;

import jakarta.validation.constraints.*;

public class CreateReviewRequest {
  @NotNull
  private Long userId;
  @NotNull
  private Long movieId;
  @NotNull
  @DecimalMin("0.0") @DecimalMax("5.0")
  private Double rating;
  private String comment;

  public Long getUserId() { return userId; }
  public void setUserId(Long userId) { this.userId = userId; }
  public Long getMovieId() { return movieId; }
  public void setMovieId(Long movieId) { this.movieId = movieId; }
  public Double getRating() { return rating; }
  public void setRating(Double rating) { this.rating = rating; }
  public String getComment() { return comment; }
  public void setComment(String comment) { this.comment = comment; }
}
