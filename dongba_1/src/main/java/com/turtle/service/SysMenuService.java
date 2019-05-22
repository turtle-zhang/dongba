package com.turtle.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.turtle.dao.SysMenuDao;
import com.turtle.entity.SysMenu;
import com.turtle.vo.Node;
import com.turtle.vo.PageObject;


/**
 * 对菜单的业务层操作
 * @author Administrator
 *
 */
public interface SysMenuService {

	/**
	 * 查询菜单表中的数据，通过根据表内关联，将父菜单的名字也查询出来了
	 * @return
	 */
	List<Map<String,Object>>findObjects();
	
	/**
	 * 通过id来删除菜单表中的数据
	 * @param id
	 * @return
	 */
	int deleteObject(Integer id);
	
	/**
	 * 得到我们要的节点信息，主要是用来显示树状的那种东西
	 * @return
	 */
	List<Node> findZtreeMenuNodes();
	
	/**
	 * 将菜单数据添加到表中去
	 * @param sysMenu
	 * @return
	 */
	int saveObject(SysMenu sysMenu);
	
	/**
	 * 对菜单数据进行更新操作
	 * @param sysMenu
	 * @return
	 */
	int updateObject(SysMenu sysMenu);
}













