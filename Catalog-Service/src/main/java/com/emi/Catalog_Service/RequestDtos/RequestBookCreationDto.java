package com.emi.Catalog_Service.RequestDtos;

import java.math.BigDecimal;
import java.util.Map;
import java.util.UUID;

public record RequestBookCreationDto(
		String title,
		String ISBN,
		BigDecimal price,
		Map<UUID ,String> authorInfo,
		Map<UUID, String> genreInfo,
		Boolean freePreviewAvailable,
		String description
		) {
}
