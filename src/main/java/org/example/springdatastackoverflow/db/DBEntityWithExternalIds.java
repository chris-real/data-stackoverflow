package org.example.springdatastackoverflow.db;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@MappedSuperclass
@NoArgsConstructor
public abstract class DBEntityWithExternalIds<Self extends DBEntityWithExternalIds<Self>> extends DBEntity {

    @Getter
    @Setter
    private String layerName;

    @Transient
    @org.springframework.data.annotation.Transient
    private transient List<ExternalId<Self>> references = new ArrayList<>();

    @Transient
    @org.springframework.data.annotation.Transient
    public List<ExternalId<Self>> getTransientReferences() {
        return references;
    }
}
