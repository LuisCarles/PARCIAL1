/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Interface;

import java.util.Random;
import java.util.Scanner;


public class EjercicioPersona  {
    public static void main(String[] args) throws Exception {
    
        Scanner entrada = new Scanner(System.in);
        //Primera persona
        System.out.println("Inserte el nombre");
        String nombre    = entrada.nextLine();
        System.out.println("Inserte el sexo, H para hombre y M para mujer");
        String sexo= entrada.nextLine();
        System.out.println("Inserte la edad");
        int edad    = entrada.nextInt();
        System.out.println("Inserte el peso");
        float peso    = entrada.nextFloat();
        System.out.println("Inserte la altura");
        float altura    = entrada.nextFloat();
        //Segunda persona
        System.out.println("Inserte el nombre");
        
        String idk    = entrada.nextLine();
        String nombre1    = entrada.nextLine();
        System.out.println("Inserte el sexo, H para hombre y M para mujer");
        String sexo1= entrada.nextLine();
        System.out.println("Inserte la edad");
        int edad1    = entrada.nextInt();
        
        
        Persona persona1 = new Persona(nombre,edad,sexo,peso,altura);
        Persona persona2 = new Persona(nombre1,edad1,sexo1);
        Persona persona3 = new Persona();

        persona3.setNombre("Andrea");
        persona3.setEdad(13);
        persona3.setSexo("M");
        persona3.setPeso(60);
        persona3.setAltura((float) 1.60);
        Boolean[] mayorDeEdad;
        mayorDeEdad = new Boolean[3];
        String[] respuestaSiEsMayor;
        respuestaSiEsMayor = new String[3];
        
        mayorDeEdad[0] = persona1.esMayorDeEdad();
        mayorDeEdad[1] = persona2.esMayorDeEdad();
        mayorDeEdad[2] = persona3.esMayorDeEdad();

        for (int i=0; i < 3; i++){
            if (mayorDeEdad[i]){
                respuestaSiEsMayor[i] = "Mayor de edad";
                
            } else{
                respuestaSiEsMayor[i] = "Menor de edad";
            }
        }

        System.out.println(persona1.getNombre() + ", estas en " + persona1.calcularIMC() + ". Esta persona es "+ respuestaSiEsMayor[0] +" datos: "+ persona1.toString());
        System.out.println(persona2.getNombre() + ", estas en " + persona2.calcularIMC() + ". Esta persona es "+ respuestaSiEsMayor[1] +" datos: "+ persona2.toString());
        System.out.println(persona3.getNombre() + ", estas en " + persona3.calcularIMC() + ". Esta persona es "+ respuestaSiEsMayor[2] +" datos: "+ persona3.toString());

        

    }
}

class Persona {
    private String nombre;
    private String sexo;
    private int edad, dui; 
    private float peso, altura;
    Random random = new Random();

    
    // Construtor por defecto
    public  Persona(){
        this.nombre = "";
        this.edad   = 0;
        this.sexo   = "H";
        this.peso   = 0;
        this.altura = 0;
        this.dui = generaDUI();
        
       

    }

    // Construtor con pocos parametros
    public Persona(String nombre, int edad, String sexo){
        this.nombre = nombre;
        this.edad   = edad;
        this.sexo   = comprobarSexo(sexo);
        this.peso   = 0;
        this.altura = 0;
        this.dui = generaDUI();

    }

    // Construtor con todos los parametros
    public Persona(String nombre, int edad, String sexo, float peso, float altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = comprobarSexo(sexo);
        this.peso = peso;
        this.altura = altura;
        this.dui = generaDUI();
      
    }


    public String calcularIMC() {
        float IMC;
        final String sobrePeso = "Sobre peso";
        final String pesoIdeal = "Peso ideal"; 
        final String bajoPeso  = "Bajo peso";

        IMC = peso / (altura * altura);
        if (IMC < 20) {
            return pesoIdeal;
        } else if (IMC >= 20 && IMC <= 25) {
            return bajoPeso;
        }else{
            return sobrePeso;
        }
    }

    public boolean esMayorDeEdad(){
        if (this.edad>=18){
            return true;
        }else{
            return false;
        }
    }


    private String comprobarSexo(String sexo){
        if(sexo == "H" || sexo =="M"){
            return sexo;
        }else{
            return "H";
        }
    }

    private int generaDUI(){

        int duiGen = random.nextInt(99999)+10000000;
        return duiGen;
    }

    public int getDui() {
        return dui;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad(){
        return edad;
    }

    public String getSexo(){
        return sexo;
    }

    public String getPeso(){
        return sexo;
    }

    public float setPeso(){
        return peso;
    }

    public float setAltura(){
        return altura;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setSexo(String sexo) {
        this.sexo = comprobarSexo(sexo);
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Persona\n{" + "nombre=" + nombre + ",\n edad=" + edad + ",\n sexo=" + sexo + ",\n peso=" + peso + ",\n altura=" + altura + ",\n dui=" + dui + '}';
    }

}