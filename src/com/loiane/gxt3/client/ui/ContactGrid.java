package com.loiane.gxt3.client.ui;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.loiane.gxt3.shared.model.Contact;
import com.loiane.gxt3.shared.model.ContactProperties;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.loader.LoadResultListStoreBinding;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;
import com.sencha.gxt.data.shared.loader.PagingLoader;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;

public class ContactGrid extends Grid<Contact> implements IsWidget {

	private static final ContactProperties props = GWT.create(ContactProperties.class);

	private static ColumnConfig<Contact, String> nameCol = new ColumnConfig<Contact, String>(props.nome(), 150, "Name");
	private static ColumnConfig<Contact, String> phoneCol = new ColumnConfig<Contact, String>(props.phone(), 150, "Phone");
	private static ColumnConfig<Contact, String> emailCol = new ColumnConfig<Contact, String>(props.email(), 150, "Email");

	public ContactGrid() {

		super(generateData(), createColumnModel());

		this.getView().setStripeRows(true);
		this.getView().setColumnLines(true);
		this.getView().setAutoExpandColumn(nameCol);
		this.setBorders(false);
		this.setColumnReordering(true);
	}

	private static ColumnModel<Contact> createColumnModel(){

		List<ColumnConfig<Contact, ?>> columnConfigList = new ArrayList<ColumnConfig<Contact, ?>>();
		columnConfigList.add(nameCol);
		columnConfigList.add(phoneCol);
		columnConfigList.add(emailCol);

		return new ColumnModel<Contact>(columnConfigList);
	}

	private static ListStore<Contact> generateData(){

		ListStore<Contact> store = new ListStore<Contact>(props.key());

		return store;
	}

	@Override
	public Widget asWidget() {
		return this;
	}
}
