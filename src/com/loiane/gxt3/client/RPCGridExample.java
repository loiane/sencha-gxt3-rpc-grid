package com.loiane.gxt3.client;

import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.loiane.gxt3.client.ui.ContactGrid;
import com.loiane.gxt3.shared.model.Contact;
import com.loiane.gxt3.shared.model.ContactProperties;
import com.loiane.gxt3.shared.service.ContactService;
import com.loiane.gxt3.shared.service.ContactServiceAsync;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;

public class RPCGridExample implements EntryPoint, IsWidget {
	
	private final ContactServiceAsync service = GWT.create(ContactService.class);
	 
	private final ContactProperties props = GWT.create(ContactProperties.class);
	
	private ContactGrid grid;

	@Override
	  public void onModuleLoad() {
	    RootPanel.get().add(this);
	  }
	 
	  @Override
	  public Widget asWidget() {
		  
	    grid = new ContactGrid();
	    populateGrid();
	 
	    FramedPanel cp = new FramedPanel();
	    cp.setCollapsible(true);
	    cp.setHeadingText("RPC Grid Example");
	    cp.setPixelSize(500, 500);
	    cp.addStyleName("margin-10");
	 
	    VerticalLayoutContainer con = new VerticalLayoutContainer();
	    con.setBorders(true);
	    con.add(grid, new VerticalLayoutData(1, 1));
	    cp.setWidget(con);
	 
	    return cp;
	  }
	  
	  public void populateGrid(){
		  
		  service.getContacts(0, 25, new AsyncCallback<List<Contact>>() {
			
			@Override
			public void onSuccess(List<Contact> result) {
				grid.getStore().addAll(result);
				
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		});
	  }

}
