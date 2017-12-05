package com.cdol.template.menu.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.cdol.template.menu.dao.MenuDAO;
import com.cdol.template.menu.dto.MenuVO;

@Service
public class MenuServiceImpl implements MenuService {
	
	@Inject
	MenuDAO menuDao;
	
	@Override
	public List<MenuVO> getMenu() {
		return menuDao.getMenu();
	}

}
