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
import org.apache.wicket.markup.html.panel.Fragment;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import com.teste.model.UserModel;

public class WelcomePage extends WebPage {

	private static final long serialVersionUID = 1L;

	private String action;

	public WelcomePage() {
	}

	public WelcomePage(String action) {

		this.action = action;
		// add(new SamplePanel("panel"));
		// add(new SamplePanel("panel1"));

		addComponents();

	}

	private void addComponents() {

		Form<?> form = new Form<Object>("form");

		Fragment fragment;

		if (action.equalsIgnoreCase("view")) {
			// 1. id do componente pai, que irá receber o conteúdo.
			// 2. É o pedaço (fragment) que queremos injetar.
			// 3. É onde o fragment está definido. Como definimos dentro de
			// WelcomePage.html (a própria página), passamos a própria página.
			fragment = new Fragment("container", "viewFragment", this);
			fragment.add(new Label("label", new Model<String>("Hello World")));
		} else {
			fragment = new Fragment("container", "editFragment", this);
			fragment.add(new TextField<String>("text", new Model<String>("Hello World")));
		}

		form.add(fragment);

		add(form);

	}

}
