package com.cdol.template.util;

import java.util.List;

import org.apache.tiles.Attribute;
import org.apache.tiles.AttributeContext;
import org.apache.tiles.preparer.PreparerException;
import org.apache.tiles.preparer.ViewPreparer;
import org.apache.tiles.request.Request;
import org.springframework.beans.factory.annotation.Autowired;

import com.cdol.template.contents.dto.ContentsVO;
import com.cdol.template.contents.service.ContentsService;
import com.cdol.template.menu.dto.MenuVO;
import com.cdol.template.menu.service.MenuService;

public class MenuPreparer implements ViewPreparer {
	
	@Autowired
	ContentsService contentsService;
	
	@Autowired
	MenuService menuService;
	
	@Override
	public void execute(Request context, AttributeContext attributeContext) throws PreparerException {
		List<ContentsVO> contents = contentsService.getContents();
		List<MenuVO> menu = menuService.getMenu();
		
		attributeContext.putAttribute("contents", new Attribute(contents), true);
		attributeContext.putAttribute("menu", new Attribute(menu), true);
		
	}

}