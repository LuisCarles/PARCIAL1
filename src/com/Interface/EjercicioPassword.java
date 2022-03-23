/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Interface;

import java.util.Random;
import java.util.Scanner;

   class EjercicioPassword {
    public static void main(String[] args) throws Exception {
      Scanner entrada = new Scanner(System.in);
      System.out.println("Inserte el largo de las contraseñas:");
      int largo    = entrada.nextInt();
      System.out.println("Inserte la cantidad de contraseñas:");
      int cantidad = entrada.nextInt();

      String[] Contraseñas; 
      Contraseñas = new String[cantidad]; 
      
      boolean[] ContrasFuertes; 
      ContrasFuertes = new boolean[cantidad]; 
      
      for(int i = 0; i < cantidad; i++){
        Password contreseñaMomentanea = new Password(largo);
        Contraseñas[i]    = contreseñaMomentanea.getPassword();
        ContrasFuertes[i] = contreseñaMomentanea.esFuerte();
      }

      for(int i = 0; i < cantidad; i++){
        int posicion = i + 1;
        System.out.println("Contraseña "+posicion+": "+Contraseñas[i]+"   Es fuerte: "+ContrasFuertes[i]);
      }
      
    }
}

class Password {
  private int longitud;
  private String contraseña;
  Random random = new Random();
  
  //constructor 1
  public Password() {
    this.longitud = 8;
    generatePassword(longitud);
  }
  //constructor 2
  public Password(int longitud) {
    this.longitud = longitud;
    generatePassword(longitud);
    
  }

  private void generatePassword(int longitud) {
    contraseña = "";
    for(int i = 1; i <= longitud; i++){
      int aleatoryNumber = random.nextInt(59);
      //0-9, 10-35, 36-59
      //Numeros 48 / 57, Mayusculas 65 / 90, Minusculas 97 / 122;

      if (aleatoryNumber <= 9) {
        contraseña = contraseña + Character.toString(aleatoryNumber + 48);
      } else if (aleatoryNumber > 9 && aleatoryNumber <= 35) {
        contraseña = contraseña + Character.toString(aleatoryNumber + 55);
      } else if (aleatoryNumber > 35 && aleatoryNumber <= 61) {
        contraseña = contraseña + Character.toString(aleatoryNumber + 61);
      }    
    }
  }

  public String getPassword(){
    return this.contraseña;
  }

  public void setPassword(String pass) {
    this.contraseña= pass;
  }

  public boolean esFuerte(){
    int contraLength = contraseña.length();
    int cantNumer = 0;
    int cantMayus = 0;
    int cantMinus = 0;
    for(int i = 0; i < contraLength; i++) {
      int ASCIIcharacter = contraseña.charAt(i);
      //Numeros 48 / 57, Mayusculas 65 / 90, Minusculas 97 / 122;
      if (ASCIIcharacter > 47 && ASCIIcharacter <= 57) {
        cantNumer++;
      } else if (ASCIIcharacter > 64 && ASCIIcharacter <= 90) {
        cantMayus++;
      } else if (ASCIIcharacter > 96 && ASCIIcharacter <= 122) {
        cantMinus++;
      }
    }

    if (cantMayus > 2 && cantMinus > 1 && cantNumer > 5){ 
      return true;
      }else {
        return false;
      }
  }
}