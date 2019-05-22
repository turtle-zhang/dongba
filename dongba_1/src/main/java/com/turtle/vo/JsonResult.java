package com.turtle.vo;

import java.io.Serializable;

/**
 * 这个是对service层返回的数据进行封装的，包含数据的详细信息
 * @author Administrator
 *
 */
public class JsonResult implements Serializable{

	private static final long serialVersionUID = -1612478171368510637L;
	
	/**状态码*/
	private int state=1;//1表示SUCCESS,0表示ERROR
	/**状态信息*/
	private String message="ok";
	/**正确数据*/
	private Object data;
	
	public JsonResult() {
	}
	
	public JsonResult(String message) {
		this.message = message;
	}
	
	public JsonResult(Object data) {
		this.data = data;
	}
	
	public JsonResult(Throwable throwable) {
		this.message = throwable.getMessage();
		this.state = 0;		
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "JsonResult [state=" + state + ", message=" + message + ", data=" + data + "]";
	}
}
