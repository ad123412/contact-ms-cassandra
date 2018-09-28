package com.digital.cmi.contactms.service;

import com.digital.cmi.contactms.model.Contact;
import com.digital.cmi.contactms.model.RelatedPartyRef;
import reactor.core.publisher.Mono;

public interface ContactService {

    public Mono<Contact> findContactById(String id);

    public Mono<RelatedPartyRef> findRelatedPartyById(String id);
}
