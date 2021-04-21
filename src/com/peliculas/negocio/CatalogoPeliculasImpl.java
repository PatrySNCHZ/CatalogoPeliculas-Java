/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peliculas.negocio;

import com.peliculas.datos.*;
import com.peliculas.domain.Pelicula;
import com.peliculas.excepciones.AccesoDatosEx;
import com.peliculas.excepciones.LecturaDatosEx;
import java.util.List;

/**
 *
 * @author PatriSNCHZ
 */
public class CatalogoPeliculasImpl implements CatalogoPeliculas {
    // crear un ATRIBUTO de la INTERFACE AccesoDatos que será un objeto
    
    private final AccesoDatos datos;

    public CatalogoPeliculasImpl() {
        // Aquí con el ATRIBUTO this.datos podemos crear el nuevo objeto
        // que forma parte de AccesoDatosImplementación
        // Así podremos usar todos los métodos implementados
        this.datos = new AccesoDatosImpl();
    }
    
    
    
    
    @Override
    public void agregarPelicula(String nombrePelicula) {
        Pelicula pelicula = new Pelicula(nombrePelicula);
        boolean anexar = false;
        try {
            // Aquí estamos usando el método existe que hemos creado
            // En AccesoDatos, que nos devuelve un boolean
            anexar = datos.existe(NOMBRE_RECURSO);
            /*
             USamos el método escribir para pasar nuestra pelicula
             El nombre del recurso 
             y la variable anexar que nos devolverá un booleano 
             dependiendo de si el archivo existe o no
             Si el fichero existe, será true, por tanto anexará
             Si el fichero no existe, será false, por tanto no anexará
             Sino podríamos crear un fichero nuevo
            */
          //  if( anexar = true ){
            datos.escribir(pelicula, NOMBRE_RECURSO, anexar);
            /*}else{
            datos.crear(NOMBRE_RECURSO);
            }*/
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso a los datos"+ ex.getMessage());
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void listarPeliculas() {
        try {
            List<Pelicula> peliculas = this.datos.listar(NOMBRE_RECURSO);
            for(var pelicula: peliculas){
                System.out.println(pelicula);
            }
        } catch (LecturaDatosEx ex) {
            System.out.println("Error acceso datos");
            ex.printStackTrace(System.out);
        }
                
    }

    @Override
    public void buscarPelicula(String buscar) {
        String resultado = null;
        try {
            resultado = this.datos.buscar(NOMBRE_RECURSO, buscar);
        } catch (LecturaDatosEx ex) {
            System.out.println("Error acceso datos");
            ex.printStackTrace(System.out);
        }
            System.out.println("Resultado: " + resultado);
    }

    @Override
    public void reiniciarArchivo() {
        try {
            if(this.datos.existe(NOMBRE_RECURSO)){
                datos.borrar(NOMBRE_RECURSO);
                datos.crear(NOMBRE_RECURSO);
            }else{
                datos.crear(NOMBRE_RECURSO);
            }
        } catch (AccesoDatosEx ex) {
               System.out.println("Error al reiniciar catalogo de peliculas");
               ex.printStackTrace(System.out);
        }
    }

  
    
}
