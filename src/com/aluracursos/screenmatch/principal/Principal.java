package com.aluracursos.screenmatch.principal;
import java.util.ArrayList;

import com.aluracursos.screenmatch.calculos.CalculadoraDeTiempo;
import com.aluracursos.screenmatch.calculos.FiltroRecomendacion;
import com.aluracursos.screenmatch.modelos.Episodio;
import com.aluracursos.screenmatch.modelos.Pelicula;
import com.aluracursos.screenmatch.modelos.Serie;

public class Principal {
    public static void main(String[] args) {

        Pelicula miPelicula = new Pelicula("Encanto", 2021);
        miPelicula.setDuracionEnMinutos(120);
        miPelicula.setIncluidoEnElPlan(true);

        miPelicula.muestraFichaTecnica(); // Esta línea reemplaza el bloque de código (1) comentado abajo
        miPelicula.evalua(10);
        miPelicula.evalua(10);
        miPelicula.evalua(7.8);
        System.out.printf("Promedio de las evaluaciones para la película: %.2f%n",miPelicula.calculaMediaDeEvaluaciones());
        System.out.println("Cantidad de evaluaciones: " + miPelicula.getTotalDeEvaluaciones());

        Pelicula otraPelicula = new Pelicula("Titanic", 1997);
        otraPelicula.setDuracionEnMinutos(180);
        otraPelicula.setIncluidoEnElPlan(false);
        
        // Este bloque de código (1) muestra la ficha técnica de otraPelicula y se puede reemplazar por un llamado al método muestraFichaTecnica()
        // System.out.println("\nMi otra película es " + otraPelicula.nombre);
        // System.out.println("Su fecha de lanzamiento fue en el ano " + otraPelicula.fechaDeLanzamiento);
        // System.out.println("Su duración es de " + otraPelicula.duracionEnMinutos + " minutos");
        // System.out.println("¿Está incluida en el plan? " + otraPelicula.incluidoEnElPlan);

        otraPelicula.muestraFichaTecnica();
        otraPelicula.evalua(9);
        otraPelicula.evalua(6.5);
        otraPelicula.evalua(8);
        otraPelicula.evalua(7.5);
        System.out.printf("Promedio de las evaluaciones para la película: %.2f%n",otraPelicula.calculaMediaDeEvaluaciones());
        System.out.println("Cantidad de evaluaciones: " + otraPelicula.getTotalDeEvaluaciones());

        Serie casaDragon = new Serie("La Casa del Dragon", 2022);
        casaDragon.setTemporadas(1);
        casaDragon.setMinutosPorEpisodio(50);
        casaDragon.setEpisodiosPorTemporada(10);
        casaDragon.setIncluidoEnElPlan(true);
        
        casaDragon.muestraFichaTecnica();
        casaDragon.evalua(10);
        casaDragon.evalua(9.5);
        System.out.printf("Promedio de las evaluaciones para la película: %.2f%n",casaDragon.calculaMediaDeEvaluaciones());
        System.out.println("Cantidad de evaluaciones: " + casaDragon.getTotalDeEvaluaciones());
        System.out.println("La duración total de la serie es de " + casaDragon.getDuracionEnMinutos() + " minutos");
        
        CalculadoraDeTiempo calculadora = new CalculadoraDeTiempo();
        calculadora.incluye(miPelicula);
        calculadora.incluye(casaDragon);
        calculadora.incluye(otraPelicula);
        System.out.println("\nTiempo necesario para ver tus títulos favoritos en estas vacaciones: " + calculadora.getTiempoTotal() + " minutos\n");

        FiltroRecomendacion filtroRecomendacion = new FiltroRecomendacion();
        filtroRecomendacion.filtra(miPelicula);

        Episodio episodio = new Episodio();
        episodio.setNombre("La casa Targaryen");
        episodio.setNumero(1);
        episodio.setSerie(casaDragon);
        episodio.setTotalVisualizaciones(350);

        filtroRecomendacion.filtra(episodio);

        var peliculaDeKike = new Pelicula("El señor de los anillos: La comunidad del anillo", 2001);
        peliculaDeKike.setDuracionEnMinutos(178);
        peliculaDeKike.setIncluidoEnElPlan(true);

        peliculaDeKike.muestraFichaTecnica();
        peliculaDeKike.evalua(10);
        peliculaDeKike.evalua(9.5);
        System.out.printf("Promedio de las evaluaciones para la película: %.2f%n",peliculaDeKike.calculaMediaDeEvaluaciones());
        System.out.println("Cantidad de evaluaciones: " + peliculaDeKike.getTotalDeEvaluaciones());
        System.out.println("\nLa duración de la película es de " + peliculaDeKike.getDuracionEnMinutos() + " minutos");

        ArrayList<Pelicula> listaDePeliculas = new ArrayList<>();
        listaDePeliculas.add(peliculaDeKike);
        listaDePeliculas.add(miPelicula);
        listaDePeliculas.add(otraPelicula);

        System.out.println("\n----Creando lista de películas----");
        System.out.println("\nLista de películas:");
        System.out.println("\n" + listaDePeliculas);
        System.out.println("\n" + listaDePeliculas.get(0).toString());
        System.out.println(listaDePeliculas.get(1).toString());
        System.out.println(listaDePeliculas.get(2).toString());

        System.out.println("\nNúmero de películas: " + listaDePeliculas.size());
        System.out.println("La primera película de la lista es: " + listaDePeliculas.get(0).getNombre() + "\n");
        
    }
}
