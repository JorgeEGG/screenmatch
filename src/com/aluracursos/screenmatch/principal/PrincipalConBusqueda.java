package com.aluracursos.screenmatch.principal;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Scanner;

import com.aluracursos.screenmatch.excepciones.ErrorEnConversionDeDuracionException;
import com.aluracursos.screenmatch.modelos.Titulo;
import com.aluracursos.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class PrincipalConBusqueda {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner teclado = new Scanner(System.in);
        System.out.print("\nIngrese el nombre de la pelicula: ");
        var busqueda = teclado.nextLine().replace(" ", "+");

        // String direccion =
        // "https://api.themoviedb.org/3/search/movie?query="+busqueda+"&api_key=2a41cf4f32849a7afd2e458e683d84e4&language=es-ES&page=1";
        String direccion = "https://www.omdbapi.com/?t=" + busqueda + "&apikey=53a418d1";

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();

        HttpResponse<String> response = client
                .send(request, BodyHandlers.ofString());

        String json = response.body();
        System.out.println("\n" + json);

        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
        TituloOmdb miTituloOmdb = gson.fromJson(json, TituloOmdb.class);
        System.out.println("\n" + miTituloOmdb);
        try {
            Titulo miTitulo = new Titulo(miTituloOmdb);
            System.out.println("\nTitulo convertido: " + miTitulo);
        } catch (ErrorEnConversionDeDuracionException e) {
            System.out.println("\nError en la conversión de duración: " + e.getMessage());
        } catch (NumberFormatException e) { // Ocurre en la película "The Flash" porque el año es "2023–, en "Bichos" porque la duración es "89 min (USA) y en muchas películas porque no hay duración
            System.out.println("\nError en los datos de la pelicula: " + e.getMessage());
        } finally {
            System.out.println("\nEl programa finalizó. Gracias por utilizar el buscador de películas.\n");
            teclado.close();
        }
    }
}
