package com.hotel.View;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class primer_panel_user extends JFrame {
    
    public primer_panel_user() {
       
        setSize(600,400);
        setLocation(600,200);
        setTitle("HOTEL COOPERATIVO TAPALQUE - Seccion : Administrador");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(new VentanaPrincipalUser());
        setVisible(true);
    }

    public class VentanaPrincipalUser extends JPanel {
        public VentanaPrincipalUser() {
            setLayout(null);
            
            
        }
    }
    

}
