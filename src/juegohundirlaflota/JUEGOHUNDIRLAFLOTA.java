/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegohundirlaflota;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author KEVIN
 */
public class JUEGOHUNDIRLAFLOTA {

    /*

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Scanner kds = new Scanner(System.in);//creo scanner
        Tablero a = new Tablero();//creo objeto
        a.leerPartida();

        Barco Portaaviones = new Barco("Portaaviones", 5, 'P');//Creo distintos objetos de la clase barco
        Barco Portaaviones2 = new Barco("Portaaviones", 5, 'P');//-------------------------------------------->Cambio
        Barco Submarino = new Barco("Submarino", 3, 'S');//Creo distintos objetos de la clase barco
        Barco Submarino2 = new Barco("Submarino2", 3, 'S');//-------------------------------------------->Cambio
        Barco Destructor = new Barco("Destructor", 2, 'D');//Creo distintos objetos de la clase barco
        Barco Destructor2 = new Barco("Destructor2", 2, 'D');//-------------------------------------------->Cambio
        Barco Fragata = new Barco("Fragata", 3, 'F');//-------------------------------------------->Cambio
        Barco Fragata2 = new Barco("Fragata2", 3, 'F');//-------------------------------------------->Cambio

        int quequiere2;//declaro
        int validador = 0;//inicializo el validador a 0

        String matrizusuario[][] = new String[10][10];//creo la matriz del usuario
        String matrizadmin[][] = new String[10][10];//creo la matriz del admin

        try {//contol de excepciones
            System.out.print("\n\n");//salto de linea
            System.out.println("\n \n El juego esta entrando en el modo Administrador.....\n");//Me muestre este mensaje en pantalla
            System.out.println("\n \n Cargando.... \n");//Me muestre este mensaje en pantalla
            System.out.println("\n \nListo,Usted esta en modo Administrador.\n");//Me muestre este mensaje en pantalla
            System.out.println("\n==============================MODO ADMINISTRADOR==============================\n\n\n");//Me muestre este mensaje en pantalla
            System.out.print("Escoge una opción:\n 1.-Colocar barcos \n 2.-Salir del juego\n-->");//Me muestre este mensaje en pantalla
            quequiere2 = kds.nextInt();//Quiero que me diga lo que desea
            switch (quequiere2) {//depende de que escoja va por un camino o por otro
                case 1://si escoje 1
                    do {//repetecion
                        a.mostrarinicio(matrizadmin, matrizusuario);
                        System.out.print("En primer lugar, coloque el Portaaviones");//Me muestre este mensaje en pantalla
                        System.out.print("¿En que fila lo quiere insertar?: ");//Me muestre este mensaje en pantalla
                        int metfila = kds.nextInt();//introduce fila
                        System.out.print("¿En que columna lo quiere insertar?: ");//Me muestre este mensaje en pantalla
                        int metcolumna = kds.nextInt();//introduce columna
                        System.out.print("¿En que posición lo quiere insertar(V o H)?: ");//Me muestre este mensaje en pantalla
                        String blanco = kds.nextLine();//salto de linea
                        String metposicion = kds.nextLine();//introduce si el vertical u horizontal
                        if (metfila + Portaaviones.Tam < 10 && a.superpongan(matrizadmin, metfila, metcolumna, metposicion, metfila) == false) {
                            a.cargarbarcos(Portaaviones, metfila, metcolumna, metposicion, matrizadmin);
                            validador = 1;
                        } else {
                            System.out.println("\n\nIntroduce valores correctos,cargue de nuevo el barco");//Me muestre este mensaje en pantalla
                        }
                        a.mostrarbarcos(matrizadmin);
                        System.out.println("¿Quiere añadir un Portaaviones mas?\n1.-Si\n2.-No\n-->");
                        int siq = kds.nextInt();

                        if (siq == 1) {//-------------------------------------------->Cambio
                            a.mostrarbarcos(matrizadmin);
                            System.out.print("En primer lugar, coloque el Portaaviones");//Me muestre este mensaje en pantalla
                            System.out.print("¿En que fila lo quiere insertar?: ");//Me muestre este mensaje en pantalla
                            int metfila4 = kds.nextInt();//introduce fila
                            System.out.print("¿En que columna lo quiere insertar?: ");//Me muestre este mensaje en pantalla
                            int metcolumna4 = kds.nextInt();//introduce columna
                            System.out.print("¿En que posición lo quiere insertar(V o H)?: ");//Me muestre este mensaje en pantalla
                            String blanco4 = kds.nextLine();//salto de linea
                            String metposicion4 = kds.nextLine();//introduce si el vertical u horizontal
                            if (metfila4 + Portaaviones2.Tam < 10 && a.superpongan(matrizadmin, metfila4, metcolumna4, metposicion4, metfila4) == false) {
                                a.cargarbarcos(Portaaviones, metfila4, metcolumna4, metposicion4, matrizadmin);
                                validador = 1;
                            } else {
                                System.out.println("\n\nIntroduce valores correctos,cargue de nuevo el barco");//Me muestre este mensaje en pantalla
                            }
                        }
                        System.out.print("\n\n");

                    } while (validador != 1);
                    a.mostrarbarcos(matrizadmin);
                    validador = 0;

                    do {
                        System.out.print("En segundo lugar, coloque el Submarino");//Me muestre este mensaje en pantalla
                        System.out.print("¿En que fila lo quiere insertar?: ");//Me muestre este mensaje en pantalla
                        int metfila1 = kds.nextInt();//introduce fila
                        System.out.print("¿En que columna lo quiere insertar?: ");//Me muestre este mensaje en pantalla
                        int metcolumna1 = kds.nextInt();//introduce columna
                        System.out.print("¿En que posición lo quiere insertar(V o H )?: ");//Me muestre este mensaje en pantalla
                        String blanco1 = kds.nextLine();//salto de linea
                        String metposicion1 = kds.nextLine();//introduce si el vertical u horizontal
                        if (metfila1 + Submarino.Tam < 10 && a.superpongan(matrizadmin, metfila1, metcolumna1, metposicion1, metfila1) == false) {           //Con esto controlo que no se salga fuera de la matriz 
                            a.cargarbarcos(Submarino, metfila1, metcolumna1, metposicion1, matrizadmin);//controlar que no se salga de matriz
                            validador = 1;
                        } else {  //Si se sale , salta el mensaje y vuelve a cargar barcos
                            System.out.println("\n\nIntroduce valores correctos, cargue de nuevo el barco");//Me muestre este mensaje en pantalla
                        }
                        System.out.println("¿Quiere añadir un Submarino mas?\n1.-Si\n2.-No\n-->");
                        int siq1 = kds.nextInt();
                        
                        
                        if (siq1 == 1) {//-------------------------------------------->Cambio
                            a.mostrarbarcos(matrizadmin);
                            System.out.print("En primer lugar, coloque el Submarino");//Me muestre este mensaje en pantalla
                            System.out.print("¿En que fila lo quiere insertar?: ");//Me muestre este mensaje en pantalla
                            int metfila5 = kds.nextInt();//introduce fila
                            System.out.print("¿En que columna lo quiere insertar?: ");//Me muestre este mensaje en pantalla
                            int metcolumna5 = kds.nextInt();//introduce columna
                            System.out.print("¿En que posición lo quiere insertar(V o H)?: ");//Me muestre este mensaje en pantalla
                            String blanco5 = kds.nextLine();//salto de linea
                            String metposicion5 = kds.nextLine();//introduce si el vertical u horizontal
                            if (metfila5 + Submarino.Tam < 10 && a.superpongan(matrizadmin, metfila5, metcolumna5, metposicion5, metfila5) == false) {
                                a.cargarbarcos(Submarino2, metfila5, metcolumna5, metposicion5,matrizadmin);
                                validador = 1;
                            } else {
                                System.out.println("\n\nIntroduce valores correctos,cargue de nuevo el barco");//Me muestre este mensaje en pantalla
                            }
                            
                            a.mostrarbarcos(matrizadmin);
                        }
                        System.out.print("\n\n");
                        
                        
                    } while (validador != 1);
                    a.mostrarbarcos(matrizadmin);
                    validador = 0;
                    System.out.print("\n\n");

                    do {
                        System.out.print("En tercer lugar, coloque el Destructor");//Me muestre este mensaje en pantalla
                        System.out.print("¿En que fila lo quiere insertar?: ");//Me muestre este mensaje en pantalla
                        int metfila2 = kds.nextInt();//introduce fila
                        System.out.print("¿En que columna lo quiere insertar?: ");//Me muestre este mensaje en pantalla
                        int metcolumna2 = kds.nextInt();//introduce columna
                        System.out.print("¿En que posición lo quiere insertar(V o H)?: ");//Me muestre este mensaje en pantalla
                        String blanco2 = kds.nextLine();//para el salto de linea
                        String metposicion2 = kds.nextLine();//introduce si el vertical u horizontal
                        if (metfila2 + Destructor.Tam < 10 && a.superpongan(matrizadmin, metfila2, metcolumna2, metposicion2, metfila2) == false) {
                            a.cargarbarcos(Destructor, metfila2, metcolumna2, metposicion2, matrizadmin);//controlar que no se salga de matriz
                            validador = 1;
                        } else {
                            System.out.println("\n\nIntroduce valores correctos,cargue de nuevo el barco");//Me muestre este mensaje en pantalla
                        }System.out.println("¿Quiere añadir un Destructor mas?\n1.-Si\n2.-No\n-->");
                        int siq2 = kds.nextInt();
                        
                        
                        if (siq2 == 1) {//-------------------------------------------->Cambio
                            a.mostrarbarcos(matrizadmin);
                            System.out.print("En primer lugar, coloque el Destructor");//Me muestre este mensaje en pantalla
                            System.out.print("¿En que fila lo quiere insertar?: ");//Me muestre este mensaje en pantalla
                            int metfila6 = kds.nextInt();//introduce fila
                            System.out.print("¿En que columna lo quiere insertar?: ");//Me muestre este mensaje en pantalla
                            int metcolumna6= kds.nextInt();//introduce columna
                            System.out.print("¿En que posición lo quiere insertar(V o H)?: ");//Me muestre este mensaje en pantalla
                            String blanco6 = kds.nextLine();//salto de linea
                            String metposicion6= kds.nextLine();//introduce si el vertical u horizontal
                            if (metfila6 + Submarino.Tam < 10 && a.superpongan(matrizadmin, metfila6, metcolumna6, metposicion6, metfila6) == false) {
                                a.cargarbarcos(Destructor2, metfila6, metcolumna6, metposicion6,matrizadmin);
                                validador = 1;
                            } else {
                                System.out.println("\n\nIntroduce valores correctos,cargue de nuevo el barco");//Me muestre este mensaje en pantalla
                            }

                            a.mostrarbarcos(matrizadmin);
                        }
                        
                    } while (validador != 1);
                    a.mostrarbarcos(matrizadmin);
                    validador = 0;
                    System.out.print("\n\n");
                    do {
                        System.out.print("En cuarto lugar, coloque la Fragata");//Me muestre este mensaje en pantalla
                        System.out.print("¿En que fila lo quiere insertar?: ");//Me muestre este mensaje en pantalla
                        int metfila3 = kds.nextInt();//introduce fila
                        System.out.print("¿En que columna lo quiere insertar?: ");//Me muestre este mensaje en pantalla
                        int metcolumna3 = kds.nextInt();//introduce columna
                        System.out.print("¿En que posición lo quiere insertar(V o H )?: ");//Me muestre este mensaje en pantalla
                        String blanco1 = kds.nextLine();//salto de linea
                        String metposicion3 = kds.nextLine();//introduce si el vertical u horizontal
                        if (metfila3 + Fragata.Tam < 10 && a.superpongan(matrizadmin, metfila3, metcolumna3, metposicion3, metfila3) == false) {           //Con esto controlo que no se salga fuera de la matriz 
                            a.cargarbarcos(Fragata, metfila3, metcolumna3, metposicion3, matrizadmin);//controlar que no se salga de matriz
                            validador = 1;
                        } else {  //Si se sale , salta el mensaje y vuelve a cargar barcos
                            System.out.println("\n\nIntroduce valores correctos, cargue de nuevo el barco");//Me muestre este mensaje en pantalla
                        }
                        System.out.println("¿Quiere añadir una Fragata mas?\n1.-Si\n2.-No\n-->");
                        int siq3 = kds.nextInt();
                        
                        
                        if (siq3 == 1) {//-------------------------------------------->Cambio
                            a.mostrarbarcos(matrizadmin);
                            System.out.print("En primer lugar, coloque la Fragata");//Me muestre este mensaje en pantalla
                            System.out.print("¿En que fila lo quiere insertar?: ");//Me muestre este mensaje en pantalla
                            int metfila7= kds.nextInt();//introduce fila
                            System.out.print("¿En que columna lo quiere insertar?: ");//Me muestre este mensaje en pantalla
                            int metcolumna7 = kds.nextInt();//introduce columna
                            System.out.print("¿En que posición lo quiere insertar(V o H)?: ");//Me muestre este mensaje en pantalla
                            String blanco7 = kds.nextLine();//salto de linea
                            String metposicion7 = kds.nextLine();//introduce si el vertical u horizontal
                            if (metfila7 + Submarino.Tam < 10 && a.superpongan(matrizadmin, metfila7, metcolumna7, metposicion7, metfila7) == false) {
                                a.cargarbarcos(Fragata2, metfila7, metcolumna7, metposicion7,matrizadmin);
                                validador = 1;
                            } else {
                                System.out.println("\n\nIntroduce valores correctos,cargue de nuevo el barco");//Me muestre este mensaje en pantalla
                            }
                            a.mostrarbarcos(matrizadmin);
                        }
                        
                    } while (validador != 1);
                    a.mostrarbarcos(matrizadmin);
                    System.out.print("\n\n");
                    break;

                case 2:
                    System.out.println("Saliendo del juego...");//Me muestre este mensaje en pantalla
                    break;
            }

            int quequiere3;
            if (quequiere2 == 1) {

                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n==============================MODO USUARIO==============================\n\n\n");
                System.out.println("Hola buenas,Vamos a comenzar a jugar al fantástico juego de Hundir La Flota,MUCHA SUERTE!!\n\n\n\n");//Me muestre este mensaje en pantalla
                do {
                    System.out.print("Escoge una opción:\n 1.-Disparar a barcos \n 2.-Salir del juego\n-->");//Me muestre este mensaje en pantalla
                    quequiere3 = kds.nextInt();
                    switch (quequiere3) {
                        case 1:
                            a.mostrarpartida(matrizusuario);
                            System.out.println("¿A que fila quiere disparar?");//Me muestre este mensaje en pantalla
                            int usquieredispfila = kds.nextInt();
                            System.out.println("¿A que columna quiere disparar?");//Me muestre este mensaje en pantalla
                            int usquieredispcolu = kds.nextInt();
                            a.InsertarDisparo(usquieredispfila, usquieredispcolu, matrizadmin, matrizusuario);
                            System.out.println("\n\n");
                            a.mostrarpartida(matrizusuario);
                            break;
                        case 2:
                            System.out.println("Saliendo del juego.....");//Me muestre este mensaje en pantalla
                            System.out.println("Adiós, gracias por jugar...");//Me muestre este mensaje en pantalla
                            break;
                    }
                } while (quequiere3 != 2 && a.comprobar() != true);
            }
        } catch (InputMismatchException e) {//Ve si algo esta mal

            System.out.println("Se ha producido un error,inicie el programa de nuevo");//Me muestre este mensaje en pantalla

        }
        System.out.println("¿Que partida quieres ver?,Tienes hasta la " + a.partida);
        int op= kds.nextInt();
        a.mostrarpartida(op);
        a.contabilizarPartida();
    }
}
