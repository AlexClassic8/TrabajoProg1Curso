/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quienparecequien;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author Alex
 */
public class Personaje implements Serializable{
    private static final long serialVersionUID = 1L;
    private String nombre; 
    private boolean gafas; 
    private boolean bigote;
    private boolean pelo;
    private boolean hombre;
    private boolean blanco;
    private boolean sombrero;
    private boolean elejido; 
    private int posicion;
    private boolean tachado=false;

    public boolean isTachado() {
        return tachado;
    }

    public void setTachado(boolean tachado) {
        this.tachado = tachado;
    }

    public Personaje(String nombre) {
        this.nombre = nombre;
    }
//Constructor por atributos
    public Personaje(String nombre, boolean gafas, boolean bigote, boolean pelo, boolean hombre, boolean blanco, boolean sombrero, int posicion) {
        this.nombre = nombre;
        this.gafas = gafas;
        this.bigote = bigote;
        this.pelo = pelo;
        this.hombre = hombre;
        this.blanco = blanco;
        this.sombrero = sombrero;
        this.posicion= posicion;
    }
    
    public static void comoEs(Personaje[] p){
        
    }

    public boolean isGafas() {
        return gafas;
    }

    public void setGafas(boolean gafas) {
        this.gafas = gafas;
    }

    public boolean isSombrero() {
        return sombrero;
    }

    public void setSombrero(boolean gordo) {
        this.sombrero = gordo;
    }

    //Getter
    public String getNombre() {
        return nombre;
    }


    public int getPosicion() {
        return posicion;
    }


    public boolean isBigote() {
        return bigote;
    }

    public boolean isPelo() {
        return pelo;
    }

    public boolean isHombre() {
        return hombre;
    }

    public boolean isBlanco() {
        return blanco;
    }

    public boolean isElejido() {
        return elejido;
    }
    
    //Setter

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public void setBigote(boolean bigote) {
        this.bigote = bigote;
    }

    public void setPelo(boolean pelo) {
        this.pelo = pelo;
    }

    public void setHombre(boolean hombre) {
        this.hombre = hombre;
    }

    public void setBlanco(boolean blanco) {
        this.blanco = blanco;
    }

    public void setElejido(boolean elejido) {
        this.elejido = elejido;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    @Override
    public String toString() {
        return "Personajes{" + "nombre=" + nombre + ", narizon=" + gafas + ", bigote=" + bigote + ", pelo=" + pelo + ", hombre=" + hombre + ", blanco=" + blanco + ", gordo=" + sombrero + ", elejido=" + elejido + ", posicion=" + posicion + ", tachado=" + tachado + '}';
    }
    
    public static void serializarPersonajes(String ruta, Personaje[] p) throws FileNotFoundException, IOException{
        FileOutputStream out=new FileOutputStream(ruta);
        ObjectOutputStream outObj=new ObjectOutputStream(out);
        for(int i=0; i<p.length;i++){
        outObj.writeObject(p[i]);
        }
        
        out.close();
        outObj.close();
    }
    public static void obtenerPersonajes(String ruta, Personaje[] p) throws FileNotFoundException, IOException, ClassNotFoundException{
         FileInputStream fis= new FileInputStream(ruta);
         ObjectInputStream entrada= new ObjectInputStream(fis);
         for(int i=0; i<p.length;i++){
           p[i]=(Personaje) entrada.readObject(); 
         } 
     }
   //Clona dos personajes, lo uso para tachar personajes
    public void copiar(Personaje p){  
        this.nombre = p.getNombre();
        this.sombrero = p.isSombrero();
        this.bigote = p.isBigote();
        this.pelo = p.isPelo();
        this.hombre = p.isHombre();
        this.blanco = p.isBlanco();
        this.gafas = p.isGafas();
        this.posicion=p.getPosicion();
    }
    //elije el personaje que hay que adivinar
     public static int elElejido(Personaje[] P){
            int pos=0;
         int num=(int)(Math.random()*P.length);
            for(int i=0;i<P.length;i++){
                if(i==num){
                    P[i].setElejido(true);
                    pos=i;
                }   
            }
            return pos;
        }
}
