package com.example.vectorservice.model;

public class EmbeddingResponse {
    private String contentId;
    private float[] vector;

    public EmbeddingResponse(String contentId, float[] vector) {
        this.contentId = contentId;
        this.vector = vector;
    }

    public String getContentId() {
        return contentId;
    }

    public float[] getVector() {
        return vector;
    }
}