/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_cine;
import java.io.File;
import java.util.Scanner;
import java.io.*;
import java.io.BufferedReader;
import java.util.Random;
/**
 *
 * @author Elias
 */
public class Proyecto_cine {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String nombreArchivo;
        nombreArchivo = "C:\\ProyectoCine\\clientes.txt";
        Archivos.crearArchivo(nombreArchivo);
        DosMil_Clientes();
        nombreArchivo = "C:\\ProyectoCine\\catalogoPeliculas.txt";
        Archivos.crearArchivo(nombreArchivo);  
        CrearPeliculas();
        nombreArchivo = "C:\\ProyectoCine\\catalogoEmpleados.txt";
        Archivos.crearArchivo(nombreArchivo);        
        nombreArchivo = "C:\\ProyectoCine\\catalogoCajas.txt";
        Archivos.crearArchivo(nombreArchivo);         
        nombreArchivo = "C:\\ProyectoCine\\catalogoSalas.txt";
        Archivos.crearArchivo(nombreArchivo);  
        
        File Archivo_Clientes = new File("C:\\ProyectoCine\\clientes.txt");
//        File Archivo_CatPeliculas = new File("C:\\ProyectoCine\\catalogoPeliculas.txt.txt");
        File Archivo_CatEmpleados = new File("C:\\ProyectoCine\\catalogoEmpleados.txt");
        File Archivo_CarCajas = new File("C:\\ProyectoCine\\catalogoCajas.txt");
        File Archivo_CatSalas = new File("C:\\ProyectoCine\\catalogoSalas.txt");

        Scanner ingreso = new Scanner(System.in);
        boolean salir = false;
        while(!salir){
        System.out.println("------Gestion de Cine------");
        System.out.println("1. Administracion ");
        System.out.println("2. Ventas ");
        System.out.println("3. Salir ");
        System.out.println("Ingresar Opcion: ");
        int OP_Cine = ingreso.nextInt();
        switch(OP_Cine)
        {
            case 1:
                for (int i = 0; i < 15; ++i) System.out.println();
                System.out.println("------Gestion Administrador------");
                System.out.println("1. Gestion de Salas ");
                System.out.println("2. Gestion de Peliculas ");
                System.out.println("3. Gestion de Empleados (Agregar o eliminar empleado)");
                System.out.println("4. Reportes de sistema");
                System.out.println("5. Volver a menu principal");
                int OP_Administrador = ingreso.nextInt();
                switch(OP_Administrador){
                    case 1:
                        for (int i = 0; i < 15; ++i) System.out.println();
                        System.out.println("------Gestion de Salas------");

                    break;
                    case 2:
                        for (int i = 0; i < 15; ++i) System.out.println();
                        System.out.println("------Gestion de Peliculas------");
                        System.out.println("1. Agregar pelicula ");
                        System.out.println("2. Eliminar pelicula ");
                        System.out.println("5. Volver a menu principal");
                        int OP_Peliculas = ingreso.nextInt();
                        switch(OP_Peliculas){
                            case 1:
                                System.out.println("Las peliculas en cartelera son las siguientes: ");
                                System.out.println("Codigo      Nombre ");
                                String linea;

                                try{
                                        FileReader fr = new FileReader("C:\\ProyectoCine\\catalogoPeliculas.txt");
                                        BufferedReader br = new BufferedReader(fr);
                                        String temp = Archivos.LeerArchivo("C:\\ProyectoCine\\catalogoPeliculas.txt");
                                        while((linea = br.readLine()) != null){
                                        String [] parts = linea.split(" ");
                                        String part1 = parts[0];
                                        String part2 = parts[1];
                                        String part3 = parts[2];
                                        String part4 = parts[3];
                                        String part5 = parts[4];
                                        System.out.println("   "+part1+"   "+part2);
                                        } 

                                } catch(Exception e){

                                }
                                        break;
                            case 2:
                                break;
                                }

                        break;
                    case 3:
                        break;
                    case 4:
                    for (int i = 0; i < 15; ++i) System.out.println();
                        System.out.println("------ Administrador Reportes------");
                        System.out.println("1. Total de ventas por caja () ");//Tambien lo recaudado por cada caja
                        System.out.println("2. Gestion de Empleados (Agregar o eliminar empleado)");
                        System.out.println("3. Planilla de empleados");
                        System.out.println("4. Reporte de ventas por pelicula");// cuanto ha recaudado cada una, total de tiquetes por película y una distribución de porcentajes de clientes por genero.
                        System.out.println("5. Volver a menu principal");
                        break;

                    }
                    break;
            case 2:
            for (int i = 0; i < 15; ++i) System.out.println();
                System.out.println("------Gestion Ventas------");
                System.out.println("1. Tickets");
                System.out.println("2. Membresia");  
                System.out.println("2. Paquetes");
                System.out.println("5. Volver a menu principal");
            break;
            case 3:
                System.exit(0);
                break;
            case 5:
                salir = true;
            break;
            default:
                System.out.println("Solo números entre 1 y 3");
            }
                    
        }
    }
    
    //Funcion para crear los 2000 clientes en el txt
    public static void DosMil_Clientes(){
        int edad = 0;
        String sexo, texto;
        boolean embarazo;
        String nombreArchivo = "C:\\ProyectoCine\\clientes.txt";
        Random digito = new Random();
        
        for(int i=0; i<100; i++){
            int N = digito.nextInt(83);
            edad=N;
            if(i%2==0){
                sexo ="Masculino";
            } else {sexo ="Femenino";}
            if(sexo=="Femenino"){
                if(edad>18 && edad<47 && edad%2!=0){
                    embarazo=true;
                } else{
                    embarazo=false;
                }
            } else {
                embarazo = false;
            }
            texto=edad+" "+sexo+" "+embarazo;
            Archivos.EscribirArchivo(nombreArchivo,texto);
        }
    }
    public static void CrearPeliculas(){
        String texto="";
        String nombreArchivo = "C:\\ProyectoCine\\catalogoPeliculas.txt";
        texto="P1 Avatar C 1500 Disponible 1";
        Archivos.EscribirArchivo(nombreArchivo,texto);
        texto="P2 Hunger_Games C 2700 Disponible 2";
        Archivos.EscribirArchivo(nombreArchivo,texto);
        texto="P3 1971 C 7000 Disponible 0";
        Archivos.EscribirArchivo(nombreArchivo,texto);
        texto="P4 Titanic C 300 Disponible 0";
        Archivos.EscribirArchivo(nombreArchivo,texto);
        
        
    }
    
}
