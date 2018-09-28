package com.digital.cmi.contactms.repository;

import com.digital.cmi.contactms.model.RelatedPartyRef;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelatedPartyRepository extends ReactiveCassandraRepository<RelatedPartyRef, String> {
}
