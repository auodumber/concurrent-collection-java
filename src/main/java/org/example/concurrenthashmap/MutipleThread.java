package org.example.concurrenthashmap;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author CMKL-Auodumber Mande
 *
 * This example demonstrate ConcurrentModificationException will be not thrown
 *
 */
public class MutipleThread extends Thread{

    private static ConcurrentHashMap<Integer,String> map  = new ConcurrentHashMap<>();
    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Child thread updating map...");
        map.put(2,"Car");
    }

    public static void main(String[] args) throws InterruptedException {
        map.put(1,"Apple");
        map.put(3,"Banana");

        MutipleThread chileThread = new MutipleThread();
        chileThread.start();

        //Forward loop: they are guaranteed to traverse elements as they existed upon construction exactly once,
        //and may (but are not guaranteed to) reflect any modifications after construction.
        for (Map.Entry<Integer,String> entry : map.entrySet()){
            System.out.println("Key "+entry.getKey() +" "+"Value "+entry.getValue());
            Thread.sleep(3000);
        }

        /*Output:
            Key 1 Value Apple
            Child thread updating map...
            Key 3 Value Banana
         */

        System.out.println(map); //{1=Apple, 2=Car, 3=Banana}
    }
}

