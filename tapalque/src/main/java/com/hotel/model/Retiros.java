package com.hotel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "Retiros")
@Getter
@Setter
@AllArgsConstructor
public class Retiros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_retiro;  // Identificador único para cada retiro

    @ManyToOne(fetch = FetchType.LAZY)  // Relación de muchos a uno con Temporada
    @JoinColumn(name = "temporada_id")  // Clave foránea que apunta a la tabla Temporada
    private Temporada temporada;  // Relación con la temporada

    @ManyToOne(fetch = FetchType.LAZY)  // Relación de muchos a uno con Usuario
    @JoinColumn(name = "usuario_id")  // Clave foránea que apunta a la tabla Usuario
    private Usuario usuario;  // Relación con Usuario

    @Column(name = "horasTrabajadasDia")
    private Double horasTrabajadasDia = 0.0;

    @Column(name = "horasTrabajadasNoche")
    private Double horasTrabajadasNoche = 0.0;

    @Column(name = "total_retiro")
    private Double total = 0.0;

}
