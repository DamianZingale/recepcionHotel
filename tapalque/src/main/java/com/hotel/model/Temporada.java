package com.hotel.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Temporada")
@Getter
@Setter
public class Temporada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_temporada;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")  // Relación con Usuario
    private Usuario usuario;

    @OneToMany(mappedBy = "temporada", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Mes> meses = new ArrayList<>();  // Relación con Mes

    @OneToMany(mappedBy = "temporada", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Anio> años = new ArrayList<>();  // Relación con Año

    @OneToMany(mappedBy = "temporada", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Retiros> retiros = new ArrayList<>();  // Relación con Retiros

    


    // Constructor para inicializar las listas de meses y años
    public Temporada() {
        // Aquí agregarías la lógica para poblar las listas si es necesario
    }
}
