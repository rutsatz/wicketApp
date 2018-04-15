package com.teste;

import java.util.ArrayList;
import java.util.List;

//import org.apache.commons.dbcp.BasicDataSource;
import org.apache.wicket.ajax.markup.html.navigation.paging.AjaxPagingNavigation;
import org.apache.wicket.ajax.markup.html.navigation.paging.AjaxPagingNavigator;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PageableListView;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigation;
import org.apache.wicket.model.IModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.springframework.context.support.ResourceBundleMessageSource;

import com.teste.dao.ISupplierDao;
//import com.teste.dao.impl.SupplierDaoImpl;
import com.teste.model.UserModel;

public class PageablePages extends WebPage {

	private static final long serialVersionUID = 1L;

//	@SpringBean(name="SupplierDao")
//	ISupplierDao supplierDao;

	public PageablePages() {
		
//		WebMarkupContainer dataContainer = new WebMarkupContainer("data");
//		dataContainer.setOutputMarkupId(true);
//		add(dataContainer);

		PageableListView<?> pageableListView = new PageableListView<UserModel>("rows", getUserModelList(), 10) {

			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<UserModel> item) {

				UserModel userModel = (UserModel) item.getDefaultModelObject();
				item.add(new Label("name", userModel.getName()));
				item.add(new Label("gender", userModel.getGender()));

			}
		};

//		dataContainer.add(pageableListView);
//		add(new AjaxPagingNavigator("nav", pageableListView));
//
//		dataContainer.setVersioned(false);

		 add(pageableListView);
		 add(new AjaxPagingNavigator("nav", pageableListView));

	}
//
//	private List<Object> getSupplierModelList() {
//		return supplierDao.getAllSuppliers("from Supplier");
//	}

	private List<UserModel> getUserModelList() {

		List<UserModel> userModels = new ArrayList<UserModel>();

		for (int index = 0; index < 100; index++) {
			userModels.add(new UserModel("Name" + index, index % 2 == 0 ? "Male" : "Female"));
		}
		return userModels;
	}

}
