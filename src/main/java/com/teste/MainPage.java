package com.teste;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;

import com.teste.model.UserSession;

public class MainPage extends WebPage {

	private static final long serialVersionUID = 1L;

	public MainPage() {
		
		add(new Label("msg", new Model<String>(UserSession.getInstance().getUserModel().getName())));
		
		add(new Link<String>("signOut") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				UserSession.getInstance().invalidate();
				setResponsePage(LoginPage.class);
				
			}
		});
		
	}
	
}
