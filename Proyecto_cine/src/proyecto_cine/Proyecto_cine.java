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
        

        Scanner ingreso = new Scanner(System.in);
        boolean salir = false;
        Random digito = new Random();
       
      
        while(!salir){
        System.out.println("------Menu Principal------");
        System.out.println("1. Administracion ");
        System.out.println("2. Ventas ");
        System.out.println("3. Salir ");
        System.out.println("Ingresar Opcion: ");
        System.out.println("---------Ingresar Opcion: ");
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
                System.out.println("---------Ingresar Opcion: ");
                int OP_Administrador = ingreso.nextInt();
                switch(OP_Administrador){
                    case 1:
                        String info=null;
                                              
                        System.out.println("------Gestion de Salas------");
                        System.out.println("1. Ver salas disponibles ");
                        System.out.println("2. Agregar nueva sala");
                        System.out.println("3. Volver al menu principal");
                        System.out.println("---------Ingresar Opcion: ");
                        int OP_Salas = ingreso.nextInt();
                        switch(OP_Salas){
                            case 1:
                                SalasActuales();
                                break;
                            case 2:
                                System.out.println("Ingrese capacidad sala ");
                                info="Sala9 "+ingreso.next();
                                info=info+" 0 0";
                                System.out.println("Ingrese precio 2D");
                                info=info+" "+ingreso.next();
                                System.out.println("Ingrese precio 3D");
                                info=info+" "+ingreso.next();
                                System.out.println("Ingrese precio 4D");
                                info=info+" "+ingreso.next();
                                System.out.println("Ingrese codigo (Correlativo en base al ultimo)");
                                info=info+" "+ingreso.next();
                                Archivos.EscribirArchivo("C:\\ProyectoCine\\catalogoSalas.txt", info);
                                break;
                            case 3:
                                break;
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
                        System.out.println("---------Ingresar Opcion: ");
                        int dia = ingreso.nextInt();
                                if(dia==3){
                                    ActualizarSistema(); /// Revizar funcion incompleta
                                } 
                        String linea, nuevoNombre="", nuevaCategoria="", nuevaP="";
                        FileReader ar;
                        int suma = 0;
                        for (int i = 0; i < 15; ++i) System.out.println();
                        System.out.println("------Gestion de Peliculas------");
                        System.out.println("1. Ver Cartelera completa ");
                        System.out.println("2. Agregar pelicula ");
                        System.out.println("3. Volver a menu principal");
                        System.out.println("---------Ingresar Opcion: ");
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
                            case 3:
                                }
                    case 3:
                        String Sueldo_Empleado="";
                        String info_empleado="";
                        System.out.println("------Gestion de Empleados------");
                        System.out.println("1. Agregar nuevo empleado ");
                        System.out.println("2. Volver a menu principal");
                        System.out.println("---------Ingresar Opcion: ");
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
                                System.out.println("---------Ingresar Opcion: ");
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
                        System.out.println("4. Volver a menu principal");
                        System.out.println("---------Ingresar Opcion: ");
                        int OP_Ventas_P1 = ingreso.nextInt();
                        switch(OP_Ventas_P1){
                            case 1:
                                Deque<String> Cola_salas = new ArrayDeque<String>();
                                System.out.println("------Ventas de Tickets------"); 
                                PeliculasActuales();

                                try{
                                    System.out.println("Ingrese opcion de pelicula:");
                                    int op_cod_pelicula = ingreso.nextInt();
                                    System.out.println("Las opciones de horario para la pelcula son: ");
//                                    texto="Sala1 P1 N 150 0 60 90 120";//2D, 3D y 4D
                                    FileReader tr;
                                    String var;
                                    tr = new FileReader("C:\\ProyectoCine\\catalogoSalas.txt");
                                    BufferedReader br = new BufferedReader(tr);
                                    while((var = br.readLine()) != null){
                                    String [] parts = var.split(" ");
                                    String part1 = parts[0];
                                    String part2 = parts[1];
                                    int cant2=Integer.parseInt(part2);
                                    String part3 = parts[2];
                                    int cant3=Integer.parseInt(part3);
                                    String part4 = parts[3];
                                    String part5 = parts[4];                                  
                                    String part6 = parts[5];
                                    String part7 = parts[6];
                                    String part8 = parts[7];
                                    String part9 = parts[8];
                                    int cant9=Integer.parseInt(part9);                                 
                                    Cola_salas.addLast(var);                                  
                                    if(op_cod_pelicula==cant2){
                                        System.out.println(part9+" "+part1+" hora: 15:30"+" Precio: 2D: Q "+part6+".00 3D: Q "+part7+".00 4DX: Q"+part8+".00");

                                    } else if(op_cod_pelicula==cant3){
                                        System.out.println(part9+" "+part1+" hora: 18:30"+" Precio: 2D: Q "+part6+".00 3D: Q "+part7+".00 4DX: Q"+part8+".00");
                                    }                                    
                                    }
                                } catch(FileNotFoundException ex){}
                                String temporal =ImprimirRecibo();
                                
                                System.out.println("_______________________");
                                System.out.println("Recibo: ");
                                System.out.println(temporal);
                                System.out.println("_______________________");

                                break;                            
                            case 2:
                            case 3: 
                            case 4:

                        }
                        break;
                    case 2:
                        VentasAleatorias();
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
    //Imprimir Recibo
    public static String ImprimirRecibo() throws IOException{
         int total;
         int OP_tipo_ticktes;
         String result = null;
         try{
            String var;
            FileReader er = new FileReader("C:\\ProyectoCine\\catalogoSalas.txt");
            BufferedReader mr= new BufferedReader(er);
            Scanner ingreso = new Scanner(System.in);
            System.out.println("Ingrese No. de sala");
            int OP_tipo = ingreso.nextInt();
            while((var = mr.readLine()) != null){
            String [] parts = var.split(" ");
            String part1 = parts[0];
            String part2 = parts[1];
            int cant2=Integer.parseInt(part2);
            String part3 = parts[2];
            int cant3=Integer.parseInt(part3);
            String part4 = parts[3];
            String part5 = parts[4];
            String part6 = parts[5];
            String part7 = parts[6];
            int cant7=Integer.parseInt(part7);
            String part8 = parts[7];
            int cant8=Integer.parseInt(part8);
            String part9 = parts[8];          
            int cant9=Integer.parseInt(part9);
            
            if(OP_tipo==cant9){
                    if(cant7!=0){
                        if(cant8!=0){
                            System.out.println("Se encuentra disponible en 2D y 3D y 4D");
                            System.out.println("Tipo de funcion:");
                            System.out.println("1. 2D");
                            System.out.println("2. 3D");
                            System.out.println("3. 4D");
                            OP_tipo_ticktes = ingreso.nextInt();
                            System.out.println("cantidad de tickets:");
                            int OP_cant_ticktes = ingreso.nextInt();
                            ActualizarSalas(OP_tipo,OP_cant_ticktes);
                            switch(OP_tipo_ticktes){
                                case 1:
                                    total = OP_cant_ticktes*60;
                                    System.out.println("Su total es "+total);
                                     result =part1+" *Cantidad de entradas: "+OP_cant_ticktes+" *Tipo funcion: 2D"+" *Total a pagar:"+total;
                                    break;
                                case 2:
                                    total = OP_cant_ticktes*90;
                                    System.out.println("Su total es "+total);
                                     result =part1+" *Cantidad de entradas: "+OP_cant_ticktes+" *Tipo funcion: 3D"+" *Total a pagar:"+total;
                                    break;
                                case 3:
                                    total = OP_cant_ticktes*120;
                                    System.out.println("Su total es "+total);
                                     result =part1+" *Cantidad de entradas: "+OP_cant_ticktes+" *Tipo funcion: 4D"+" *Total a pagar:"+total;
                                    break;
                            }  
                        } else{
                          System.out.println("Se encuentra disponible en 2D y 3D");
                            System.out.println("Tipo de funcion:");
                            System.out.println("1. 2D");
                            System.out.println("2. 3D");
                            OP_tipo_ticktes = ingreso.nextInt();
                            System.out.println("cantidad de tickets:");
                            int OP_cant_ticktest = ingreso.nextInt();
                            switch(OP_tipo_ticktes){
                                case 1:
                                    total = OP_cant_ticktest*60;
                                    System.out.println("Su total es "+total);
                                     result =part1+" *Cantidad de entradas: "+OP_cant_ticktest+" *Tipo funcion: 2D"+" *Total a pagar:"+total;
                                    break;
                                case 2:
                                    total = OP_cant_ticktest*90;
                                    System.out.println("Su total es "+total);
                                     result =part1+" *Cantidad de entradas: "+OP_cant_ticktest+" *Tipo funcion: 3D"+" *Total a pagar:"+total;
                                    break;
                            }
                        }
                    }else {
                            System.out.println("cantidad de tickets:");
                            int OP_cant_ticktest = ingreso.nextInt();
                            total = OP_cant_ticktest*60;
                            System.out.println("Su total es "+total);
                                     result =part1+" *Cantidad de entradas: "+OP_cant_ticktest+" *Tipo funcion: 2D"+" *Total a pagar:"+total;

                    }


            
            }
                        }
        } catch(FileNotFoundException ex){}
        return result;
    }
    //Funcion para crear los 2000 clientes en el txt
    public static void DosMil_Clientes(){
        int edad = 0;
        String sexo, texto;
        boolean embarazo;
        String nombreArchivo = "C:\\ProyectoCine\\clientes.txt";
        Random digito = new Random();
        
        for(int i=0; i<2000; i++){
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
        texto="Sala1 1 0 150 0 60 90 120 1";//2D, 3D y 4D
        Archivos.EscribirArchivo(nombreArchivo,texto);
        texto="Sala2 2 1 100 0 60 90 0 2";//2D y 3D
        Archivos.EscribirArchivo(nombreArchivo,texto);
        texto="Sala3 3 2 100 0 60 90 0 3";//2D y 3D
        Archivos.EscribirArchivo(nombreArchivo,texto);
        texto="Sala4 0 0 125 0 60 0 0 4";//infantiles
        Archivos.EscribirArchivo(nombreArchivo,texto);  
        texto="Sala5 4 3 100 0 60 90 0 5";//2D y 3D
        Archivos.EscribirArchivo(nombreArchivo,texto);
        texto="Sala6 5 4 75 0 60 0 0 6";//2D
        Archivos.EscribirArchivo(nombreArchivo,texto);
        texto="Sala7 0 5 75 0 60 0 0 7";//2D
        Archivos.EscribirArchivo(nombreArchivo,texto);
        texto="Sala8 0 0 75 0 60 0 0 8";//2D
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
        //Ver peliculas actuales
    static void PeliculasActuales() throws IOException{								  
        String linea;
        FileReader cr;
         try {
            cr = new FileReader("C:\\ProyectoCine\\catalogoPeliculas.txt");
            BufferedReader br = new BufferedReader(cr);
            System.out.println("Lista actual de peliculas");
            while((linea = br.readLine()) != null){			 
                String [] parts = linea.split(" ");
                String part1 = parts[0];
                String part2 = parts[1];           
                System.out.println(part1+"   "+part2);
            }
            } catch (FileNotFoundException ex) {
            Logger.getLogger(Proyecto_cine.class.getName()).log(Level.SEVERE, null, ex);
        }
         
													 
							
    }
            //Ver Salas actuales
    static void SalasActuales() throws IOException{								  
        String linea;
        FileReader cr;
         try {
            cr = new FileReader("C:\\ProyectoCine\\catalogoSalas.txt");
            BufferedReader br = new BufferedReader(cr);
            System.out.println("Lista actual de peliculas");
            while((linea = br.readLine()) != null){			 
                String [] parts = linea.split(" ");
                String part1 = parts[0];
                String part2 = parts[1];  
                String part3 = parts[2];
                String part4 = parts[3];
                String part5 = parts[4]; 
                System.out.println(part1+"   "+part4+" "+part5);
            }
            } catch (FileNotFoundException ex) {
            Logger.getLogger(Proyecto_cine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
	
   
   static void VentasAleatorias(){
    String[][] matriz= new String[2000][3];
       try {
        //ruta de tu archivo
        String ruta = "C:\\ProyectoCine\\clientes.txt";
        BufferedReader br = new BufferedReader(new FileReader(ruta));
        //leemos la primera linea
        String linea =  br.readLine();
        //creamos la matriz vacia
       
        //contador
        int contador = 0;
        while(linea != null){
            String[] values = linea.split(" ");
            //recorremos el arrar de string
            for (int i = 0; i<values.length; i++) {
                //se obtiene el primer caracter de el arreglo de strings
                matriz[contador][i] = values[i].toString();
            }
            contador++;
            linea = br.readLine();
        }
    } catch (IOException | NumberFormatException e) {
        e.printStackTrace();
    }
  
       
       //peliculas disponibles
      try {
        //ruta de tu archivo
        String ruta = "C:\\ProyectoCine\\catalogoSalas.txt";
        BufferedReader br = new BufferedReader(new FileReader(ruta));
        //leemos la primera linea
        String linea =  br.readLine();
        //creamos la matriz vacia
       
        //contador
        int contador = 0;
        while(linea != null){
            String[] values = linea.split(" ");
            //recorremos el arrar de string
            for (int i = 0; i<values.length; i++) {
                //se obtiene el primer caracter de el arreglo de strings
                matriz[contador][i] = values[i].toString();
            }
            contador++;
            linea = br.readLine();
        }
    } catch (IOException | NumberFormatException e) {
        e.printStackTrace();
    }
///caja1
       
       Random digito = new Random();
       int ContC1=0;      
       for(int i=0;i<400;i++){
          int N = digito.nextInt(10)+1;   
          ContC1=ContC1+N;
          
  
  }
 
}
public static void ActualizarSalas(int fila, int cantidad) throws IOException{
        Deque<String> Cola_Salas = new ArrayDeque<String>();
        int eliminarP =0;
        String linea;
        FileReader cr;
        try {
            cr = new FileReader("C:\\ProyectoCine\\catalogoSalas.txt");
            BufferedReader br = new BufferedReader(cr);								 
            while((linea = br.readLine()) != null){
					 
                String [] parts = linea.split(" ");
                String part1 = parts[0];
                String part2 = parts[1];
                Cola_Salas.addLast(linea);
//                System.out.println(part1+"   "+part2);
            }
        } catch(FileNotFoundException ex){}
    
        for(String elemento: Cola_Salas){
        String [] parts = elemento.split(" ");
        String parte1 = parts[0];
        String parte2 = parts[1];
        String parte3 = parts[2];
        String parte4 = parts[3];
        String parte5 = parts[4];
        int cant5=Integer.parseInt(parte5);
        String parte6 = parts[5];
        String parte7 = parts[6];
        String parte8 = parts[7];
        String parte9 = parts[8];
        int cant9=Integer.parseInt(parte9);
        
        if(fila==cant9){
            cant5=cant5+cantidad;
            Cola_Salas.remove(elemento);
            Cola_Salas.add(parte1+" "+parte2+" "+parte3+" "+parte4+" "+cant5+" "+parte6+" "+parte7+" "+parte8+" "+parte9);
        }
        }
            Archivos.crearArchivo("C:\\ProyectoCine\\catalogoPeliculas.txt");
            for(String elementos: Cola_Salas){
                Archivos.EscribirArchivo("C:\\ProyectoCine\\catalogoSalas.txt", elementos);
                System.out.println(elementos);                

            }

    }
    
}