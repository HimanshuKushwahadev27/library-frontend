package com.emi.Catalog_Service.ResponseDtos;

import java.util.List;
import java.util.UUID;

public record ResponseFullBookDto(
		
		String title,
		String description,
		String ISBN,
		String price,
		List<UUID> authorIds,
		List<UUID> genreIds,
		String status,
		Integer totalChapters,
		List<UUID> chapterIds,
		Boolean freePreview
		) {
}
