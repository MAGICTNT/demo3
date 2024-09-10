package fr.maxime.demo_spring_4.service;

import fr.maxime.demo_spring_4.model.Contact;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class ContactService {
    private final Map<UUID, Contact> contacts;

    public ContactService() {
        contacts = new HashMap<UUID, Contact>();

        Contact contactA =  Contact.builder()
                .id(UUID.randomUUID())
                .name("Riri")
                .phone("123456789")
                .age(18)
                .build();
        Contact contactB =  Contact.builder()
                .id(UUID.randomUUID())
                .name("Fifi")
                .phone("23665489")
                .age(14)
                .build();
        Contact contactC =  Contact.builder()
                .id(UUID.randomUUID())
                .name("Loulou")
                .phone("987654321")
                .age(100)
                .build();
        contacts.put(contactA.getId(), contactA);
        contacts.put(contactB.getId(), contactB);
        contacts.put(contactC.getId(), contactC);

    }

    public List<Contact> getAllContacts() {
        return contacts.values().stream().toList();
    }

    public Contact getContactById(UUID id) {
        return contacts.get(id);
    }

    public Contact getContactByName(String name) {
        return contacts.values().stream().filter(contact -> contact.getName().equals(name)).findFirst().orElse(null);
    }
    public Contact getContactByPhone(String phone) {
        return contacts.values().stream().filter(contact -> contact.getPhone().equals(phone)).findFirst().orElse(null);
    }
    public List<Contact> addContact(Contact contact){
        contact.setId(UUID.randomUUID());
        contacts.put(contact.getId(), contact);
        return contacts.values().stream().toList();
    }



}
