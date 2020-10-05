/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import controller.DebitController;
import dao.DBException;

/**
 *
 * @author jairo
 */
public class Testes {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) throws DBException, Exception {
        DebitController d = new DebitController();
     d.cadastrar("10/10/10", "10/10/10", "10/10/10", 30.00, 50.00, false, "Test", "f", 1);
//        CreditController c = new CreditController();
//        c.cadastrar("10/10/10", "10/10/10", "10/10/10", 30.00, 50.00, false, "Test", "f", 1);
//    }
//    
   }
}
