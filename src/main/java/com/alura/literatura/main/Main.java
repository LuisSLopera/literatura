package com.alura.literatura.main;

import com.alura.literatura.model.Autores;
import com.alura.literatura.model.DatosLibros;
import com.alura.literatura.model.Libros;
import com.alura.literatura.model.RespuestaOriginal;
import com.alura.literatura.repository.AutoresRepository;
import com.alura.literatura.repository.LibrosRepository;
import com.alura.literatura.service.ConsumoAPI;
import com.alura.literatura.service.ConvertirDatos;

import java.util.Optional;
import java.util.Scanner;

public class Main {

    private Scanner entrada = new Scanner(System.in);
    private String URL_BASE ="https://gutendex.com/books/";
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConvertirDatos convertirDatos = new ConvertirDatos();
    private AutoresRepository autoresRepository;
    private LibrosRepository librosRepository;
    private Optional<Libros> libroBuscado;
    private Optional<Autores> autorBuscado;

    public Main(AutoresRepository autoresRepository, LibrosRepository librosRepository) {
        this.autoresRepository = autoresRepository;
        this.librosRepository = librosRepository;
    }


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
        Libros libro = new Libros(datosLibros);
        Autores autor = new Autores(datosLibros.autor().getFirst());
        libro.setAutor(autor);

        autorBuscado = autoresRepository.findByNombreContainsIgnoreCaseAndFechaNacimiento(autor.getNombre(),autor.getFechaNacimiento());
        libroBuscado = librosRepository.findByTitulo(libro.getTitulo());

        if (autorBuscado.isPresent()){

        } else {
            autoresRepository.save(autor);
        }

        if (libroBuscado.isPresent()){
            System.out.println("El libro ya sta cargado");
        } else{
            librosRepository.save(libro);
            System.out.println(libro);
            System.out.println(autor);
        }

    }
}
