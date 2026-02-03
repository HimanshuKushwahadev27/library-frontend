package com.emi.Catalog_Service.ServiceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;

import com.emi.Catalog_Service.RequestDtos.RequestBookCreationDto;
import com.emi.Catalog_Service.RequestDtos.RequsestBookUpdateDto;
import com.emi.Catalog_Service.ResponseDtos.ResponseBookDto;
import com.emi.Catalog_Service.ResponseDtos.ResponseFullBookDto;
import com.emi.Catalog_Service.Services.BookReadOnly;

public class BookReadServiceImpl implements BookReadOnly {

	@Override
	public ResponseBookDto createBook(RequestBookCreationDto requestDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseFullBookDto getBookById(UUID bookId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ResponseFullBookDto> getBookByIds(List<UUID> bookIds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseBookDto updateBook(RequsestBookUpdateDto requestDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> deleteBook(UUID bookId) {
		// TODO Auto-generated method stub
		return null;
	}

}
