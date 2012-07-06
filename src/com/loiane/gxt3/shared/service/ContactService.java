package com.loiane.gxt3.shared.service;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.loiane.gxt3.shared.model.Contact;

@RemoteServiceRelativePath("gxt3/contactService")
public interface ContactService extends RemoteService {

	void deleteContact(int id);

	List<Contact> getContacts(int start, int limit);

	int getTotalContacts();

	Contact saveContact(Contact contact);

}
