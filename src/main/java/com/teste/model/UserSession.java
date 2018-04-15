package com.teste.model;

import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;

public class UserSession extends WebSession {

	private static final long serialVersionUID = 1L;

	private UserModel userModel;

	public UserSession(Request request) {
		super(request);
	}

	public static UserSession getInstance() {
		// Como sobrescrevemos o newSession(), criamos esse método para
		// recuperar nossa sessão.
		return (UserSession) Session.get();
	}

	public UserModel getUserModel() {
		return userModel;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}
}
