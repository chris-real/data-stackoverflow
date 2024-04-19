package org.example.springdatastackoverflow.repository;

import org.example.springdatastackoverflow.db.SomeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SomeEntityRepository extends JpaRepository<SomeEntity, UUID> {
}
