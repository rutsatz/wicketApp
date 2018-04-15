package com.teste;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.teste.model.UserModel;

public class SpringIntegrationPage extends WebPage {

	private static final long serialVersionUID = 1L;

	// Definido lá no applicationContext.xml
	@SpringBean(name="userModel")
	private UserModel uSerModel;
	
	public SpringIntegrationPage() {
		
		
		
		// PropertyModel faz o bind do meu model com o componente da tela.
		add(new Label("namelbl", new PropertyModel<>(uSerModel, "name")));
		add(new Label("genderlbl", new PropertyModel<>(uSerModel, "gender")));
		
		
	}
	
}
