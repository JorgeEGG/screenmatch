package com.aluracursos.screenmatch.calculos;

public class FiltroRecomendacion {

    public void filtra (Clasificacion clasificacion){
    
        if (clasificacion.getClasificacion() >= 4){
            System.out.println("Muy bien evaluado.");
        } else if (clasificacion.getClasificacion() >= 3) {
            System.out.println("Puede ser una buena elección. Muy popular en el momento.");
        } else {
            System.out.println("Colócalo en tu lista para verlo después.");
        }
    }
}
