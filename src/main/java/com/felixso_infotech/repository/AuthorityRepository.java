package com.felixso_infotech.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.felixso_infotech.domain.Authority;

/**
 * Spring Data MongoDB repository for the {@link Authority} entity.
 */
public interface AuthorityRepository extends Neo4jRepository<Authority, String> {
}
