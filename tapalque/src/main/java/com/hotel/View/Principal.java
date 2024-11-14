package com.hotel.View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.hotel.Logica.LogicaUsuario;

public class Principal extends JFrame {
    private JTextField textField1;
    
    

    /*public static void main(String[] args) {
        // Crear la ventana principal
        new Principal();
    }*/

    public Principal() {
        setSize(400,300);
        setLocation(600,200);
        setTitle("HOTEL COOPERATIVO TAPALQUE");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(new VentanaPrincipal());
        setVisible(true);
    }

    public class VentanaPrincipal extends JPanel {
    	public VentanaPrincipal() {
            
            setLayout(null);

            JLabel lblLabel1 = new JLabel("Usuario:");
            lblLabel1.setFont(new Font("Arial", Font.PLAIN, 14)); 
            lblLabel1.setBounds(165, 30, 100, 30); 
            add(lblLabel1);

            textField1 = new JTextField(20);
            textField1.setFont(new Font("Arial", Font.PLAIN, 14)); 
            textField1.setBounds(100, 60, 200, 30); 
            add(textField1);

            
            JLabel lblLabel2 = new JLabel("Contraseña:");
            lblLabel2.setFont(new Font("Arial", Font.PLAIN, 14)); 
            lblLabel2.setBounds(150, 120, 100, 30); 
            add(lblLabel2);
           
            JPasswordField passwordField = new JPasswordField(20); 
            passwordField.setFont(new Font("Arial", Font.PLAIN, 14));
            passwordField.setBounds(100, 150, 200, 30);
            add(passwordField);

            // Botón de "ver contraseña"
            JButton btnVerContraseña = new JButton("🔍"); 
            btnVerContraseña.setBounds(320, 140, 50, 50); 
            add(btnVerContraseña);

               
           
            JButton btnIngresar = new JButton("Ingresar");
            btnIngresar.setFont(new Font("Arial", Font.PLAIN, 14)); 
            btnIngresar.setBounds(150, 200, 100, 30); 
            add(btnIngresar);
        
        btnVerContraseña.addActionListener(new ActionListener() {
            private boolean mostrandoContraseña = false;
    
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mostrandoContraseña) {
                    passwordField.setEchoChar('*'); // Ocultar la contraseña
                    mostrandoContraseña = false;
                } else {
                    passwordField.setEchoChar((char) 0); // Mostrar la contraseña
                    mostrandoContraseña = true;
                    }
                }
            });

        btnIngresar.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e){
               
                String usuario = textField1.getText();
                String contraseña = new String(passwordField.getPassword());
               
                LogicaUsuario log = new LogicaUsuario();
                boolean confirmacion = false;
                try {
                    confirmacion = log.EsAdmin(usuario, contraseña);
                } catch (SQLException e1) {
                   
                    e1.printStackTrace();
                }

                if(!confirmacion){
                    JOptionPane.showMessageDialog(btnIngresar, "Imposible acceder, intente nuevamente", contraseña, DISPOSE_ON_CLOSE);

                }else{
                    primer_panel_admin ventanaAdmin = new primer_panel_admin();
                    ventanaAdmin.setVisible(true);  

                    dispose(); 
           
                }


            }
        });
       
            
        }
    }
}

