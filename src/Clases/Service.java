package Clases;

import Clases.Database;
import Clases.Query;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class Service {
    private static Service theInstance;
     private Database conexion;  
    
    public static Service instance(){
        if (theInstance==null){ 
            theInstance=new Service();
        }
        return theInstance;
    }
    
  
    public Service() {
        this.conexion=Database.instance();
    }

    public Database getConexion() {
        return conexion;
    }

    public void setConexion(Database conexion) {
        this.conexion = conexion;
    }

   
   

}
