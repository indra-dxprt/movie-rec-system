package com.example.movies.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "movies")
public class Movie {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Column(nullable = false)
  private String title;

  @NotBlank
  @Column(nullable = false)
  private String genre;

  @Min(0) @Max(10)
  private Double rating;

  private Integer year;

  public Movie() {}

  public Movie(String title, String genre, Double rating, Integer year) {
    this.title = title;
    this.genre = genre;
    this.rating = rating;
    this.year = year;
  }

  // getters & setters
  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }
  public String getTitle() { return title; }
  public void setTitle(String title) { this.title = title; }
  public String getGenre() { return genre; }
  public void setGenre(String genre) { this.genre = genre; }
  public Double getRating() { return rating; }
  public void setRating(Double rating) { this.rating = rating; }
  public Integer getYear() { return year; }
  public void setYear(Integer year) { this.year = year; }
}
