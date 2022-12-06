package com.ltp.contacts.service;

import java.util.List;
import java.util.stream.IntStream;

import com.ltp.contacts.pojo.Contact;
import exception.NoContactException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltp.contacts.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;


    private int findIndexById(String id) throws NoContactException {
        return IntStream.range(0, contactRepository.getContacts().size())
                .filter(index -> contactRepository.getContacts().get(index).getId().equals(id))
                .findFirst()
                .orElseThrow(() ->  new NoContactException() /*-> in workbook 8.1, we handled bad requests by throwing and catching checked exceptions. This method is annoying because it forces you to modify the service methods.*/);
    }

    @Override
    public Contact getContactById(String id) throws NoContactException {
       return contactRepository.getContact(findIndexById(id));
    }

    @Override
    public List<Contact> getContacts(){
        return contactRepository.getContacts();
    }

    @Override
    public void saveContact(Contact contact){
        contactRepository.saveContact(contact);
    }

    @Override
    public void updateContact(String id, Contact contact) throws NoContactException {
        contactRepository.updateContact(findIndexById(id), contact);
    }

    @Override
    public void deleteContact(String id) throws NoContactException {
        contactRepository.deleteContact(findIndexById(id));
    }
}
