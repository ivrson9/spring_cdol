package com.cdol.template.contents.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.cdol.template.contents.dao.ContentsDAO;
import com.cdol.template.contents.dto.ContentsVO;

@Service
public class ContentsServiceImpl implements ContentsService {
	
	@Inject
	ContentsDAO contentsDao;
	
	@Override
	public List<ContentsVO> getContents() {
		return contentsDao.getContents();
	}

}
