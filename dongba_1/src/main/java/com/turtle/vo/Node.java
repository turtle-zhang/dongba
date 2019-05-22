package com.turtle.vo;

import java.io.Serializable;

/**
 * 用来封装从数据库中取出来的上下级关系的数据
 * @author Administrator
 *
 */
public class Node implements Serializable {

	private static final long serialVersionUID = -8505312408168715570L;
	
	private Integer id;
	private String name;
	private Integer parentId;
	public Node() {
		super();
	}
	public Node(Integer id, String name, Integer parentId) {
		super();
		this.id = id;
		this.name = name;
		this.parentId = parentId;
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
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	@Override
	public String toString() {
		return "Node [id=" + id + ", name=" + name + ", parentId=" + parentId + "]";
	}
	
	
}
