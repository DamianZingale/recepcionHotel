package com.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.model.Usuario;
@Repository
public interface I_UserRepository extends JpaRepository <Usuario, Integer>{
    Usuario findByNombre_Usuario(String userName);
    /*boolean existsByNombre_Usuario(String nombre_usuario);
    boolean existsByPassword(String password);
    boolean existsByRol(String s);*/
    
}
