package com.flea.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

/*
 * 为Action程序提供一些通用功能
 */
public class BaseAction extends ActionSupport {

	private HttpServletRequest request;
	private HttpServletResponse response;
	private PrintWriter printWriter;
	private ActionContext actionContext;
	private ValueStack valueStack;
	private HttpSession session;

	public HttpServletRequest getRequest() {
		request = ServletActionContext.getRequest();
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

	// 获取PrintWriter对象
	public PrintWriter getPrintWriter() {
		// PrintWriter printWriter = null;
		// 获得HttpServletResponse对象
		response = ServletActionContext.getResponse();

		try {
			printWriter = response.getWriter();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return printWriter;
	}

	// 向值栈内存入数据
	public void setValue(String ognl, Object value) {
		actionContext = ActionContext.getContext();
		valueStack = actionContext.getValueStack();

		valueStack.setValue(ognl, value);
	}

	// 从值栈中取出数据
	public Object findValue(String ognl) {
		actionContext = ActionContext.getContext();
		valueStack = actionContext.getValueStack();

		return valueStack.findValue(ognl);
	}

	// 移除session
	public void removeSession(String str) {
		request = ServletActionContext.getRequest();
		session = request.getSession(true);

		session.removeAttribute(str);
	}
}
