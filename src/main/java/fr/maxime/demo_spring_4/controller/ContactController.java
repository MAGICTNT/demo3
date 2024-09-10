package fr.maxime.demo_spring_4.controller;

import fr.maxime.demo_spring_4.model.Contact;
import fr.maxime.demo_spring_4.service.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
public class ContactController {
    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @RequestMapping("/")
    public String homePage(Model model) {
        return "pageA";
    }

    @RequestMapping("/detail/{idContact}")
    public String contactPage(Model model, @PathVariable("idContact") UUID id) {
        model.addAttribute("contact", contactService.getContactById(id));
        return "pageC";
    }

    @RequestMapping("/list")
    public String allContactsPage(Model model){
        model.addAttribute("contacts", contactService.getAllContacts());
        return "pageB";
    }

    @RequestMapping("/search")
    public String searchContact(Model model,
                                @RequestParam(name = "contactName", required = false) String name,
                                @RequestParam(name = "telephone", required = false) String telephone){

        Contact contact = new Contact();
        if (telephone != null) {
            contact =contactService.getContactByPhone(telephone);
        }else {
            contact = contactService.getContactByName(name);

        }
        if(contact != null){
            model.addAttribute("contact", contact);
            return "pageC";
        }
        return "pageA";
    }
//form
    @RequestMapping("/formulaire")
    public String contactForm(Model model){
        model.addAttribute("contact", new Contact());
        return "form";
    }
    @PostMapping("/add")
    public String submitContact(@ModelAttribute("contact") Contact contact){
        System.out.println(contact.getName());
        System.out.println(contact.getPhone());
        System.out.println(contact.getAge());
        contactService.addContact(contact);
        return "redirect:/list";
//        if(contact != null){
//
//        }
    }

}
