package com.hotel.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@Entity
@Table(name = "Usuario")
@Getter
@Setter
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_usuario;
    @Column(name="Nombre")
    private String nombre;
    @Column(name="apellido")
    private String apellido;
    @Column(name="documento")
    private String documento;
    @Column(name="telefono")
    private String telefono;
    @Column(name="nombre_usuario")
    private String nombre_usuario;
    @Column(name="paswword")
    private String password;
    @Column(name="rol")
    private String rol;

    @OneToMany(mappedBy = "Usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Temporada> temporadas = new ArrayList<>();  // Relación con Temporadas

    @OneToMany(mappedBy = "Usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Retiros> retiros = new ArrayList<>();  // Relación con Retiros



   
    
    public Usuario(String nombre, String apellido, String documento, String telefono, String nombreUsuario, String rol) {
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.documento = documento;
		this.telefono = telefono;
		this.nombre_usuario = nombreUsuario;
		this.password = documento + "." + "hotel";
		this.rol = rol;
     
	}
  public Usuario(String nombre, String apellido, String documento, String telefono, String rol) {
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.documento = documento;
		this.telefono = telefono;
		this.nombre_usuario = null;
		this.password = documento + "." + "hotel";
		this.rol = rol;
	}
    
    
   
   
    
    
   
}
