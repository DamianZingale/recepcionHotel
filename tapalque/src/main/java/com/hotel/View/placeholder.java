package com.hotel.View;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

public class placeholder extends JTextField {

    public placeholder(String p){
        
        super(p);
        
       setForeground(Color.GRAY);
        
        addFocusListener(new FocusListener()  {

            public void focusGained(FocusEvent e) {
                if (getText().equals(p)) {
                    setText("");
                    setForeground(Color.BLACK); // Cambiar color cuando se empieza a escribir
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (getText().isEmpty()) {
                    setForeground(Color.GRAY); // Volver al color gris
                    setText(p); // Restaurar el placeholder
                }
            }

        });

    }

    
}
