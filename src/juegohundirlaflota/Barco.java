/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegohundirlaflota;

/**
 *
 * @author KEVIN
 */
public class Barco {
    String Tipo;
    int Tam;
    char Letra;
    
    
    public Barco(String Tipo,int Tam,char Letra) { //constructor
        this.Tipo = Tipo;
        this.Tam = Tam;
        this.Letra = Letra;
    }
    
    //============================================METODOS GET Y SET=======================================

    public String getTipo() {
        return Tipo;
    }

    public int getTam() {
        return Tam;
    }

    public char getLetra() {
        return Letra;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public void setTam(int Tam) {
        this.Tam = Tam;
    }

    public void setLetra(char Letra) {
        this.Letra = Letra;
    }
    //======================================================================================================
    
    
    
    
    
}
