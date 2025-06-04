package com.hotel.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.springframework.stereotype.Repository;

import com.hotel.model.PrecioHora;
import com.hotel.model.Usuario;

@Repository

public class UserRepository implements I_UserRepository {

    private ConnectionRepository cn;

    public UserRepository() {
        cn = new ConnectionRepository();
    }

    public void crearusuario(Usuario us) {
        String sql = "INSERT INTO Usuario (nombre, apellido, documento, telefono, nombre_usuario, password, rol) VALUES (?, ?, ?, ?, ?, ?, ?)";
        Connection conn = cn.conexion();
        PreparedStatement st;
        try {
            st = conn.prepareStatement(sql);
            if (st != null) {
                st.setString(1, us.getNombre());
                st.setString(2, us.getApellido());
                st.setString(3, us.getDocumento());
                st.setString(4, us.getTelefono());
                st.setString(5, us.getNombre_usuario());
                st.setString(6, us.getPassword());
                st.setString(7, us.getRol());
                int rowsInserted = st.executeUpdate();
                if (rowsInserted > 0) {

                    JOptionPane.showMessageDialog(null, "Usuario creado exitosamente.\nNombre de usuario: "
                            + us.getNombre_usuario() + '\n' + "Contraseña: " + us.getPassword());
                }

            }
        } catch (SQLException e) {

            e.printStackTrace();
            System.out.println("Error al intentar guardar usuario");
        }

    }

    public Usuario traerUsuario(String userName) throws SQLException {

        String sql = "SELECT * FROM Usuario WHERE nombre_usuario = ?";
        Usuario usuario = new Usuario();
        Connection conn = cn.conexion();
        PreparedStatement st = conn.prepareStatement(sql);
        try {
            if (st != null) {
                st.setString(1, userName);

                ResultSet rs = st.executeQuery();
                while (rs.next()) {

                    usuario.setId_usuario(rs.getInt("id_usuario"));
                    usuario.setNombre(rs.getString("Nombre"));
                    usuario.setApellido(rs.getString("apellido"));
                    usuario.setDocumento(rs.getString("documento"));
                    usuario.setTelefono(rs.getString("telefono"));
                    usuario.setNombre_usuario(rs.getString("nombre_usuario"));
                    usuario.setPassword(rs.getString("password"));
                    usuario.setRol(rs.getString("rol"));

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error tratando de acceder");
        }

        cn.cerrarConexion();
        return usuario;
    }

    public int contarUsuariosConNombreYApellido(String nombre, String apellido) {
        int cantidad = 0;
        String sql = "SELECT COUNT(*) FROM Usuario WHERE nombre = ? AND apellido = ?";
       

        try (Connection conn = cn.conexion() ; //colocamos la conexion en el try para que el mismo bloque la cierre al terminar
             PreparedStatement st = conn.prepareStatement(sql)) {
            
            st.setString(1, nombre);
            st.setString(2, apellido);
            
            try (ResultSet rs = st.executeQuery() ){
            if (rs.next()) {
                    cantidad = rs.getInt(1); // cantidad de usuarios encontrados
                }
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al contar usuarios con mismo nombre y apellido");
        }
        // si la conexion a bd no estuviese en el try, habria que cerrar la conexion aca con cn.cerrarConexion();
        return cantidad;
    }

    public List<Double> selectHora() {

        List<Double> horasP = new ArrayList<>();
        String query = "select dia, noche from Precio";
        Connection conn = cn.conexion();
        PreparedStatement st = null;
        try {
            if (conn != null) {
                st = conn.prepareStatement(query);
                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    horasP.add(rs.getDouble("dia"));
                    horasP.add(rs.getDouble("noche"));

                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return horasP;
    }

    public void grabarHora(PrecioHora hr) {

        String query = "UPDATE Precio SET dia = ?, noche = ? WHERE id_hora = 1";
        Connection conn = cn.conexion();
        PreparedStatement st = null;

        try {

            if (conn != null) {
                st = conn.prepareStatement(query);
                st.setDouble(1, hr.getDiurna());
                st.setDouble(2, hr.getNocturna());
                st.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {

            try {
                if (st != null)
                    st.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Usuario traerUsuarioPorDNI(String DNI) throws SQLException {

        String sql = "SELECT * FROM Usuario WHERE documento = ?";
        Usuario usuario = null; //La cambie a null porque si no encuentra me retornaba un usuario vacio y no null(Santi)
        Connection conn = cn.conexion();
        PreparedStatement st = conn.prepareStatement(sql);
        try {
            if (st != null) {
                st.setString(1, DNI);

                ResultSet rs = st.executeQuery();
                while (rs.next()) {

                    usuario.setId_usuario(rs.getInt("id_usuario"));
                    usuario.setNombre(rs.getString("Nombre"));
                    usuario.setApellido(rs.getString("apellido"));
                    usuario.setDocumento(rs.getString("documento"));
                    usuario.setTelefono(rs.getString("telefono"));
                    usuario.setNombre_usuario(rs.getString("nombre_usuario"));
                    usuario.setPassword(rs.getString("password"));
                    usuario.setRol(rs.getString("rol"));

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error tratando de acceder");
        }

        // cn.cerrarConexion();
        return usuario;
    }

    public Usuario modificar_usuario(Usuario us, int id) throws SQLException {

        String sql = "update Usuario set Nombre = ?, apellido = ?, telefono = ?, rol = ? where id_usuario = ?";
        Usuario usuario = new Usuario();
        usuario = us;
        Connection conn = cn.conexion();
        PreparedStatement st = conn.prepareStatement(sql);
        try {
            if (st != null) {
                st.setString(1, us.getNombre());
                st.setString(2, us.getApellido());
                st.setString(3, us.getTelefono());
                st.setString(4, us.getRol());
                st.setInt(5, id);

                st.executeUpdate();

            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error tratando de acceder");
        }

        cn.cerrarConexion();
        return usuario;
    }

    public void guardarTiempo(String tiempo) {
        String sql = "INSERT INTO Tiempo (tiempo) VALUES (?)";
        Connection conn = cn.conexion();
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(sql);
            if (st != null) {
                st.setString(1, tiempo);
                int rowsInserted = st.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Tiempo guardado exitosamente.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al intentar guardar tiempo");
        } finally {
            try {
                if (st != null)
                    st.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public void eliminarUsuario(int id) {
        String sql = "DELETE FROM Usuario WHERE id_usuario = ?";
        Connection conn = cn.conexion();
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(sql);
            if (st != null) {
                st.setInt(1, id);
                int rowsDeleted = st.executeUpdate();
                if (rowsDeleted > 0) {
                    System.out.println("Usuario eliminado exitosamente.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al intentar eliminar usuario");
        } finally {
            try {
                if (st != null)
                    st.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
