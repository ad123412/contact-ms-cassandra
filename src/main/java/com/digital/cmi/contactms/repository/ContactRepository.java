package com.digital.cmi.contactms.repository;

import com.digital.cmi.contactms.model.Contact;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends ReactiveCassandraRepository<Contact, String> {
}
