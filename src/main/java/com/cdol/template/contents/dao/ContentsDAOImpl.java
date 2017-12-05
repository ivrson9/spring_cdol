package com.cdol.template.contents.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cdol.template.contents.dto.ContentsVO;

@Repository
public class ContentsDAOImpl implements ContentsDAO {
	
	@Autowired
    SqlSession sqlSession; // mybatis 실행 객체
	
	@Override
	public List<ContentsVO> getContents() {
		return sqlSession.selectList("getServices");
	}

}
