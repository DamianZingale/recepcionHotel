package com.hotel.View;

import java.time.LocalTime;
import javax.swing.*;

import com.hotel.model.SessionUsuario;

public class primer_panel_user extends JFrame {

    private JLabel tiempotranscurrido;
    private int horas = 0;
    private int minutos = 0;
    private int segundos = 0;

    public primer_panel_user() {
        setSize(600, 400);
        setLocation(600, 200);
        setTitle("HOTEL COOPERATIVO TAPALQUE - Seccion : Recepcion");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(new VentanaPrincipalUser());
        setVisible(true);

        // Iniciar el contador en un hilo separado
        new Thread(() -> {
            try {
                iniciarContador();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public class VentanaPrincipalUser extends JPanel {
        public VentanaPrincipalUser() {
            setLayout(null);

            JLabel Nombre = new JLabel("Bienvenido " + SessionUsuario.getUsuario().getNombre() + " " + SessionUsuario.getUsuario().getApellido());
            Nombre.setBounds(20, 20, 200, 30);
            add(Nombre);

            JLabel Inicio = new JLabel("Hora de entrada:");
            Inicio.setBounds(20, 60, 200, 30);
            add(Inicio);

            final String horarioEntrada = LocalTime.now().toString();
            JLabel HoraEntrada = new JLabel(horarioEntrada);
            HoraEntrada.setBounds(140, 60, 200, 30);
            add(HoraEntrada);

            
            tiempotranscurrido = new JLabel("00:00:00", SwingConstants.CENTER);
            tiempotranscurrido.setBounds(200, 200, 200, 30);
            add(tiempotranscurrido);

            JButton cerrarSesion = new JButton("Cerrar Sesion");
            cerrarSesion.setBounds(20, 100, 200, 30);
            add(cerrarSesion);
            cerrarSesion.addActionListener(e -> {
                SessionUsuario.cerrarSesion();
                String tiempo = tiempotranscurrido.getText();
                JOptionPane.showMessageDialog(this, "Tiempo de sesión: " + tiempo);
                new Principal().setVisible(true);
                dispose(); 
            });
        }
    }

    public void iniciarContador() throws InterruptedException {
        while (SessionUsuario.isLoggedIn()) {
            // Incrementar el contador cada segundo
            Thread.sleep(1000); // Esperar 1 segundo

            segundos++;
            if (segundos == 60) {
                segundos = 0;
                minutos++;
            }

            if (minutos == 60) {
                minutos = 0;
                horas++;
            }

            if (horas == 24) {
                horas = 0;
            }

            String tiempoFormateado = String.format("%02d:%02d:%02d", horas, minutos, segundos);

            // Asegurarse de actualizar el JLabel desde el hilo de Swing
            SwingUtilities.invokeLater(() -> {
                tiempotranscurrido.setText(tiempoFormateado);
            });
        }
    }
}
