package org.example.copyonwritearraylist;

/**
 * @author CMKL-Auodumber Mande
 */

/*
    1. As update operation performed on cloned copy there is no effect for the treads which performs read operation
    2. It is Costly to use because every update operation a cloned copy will be created. hence `CopyOnWriteArrayList`
       is the best choice if several read operation and less no. of write operation are required to perform.
    3. Insertion order is preserved.
    4. Duplicate objects are allowed.
    5. Heterogeneous objects are allowed.
    6. Null insertion is possible.
    7. While one thread iterating CopyOnWriteArrayList, the other threads are allowed modify, and we won't get ConcurrentModificationException
       That iterator is fail-safe iterator.
    8. Iterator of `ArrayList` can perform remove operation but iterator of `CopyOnWriteArrayList` cant perform remove operation
       otherwise we will get RuntimeException saying `UnsupportedOperationException`.

*/
public class CopyOnWriteArrayListExample {

    public static void main(String[] args) {

    }
}
