package com.teste;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import com.teste.model.UserModel;

public class WelcomePage extends WebPage {

	private static final long serialVersionUID = 1L;

	private List<String> genderChoices = new ArrayList<>();

	public WelcomePage() {

		genderChoices.add("Male");
		genderChoices.add("Female");
		UserModel userModel = new UserModel();

		Form<?> form = new Form<>("form");

		final TextField<String> text = new TextField<>("text", new PropertyModel<String>(userModel, "name"));
		text.setOutputMarkupId(true);
		
		final DropDownChoice<String> gender = new DropDownChoice<>("gender", new PropertyModel<String>(userModel, "gender"),
				genderChoices);
		gender.setOutputMarkupId(true);

//		Button button = new Button("submit") {
//			public void onSubmit() {
//				super.onSubmit();
//
//			};
//		};

		AjaxButton ajaxButton = new AjaxButton("submit") {
			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				super.onSubmit(target, form);
				
				text.setEnabled(false);
				gender.setEnabled(false);
				
				target.add(text);
				target.add(gender);
				
			}
		};
		
		add(form);

		form.add(text);
		form.add(gender);
		form.add(ajaxButton);

	}

}
