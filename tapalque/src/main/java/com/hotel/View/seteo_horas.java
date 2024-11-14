package com.hotel.View;



import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.hotel.Logica.LogicaUsuario;
import com.hotel.model.PrecioHora;

public class seteo_horas extends JFrame{


    private LogicaUsuario log = new LogicaUsuario();
    private PrecioHora precio = log.buscarPrecioHoras();

    public seteo_horas(){

        setTitle("Precio de hora");
        setBounds(700,400,270,250);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().add(new horas());
        setVisible(true);


    }

    public class horas  extends JPanel {
        
       
        
        public horas(){
        setLayout(null);

        JLabel lbldia = new JLabel("Horas DIA:");
        lbldia.setBounds(40, 20, 90, 20);
        add(lbldia);
        JTextField txtdia = new JTextField(precio.getDiurna().toString());
        txtdia.setBounds(150, 20, 50, 20);
        add(txtdia);

        JLabel lblnoche = new JLabel("Horas NOCHE:");
        lblnoche.setBounds(40, 60, 90, 20);
        add(lblnoche);
        JTextField txtnoche = new JTextField(precio.getNocturna().toString());
        txtnoche.setBounds(150, 60, 50, 20);
        add(txtnoche);

        JButton guardar = new JButton("Guardar");
        guardar.setBounds(70,100, 100, 30);
        add(guardar);
        guardar.addActionListener(e->{
            precio.setDiurna( Double.parseDouble(txtdia.getText()));
            precio.setNocturna(Double.parseDouble(txtnoche.getText()));
            System.out.println("hora dia: " + precio.getDiurna());
            log.acomodoHora(precio);
            dispose();

        });

        JButton cancelar = new JButton("Cancelar");
        cancelar.setBounds(70, 140, 100, 30);
        add(cancelar);
        cancelar.addActionListener(e->{
            dispose();
        });


       }
    
        
    }
    


}
