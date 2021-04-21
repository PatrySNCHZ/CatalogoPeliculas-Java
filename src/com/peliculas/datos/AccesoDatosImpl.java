package com.peliculas.datos;

import com.peliculas.domain.Pelicula;
import com.peliculas.excepciones.*;
import java.io.*;
import java.util.*;




public class AccesoDatosImpl implements AccesoDatos{

    @Override
    public boolean existe(String nombreArchivo){
        File archivo = new File(nombreArchivo);
        return archivo.exists(); // exists() regresa un booleano según el fichero existe o no.
        
    }

    @Override
    public List<Pelicula> listar(String nombre) throws LecturaDatosEx {
        File archivo = new File(nombre);
        List<Pelicula> peliculas = new ArrayList<>();
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String linea  = null;
            linea = entrada.readLine();
            while (linea !=null){
                Pelicula pelicula= new Pelicula(linea);
                peliculas.add(pelicula);
                linea = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx ("Excepción al listar peliculas" + ex.getMessage());
       
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx ("Excepción al listar peliculas" + ex.getMessage());
        }
        
        return peliculas;
        
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(pelicula.toString());
            salida.close();
            System.out.println("Se ha escrito información al archivo:" + pelicula);
        } catch (IOException ex) {
            ex.printStackTrace();
           throw new EscrituraDatosEx ("Escritura fallida:" + ex.getMessage());
        }
    }

    @Override
    public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx {
        File archivo = new File(nombreArchivo);
        String resultado = null;
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            int indice = 1 ; 
            while (linea !=null){
                if (buscar != null && buscar.equalsIgnoreCase(linea)){
                 resultado = "Pelicula " + linea + " encontrada en el indice " + indice;
                 break;
                }
            linea = entrada.readLine();
            indice++;
             
            }
            entrada.close();
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx ("Excepción al buscar archivo" + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx ("Excepción al buscar archivo" + ex.getMessage());
        }
        
        return resultado;
    }

    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(archivo);
            salida.close();
            System.out.println("Se ha creado el nuevo fichero: " + archivo );
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new AccesoDatosEx ("Excepción al crear el nuevo fichero " + ex.getMessage());
        }
        
        
    }

    @Override
    public void borrar(String nombreArchivo){
        File archivo = new File(nombreArchivo);
        if(archivo.exists())
            archivo.delete();
            System.out.println("Se ha borrado el fichero " + archivo);
        }
    

}


  

