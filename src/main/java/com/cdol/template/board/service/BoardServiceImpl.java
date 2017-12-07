package com.cdol.template.board.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.cdol.template.board.dao.BoardDAO;
import com.cdol.template.board.dto.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Inject
	BoardDAO boardDao;
			
	@Override
	public List<BoardVO> getList(Map<String, Object> parameters) {
		return boardDao.getList(parameters);
	}

	@Override
	public int getCount(Map<String, Object> parameters) {
		return boardDao.getCount(parameters);
	}

}
