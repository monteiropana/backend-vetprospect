package com.unifil.vetprospect.protocol;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class Protocol implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<KeyValueData> header;
	@Getter @Setter private Object data;
	@Getter @Setter private int statusCode;
	@Getter @Setter private String message;
	
	public List<KeyValueData> getHeader() {
		if (null == this.header) {
			this.header = Collections.emptyList();
		}
		return this.header;
	}
	
	public void setHeader(List<KeyValueData> header) {
		this.header = header;
	}
}
