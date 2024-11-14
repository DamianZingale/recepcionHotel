package com.hotel.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Mes")
@Getter
@Setter
public class Mes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_mes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "temporada_id")
    private Temporada temporada;

    private String mes;  // Nombre del mes

    // Constructor
    public Mes(String mes) {
        this.mes = mes;
    }
}

