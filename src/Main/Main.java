/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import controller.CreditController;
import controller.DebitController;
import model.Debits;
import dao.DBException;
import java.awt.Menu;
import java.util.ArrayList;
import view.FMenu;
/**
 *
 * @author jairo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
          FMenu menuScreen = new FMenu();
          
          menuScreen.setVisible(true);
    }
}
