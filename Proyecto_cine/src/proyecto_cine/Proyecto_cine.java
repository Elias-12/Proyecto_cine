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
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Elias
 */
public class Proyecto_cine {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        File archivo = new File("C:\\ProyectoCine");
if (!archivo.exists()) {
    System.out.println("Repositorio C:\\ProyectoCine no existe!!");
    
}
        String nombreArchivo;
        nombreArchivo = "C:\\ProyectoCine\\clientes.txt";
        Archivos.crearArchivo(nombreArchivo);
        DosMil_Clientes();
        nombreArchivo = "C:\\ProyectoCine\\catalogoPeliculas.txt";
        Archivos.crearArchivo(nombreArchivo);  
        CrearPeliculas();
        nombreArchivo = "C:\\ProyectoCine\\catalogoEmpleados.txt";
        Archivos.crearArchivo(nombreArchivo); 
        Empleados();
        nombreArchivo = "C:\\ProyectoCine\\catalogoCajas.txt";
        Archivos.crearArchivo(nombreArchivo);    
        Cajas();
        nombreArchivo = "C:\\ProyectoCine\\catalogoSalas.txt";
        Archivos.crearArchivo(nombreArchivo);  
        Salas();
        
//        File Archivo_Clientes = new File("C:\\ProyectoCine\\clientes.txt");
////        File Archivo_CatPeliculas = new File("C:\\ProyectoCine\\catalogoPeliculas.txt.txt");
//        File Archivo_CatEmpleados = new File("C:\\ProyectoCine\\catalogoEmpleados.txt");
//        File Archivo_CarCajas = new File("C:\\ProyectoCine\\catalogoCajas.txt");
//        File Archivo_CatSalas = new File("C:\\ProyectoCine\\catalogoSalas.txt");

        Scanner ingreso = new Scanner(System.in);
        boolean salir = false;
        Random digito = new Random();
       
      
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
                System.out.println("5. Salir");
                int OP_Administrador = ingreso.nextInt();
                switch(OP_Administrador){
                    case 1:
                        String info=null;
                        for (int i = 1; i < 9; ++i){                        
                        System.out.println("------Gestion de Salas------");
                        System.out.println("1. Agregar nueva sala");
                        System.out.println("2. Eliminar sala");
                        int OP_Salas = ingreso.nextInt();
                        switch(OP_Salas){
                            case 1:
                                System.out.println("Sala "+i);
                                System.out.println("Ingrese capacidad sala ");
                                info=ingreso.next();
                                System.out.println("Ingrese horario 1 ");
                                info=info+" "+ingreso.next();
                                System.out.println("Ingrese horario 2 ");
                                info=info+" "+ingreso.next();
                                System.out.println("Ingrese precio 2D");
                                info=info+" "+ingreso.next();
                                System.out.println("Ingrese precio 3D");
                                info=info+" "+ingreso.next();
                                System.out.println("Ingrese precio 4D");
                                info=info+" "+ingreso.next();
                                Archivos.EscribirArchivo("C:\\ProyectoCine\\catalogoSalas.txt", info);
                                break;
                            case 2:
                                break;
                        }
                        }
                        break;
                    case 2:
                        System.out.println("Seleccionar dia de la semana");
                        System.out.println("1. Lunes");
                        System.out.println("2. Martes");
                        System.out.println("3. Miercoles");
                        System.out.println("4. Jueves");
                        System.out.println("6. Viernes");
                        System.out.println("7. Sabado");
                        System.out.println("8. Domingo");
                        int dia = ingreso.nextInt();
                                if(dia==3){
                                    ActualizarSistema();
                                } 
                        String linea, nuevoNombre="", nuevaCategoria="", nuevaP="";
                        FileReader ar;
                        int suma = 0;
                        for (int i = 0; i < 15; ++i) System.out.println();
                        System.out.println("------Gestion de Peliculas------");
                        System.out.println("1. Ver Cartelera completa ");
                        System.out.println("2. Agregar pelicula ");
                        System.out.println("5. Volver a menu principal");
                        int OP_Peliculas = ingreso.nextInt();
                        switch(OP_Peliculas){
                            case 1:
                                    try {
                                        ar = new FileReader("C:\\ProyectoCine\\catalogoPeliculas.txt");
                                        BufferedReader br = new BufferedReader(ar);
                                        String temp = Archivos.LeerArchivo("C:\\ProyectoCine\\catalogoPeliculas.txt");
                                        while((linea = br.readLine()) != null){
                                        String [] parts = linea.split(" ");
                                        String part1 = parts[0];
                                        int temp_part1 = Integer.parseInt(part1);
                                         suma = temp_part1+1;
                                        String part2 = parts[1];
                                        System.out.println(suma+"   "+part1+"   "+part2);
                                        }
                                    } catch (FileNotFoundException ex) {
                                        Logger.getLogger(Proyecto_cine.class.getName()).log(Level.SEVERE, null, ex);
                                    }                                    
                                break;  
                            case 2:
                                System.out.println("Las peliculas en cartelera son las siguientes: ");
                                System.out.println("Codigo      Nombre ");
                                int h =1;
                                int nuevoCodigo=0;
                                    try{
                                        FileReader fr = new FileReader("C:\\ProyectoCine\\catalogoPeliculas.txt");
                                        BufferedReader br = new BufferedReader(fr);
                                        String temp = Archivos.LeerArchivo("C:\\ProyectoCine\\catalogoPeliculas.txt");
                                        while((linea = br.readLine()) != null){
                                        String [] parts = linea.split(" ");
                                        String part1 = parts[0];
                                        int temp_part1 = Integer.parseInt(part1);
                                         suma = temp_part1+1;
                                        String part2 = parts[1];
                                        System.out.println(suma+"   "+part1+"   "+part2);
                                        }
                                        System.out.println("Ingrese nombre de pelicula sin espacios: ");
                                        nuevoNombre = ingreso.next();
                                        System.out.println("Ingrese categoria de pelicula 'Ejemplo: 'C'': ");
                                        nuevaCategoria = ingreso.next();
                                        
                                        nuevoCodigo= suma+h;
                                        String ide = "C:\\ProyectoCine\\catalogoPeliculas.txt";
                                        nuevaP = (nuevoCodigo+" "+nuevoNombre+" "+nuevaCategoria+" "+"0 Disponible 1");
                                        System.out.println(nuevaP);
                                        Archivos.EscribirArchivo(ide,nuevaP);
                                        System.out.println("Se guardo de manera exitosa");
                                        System.out.println("------------------------");
                                } catch(Exception e){

                                
                                }
				   
                                break;
                                }
                    case 3:
                        String Sueldo_Empleado="";
                        String info_empleado="";
                        System.out.println("------Gestion de Empleados------");
                        System.out.println("1. Agregar nuevo empleado ");
                        System.out.println("2. Eliminar empleado ");
                        int OP_Empleados = ingreso.nextInt();
                        switch(OP_Empleados){
                            case 1:
                                String vari = "E";
                                int N4 = digito.nextInt(1200);
                                String nombre6 = Integer.toString(N4);
                                System.out.println("Ingrese letra de puesto de empleado ");
                                System.out.println("1. Administracion ");
                                System.out.println("2. Mantenimiento ");
                                System.out.println("3. Ventas");
                                int OP_Empleados_2 = ingreso.nextInt();
                                if(OP_Empleados_2==1){
                                    info_empleado=vari+nombre6+" A"+info_empleado;
                                    Sueldo_Empleado=Integer.toString(10000);
                                } else if(OP_Empleados_2==2){
                                    info_empleado=vari+nombre6+" M"+info_empleado;
                                    Sueldo_Empleado=Integer.toString(4000);
                                } else if(OP_Empleados_2==3){
                                    info_empleado=vari+nombre6+" V"+info_empleado;
                                    Sueldo_Empleado=Integer.toString(3500);
                                }                     
                                info_empleado=info_empleado+" "+Sueldo_Empleado;
                                System.out.println("Ingrese Primer Nombre:");
                                info_empleado=info_empleado+" "+ingreso.next();
                                System.out.println("Ingrese Primer Apellido");
                                info_empleado=info_empleado+" "+ingreso.next();
                                if(OP_Empleados_2==3){
                                info_empleado=info_empleado+" 0 0";
                                } else{
                                info_empleado=info_empleado+" N N";
                                }
                                Archivos.EscribirArchivo("C:\\ProyectoCine\\catalogoEmpleados.txt", info_empleado);
                                break;
                            case 2:
                                break;
                        }
                        
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
                    case 5:
                        salir = true;
                        break;
                        
                    }

                    break;
            case 2:
            for (int i = 0; i < 15; ++i) System.out.println();
                System.out.println("------Gestion Ventas------");
                System.out.println("1. Proceso de ventas 1 (Proceso Normal)"); // 
                System.out.println("2. Proceso de ventas 2 (2000 Clientes Preingresados)"); // 

                int OP_Ventas = ingreso.nextInt();
                switch(OP_Ventas){
                    case 1:
                        System.out.println("------Gestion Ventas (Proceso 1)------");
                        System.out.println("1. Tickets"); // 
                        System.out.println("2. Membresia");  //Membresia = Q 45.00 -> Q 2.25 de comision 
                        System.out.println("3. Paquetes");// Paquete = Q2500.00 -> Q 62.5 de comision
                        System.out.println("5. Volver a menu principal");
                        int OP_Ventas_P1 = ingreso.nextInt();
                        switch(OP_Ventas_P1){
                            case 1:
                                System.out.println("------Ventas de Tickets------");   
                            case 2:
                            case 3:    

                        }
                        break;
                    case 2:
                        break;
                    case 5:
                        break;
                }
                
                
                
                
                
                
                
                
            break;
            case 3:
                System.exit(0);
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
    //Funcion para crear peliculas iniciales
    public static void CrearPeliculas(){
        String texto="";
        String nombreArchivo = "C:\\ProyectoCine\\catalogoPeliculas.txt";
        texto="1 Avatar C 1500 Disponible 1";
        Archivos.EscribirArchivo(nombreArchivo,texto);
        texto="2 Hunger_Games C 2700 Disponible 2";
        Archivos.EscribirArchivo(nombreArchivo,texto);
        texto="3 1971 C 7000 Disponible 0";
        Archivos.EscribirArchivo(nombreArchivo,texto);
        texto="4 Titanic C 300 Disponible 0";
        Archivos.EscribirArchivo(nombreArchivo,texto);
        texto="5 Sataniame D 300 Disponible 0";
        Archivos.EscribirArchivo(nombreArchivo,texto);
   
    }
    //Se actualiza el sistema por ser dia miercoles (se borran las peliculas que no llegan al minimo de ventas)
    static void ActualizarSistema() throws IOException{
        Scanner ingreso = new Scanner(System.in);
        Deque<String> Cola_peliculas = new ArrayDeque<String>();
//        int OP_Cine = ingreso.nextInt();
        int eliminarP =0;
        String linea;
        FileReader cr;
        try {
            cr = new FileReader("C:\\ProyectoCine\\catalogoPeliculas.txt");
            BufferedReader br = new BufferedReader(cr);
//            System.out.println("Lista actual de peliculas");
            while((linea = br.readLine()) != null){
                String [] parts = linea.split(" ");
                String part1 = parts[0];
                String part2 = parts[1];
                Cola_peliculas.addLast(linea);
//                System.out.println(part1+"   "+part2);
            }
            } catch (FileNotFoundException ex) {
            Logger.getLogger(Proyecto_cine.class.getName()).log(Level.SEVERE, null, ex);
        }

//            System.out.println("Ingresar codigo de pelicula a eliminar: ");
//            eliminarP = ingreso.nextInt();          
            
            
            for(String elemento: Cola_peliculas){
                String [] parts = elemento.split(" ");
                String parte1 = parts[0];
//                int cant1=Integer.parseInt(parte1);
                String parte2 = parts[1];
                String parte3 = parts[2];
                String parte4 = parts[3];
                int cant4=Integer.parseInt(parte4);
                String parte5 = parts[4];
                String parte6 = parts[5];
                int cant6=Integer.parseInt(parte6);
                
                if(cant4<=999){
                    Cola_peliculas.remove(elemento);
                } else if(cant4>=1000){
                    cant6=cant6+1;
                    cant4=0;
                } else{
                
                }
                
                
//                if(cant1==eliminarP){
//                    Cola_peliculas.remove(elemento);
//            }
            }
            Archivos.crearArchivo("C:\\ProyectoCine\\catalogoPeliculas.txt");
            for(String elementos: Cola_peliculas){
                Archivos.EscribirArchivo("C:\\ProyectoCine\\catalogoPeliculas.txt", elementos);
                 System.out.println(elementos);                
            }
            
            

    }
        //Funcion para crear Salas iniciales
    static void Salas(){
        String texto="";
        String nombreArchivo = "C:\\ProyectoCine\\catalogoSalas.txt";
        texto="Sala1 P1 N 150 0 60 90 120";//2D, 3D y 4D
        Archivos.EscribirArchivo(nombreArchivo,texto);
        texto="Sala2 P2 P1 100 0 60 90 X";//2D y 3D
        Archivos.EscribirArchivo(nombreArchivo,texto);
        texto="Sala3 P3 P2 100 0 60 90 X";//2D y 3D
        Archivos.EscribirArchivo(nombreArchivo,texto);
        texto="Sala4 125 0 60 X  X";//infantiles
        Archivos.EscribirArchivo(nombreArchivo,texto);   
        texto="Sala5 P4 P3 100 0 60 90 X";//2D y 3D
        Archivos.EscribirArchivo(nombreArchivo,texto);
        texto="Sala6 P5 P4 75 0 60 X X";//2D
        Archivos.EscribirArchivo(nombreArchivo,texto);
        texto="Sala7 17:30 P5 75 0 60 X X";//2D
        Archivos.EscribirArchivo(nombreArchivo,texto);
        texto="Sala8 17:30 20:30 75 0 60 X X";//2D
        Archivos.EscribirArchivo(nombreArchivo,texto);
    }
        //Funcion para crear empleados iniciales
    static void Empleados(){
        String texto="";
        String nombreArchivo = "C:\\ProyectoCine\\catalogoEmpleados.txt";
        texto="E1325 A 10000 Antonio Banderas N N";
        Archivos.EscribirArchivo(nombreArchivo,texto);
        texto="E1343 A 10000 Carlos Merida N N";
        Archivos.EscribirArchivo(nombreArchivo,texto);
        texto="E1432 V 3500 Sebastian Hernandez 0 0";
        Archivos.EscribirArchivo(nombreArchivo,texto);
        texto="E1378 V 3500 Juan Maegli 0 0";
        Archivos.EscribirArchivo(nombreArchivo,texto);
        texto="E1511 M 4000 Hector Hernandez N N";
        Archivos.EscribirArchivo(nombreArchivo,texto);
        texto="E1669 M 4000 Emanuel Tavarez N N";
        Archivos.EscribirArchivo(nombreArchivo,texto);
    }
     //Funcion para crear cajas iniciales
    static void Cajas(){
        String texto="";
        String nombreArchivo = "C:\\ProyectoCine\\catalogoCajas.txt";
        texto="1 Caja1";
        Archivos.EscribirArchivo(nombreArchivo,texto);
        texto="2 Caja2";
        Archivos.EscribirArchivo(nombreArchivo,texto);
        texto="3 Caja3";
        Archivos.EscribirArchivo(nombreArchivo,texto);
        texto="4 Caja4";
        Archivos.EscribirArchivo(nombreArchivo,texto);
        texto="5 Caja5";
        Archivos.EscribirArchivo(nombreArchivo,texto);
    }
}