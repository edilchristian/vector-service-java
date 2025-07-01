package com.example.vectorservice.service;

import com.example.vectorservice.model.EmbeddingResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmbeddingService {

    private final Map<String, float[]> embeddingStore = new HashMap<>();

    @PostConstruct
    public void loadEmbeddings() {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("mock_embeddings.json")) {
            ObjectMapper mapper = new ObjectMapper();
            Map<String, double[]> rawMap = mapper.readValue(is, new TypeReference<>() {});
            for (Map.Entry<String, double[]> entry : rawMap.entrySet()) {
                float[] vector = new float[entry.getValue().length];
                for (int i = 0; i < vector.length; i++) {
                    vector[i] = (float) entry.getValue()[i];
                }
                embeddingStore.put(entry.getKey(), vector);
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to load mock embeddings", e);
        }
    }

    public EmbeddingResponse getEmbedding(String contentId) {
        float[] vector = embeddingStore.getOrDefault(contentId, new float[0]);
        return new EmbeddingResponse(contentId, vector);
    }
}