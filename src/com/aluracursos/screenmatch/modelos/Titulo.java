package com.aluracursos.screenmatch.modelos;

import com.google.gson.annotations.SerializedName;
import com.aluracursos.screenmatch.modelos.Titulo;

public class Titulo implements Comparable<Titulo>{
    
    @SerializedName("Title")
    private String nombre;
    @SerializedName("Year")
    private int fechaDeLanzamiento;
    private String sinopsis;
    private int duracionEnMinutos;
    private boolean incluidoEnElPlan;
    private double sumaDeLasEvaluaciones;
    private int totalDeEvaluaciones;
    
    
    public Titulo(String nombre, int fechaDeLanzamiento) {
        this.nombre = nombre;
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    public Titulo(TituloOmdb miTituloOmdb) {
        this.nombre = miTituloOmdb.title();
        this.fechaDeLanzamiento = Integer.valueOf(miTituloOmdb.year());
        this.sinopsis = miTituloOmdb.plot();
        this.duracionEnMinutos = Integer.valueOf(miTituloOmdb.runtime().replace(" min", ""));
        // this.duracionEnMinutos = Integer.valueOf(miTituloOmdb.runtime().substring(0, 3));
        // String duracion = miTituloOmdb.runtime();
        // this.duracionEnMinutos = Integer.valueOf(duracion.replace(" min", ""));
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFechaDeLanzamiento() {
        return fechaDeLanzamiento;
    }

    public void setFechaDeLanzamiento(int fechaDeLanzamiento) {
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public int getDuracionEnMinutos() {
        return duracionEnMinutos;
    }

    public void setDuracionEnMinutos(int duracionEnMinutos) {
        this.duracionEnMinutos = duracionEnMinutos;
    }

    public void setIncluidoEnElPlan(boolean incluidoEnElPlan) {
        this.incluidoEnElPlan = incluidoEnElPlan;
    }

    public double getSumaDeLasEvaluaciones() {
        return sumaDeLasEvaluaciones;
    }

    public int getTotalDeEvaluaciones() {
        return totalDeEvaluaciones;
    }

    public void muestraFichaTecnica() {
        System.out.println("\nEl nombre de la película es " + nombre);
        System.out.println("Su fecha de lanzamiento fue en el año " + fechaDeLanzamiento);
        System.out.println("Su duración es de " + getDuracionEnMinutos() + " minutos");
        System.out.println("¿Está incluida en el plan? " + incluidoEnElPlan);
    }

    public void evalua(double nota) {
        sumaDeLasEvaluaciones += nota;
        totalDeEvaluaciones++;

    }

    public double calculaMediaDeEvaluaciones() {
        return sumaDeLasEvaluaciones / totalDeEvaluaciones;
    }

    @Override
    public int compareTo(Titulo otroTitulo) {
        return this.getNombre().compareTo(otroTitulo.getNombre());
    }

    @Override
    public String toString() {
        return "\nTitulo: " + nombre + " (" + fechaDeLanzamiento + ")" +
               "\nSinopsis: " + sinopsis +
               "\nDuración: " + duracionEnMinutos + " minutos";
    }

    
    
}
