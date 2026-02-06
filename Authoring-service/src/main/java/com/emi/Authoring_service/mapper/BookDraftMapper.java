package com.emi.Authoring_service.mapper;

import java.time.Instant;

import org.springframework.stereotype.Component;

import com.emi.Authoring_service.RequestDtos.RequestBookCreateDto;
import com.emi.Authoring_service.RequestDtos.RequestUpdateDraftBookDto;
import com.emi.Authoring_service.ResponseDtos.ResponseDraftBookDto;
import com.emi.Authoring_service.entity.AuthorDraftBook;

@Component
public class BookDraftMapper {

	public AuthorDraftBook toEntity(RequestBookCreateDto request) {
		
		AuthorDraftBook draftBook= new AuthorDraftBook();
		draftBook.setAuthorId(request.authorId());
		draftBook.setDescription(request.description());
		draftBook.setFreePreview(request.freePreview());
		draftBook.setIsbn(request.isbn());
		draftBook.setStatus(request.status());
		draftBook.setPrice(request.price());
		draftBook.setTitle(request.title());
		draftBook.setUpdatedAt(Instant.now());
		draftBook.setCreatedAt(Instant.now());
		
		return draftBook;
	}

	public ResponseDraftBookDto toDto(AuthorDraftBook draftBook) {
		return new ResponseDraftBookDto(
				draftBook.getId(),
				draftBook.getAuthorId(),
				draftBook.getTitle(),
				draftBook.getDescription(),
				draftBook.getIsbn(),
				draftBook.getPrice(),
				draftBook.getStatus(),
				draftBook.getFreePreview(),
				draftBook.getCreatedAt(),
				draftBook.getUpdatedAt()
				);
							     
	}

	public AuthorDraftBook updateDraft(RequestUpdateDraftBookDto request) {
		
		
		AuthorDraftBook draftBook= new AuthorDraftBook();
		draftBook.setDescription(request.description());
		draftBook.setFreePreview(request.freePreview());
		draftBook.setStatus(request.status());
		draftBook.setPrice(request.price());
		draftBook.setTitle(request.title());
		draftBook.setUpdatedAt(Instant.now());
		
		return draftBook;
		
	}

}
