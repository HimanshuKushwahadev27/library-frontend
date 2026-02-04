package com.emi.Catalog_Service.ResponseDtos;

import java.util.UUID;

public record ResponseBookDto (
		
		UUID bookId,
		String status,
		Integer totalChapters, 
		String message
		){
}
