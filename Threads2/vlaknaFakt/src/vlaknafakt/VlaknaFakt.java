/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vlaknafakt;

/**
 *
 * @author admin
 */
public class VlaknaFakt {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        long startTime = System.nanoTime(); 
        int vysledek=0;
        Worker w1 = new Worker(1,1,30);
        System.out.println("Result: " +w1.getValue());
        long duration = System.nanoTime() - startTime;
        System.out.println("Bez:" +duration/1e6);
        System.out.println("------------------");
        /****************/
        
        startTime = System.nanoTime(); 
        Worker w11 = new Worker(1,1,10);
        Worker w2 = new Worker(2,11,20);
        Worker w3 = new Worker(3,21,30);
        
        w11.join();
        w2.join();
        w3.join();

        System.out.println("Result: " +w11.getValue().multiply(w2.getValue().multiply(w3.getValue())));
         
        duration = System.nanoTime() - startTime;
        System.out.println("S:" +duration/1e6);
    }
    
}
