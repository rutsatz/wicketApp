package com.teste;

import org.apache.wicket.Session;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.springframework.web.context.ContextLoaderListener;

import com.teste.model.UserSession;

/**
 * Application object for your web application. If you want to run this
 * application without deploying, run the Start class.
 * 
 * @see com.teste.Start#main(String[])
 */
public class WicketApplication extends WebApplication {
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends WebPage> getHomePage() {
		return MainPage.class;
	}

	@Override
	public Session newSession(Request request, Response response) {
		
		// Para cada sessão criada, sobrescrevemos o método para dizer
		// ao wicket para usar nossa classe de session, ao invés da WebSession.
		return new UserSession(request);
	}
	
	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init() {
		super.init();

		// add your configuration here

		getComponentInstantiationListeners().add(new SpringComponentInjector(this));

	}
}
