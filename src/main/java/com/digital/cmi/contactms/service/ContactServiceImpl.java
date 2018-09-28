package com.digital.cmi.contactms.service;

import com.digital.cmi.contactms.model.Contact;
import com.digital.cmi.contactms.model.RelatedPartyRef;
import com.digital.cmi.contactms.repository.ContactRepository;
import com.digital.cmi.contactms.repository.RelatedPartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private RelatedPartyRepository relatedPartyRepository;

    @Override
    public Mono<Contact> findContactById(String id) {

        Mono<Contact> contactMono = contactRepository.findById(id);
        contactMono = contactMono.map(
                contact -> {

                    RelatedPartyRef relatedPartyRef = contact.getRelatedParty();
                    Mono<RelatedPartyRef> relatedPartyRefMono =
                            relatedPartyRepository.findById(relatedPartyRef.getId());
                    RelatedPartyRef relatedPartyRefFinal = relatedPartyRefMono.block();
                    contact.setRelatedParty(relatedPartyRefFinal);
                    return contact;
                }
        );
        return contactMono;
    }

    @Override
    public Mono<RelatedPartyRef> findRelatedPartyById(String id) {

        Mono<RelatedPartyRef> relatedPartyRefMono =
                relatedPartyRepository.findById(id);
        return relatedPartyRefMono;
    }
}
