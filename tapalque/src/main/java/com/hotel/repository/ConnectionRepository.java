package com.hotel.repository;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionRepository {

    private  Connection cn;
    private String URL = "jdbc:sqlite:tapalque/HotelTapalque.db";

    public ConnectionRepository(){}
    
    public Connection conexion() {
    try {
        if (cn == null || cn.isClosed()) {
            cn = DriverManager.getConnection(URL);
            System.out.println("Conexión a SQLite establecida.");
        }
    } catch (SQLException e) {
        System.err.println("Error: No se puede conectar a la base de datos.");
        e.printStackTrace();
        cn = null;
    }
    return cn;
}
    

    // Método para cerrar la conexión
    public  void cerrarConexion() {
        if (cn != null) {
            try {
                if(!cn.isClosed()){
                    cn.close();
                    System.out.println("Conexión a SQLite cerrada.");
                    cn = null;
                }
            } catch (SQLException e) {
                System.err.println("Error: No se pudo cerrar la conexión.");
                e.printStackTrace();
            } 
        }
    }



    

   
                                
}
