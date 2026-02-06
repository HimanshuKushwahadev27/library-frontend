package com.emi.Authoring_service.RequestDtos;

import java.math.BigDecimal;
import java.util.UUID;

import com.emi.Authoring_service.enums.BookStatus;

public record RequestUpdateDraftBookDto(
		
		 UUID id,
		 UUID authorId,
		 String title,
		 String description,
		 BigDecimal price,
		 BookStatus status,
		 Boolean freePreview
		) {

}
