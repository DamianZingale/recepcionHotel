package com.hotel.Logica;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.hotel.model.PrecioHora;
import com.hotel.model.Usuario;
import com.hotel.repository.UserRepository;


@Service
public class LogicaUsuario {

    
    
    UserRepository repo = new UserRepository();
   
    
    public boolean EsAdmin(String usuario, String contraseña) throws SQLException {
        boolean es = false;
        Usuario user = new Usuario();
        user = repo.traerUsuario(usuario);
        if (user != null) {
            String pass = user.getPassword();
            if (pass.equals(contraseña)&& user.getRol().equals("Administrador")) { 
                es = true;
            }
        }
        return es;
    }

    public void crearUsuario(String Nombre, String Apellido, String Documento, String telefono, String Rol) {

        Usuario user = new Usuario(Nombre, Apellido, Documento, telefono, Rol);
        repo.crearusuario(user);

    }

    public PrecioHora buscarPrecioHoras(){

        List<Double> lista = new ArrayList<Double>();
        lista = repo.selectHora();
        Double dia;
        Double noche;
        dia = lista.get(0);
        noche = lista.get(1);
        
        PrecioHora Phora = new PrecioHora(dia, noche);

        return Phora;
    }

    public void acomodoHora(PrecioHora hr){
        repo.grabarHora(hr);
    }

    public Optional<Usuario> user_for_all(String DNI) {
    try {
        // Intentamos traer el usuario por el DNI
        Usuario usuario = (Usuario) repo.traerUsuarioPorDNI(DNI);
        return Optional.ofNullable(usuario);
    } catch (SQLException e) {
        e.printStackTrace();
        return Optional.empty();  // En caso de error, devolvemos un Optional vacío
    }
}
    public void modificar(Usuario user, int id){
        
        try{
            repo.modificar_usuario(user, id);
        
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
