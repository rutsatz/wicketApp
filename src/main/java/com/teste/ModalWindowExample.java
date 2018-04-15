package com.teste;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.Page;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow.PageCreator;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow.WindowClosedCallback;

public class ModalWindowExample extends WebPage {

	private static final long serialVersionUID = 1L;

	private ModalWindow modalWindow;

	private String action;
	
	public ModalWindowExample() {

		modalWindow = new ModalWindow("modalWindow");

		modalWindow.setPageCreator(new PageCreator() {

			@Override
			public Page createPage() {
				return new WelcomePage(action);
			}
		});

		modalWindow.setTitle("ModalWindowExample");

		modalWindow.setWindowClosedCallback(new WindowClosedCallback() {
			@Override
			public void onClose(AjaxRequestTarget target) {
				System.out.println("Usuário fechou a janela modal.");
			}

		});

		add(new AjaxLink<String>("viewLink") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				action = "view";
				modalWindow.show(target);

			}
		});

		add(new AjaxLink<String>("editLink") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				action = "edit";
				modalWindow.show(target);

			}

		});

		add(modalWindow);

	}

}
