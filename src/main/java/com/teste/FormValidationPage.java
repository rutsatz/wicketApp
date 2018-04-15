package com.teste;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;
import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.IValidator;
import org.apache.wicket.validation.ValidationError;
import org.apache.wicket.validation.validator.EmailAddressValidator;
import org.apache.wicket.validation.validator.RangeValidator;

public class FormValidationPage extends WebPage {

	private static final long serialVersionUID = 1L;

	public FormValidationPage() {
		prepareComponent();
	}

	void prepareComponent() {

		FeedbackPanel feedbackPanel = new FeedbackPanel("feedbackMsg");

		Form<?> form = new Form<Object>("form");
		TextField<String> name = new RequiredTextField<>("name", new Model<String>());
		TextField<Integer> age = new RequiredTextField<>("age", new Model<Integer>());
		TextField<String> email = new RequiredTextField<>("email", new Model<String>());
		TextField<String> zipcode = new RequiredTextField<>("zipcode", new Model<String>());

		email.add(EmailAddressValidator.getInstance());

		zipcode.add(new ZipCodeValidator());
		
		age.setType(Integer.class);
		age.add(RangeValidator.range(18, 60));

		form.add(new Button("submit") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onSubmit() {
				super.onSubmit();
			}
		});

		add(feedbackPanel);
		add(form);
		form.add(name);
		form.add(age);
		form.add(email);
		form.add(zipcode);

	}

	private class ZipCodeValidator implements IValidator<String> {

		private static final long serialVersionUID = 1L;

		@Override
		public void validate(IValidatable<String> validatable) {
			String zipCode = validatable.getValue();

			if (!zipCode.startsWith("411") || zipCode.length() != 6) {
				validatable.error(new ValidationError().setMessage("Incorrect ZipCode"));
			}

		}

	}

}
