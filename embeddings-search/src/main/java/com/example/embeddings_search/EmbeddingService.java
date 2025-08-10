package com.example.embeddings_search;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmbeddingService {

    private static final Logger logger = LoggerFactory.getLogger(EmbeddingService.class);

    private final VectorStore vectorStore;
    private final EmbeddingModel embeddingModel;

    public EmbeddingService (VectorStore vectorStore, EmbeddingModel embeddingModel) {
        this.vectorStore = vectorStore;
        this.embeddingModel = embeddingModel;
    }

    public void storeTextAsEmbeddings(String text) {
        // Create a Document object from your text.
        // You can also add metadata (e.g., source, author, etc.).
        Document document = new Document(text);

        // Spring AI automatically handles the embedding generation and storage.
        // It uses the injected EmbeddingClient to get the vector and then stores it
        // in the VectorStore (in this case, pgvector).
        vectorStore.add(List.of(document));

        logger.info("Document stored in vector database successfully.");
    }

    // New method for searching
    public List<Document> searchForSimilarTexts(String query) {
        // The `similaritySearch` method takes a query string.
        // Spring AI handles the following automatically:
        // 1. It uses the `EmbeddingClient` to convert the `query` string into a vector embedding.
        // 2. It sends this vector to the `VectorStore` (pgvector in our case).
        // 3. The vector database performs a similarity search (e.g., using cosine distance).
        // 4. It returns the documents that are most semantically similar to the query.
        return vectorStore.similaritySearch(query);
    }

    public List<Document> advancedSearch(String query) {
        // You can configure the search to:
        // - Get a specific number of results (topK)
        // - Set a similarity threshold (documents must be above this value)
        // - Add metadata filters
        SearchRequest searchRequest = SearchRequest.builder()
                .query(query)
                .topK(2)
                .similarityThreshold(0.7) // Only return results with a similarity > 0.7
                .build();

        return vectorStore.similaritySearch(searchRequest);
    }
}