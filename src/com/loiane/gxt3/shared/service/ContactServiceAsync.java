package com.loiane.gxt3.shared.service;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.loiane.gxt3.shared.model.Contact;

public interface ContactServiceAsync {

	void getContacts(int start, int limit, AsyncCallback<List<Contact>> callback);
	
	void deleteContact(int id, AsyncCallback<Void> callback);
	
	void saveContact(Contact contact, AsyncCallback<Contact> callback);
	
	void getTotalContacts(AsyncCallback<Integer> callback);
}
