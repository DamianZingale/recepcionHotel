package com.hotel.model;

public class SessionUsuario {
    private static Usuario usuario;

    public SessionUsuario(Usuario u) {
        usuario = u;
    }
    public static void setUsuario(Usuario u) {
        usuario = u;
    }

    public static Usuario getUsuario() {
        return usuario;
    }

    public static void cerrarSesion() {
        usuario = null;
    }
    public static boolean isLoggedIn() {
        
        throw new UnsupportedOperationException("Unimplemented method 'isLoggedIn'");
    }
}
