package com.teste;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;

import com.teste.model.UserModel;
import com.teste.model.UserSession;

public class LoginPage extends WebPage {

	private static final long serialVersionUID = 1L;

	public LoginPage() {

		final UserModel userModel = new UserModel();
		Form<Object> form = new Form<Object>("form");

		form.add(new TextField<String>("userName", new PropertyModel<String>(userModel, "name")));
		form.add(new PasswordTextField("pswd", new PropertyModel<String>(userModel, "pswd")));

		form.add(new Button("submit") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onSubmit() {
				super.onSubmit();

				if (userModel.getName().equalsIgnoreCase("admin") && userModel.getPswd().equalsIgnoreCase("admin")) {

					UserSession.getInstance().setUserModel(userModel);
					setResponsePage(MainPage.class);
					
				}else {
					System.out.println("Usuário ou senha incorretos.");
				}

			}
		});

		add(form);

	}

}
