package com.example.movies.repository;

import com.example.movies.entity.Review;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
  List<Review> findByMovie_Id(Long movieId);
}
