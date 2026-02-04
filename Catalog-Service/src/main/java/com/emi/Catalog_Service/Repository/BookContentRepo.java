package com.emi.Catalog_Service.Repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emi.Catalog_Service.Entity.Book_Content;

public interface BookContentRepo extends JpaRepository<Book_Content, UUID> {

	List<Book_Content> findAllByBookId(UUID bookId);

}
