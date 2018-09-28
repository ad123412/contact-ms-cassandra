package com.digital.cmi.contactms.controller;

import com.digital.cmi.contactms.model.Contact;
import com.digital.cmi.contactms.model.RelatedPartyRef;
import com.digital.cmi.contactms.service.ContactServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class AccountContactController {

    @Autowired
    private ContactServiceImpl contactService;

    @GetMapping(value = {"/account/contact/{id}"})
    public Flux<Contact> getContactDetails(
            @PathVariable(value = "id") String contactId){

        return contactService.findContactById(contactId)
                             .flatMapMany(Flux::just);
    }

    @GetMapping(value = {"/account/contact/relatedParty/{id}"})
    public Flux<RelatedPartyRef> getRelatedPartyDetails(
            @PathVariable(value = "id") String relatedPartyId){

        return contactService.findRelatedPartyById(relatedPartyId)
                             .flatMapMany(Flux::just);
    }
}
