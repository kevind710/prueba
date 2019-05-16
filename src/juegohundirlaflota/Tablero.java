/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegohundirlaflota;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 *
 * @author KEVIN
 */
public class Tablero {
    
    int partida=1;
    ArrayList<Registro> a = new ArrayList();
    
    

    public void mostrarinicio(String matriz[][],String matrizusuario[][]) {//muestra inicio de partida

        System.out.println("\t0\t1\t2\t3\t4\t5\t6\t7\t8\t9\n");

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = "-";
                matrizusuario[i][j] = "-";
            }
        }
        for (int i = 0; i < matriz.length; i++) {
            System.out.printf("%d    |\t", i);
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j]);
                if (j != matriz[i].length - 1) {
                    System.out.print("  \t");
                }
            }
            System.out.println("    |\n");
        }
    }

    public void mostrarbarcos(String matriz[][]) {//muestra los barcos

        System.out.println("\t0\t1\t2\t3\t4\t5\t6\t7\t8\t9\n");
        for (int i = 0; i < matriz.length; i++) {
            System.out.printf("%d    |\t", i);
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j]);
                if (j != matriz[i].length - 1) {
                    System.out.print("  \t");
                }
            }
            System.out.println("    |\n");
        }
    }

    public void cargarbarcos(Barco intro, int fila, int columna, String colocacion, String matriz[][]) {//este metodo carga los barcos introducidos
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (i == fila && j == columna) {
                    if ("V".equalsIgnoreCase(colocacion)) {
                        for (int x = i; x < (i + intro.Tam); x++) {
                            String a = Character.toString(intro.Letra);
                            matriz[x][columna] = a;//con esto hacemos que recorra nada mas las filas
                        }
                    } else if ("H".equalsIgnoreCase(colocacion)) {
                        for (int y = j; y < (j + intro.Tam); y++) {
                            String b = Character.toString(intro.Letra);
                            matriz[fila][y] = b;//con esto hacemos que recorra nada mas las columnas
                        }
                    }

                }

            }
        }

    }
   int contadorm =0;
   int contadorh =0;//contadores
   int contadorp =0;//contadores
   int contadorp2 =0;//contadores
   int contadors =0;//contadores
   int contadors2 =0;//contadores
   int contadord =0;//contadores
   int contadord2 =0;//contadores
   int contadorf =0;  
   int contadorf2 =0;
   
    public void InsertarDisparo(int fila, int columna, String matrizadmin[][], String matrizusuario[][]) {
        if ("P".equals(matrizadmin[fila][columna]) || "S".equals(matrizadmin[fila][columna]) || "D".equals(matrizadmin[fila][columna])|| "F".equals(matrizadmin[fila][columna])) {
            matrizusuario[fila][columna] = "T";
        String dev=matrizadmin[fila][columna];//para que la string dev sea dicha matriz
            contardisparos(dev,matrizusuario,fila,columna);
        }else if("-".equals(matrizadmin[fila][columna])){
             matrizusuario[fila][columna] = "A";
        }
        Registro disparo = new Registro(partida, fila, columna, matrizusuario[fila][columna]);
        GuardarDisparo(disparo);
        contadorm++;
    }
    
    public void contardisparos(String dev,String matrizusuario[][],int fila,int columna){
    if("P".equals(dev)){
            contadorp++;
    }else if("S".equals(dev)){
        contadors++;
    }else if("D".equals(dev)){
        contadord++;
    }else if("F".equals(dev)){
        contadorf++;
    }
       if(contadorp==5){//Si el contador llega a 4 me pone la H de hundido
            contadorp++;
            matrizusuario[fila][columna]="H";
            contadorh++;
    }else if(contadors==3){
        contadors++;
        matrizusuario[fila][columna]="H";
         contadorh++;
    }else if(contadord==2){
        contadord++;
        matrizusuario[fila][columna]="H";
         contadorh++;
    }else if(contadorf==3){
        contadorf++;
        matrizusuario[fila][columna]="H";
         contadorh++;
    }
    }
    public boolean superpongan(String matrizadmin[][],int fila, int columna,String colocacion,int tam) {//comprueba si su posicion esta ocupada o no para que no se superpongan

        boolean siestaocup = false;//Para que desde un inicio no haya barco
        if (colocacion.equalsIgnoreCase("H")) {
            for (int i = columna; i < (columna + tam); i++) {//para que te recorra la longitud del barco
                if (!"-".equals(matrizadmin[fila][i])) {
                    siestaocup = true;
                    return siestaocup;
                }
            }//este metodo seria para horizontales
        } else {
            for (int i = fila; i < (fila + tam); i++) {
                if (!"-".equals(matrizadmin[i][columna])) {
                    siestaocup = true;
                    return siestaocup;
                }
            }
        }//este metodo seria para verticales
        return siestaocup;
    }
    
    public void mostrarpartida(String matriz[][]){
         System.out.println("\t0\t1\t2\t3\t4\t5\t6\t7\t8\t9\n");
        for (int i = 0; i < matriz.length; i++) {
            System.out.printf("%d    |\t", i);
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j]);
                if (j != matriz[i].length - 1) {
                    System.out.print("  \t");
                }
            }
            System.out.println("    |\n");
        }
        
    }
    
    
    public boolean comprobar(){
        if(contadorh==3){
            System.out.print("¡¡¡¡HAS GANADO,ENHORABUENA!!!!");//Me muestre este mensaje en pantalla
        }else{
            return false;
        }
        return true;
    }
    
    
    
    
    
    
    
    public void GuardarDisparo(Registro aux) {


        try {
            FileOutputStream fs = new FileOutputStream("mifichero.txt", true);
            DataOutputStream a = new DataOutputStream(fs);

            a.writeInt(aux.getPartida());

            a.writeInt(aux.getFila());

            a.writeInt(aux.getColumna());

            a.writeUTF(aux.getEfecto());

        } catch (IOException ex) {
        }
    }

    public void leerPartida()throws IOException {

        FileInputStream fs = null;
        DataInputStream d = null;
        try {
            fs = new FileInputStream("mifichero.txt");
            d = new DataInputStream(fs);
            int k, v, s;
            String e;
            while (true) {
                k = d.readInt();
                v = d.readInt();
                s = d.readInt();
                e = d.readUTF();

               Registro r = new Registro(k,v,s,e);
                a.add(r);
                partida = k+1;

            }
        } catch (EOFException e) {

            System.out.println("Fin del fichero");
        } catch (IOException e) {
            System.out.println("Error E/S");
        } finally {
            if (d != null) {
                d.close();
                fs.close();
            }
        }





    }
public void mostrarpartida(int seleccionado){

         String matriz[][] = new String[10][10];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = "-";

            }
        }

           Registro aux;
        for (int i = 0; i < a.size(); i++) {

            aux = (Registro) a.get(i);

            if (aux.getPartida() == seleccionado ) {

                matriz[aux.getFila()][aux.getColumna()] = aux.getEfecto();


            }

        }
           System.out.print("\t");
        System.out.print("\t");

        for (int i = 1; i < 11; i++) {

            System.out.printf("%d", i);
            System.out.print("\t");
        }

        System.out.print("\n");
        System.out.print("\n");

        for (int j = 0; j < matriz.length; j++) {

            System.out.printf("%d", j);
            System.out.print("\t|\t");

            for (int i = 0; i < matriz[j].length; i++) {

                System.out.print(matriz[j][i]);

                if (i != matriz[j].length - 1) {

                    System.out.print("\t");
                }
            }
            System.out.println("\t|");
        }
    }


public void contabilizarPartida(){

    System.out.println("El número de movimientos en la partida actual ha sido: " + contadorm );
}
}
