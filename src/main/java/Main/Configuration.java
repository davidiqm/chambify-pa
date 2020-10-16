package Main;

import Controlador.Controller;
import Modelo.ConnectionBD;
import Vista.Login.LoginFrame;

/**
 *
 * @author Angel J Garcia Sandoval & David I Quime Montalvo
 */
public class Configuration {
    public Configuration(){
        ConnectionBD conn = new ConnectionBD();
        LoginFrame interfaz = new LoginFrame();
        Controller controller = new Controller();
    }
}
