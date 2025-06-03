package com.hotel.View;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class primer_panel_admin extends JFrame {

    
    public primer_panel_admin() {
       
        setSize(600,400);
        setLocation(600,200);
        setTitle("HOTEL COOPERATIVO TAPALQUE - Seccion : Administrador");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(new VentanaPrincipalAdmin());
        setVisible(true);
    }

    public class VentanaPrincipalAdmin extends JPanel {
    public VentanaPrincipalAdmin() {
        setLayout(null);

        // Botón y etiqueta "Agregar Usuario"
        JButton btnAgregarUsuario = new JButton("Agregar Usuario");
        btnAgregarUsuario.setBounds(50, 20, 200, 30); 
        add(btnAgregarUsuario);

        JLabel lblagregarusuario = new JLabel("Crea un nuevo usuario");
        lblagregarusuario.setBounds(270, 20, 300, 30); 
        add(lblagregarusuario);
        //Accion del boton
        btnAgregarUsuario.addActionListener(e->{
            agregar_usuario agregar = new agregar_usuario();
            agregar.setVisible(true);
            
        });

        // Botón y etiqueta "Ver retiros de usuario"
        JButton btnVerMesUsuario = new JButton("Ver retiros de usuario");
        btnVerMesUsuario.setBounds(50, 70, 200, 30);
        add(btnVerMesUsuario);

        JLabel lblVerMesUsuario = new JLabel("Revisa cómo va el usuario en horas y retiros");
        lblVerMesUsuario.setBounds(270, 70, 300, 30);
        add(lblVerMesUsuario);

        // Botón y etiqueta "Ver listado de retiros"
        JButton btnVerlistadoretiros = new JButton("Ver listado de retiros");
        btnVerlistadoretiros.setBounds(50, 120, 200, 30);
        add(btnVerlistadoretiros);

        JLabel lblVerListadoRetiros = new JLabel("Un listado con todos los retiros del mes");
        lblVerListadoRetiros.setBounds(270, 120, 300, 30);
        add(lblVerListadoRetiros);

        // Botón y etiqueta "Modificar usuario"
        JButton btnModificarUsuario = new JButton("Modificar usuario");
        btnModificarUsuario.setBounds(50, 170, 200, 30);
        add(btnModificarUsuario);

        btnModificarUsuario.addActionListener(e->{
            modify_user mod_user = new modify_user();
            mod_user.setVisible(true);
        });

        JLabel lblModificarUsuario = new JLabel("Modifica alguna propiedad de un usuario");
        lblModificarUsuario.setBounds(270, 170, 300, 30);
        add(lblModificarUsuario);

        // Botón y etiqueta "Agregar horas"
        JButton btnAgregarHoras = new JButton("Agregar horas de trabajo a...");
        btnAgregarHoras.setBounds(50, 220, 200, 30);
        add(btnAgregarHoras);

        JLabel lblAgregarHoras = new JLabel("Agrega horas no contabilizadas por el sistema");
        lblAgregarHoras.setBounds(270, 220, 300, 30);
        add(lblAgregarHoras);

        // Botón y etiqueta "Eliminar usuario"
        JButton btnEliminarUsuario = new JButton("Eliminar usuario");
        btnEliminarUsuario.setBounds(50, 270, 200, 30);
        add(btnEliminarUsuario);
        JLabel lblEliminarUsuario = new JLabel("Elimina un usuario (permanente)");
        lblEliminarUsuario.setBounds(270, 270, 300, 30);
        add(lblEliminarUsuario);
        //Accion del boton
        btnEliminarUsuario.addActionListener(e->{
            delete_user delete = new delete_user();
            delete.setVisible(true);
        });

        // Botón y etiqueta "Establecer precio"
        JButton btnPrecioHora= new JButton("Establecer precio");
        btnPrecioHora.setBounds(50, 320, 200, 30);
        add(btnPrecioHora);

        JLabel lblPrecioHora = new JLabel("Establece el precio de la hora laboral");
        lblPrecioHora.setBounds(270, 320, 300, 30);
        add(lblPrecioHora);

        //accion del boton
        btnPrecioHora.addActionListener(e->{
            seteo_horas setear = new seteo_horas();
            setear.setVisible(true);
            
        });
        }
        
    }
}
