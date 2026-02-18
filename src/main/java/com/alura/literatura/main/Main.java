package com.alura.literatura.main;

import com.alura.literatura.model.DatosLibros;
import com.alura.literatura.model.RespuestaOriginal;
import com.alura.literatura.service.ConsumoAPI;
import com.alura.literatura.service.ConvertirDatos;

import java.net.URL;
import java.util.Scanner;

public class Main {

    Scanner entrada = new Scanner(System.in);
    String URL_BASE ="https://gutendex.com/books/";
    ConsumoAPI consumoAPI = new ConsumoAPI();
    ConvertirDatos convertirDatos = new ConvertirDatos();

    public void menu(){

        var menuValidador = 0;

        while (menuValidador!=-1){
            System.out.println("""
                ----------------------------------------
                
                         Challenge de literatura
                
                ----------------------------------------
                
                1. Buscar libros por titulo
                2. Listar libros registrados
                3. listar autores registrados
                4. listar autores vivos en un periodo
                5. listar libros por idioma
                """);

            menuValidador = entrada.nextInt();

            switch (menuValidador){
                case 1:
                    buscarLibrosPorTitulo();
            }
        }


    }

    private void buscarLibrosPorTitulo() {
        System.out.println("Digita el nombre de libro a consultar: ");
        entrada.nextLine();
        String datoUsuario= entrada.nextLine();
        String urlFinal =URL_BASE+"?search="+datoUsuario.replace(" ","+").toLowerCase();
        String jsonRespuesta = consumoAPI.consultoBase(urlFinal);
        RespuestaOriginal respuestaOriginal = convertirDatos.obtenerDatos(jsonRespuesta, RespuestaOriginal.class);
        DatosLibros datosLibros = respuestaOriginal.libros().getFirst();
        System.out.println(datosLibros);
    }
}
