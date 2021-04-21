
package com.peliculas.presentacion;

import com.peliculas.negocio.CatalogoPeliculas;
import com.peliculas.negocio.CatalogoPeliculasImpl;
import java.util.Scanner;

public class PeliculasPresentacion {
    public static void main(String[] args) {
        var option = -1;
        int op = -1;
        var scanner = new Scanner(System.in);
        

            /* Aquí estamos usando la implementación de CatalogoPeliculas
             Estamos de esta manera relacionandonos con CatalogoPeliculasImpl
             creando una variable objeto de ese tipo 
             Para poder usar los métodos de esa capa y no relacionar
             de manera explicita en esta capa actual que verá el usuario 
             la construcción de los métodos y archivos usados */
            
        
        CatalogoPeliculas catalogo = new CatalogoPeliculasImpl();
        
        while (option != 0 ){
            System.out.println("Elige una opcion: \n"
                    + "1. Reiniciar catalogo peliculas\n"
                    + "2. Agregar pelicula\n"
                    + "3. Listar peliculas \n"
                    + "4. Buscar pelicula \n"
                    + "0. Salir"             
            );
            
            // Aquí usaremos nextLine por tanto tendremos que convertir
            // nuestra entrada por scanner en un Integer con parseInt
            option = Integer.parseInt(scanner.nextLine());
            
            // Ahora agregaremos un switch para procesar y ejecutar las opciones que nos de el usuario
            
            
                switch(option){
                    case 1: 
                            
                              System.out.println("¿Estás seguro? Esto borrará todos los registros de peliculas del catalogo.\n"
                            + "1. Sí, borralo\n"
                            + "2. No. No lo hagas\n");
                            op = Integer.parseInt(scanner.nextLine());
                            switch (op){
                                case 1: 
                                    catalogo.reiniciarArchivo();
                                    break;
                                case 2:
                                    break;
                            }
                        break;
                    case 2:
                        System.out.println("Introduce el nombre de la pelicula");
                        var nombrePelicula = scanner.nextLine();
                        catalogo.agregarPelicula(nombrePelicula);
                        break;
                    case 3: 
                        catalogo.listarPeliculas();
                        break;
                    case 4: 
                        System.out.println("Introduce el nombre de la pelicula que quieres buscar");
                        var buscar = scanner.nextLine();
                        catalogo.buscarPelicula(buscar);
                        break;
                    case 0:
                        System.out.println("Hasta pronto!");
                        break;
                    default:
                        System.out.println("Opción no reconocida");
                }
            
        }
    }
}
