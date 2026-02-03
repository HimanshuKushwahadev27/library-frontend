package com.emi.Catalog_Service.RequestDtos;

import java.math.BigDecimal;
import java.util.Map;

public record RequestBookCreationDto(
		String title,
		String ISBN,
		BigDecimal price,
		Map<String ,String> authorInfo,
		Map<String, String> genreInfo,
		Boolean freePreviewAvailable,
		String description
		) {
}
