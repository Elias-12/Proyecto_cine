/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_cine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Antonio Muralles
 */
public class Archivos {
        public static void crearArchivo(String nombreArchivo) {
        File file = new File(nombreArchivo);
        try {
            PrintWriter output = new PrintWriter(file);
            output.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
        
    }
                public static String LeerArchivo(String nombreArchivo){
            String texto="";
            try{
                BufferedReader bf = new BufferedReader(new FileReader(nombreArchivo));
                String temp ="";
                String bfReader;
                while((bfReader = bf.readLine()) !=null){
                    temp = temp + bfReader;
                }
                texto = temp;
        }catch(Exception e){
            System.err.println("No se encontro archivo");
        }
            return texto;
        }
                
        public static void EscribirArchivo(String nombreArchivo, String texto) {
        File file = new File(nombreArchivo);
        try{
            PrintWriter output = new PrintWriter(new FileWriter(file, true));
            output.println(texto);
            output.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
}
