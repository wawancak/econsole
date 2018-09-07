package com.sh.djpk.econsole.ui.controller;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class LoginCtl {

	private String txtUserId;
	private String txtPassword;
	private String msg;

	public LoginCtl() {
	}

	public String btnLogin() {
		if ("admin".equals(txtUserId) && "admin".equals(txtPassword)) {
			return "index";
		} else {
			txtUserId = "";
			txtPassword = "";
			msg = "Incorrect username or password.";
		}
		return null;
	}

	public String getTxtUserId() {
		return txtUserId;
	}

	public void setTxtUserId(String txtUserId) {
		this.txtUserId = txtUserId;
	}

	public String getTxtPassword() {
		return txtPassword;
	}

	public void setTxtPassword(String txtPassword) {
		this.txtPassword = txtPassword;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
