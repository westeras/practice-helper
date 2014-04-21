package com.adamwesterman.core;

public class APIParameter {
	private String key;
	private String value;
	
	public APIParameter(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}
	protected String getKey() {
		return key;
	}
	protected void setKey(String key) {
		this.key = key;
	}
	protected String getValue() {
		return value;
	}
	protected void setValue(String value) {
		this.value = value;
	}
}
