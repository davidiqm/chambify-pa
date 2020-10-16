package Main;

import Modelo.ConnectionBD;
import Vista.Login;

/**
 *
 * @author Angel J Garcia Sandoval & David I Quime Montalvo
 */
public class Configuration {
    public Configuration(){
        ConnectionBD conn = new ConnectionBD();
        Login interfaz = new Login();
    }
}
