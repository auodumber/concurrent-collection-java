package org.example.concurrenthashmap;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author CMKL-Auodumber Mande
 *
 *  1. Underlying Data Structure is HashTable
 *
 *  2. To Perform read operation thread won't require ant lock. But to perform update operation thread required
 *     lock but, it is the lock of only a particular part of Map (Buket/Segement level lock)
 *
 *  3. Instead of whole map concurrent update achieved by internally dividing map into samller portion which is defined
 *     by concurrency level is 16
 *
 *  4. That is ConcurrentHashMap allows simultaneous read opertion and simultaneously 16 write(upadate) opertations
 *
 *  5. Null is not allowed for both keys and values
 *
 *  constructors:
 *
 *  ConcurrentHasMap<K,V> map = new ConcurrentHashMap<>();
 *  // Creates Empty ConcurrentHashMap with Default Initial Capacity 16, Default fill Ratio 0.75 and Default concurrency level 16
 *
 *  ConcurrentHasMap<K,V> map = new ConcurrentHashMap<>(int initCapacity);
 *  ConcurrentHasMap<K,V> map = new ConcurrentHashMap<>(int initCapacity, float fillRatio);
 *  ConcurrentHasMap<K,V> map = new ConcurrentHashMap<>(int initCapacity, float fillRatio, int concurrencyLevel);
 *  ConcurrentHasMap<K,V> map = new ConcurrentHashMap<>(Map m);
 *
 *
 */
public class ConcurrentHashMapExample {

    public static void main(String[] args) {
        ConcurrentHashMap<Integer,String> hashMap = new ConcurrentHashMap<>();

        hashMap.putIfAbsent(1,"Apple");
        hashMap.putIfAbsent(2,"Banana");
        hashMap.putIfAbsent(3,"Mango");
        hashMap.putIfAbsent(4,"Watermelon");
        hashMap.putIfAbsent(5,"Kiwi");
        hashMap.putIfAbsent(1,"Car"); //Not added

        System.out.println(hashMap); //{1=Apple, 2=Banana, 3=Mango, 4=Watermelon, 5=Kiwi}


        hashMap.remove(1); // removes entry associated with key
        System.out.println(hashMap); //{1=Apple, 3=Mango, 4=Watermelon, 5=Kiwi}

        hashMap.remove(2,"Banana"); // removes entry associated with key only if both key and value matches (from ConcurrentMap Interface)
        System.out.println(hashMap); //{3=Mango, 4=Watermelon, 5=Kiwi}

        hashMap.replace(3,"MangoShake"); //replace value of the key with new value
        System.out.println(hashMap);//{3=MangoShake, 4=Watermelon, 5=Kiwi}

        hashMap.replace(4,"Watermelon","Cherry");// replace entry with new value if both key and value matches (from ConcurrentMap Interface)
        System.out.println(hashMap);//{3=MangoShake, 4=Cherry, 5=Kiwi}


    }

}
