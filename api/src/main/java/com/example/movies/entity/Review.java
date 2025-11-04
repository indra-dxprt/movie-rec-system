package com.example.movies.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "reviews")
public class Review {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "movie_id", nullable = false)
  private Movie movie;

  @NotBlank
  private String reviewer;

  @NotNull
  @Min(1) @Max(10)
  private Integer stars;

  @Size(max = 1000)
  private String comment;

  public Review() {}

  // getters & setters
  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }
  public Movie getMovie() { return movie; }
  public void setMovie(Movie movie) { this.movie = movie; }
  public String getReviewer() { return reviewer; }
  public void setReviewer(String reviewer) { this.reviewer = reviewer; }
  public Integer getStars() { return stars; }
  public void setStars(Integer stars) { this.stars = stars; }
  public String getComment() { return comment; }
  public void setComment(String comment) { this.comment = comment; }
}
