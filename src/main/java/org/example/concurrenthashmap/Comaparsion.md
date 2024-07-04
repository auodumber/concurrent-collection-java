Sure, I'll create a `README.md` file from the content in the image you provided.

---

## Difference between ConcurrentHashMap, synchronizedMap() and Hashtable

| Feature | ConcurrentHashMap | synchronizedMap() | Hashtable |
|---------|--------------------|-------------------|-----------|
| Thread Safety | We will get Thread Safety without locking Total Map Object. Just with Bucket Level Lock. | We will get Thread Safety by locking Whole Map Object. | We will get Thread Safety by locking Whole Map Object. |
| Multiple Threads | At a Time Multiple Threads are allowed to Operate on Map Object in Safe Manner. | At a Time Only One Thread is allowed to Perform any Operation on Map Object. | At a Time Only One Thread is allowed to Operate on Map Object. |
| Read/Write Operations | Read Operation can be performed without Lock but write Operation can be performed with Bucket Level Lock. | Every Read and Write Operations require Total Map Object Lock. | Every Read and Write Operations require Total Map Object Lock. |
| Concurrent Modification | While One Thread iterating Map Object, the Other Threads are allowed to Modify Map and we won't get ConcurrentModificationException. | While One Thread iterating Map Object, the Other Threads are Not allowed to Modify Map. Otherwise we will get ConcurrentModificationException. | While One Thread iterating Map Object, the Other Threads are Not allowed to Modify Map. Otherwise we will get ConcurrentModificationException. |
| Iterator Behavior | Iterator of ConcurrentHashMap is Fail-Safe and won’t raise ConcurrentModificationException. | Iterator of synchronizedMap is Fail-Fast and it will raise ConcurrentModificationException. | Iterator of Hashtable is Fail-Fast and it will raise ConcurrentModificationException. |
| Null Keys/Values | null is Not allowed for Both Keys and Values. | null is allowed for Both Keys and Values. | null is Not allowed for Both Keys and Values. |
| Version Introduced | Introduced in 1.5 Version. | Introduced in 1.2 Version. | Introduced in 1.0 Version. |

---