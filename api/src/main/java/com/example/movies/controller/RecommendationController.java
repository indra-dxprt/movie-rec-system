package com.example.movies.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/movies")
public class RecommendationController {

  private final RestTemplate restTemplate;
  private final String recommenderBaseUrl;

  public RecommendationController(RestTemplate restTemplate,
                                  @Value("${app.recommender.base-url}") String recommenderBaseUrl) {
    this.restTemplate = restTemplate;
    this.recommenderBaseUrl = recommenderBaseUrl;
  }

  @GetMapping("/recommendations")
  public ResponseEntity<String> getRecommendations(@RequestParam("movieId") Long movieId) {
    String url = recommenderBaseUrl + "/recommend?movieId=" + movieId;
    String response = restTemplate.getForObject(url, String.class);
    return ResponseEntity.ok(response);
  }
}
