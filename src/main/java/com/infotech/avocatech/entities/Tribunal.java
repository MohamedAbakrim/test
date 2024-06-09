package com.infotech.avocatech.entities;

import com.infotech.avocatech.enumerations.TypeTribunal;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Tribunal extends AbstractEntity{


    @Enumerated(EnumType.STRING)
    private TypeTribunal typeTribunal;

    private String ville;
}
