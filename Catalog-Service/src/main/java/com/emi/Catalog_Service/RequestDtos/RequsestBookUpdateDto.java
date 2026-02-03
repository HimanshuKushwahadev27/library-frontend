package com.emi.Catalog_Service.RequestDtos;

import java.math.BigDecimal;
import java.util.Map;


public record RequsestBookUpdateDto (
		
		BigDecimal price,
		String title,
		String description,
		Boolean freePreviewAvailable,
		Map<String, String> genreInfo
		)
{

}
