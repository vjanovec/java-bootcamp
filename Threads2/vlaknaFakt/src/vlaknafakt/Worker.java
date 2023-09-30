/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vlaknafakt;


import java.math.BigInteger;

/**
 *
 * @author admin
 */
public class Worker extends Thread {
    
    private long startValue=0;
    private long endValue=0;
    private BigInteger value = new BigInteger("1");
    
    
    
    public Worker(int id, int startValue,int endValue) {
        super("Worker " + id);
        this.startValue=startValue;
        this.endValue=endValue;
        
       
        System.out.println("Worker id: " + id + " has been created threadID:" + getId());
        run();
    }
    
    @Override
    public void run() {
        for (long i = startValue; i <= this.endValue; ++i) {
            BigInteger j = new BigInteger(String.valueOf(i));
            value = value.multiply(j);
            //System.out.println("Worker id: " + getId() + ":: value:" + value);
        }
        }

    public BigInteger getValue() {
        return value;
    }
    
}
