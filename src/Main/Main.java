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
import java.util.ArrayList;
/**
 *
 * @author jairo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws DBException, Exception {
//          ArrayList<Debits> d1 = new  ArrayList<Debits>();;
//          DebitController d2 = new DebitController();
          
          
         CreditController de = new CreditController();
        de.cadastrar("10/10/10", "10/10/10", "10/10/10", 30.00, 50.00, false, "Test", "f", 1);
//        ArrayList<this.controlador.getDebitList().> aList = new ArrayList<DebitController>(); 
        
//         for(int i = 0; i<d.size(); i++){
//            System.out.println(d2.getDebitList());
//        }

//        c.cadastrar("10/10/10", "10/10/10", "10/10/10", 30.00, 50.00, false, "Test", "f", 1);
           
    
    }
    
}
