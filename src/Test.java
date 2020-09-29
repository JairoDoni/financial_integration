
import controller.CreditController;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gui
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        
        CreditController c = new CreditController();
        
        c.cadastrar("10/10/10", "10/10/10", "10/10/10", 30.00, 50.00, false, "Test", "f", 4);
        
        
    }
    
}
