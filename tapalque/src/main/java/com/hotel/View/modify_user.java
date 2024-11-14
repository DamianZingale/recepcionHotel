package com.hotel.View;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.hotel.Logica.LogicaUsuario;
import com.hotel.model.Usuario;

public class modify_user extends JFrame {

    private String Documento = JOptionPane.showInputDialog("Ingrese el N° documento del usuario");
    Usuario user = new Usuario();
    LogicaUsuario us = new LogicaUsuario();
    
    public modify_user(){
        
        setTitle("HOTEL COOPERATIVO TAPALQUE - Modificar usuario");
        setBounds(600, 200, 600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().add(new ventana_mod_usuario());
        setVisible(true);
    }
    
    public class ventana_mod_usuario extends JPanel{
        
        public ventana_mod_usuario(){
            user = us.user_for_all(Documento);
            int id_usuario = user.getId_usuario();
            setLayout(null);
            
            placeholder txtNombre = new placeholder(user.getNombre());
            txtNombre.setBounds(100, 30, 200, 30);  
            add(txtNombre);
            
            placeholder txtApqllido = new placeholder(user.getApellido());
            txtApqllido.setBounds(100, 75, 200, 30);
            add(txtApqllido);
            
            placeholder txtDocumento = new placeholder(user.getDocumento());
            txtDocumento.setBounds(100, 120, 200, 30);
            add(txtDocumento);
            
            placeholder txtTelefono = new placeholder(user.getTelefono());
            txtTelefono.setBounds(100, 165, 200, 30);
            add(txtTelefono);
            
            //Crear los checkboxes para roles y agregarlos al panel
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
            
            aceptar.addActionListener(e -> {
                String rol = "";
            
                // Verifica si ninguno de los JCheckBox está seleccionado
                if (group.getSelection() == null) {
                    // Si no se ha seleccionado ninguna opción, muestra el mensaje
                    JOptionPane.showMessageDialog(aceptar, "Debe elegir Administrador o Recepcionista para continuar");
                    
                    // Pone el foco en el JCheckBox Admin para que el usuario lo seleccione
                    ckAdmin.requestFocusInWindow();
                } else {
                    // Si se seleccionó un JCheckBox, asigna el valor de rol
                    if (ckAdmin.isSelected()) {
                        rol = ckAdmin.getText(); // Asigna el texto de Admin
                    } else {
                        rol = ckRecep.getText(); // Asigna el texto de Recepcionista
                    }
            
                    // Aquí puedes continuar con el flujo después de la selección
                    user.setNombre(txtNombre.getText());
                    user.setApellido(txtApqllido.getText());
                    user.setTelefono(txtTelefono.getText());
                    user.setRol(rol);
                    LogicaUsuario us = new LogicaUsuario();
                    us.modificar(user, id_usuario);
                    dispose();
                }
                
            });
            
        }


        
        
    }
    
}
