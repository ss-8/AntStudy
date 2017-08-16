package com.aaa.json;

public class AccessMessage {
	private String token;
	private String ip;
	private Integer type;// 1通过验证0未通过
	
	

	public AccessMessage() {
		super();
	}

	public AccessMessage(String token, String ip, Integer type) {
		this.token = token;
		this.ip = ip;
		this.type = type;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
}
