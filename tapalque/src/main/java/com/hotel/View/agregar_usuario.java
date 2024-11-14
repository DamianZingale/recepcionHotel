package com.hotel.View;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.hotel.Logica.LogicaUsuario;



public class agregar_usuario extends JFrame{

    public static void main(String[] args) {
        // Crear la ventana principal
        new Principal();
    }
    public agregar_usuario(){

        setSize(400,400);
        setLocation(600,200);
        setTitle("HOTEL COOPERATIVO TAPALQUE - Agregar Usuario");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().add(new form_usuario());
        setVisible(true);
    }

    public class form_usuario extends JPanel {

        public form_usuario() {
            setLayout(null);  
           
            placeholder txtNombre = new placeholder("Nombre");
            txtNombre.setBounds(100, 30, 200, 30);  
            add(txtNombre);

            placeholder txtApqllido = new placeholder("Apellido");
            txtApqllido.setBounds(100, 75, 200, 30);
            add(txtApqllido);

            placeholder txtDocumento = new placeholder("Documento");
            txtDocumento.setBounds(100, 120, 200, 30);
            add(txtDocumento);

            placeholder txtTelefono = new placeholder("Telefono");
            txtTelefono.setBounds(100, 165, 200, 30);
            add(txtTelefono);

            // Crear los checkboxes para roles y agregarlos al panel
            JCheckBox ckAdmin = new JCheckBox("Administrador");
            JCheckBox ckRecep = new JCheckBox("Recepcionista");
            ButtonGroup group = new ButtonGroup();
            ckAdmin.setBounds(100, 200, 150, 20);
            ckRecep.setBounds(100, 230, 150, 20);
            group.add(ckAdmin);
            group.add(ckRecep);

            // Agregar los checkboxes al panel
            add(ckAdmin);
            add(ckRecep);

            JButton aceptar = new JButton("Aceptar");
            aceptar.setBounds(150, 280, 100, 60);
            add(aceptar);

            aceptar.addActionListener( e->{
                String rol = "";
                if(ckAdmin.isSelected()){
                    rol = ckAdmin.getText();
                }else{
                    rol = ckRecep.getText();
                }
                LogicaUsuario us = new LogicaUsuario();
                us.crearUsuario(txtNombre.getText(), txtApqllido.getText(),txtDocumento.getText(),txtTelefono.getText(),rol);
                dispose();
            });
        }
    }
}