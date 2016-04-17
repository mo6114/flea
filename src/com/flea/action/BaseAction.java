package com.flea.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {

	private HttpServletRequest request;
	private HttpServletResponse response;
	private PrintWriter printWriter;
	
	public HttpServletRequest getRequest() {
		return request;
	}


	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}


	public HttpServletResponse getResponse() {
		return response;
	}


	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}


	public PrintWriter getPrintWriter() {
		//PrintWriter printWriter = null;
		response = ServletActionContext.getResponse();
		
		try {
			printWriter = response.getWriter();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return printWriter;
	}
}
