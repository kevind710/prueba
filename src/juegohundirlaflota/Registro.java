/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegohundirlaflota;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KEVIN
 */
public class Registro {
  
    private int partida;
    private int fila;
    private int columna;
    private String efecto;

    public Registro(int partida, int fila, int columna, String efecto){
        this.partida = partida;
        this.fila = fila;
        this.columna = columna;
        this.efecto = efecto;
    }

    public void Mostrarpartida(){
        System.out.println("Partida : " + this.partida);
        System.out.println("Fila : " + this.fila);
        System.out.println("Columna : " + this.columna);
        System.out.println("Efecto : " + this.efecto);
    }

    public int getPartida() {
        return partida;
    }

    public void setPartida(int partida) {
        this.partida = partida;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public String getEfecto() {
        return efecto;
    }

    public void setEfecto(String efecto) {
        this.efecto = efecto;
    }
    
    
    
    
}
