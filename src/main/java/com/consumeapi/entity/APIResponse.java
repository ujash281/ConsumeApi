package com.consumeapi.entity;

import java.util.List;

public class APIResponse {
	private int status;
	private String statusMsg;
	private List<Trade> result;

	public APIResponse(int status, String statusMsg, List<Trade> result) {
		super();
		this.status = status;
		this.statusMsg = statusMsg;
		this.result = result;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getStatusMsg() {
		return statusMsg;
	}

	public void setStatusMsg(String statusMsg) {
		this.statusMsg = statusMsg;
	}

	public List<Trade> getResult() {
		return result;
	}

	public void setResult(List<Trade> result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "APIResponse [status=" + status + ", statusMsg=" + statusMsg + ", result=" + result + "]";
	}

}