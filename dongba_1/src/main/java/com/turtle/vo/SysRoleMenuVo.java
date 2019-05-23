package com.turtle.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 封装的是要传给角色编辑界面的数据
 * @author Administrator
 *
 */
public class SysRoleMenuVo implements Serializable {

	private static final long serialVersionUID = 6169994951026112390L;
	
	/**角色id*/
	private Integer id;
	/**角色名称*/
	private String name;
	/**角色备注*/
	private String note;
	/**角色对应的菜单id*/
	private List<Integer> menuIds;
	public SysRoleMenuVo() {
		super();
	}
	public SysRoleMenuVo(Integer id, String name, String note, List<Integer> menuIds) {
		super();
		this.id = id;
		this.name = name;
		this.note = note;
		this.menuIds = menuIds;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public List<Integer> getMenuIds() {
		return menuIds;
	}
	public void setMenuIds(List<Integer> menuIds) {
		this.menuIds = menuIds;
	}
	@Override
	public String toString() {
		return "SysRoleMenuVo [id=" + id + ", name=" + name + ", note=" + note + ", menuIds=" + menuIds + "]";
	}
	
	

}
