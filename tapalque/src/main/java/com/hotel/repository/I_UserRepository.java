package com.hotel.repository;


import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.hotel.model.PrecioHora;
import com.hotel.model.Usuario;
@Repository
public interface I_UserRepository {
    
    void crearusuario(Usuario us);
    Usuario traerUsuario(String userName)throws SQLException;
    List<Double> selectHora();
    void grabarHora(PrecioHora hr);
    Usuario traerUsuarioPorDNI(String DNI) throws SQLException;
    Usuario modificar_usuario(Usuario us, int id) throws SQLException;
    void guardarTiempo(String tiempo);
    void eliminarUsuario(int id);

    
   
}
