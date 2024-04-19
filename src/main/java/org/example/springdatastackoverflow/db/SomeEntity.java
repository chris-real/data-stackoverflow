package org.example.springdatastackoverflow.db;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class SomeEntity extends DBEntityWithExternalIds<SomeEntity> {

    private String someField;

}
