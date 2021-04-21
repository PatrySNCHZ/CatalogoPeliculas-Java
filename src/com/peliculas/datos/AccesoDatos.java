/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peliculas.datos;
import com.peliculas.domain.Pelicula;
import com.peliculas.excepciones.*;
import java.util.List;


public interface AccesoDatos {
    
     boolean existe( String nombreArchivo) throws AccesoDatosEx;
     List<Pelicula> listar( String nombre) throws LecturaDatosEx;
     void escribir( Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx;
     String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx;
     void crear(String nombreArchivo) throws AccesoDatosEx;
     void borrar(String nombreArchivo) throws AccesoDatosEx;
    
    
    
    
}
