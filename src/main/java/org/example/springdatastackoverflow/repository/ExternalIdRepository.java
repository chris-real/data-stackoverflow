package org.example.springdatastackoverflow.repository;

import org.example.springdatastackoverflow.db.ExternalId;
import org.example.springdatastackoverflow.db.DBEntityWithExternalIds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExternalIdRepository extends JpaRepository<ExternalId, Long> {

    @Query("select ei from ExternalId as ei where ei.target = :dbEntity")
    <EntityReferencedByExternalId extends DBEntityWithExternalIds<EntityReferencedByExternalId>> List<ExternalId<EntityReferencedByExternalId>> findAllExternalIdsFor(EntityReferencedByExternalId dbEntity);

}
