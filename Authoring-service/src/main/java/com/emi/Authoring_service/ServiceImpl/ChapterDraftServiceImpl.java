package com.emi.Authoring_service.ServiceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.emi.Authoring_service.RequestDtos.RequestChapterCreateDto;
import com.emi.Authoring_service.RequestDtos.RequestUpdateDraftChapterDto;
import com.emi.Authoring_service.ResponseDtos.ResponseDraftChapterDto;
import com.emi.Authoring_service.service.DraftChapterService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChapterDraftServiceImpl implements DraftChapterService {

	@Override
	public ResponseDraftChapterDto createChapterDraft(RequestChapterCreateDto request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseDraftChapterDto updateChapterDraft(RequestUpdateDraftChapterDto request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ResponseDraftChapterDto> getMyDraftChapters(UUID authorId, UUID bookId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseDraftChapterDto getMyDraftChapterById(UUID authorId, UUID draftChapterId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteDraftChapterById(UUID chapterId, UUID authorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseDraftChapterDto publishDraftedChapters(UUID draftChapterId, UUID authorId) {
		// TODO Auto-generated method stub
		return null;
	}

}
