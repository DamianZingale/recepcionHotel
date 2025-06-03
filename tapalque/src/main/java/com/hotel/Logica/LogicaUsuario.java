package com.hotel.Logica;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
            if (pass.equals(contraseña) && user.getRol().equals("Administrador")) {
                es = true;
            }
        }
        return es;
    }

    public boolean esUser(String usuario, String contraseña) throws SQLException {
        boolean es = false;
        Usuario user = new Usuario();
        user = repo.traerUsuario(usuario);
        if (user != null) {
            String pass = user.getPassword();
            if (pass.equals(contraseña) && user.getRol().equals("Recepcionista")) {
                es = true;
            }

        }
        return es;
    }

    public void crearUsuario(String Nombre, String Apellido, String Documento, String telefono, String Rol) throws SQLException {

        Usuario user = new Usuario(Nombre, Apellido, Documento, telefono, Rol);
        user.setNombre_usuario(generarNombreUsuarioUnico(Nombre, Apellido));
        repo.crearusuario(user);

    }

    public String generarNombreUsuarioUnico(String nombre, String apellido) throws SQLException {
        int cantidad = repo.contarUsuariosConNombreYApellido(nombre,apellido);
        if (cantidad == 0) {
            return nombre + "."+apellido;
        } else {
            return nombre + cantidad + "."+apellido; // Ej: santiago1.hotel, santiago2.hotel, etc.
        }
    }

    public PrecioHora buscarPrecioHoras() {

        List<Double> lista = new ArrayList<Double>();
        lista = repo.selectHora();
        Double dia;
        Double noche;
        dia = lista.get(0);
        noche = lista.get(1);

        PrecioHora Phora = new PrecioHora(dia, noche);

        return Phora;
    }

    public void acomodoHora(PrecioHora hr) {
        repo.grabarHora(hr);
    }

    public Usuario user_for_all(String DNI) {
        Usuario user = null; // Inicializar antes del bloque try

        try {
            // Intentamos traer el usuario por el DNI
            user = repo.traerUsuarioPorDNI(DNI);
        } catch (SQLException e) {
            // Si ocurre una SQLException, se captura y se imprime el error
            e.printStackTrace();
            user = null; // Si hay un error, asignamos null al usuario
        }

        return user;

    }

    public void modificar(Usuario user, int id) {

        try {
            repo.modificar_usuario(user, id);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminar(int id_usuario) {
        try{
            repo.eliminarUsuario(id_usuario);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}
