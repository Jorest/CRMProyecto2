
import java.sql.Connection;
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luis
 */
public class CRMProyecto2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Connection c = ConnectionDB.GetConnect();
        GUI gui = new GUI();
        gui.setVisible(true);

}
}
