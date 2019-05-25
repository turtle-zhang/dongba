package com.turtle.vo;

/**
 * 此对象封装角色id,角色名称
 * @author Administrator
 *
 */
public class CheckBox {

	private Integer id;
	private String name;
	public CheckBox(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public CheckBox() {
		super();
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
	@Override
	public String toString() {
		return "CheckBox [id=" + id + ", name=" + name + "]";
	}
	
	
}
