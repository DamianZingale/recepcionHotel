package com.hotel.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class PrecioHora {

    private Double diurna;
    private Double nocturna;

    public PrecioHora(){

        diurna = 0.0;
        nocturna = 0.0;
    }



}
