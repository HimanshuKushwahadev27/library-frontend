package com.emi.Catalog_Service.RequestDtos;

import java.math.BigDecimal;
import java.util.Map;
import java.util.UUID;



public record RequsestBookUpdateDto (
		
		UUID bookId,
		BigDecimal price,
		String title,
		String description,
		Boolean freePreviewAvailable,
		Map<UUID, String> genreInfo
		)
{

}
