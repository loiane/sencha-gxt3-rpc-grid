package com.loiane.gxt3.server.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.loiane.gxt3.server.dao.ContactDAO;
import com.loiane.gxt3.shared.model.Contact;
import com.loiane.gxt3.shared.service.ContactService;

@Service("contactService")
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactDAO contactDao;
	
	@PostConstruct
	public void init() throws Exception {}
	
	@PreDestroy
	public void destroy() {}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public void deleteContact(int id) {
		contactDao.deleteContact(id);
	}

	@Override
	public List<Contact> getContacts(int start, int limit) {
		return contactDao.getContacts(start, limit);
	}

	@Override
	public int getTotalContacts() {
		return contactDao.getTotalContacts();
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public Contact saveContact(Contact contact) {
		return contactDao.saveContact(contact);
	}

}
