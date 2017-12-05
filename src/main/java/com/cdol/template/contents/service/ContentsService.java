package com.cdol.template.contents.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.cdol.template.contents.dto.ContentsVO;

public interface ContentsService {
	public List<ContentsVO> getContents();
}
