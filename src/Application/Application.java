package Application;
import Clases.Service;
import Ventanas.Principal;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author DavidTK1198
 */
public class Application {

  public static void main(String[] args) {
        Service servicio = Service.instance();//clase que se encarga de Conectarse a la base
        Ventanas.Principal ventana= new Principal(servicio);
    }

}
