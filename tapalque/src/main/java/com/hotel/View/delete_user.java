package com.hotel.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.hotel.Logica.LogicaUsuario;
import com.hotel.model.Usuario;

public class delete_user extends JFrame {

    private String Documento;
    private Usuario user;
    private LogicaUsuario us = new LogicaUsuario();

    public delete_user() {
        Documento = JOptionPane.showInputDialog("Ingrese el N° documento del usuario a eliminar");

        user = us.user_for_all(Documento);
        if (user == null) {
            JOptionPane.showMessageDialog(this, "Usuario no encontrado con ese documento.");
            dispose(); // Cierra esta ventana y retorna al menú anterior
            return;
        }

        setTitle("HOTEL COOPERATIVO TAPALQUE - Eliminar usuario");
        setBounds(600, 200, 600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().add(new ventana_delete_usuario());
        setVisible(true);
    }

    public class ventana_delete_usuario extends JPanel {

        public ventana_delete_usuario() {
            setLayout(null);

            JLabel lblNombre = new JLabel("Nombre: " + user.getNombre());
            lblNombre.setBounds(100, 30, 300, 25);
            add(lblNombre);

            JLabel lblApellido = new JLabel("Apellido: " + user.getApellido());
            lblApellido.setBounds(100, 65, 300, 25);
            add(lblApellido);

            JLabel lblDocumento = new JLabel("Documento: " + user.getDocumento());
            lblDocumento.setBounds(100, 100, 300, 25);
            add(lblDocumento);

            JLabel lblTelefono = new JLabel("Teléfono: " + user.getTelefono());
            lblTelefono.setBounds(100, 135, 300, 25);
            add(lblTelefono);

            JLabel lblRol = new JLabel("Rol: " + user.getRol());
            lblRol.setBounds(100, 170, 300, 25);
            add(lblRol);

            JButton btnEliminar = new JButton("Eliminar Usuario");
            btnEliminar.setBounds(200, 230, 160, 50);
            add(btnEliminar);

            btnEliminar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int confirm = JOptionPane.showConfirmDialog(
                            delete_user.this,
                            "¿Está seguro que desea eliminar este usuario?",
                            "Confirmar eliminación",
                            JOptionPane.YES_NO_OPTION
                    );

                    if (confirm == JOptionPane.YES_OPTION) {
                        us.eliminar(user.getId_usuario());
                        JOptionPane.showMessageDialog(delete_user.this, "Usuario eliminado correctamente.");
                        dispose(); // Cierra la ventana después de eliminar
                    }
                }
            });
        }
    }
}