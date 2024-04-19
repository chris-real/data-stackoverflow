package org.example.springdatastackoverflow.db;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@Getter
@Setter
public abstract class DBEntity implements Persistable<UUID> {

    @Id
    @Column(unique = true, nullable = false, updatable = false)
    private UUID id = UUID.randomUUID();

    @Version
    @Column(nullable = false)
    private Integer version;

    @Column(nullable = false)
    @CreatedDate
    private Instant createdDate;

    @Column(nullable = false)
    @CreatedBy
    private String createdBy;

    @LastModifiedDate
    private Instant updatedDate;

    @LastModifiedBy
    private String updatedBy;

    @JsonIgnore
    @Transient
    public boolean hasUpdatedDate() {
        return updatedDate != null;
    }

    @Override
    @JsonIgnore
    @Transient
    public boolean isNew() {
        return version == null;
    }

    @JsonIgnore
    @Transient
    public Instant getLatestModificationDate() {
        return updatedDate == null ? getCreatedDate() : getUpdatedDate();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "( id=" + id + " )";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        DBEntity dbEntity = (DBEntity) o;

        return Objects.equals(id, dbEntity.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }




}
