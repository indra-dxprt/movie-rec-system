package com.example.movies.service;

import com.example.movies.dto.RecommendationResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Map;

@Service
public class RecommendationService {

  private final RestClient restClient;
  private final String baseUrl;

  public RecommendationService(RestClient restClient,
                               @Value("${recommender.base-url}") String baseUrl) {
    this.restClient = restClient;
    this.baseUrl = baseUrl;
  }

  public RecommendationResponse requestRecommendations(Map<Long, Double> avgRatings,
                                                       List<Long> alreadyReviewed,
                                                       int limit) {
    record Payload(Map<Long, Double> averages, List<Long> exclude, int limit) {}
    Payload payload = new Payload(avgRatings, alreadyReviewed, limit);

    return restClient.post()
        .uri(baseUrl + "/recommend")
        .contentType(MediaType.APPLICATION_JSON)
        .body(payload)
        .retrieve()
        .body(RecommendationResponse.class);
  }
}
