package com.example.embeddings_search;

import org.springframework.ai.document.Document;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmbeddingController {

    private final EmbeddingService embeddingService;

    public EmbeddingController(EmbeddingService embeddingService) {
        this.embeddingService = embeddingService;
    }

    @PostMapping("/store")
    public String storeText(@RequestBody String text) {
        embeddingService.storeTextAsEmbeddings(text);
        return "Text received and sent for embedding and storage.";
    }

    // New GET endpoint for searching
    @GetMapping("/search")
    public List<Document> search(@RequestParam(value = "query") String query) {
        return embeddingService.searchForSimilarTexts(query);
    }
}