package com.emi.Authoring_service.ServiceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.emi.Authoring_service.Repository.DraftBookRepo;
import com.emi.Authoring_service.RequestDtos.RequestBookCreateDto;
import com.emi.Authoring_service.RequestDtos.RequestUpdateDraftBookDto;
import com.emi.Authoring_service.ResponseDtos.ResponseDraftBookDto;
import com.emi.Authoring_service.entity.AuthorDraftBook;
import com.emi.Authoring_service.enums.BookStatus;
import com.emi.Authoring_service.exceptions.BookAlreadyExistsException;
import com.emi.Authoring_service.exceptions.DeletedException;
import com.emi.Authoring_service.exceptions.DraftNotFoundException;
import com.emi.Authoring_service.exceptions.NotAuthorizedException;
import com.emi.Authoring_service.mapper.BookDraftMapper;
import com.emi.Authoring_service.service.DraftBookService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookDraftServiceImpl implements DraftBookService {

	private final BookDraftMapper bookDraftMapper;
	private final DraftBookRepo bookDraftRepo;
	
	@Transactional
	@Override
	public ResponseDraftBookDto createBookDraft(RequestBookCreateDto request) {
		
		if(bookDraftRepo.existsByIsbn(request.isbn())) {
			throw new BookAlreadyExistsException("Book with the isbn "+ request.isbn()+" already exists");
		}
		
		var draftBook = bookDraftMapper.toEntity(request);
		bookDraftRepo.save(draftBook);
		
		return bookDraftMapper.toDto(draftBook);
	}

	@Transactional
	@Override
	public ResponseDraftBookDto updateBookDraft(RequestUpdateDraftBookDto request) {
		
		AuthorDraftBook bookDraft = bookDraftRepo
				      .findById(request.id())
				      .orElseThrow(
				    		  () -> new DraftNotFoundException("Book Draft for the id " + request.id() + "not found")
				    		  );
		
		if(bookDraft.getAuthorId()!=request.authorId()) {
			throw new NotAuthorizedException("You are not permitted to access the book draft with id " + request.id());
		}
		
		if(bookDraft.getStatus() == BookStatus.DELETED){
			throw new DeletedException("Book draft with id " + request.id() + " already deleted" );
		}
		
		bookDraft = bookDraftMapper.updateDraft( request);
		bookDraftRepo.save(bookDraft);
		
		return bookDraftMapper.toDto(bookDraft);
	}

	@Override
	public List<ResponseDraftBookDto> getMyDraftBooks(UUID authorId) {
		
		List<AuthorDraftBook> bookDrafts = bookDraftRepo
				         		.findAllByAuthorId(authorId)
				         		.orElseThrow(() -> new DraftNotFoundException("No drafted books for authorId " + authorId));
		
		
		
		return bookDrafts
				.stream()
				.filter(t -> !t.isDeleted())
				.map(bookDraftMapper::toDto)
				.toList();
		
	}

	@Override
	public ResponseDraftBookDto getMyDraftBooksById(UUID authorId, UUID draftBookId) {
		
		AuthorDraftBook bookDraft = bookDraftRepo
			      .findByAuthorIdAndId(authorId, draftBookId)
			      .orElseThrow(
			    		  () -> new DraftNotFoundException("Book Draft for the id " + draftBookId + "not found")
			    		  );
		
		if(bookDraft.getStatus() == BookStatus.DELETED){
			throw new DeletedException("Book draft with id " + draftBookId + " already deleted" );
		}
		
		return bookDraftMapper.toDto(bookDraft);
	}

	@Override
	public String deleteDraftBookById(UUID bookId, UUID authorId) {
		AuthorDraftBook bookDraft = bookDraftRepo
			      .findByAuthorIdAndId(authorId, bookId)
			      .orElseThrow(
			    		  () -> new DraftNotFoundException("Book Draft for the id " + bookId + "not found")
			    		  );
		
		if(bookDraft.getStatus() == BookStatus.DELETED){
			throw new DeletedException("Book draft with id " + bookId + " already deleted" );
		}

		
		bookDraft.setDeleted(true);
		bookDraft.setStatus(BookStatus.DELETED);
		
		return "Book draft with id " + bookId + "of author " +authorId+ "is deleted !!";
	}

	@Override
	public ResponseDraftBookDto publishDraftedBook(UUID draftBookId, UUID authorId) {
		return null;
	}

}
