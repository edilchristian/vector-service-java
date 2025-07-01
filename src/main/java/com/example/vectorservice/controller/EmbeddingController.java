package com.example.vectorservice.controller;

import com.example.vectorservice.model.EmbeddingResponse;
import com.example.vectorservice.service.EmbeddingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/embedding")
public class EmbeddingController {

    private final EmbeddingService embeddingService;

    public EmbeddingController(EmbeddingService embeddingService) {
        this.embeddingService = embeddingService;
    }

    @GetMapping("/{contentId}")
    public EmbeddingResponse getEmbedding(@PathVariable String contentId) {
        return embeddingService.getEmbedding(contentId);
    }
}