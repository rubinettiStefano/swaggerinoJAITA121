package com.generation.swaggerino.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Person 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Id, se inserito provoca Update, Altrimenti Insert",example = "22")
    private Integer id;

    @Schema(description = "Nome Proprio",example = "Ferdinando")
    private String name;

    @Schema(description = "Cognome",example = "Primerano")
    @Column(nullable=false)
    private String surname;
    @Schema(description = "Età",example = "1642")
    private int age;
}
