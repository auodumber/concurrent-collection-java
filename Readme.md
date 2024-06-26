# Concurrent Collections in Java

## Need for Concurrent Collections

1. Traditional Collection Objects (like `ArrayList`, `HashMap`, etc.) can be accessed by multiple threads simultaneously, leading to potential data inconsistency problems, making them not thread-safe.
2. Existing thread-safe collections (`Vector`, `Hashtable`, `synchronizedList()`, `synchronizedSet()`, `synchronizedMap()`) do not perform well enough.
3. Because for every operation, even for read operations, the entire collection will be locked by only one thread at a time, increasing the waiting time of threads.



### Issues with Traditional Collections

1. Another big problem with traditional collections is that while one thread is iterating over the collection, other threads are not allowed to modify the collection object simultaneously. If modification is attempted, a `ConcurrentModificationException` is thrown.
2. Hence, these traditional collection objects are not suitable for scalable multi-threaded applications.
3. To overcome these problems, SUN introduced concurrent collections in Java 1.5.

## Differences Between Traditional & Concurrent Collections

1. Concurrent Collections are always thread-safe.
2. When compared with traditional thread-safe collections, performance is improved due to different locking mechanisms.
3. While one thread is interacting with the collection, other threads are allowed to modify the collection in a safe manner.

Hence, Concurrent Collections never throw `ConcurrentModificationException`.

### Important Concurrent Classes

1. `ConcurrentHashMap`
2. `CopyOnWriteArrayList`
3. `CopyOnWriteArraySet`


## ConcurrentMap(I)

<img alt="concurrent_map" height="300" src="img/concurrent_map.png" width="300"/>

### Methods

1. `Object putIfAbsent(Object key, Object value)`: To Add Entry to the Map If the specified Key is Not Already Available

| put()                                                                                            | putIfAbsent()                                                                                                                                               |
|--------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------|
| If the key is Already Available, Old Value will <br/>be replaced with New Value <br/>and Returns Old Value | If the key is already present then entry wont<br/>be added and returns old associated value.<br/>If the key is not available then only entry will be added. |

2. `boolean remove(Object key, Object value)` :  Removes the Entry if Key Associated with specified Value only
3. `boolean replace(Object key,Object oldValue, Object newValue)` : If Key Value Matched then Replace with newValue



    