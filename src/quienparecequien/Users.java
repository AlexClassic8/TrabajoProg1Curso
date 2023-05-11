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
import java.util.ArrayList;

/**
 *
 * @author Alex
 */
public class Users implements Serializable, Comparable<Users>{
    private static final long serialVersionUID = 2L;
    private String nombre;
    private int puntuacion;

    public Users(String nombre, int puntuacion) {
        this.nombre = nombre;
        this.puntuacion = puntuacion;
    }

    public Users(){
        
    }
    
    @Override
    public int compareTo(Users u)
    {
        if (this.getPuntuacion() != u.getPuntuacion()) {
            return this.getPuntuacion() - u.getPuntuacion();
        }
        return this.getNombre().compareTo(u.getNombre());
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
    
    public static void serializarUser(String ruta, ArrayList<Users> U) throws FileNotFoundException, IOException{
        ObjectOutputStream outObj;
        //Aqui pongo false en el constructor para que ya que solo muestra una que muestre la de este usuario
        //ya que si la dejo como true y permite guardar en vez de sobreescribir solo te va a sacar el primer usuario que jugo.
        try (FileOutputStream out = new FileOutputStream(ruta, false)) {
            outObj = new ObjectOutputStream(out);
            for(int i = 0; i<U.size();i++) {
            outObj.writeObject(U.get(i));
            }
        }
        outObj.close();
    }
    
    public static void obtenerUser(String ruta, ArrayList<Users> contenedor) throws FileNotFoundException, IOException, ClassNotFoundException{
        ObjectInputStream entrada;
        try (FileInputStream fis = new FileInputStream(ruta)) {
            entrada = new ObjectInputStream(fis);
            //Dejo esta parte comentada para que funcione bien ya que tengo un error a la hora de leer mas de un usuario del archivo de Users.
            while(fis.available()>0){
            contenedor.add((Users) entrada.readObject());
            }
        }
        entrada.close();
         } 
           
        
        
     }

