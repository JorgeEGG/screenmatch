package com.aluracursos.screenmatch.principal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import com.aluracursos.screenmatch.modelos.Episodio;
import com.aluracursos.screenmatch.modelos.Pelicula;
import com.aluracursos.screenmatch.modelos.Serie;
import com.aluracursos.screenmatch.modelos.Titulo;

public class PrincipalConListas {
    public static void main(String[] args) {

        Pelicula miPelicula = new Pelicula("Encanto", 2021);
        Pelicula otraPelicula = new Pelicula("Titanic", 1997);
        var peliculaDeKike = new Pelicula("El señor de los anillos: La comunidad del anillo", 2001);
        Serie casaDragon = new Serie("La Casa del Dragon", 2022);
        Episodio episodio = new Episodio();

        Pelicula p1 = miPelicula; // Upcasting: una Pelicula es un Titulo
        System.out.println("\n" + p1.getNombre());

        System.out.println("\n*********************************\n");

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(miPelicula);
        miPelicula.evalua(9);
        lista.add(otraPelicula);
        otraPelicula.evalua(6);
        lista.add(peliculaDeKike);
        peliculaDeKike.evalua(10);
        lista.add(casaDragon);
        casaDragon.evalua(8);

        for (Titulo item : lista) {
            System.out.println(item.getNombre());
            if (item instanceof Pelicula pelicula && pelicula.getClasificacion() > 2) { // Aquí usamos pattern matching para el casting y la condición en una sola línea
            // Pelicula pelicula = (Pelicula) item; // Casting explícito de Titulo a Pelicula que es innecesario con pattern matching
                System.out.println(pelicula.getClasificacion());
            } else if (item instanceof Serie serie && serie.getClasificacion() > 2) {
                System.out.println(serie.getClasificacion());
            }
        }

        System.out.println("\n*********************************\n");
        // Utilizando la interfaz List y LinkedList como clase igual que ArrayList, con objetos de tipo Titulo
        List<Titulo> otraLista = new LinkedList<>();
        otraLista.add(miPelicula);
        otraLista.add(otraPelicula);
        otraLista.add(peliculaDeKike);
        otraLista.add(casaDragon);

        for (Titulo item : otraLista) {
            System.out.println(item.getNombre());
            if (item instanceof Pelicula pelicula && pelicula.getClasificacion() > 2) { // Aquí usamos pattern matching para el casting y la condición en una sola línea
            // Pelicula pelicula = (Pelicula) item; // Casting explícito de Titulo a Pelicula que es innecesario con pattern matching
                System.out.println(pelicula.getClasificacion());
            } else if (item instanceof Serie serie && serie.getClasificacion() > 2) {
                System.out.println(serie.getClasificacion());
            }
        }

        System.out.println("\n*********************************\n");
        //Lista de artistas
        ArrayList<String> listaDeArtistas = new ArrayList<>();
        listaDeArtistas.add("Leonardo DiCaprio");
        listaDeArtistas.add("Jennifer Lawrence");
        listaDeArtistas.add("Tom Cruise");
        listaDeArtistas.add("Natalie Portman");
        listaDeArtistas.add("Morgan Freeman");

        System.out.println("\nLista de artistas desordenada:\n" + listaDeArtistas);

        Collections.sort(listaDeArtistas);
        System.out.println("\nLista de artistas ordenada:\n" + listaDeArtistas);

        Collections.sort(lista);
        System.out.println("\nLista de títulos ordenada por nombre:\n" + lista);

        Collections.sort(otraLista);
        System.out.println("\nOtra lista de títulos ordenada por nombre:\n" + otraLista);

        lista.sort(Comparator.comparing(Titulo::getFechaDeLanzamiento));
        System.out.println("\nLista de títulos ordenada por año de lanzamiento:\n" + lista);

        otraLista.sort(Comparator.comparing(Titulo::getFechaDeLanzamiento));
        System.out.println("\nOtra lista de títulos ordenada por año de lanzamiento:\n" + otraLista + "\n");
    }
}
