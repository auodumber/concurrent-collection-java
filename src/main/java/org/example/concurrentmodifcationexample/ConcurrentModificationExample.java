package org.example.concurrentmodifcationexample;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author CMKL-Auodumber Mande
 */
public class ConcurrentModificationExample extends Thread {

    static List<String> list  = new ArrayList<>();

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            System.out.println("Child Thread Updating List");
            list.add("Mercedes"); //this will cause ConcurrentModification Exception
        } catch (InterruptedException ignored) {

        }
    }

    public static void main(String[] args) throws InterruptedException {
        list.add("apple");
        list.add("banana");

        ConcurrentModificationExample childThread = new ConcurrentModificationExample();
        childThread.start(); // starting child thread

        for (String s : list) {
            System.out.println("Item is " + s);
            Thread.sleep(3000);
        }

        System.out.println("Final List is "+list);
    }
}


