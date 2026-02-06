package com.emi.Authoring_service.ResponseDtos;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

import com.emi.Authoring_service.enums.BookStatus;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description="Response DTO for book draft")
public record ResponseDraftBookDto(
		
		UUID draftBookId,
		UUID authorId,
		String title,
		String description,
		String isbn,
		BigDecimal price,
		BookStatus status,
		Boolean freePreview,
		Instant createdAt,
		Instant updatedAt
		
		) {

}
