package org.example.springdatastackoverflow.db;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Any;
import org.hibernate.annotations.AnyDiscriminator;
import org.hibernate.annotations.AnyDiscriminatorValue;
import org.hibernate.annotations.AnyKeyJavaClass;

import java.util.UUID;

@Entity
@Getter
@Setter
public class ExternalId<Target extends DBEntityWithExternalIds<Target>> extends DBEntity {

    @Column(nullable = false)
    private String externalId;
    @Column(nullable = false)
    private String source;

    @Any(optional = false, fetch = FetchType.LAZY)
    @AnyDiscriminator(DiscriminatorType.STRING)
    @AnyKeyJavaClass(UUID.class)
    @AnyDiscriminatorValue(discriminator = "some_entity", entity = SomeEntity.class)
    @Column(name = "referenceToTargetType")
    @JoinColumn(name = "referenceToTargetId", referencedColumnName = "id", nullable = false)
    private Target target;

}
