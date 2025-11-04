package com.example.movies.repository;

import com.example.movies.entity.Movie;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
  List<Movie> findByTitleContainingIgnoreCase(String q);
  List<Movie> findTop10ByOrderByRatingDesc();
  List<Movie> findByGenreIgnoreCase(String genre);
}
