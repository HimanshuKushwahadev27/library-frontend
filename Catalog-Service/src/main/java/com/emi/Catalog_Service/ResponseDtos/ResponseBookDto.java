package com.emi.Catalog_Service.ResponseDtos;

import java.util.UUID;




public record ResponseBookDto (
		UUID id,
		String status,
		Integer totalChapters, 
		String message
		){
}
