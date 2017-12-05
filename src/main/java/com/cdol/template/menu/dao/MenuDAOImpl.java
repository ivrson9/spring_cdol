package com.cdol.template.menu.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cdol.template.menu.dto.MenuVO;

@Repository
public class MenuDAOImpl implements MenuDAO {
	
	@Autowired
    SqlSession sqlSession; // mybatis 실행 객체
	
	@Override
	public List<MenuVO> getMenu() {
		return sqlSession.selectList("getMenu");
	}

}
