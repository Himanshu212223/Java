# Different Types of Collections and their features


## Set

| Feature	        | HashSet	        | LinkedHashSet	    | TreeSet	        | EnumSet           |
|-------------------|-------------------|-------------------|-------------------|-------------------|
| Order Maintained	| No	            | Yes (insertion)   | Yes (sorted)	    | Yes (enum order)  |
| Sorting	        | No	            | No	            | Yes	            | Enum order        |
| Null Allowed	    | Yes   	        | Yes   	        |No	                | No                |
| Performance	    | O(1) avg	        | O(1) avg	        | O(log n)	        | O(1)              |
| Use Case	        | Fast & unique	    | Unique + order	| Unique + sorted	| Enum values       |




## List

| Feature	| ArrayList	| LinkedList	| Vector	| Stack	| CopyOnWriteArrayList |
|-----------|-----------|---------------|-----------|-------|---------------------|
|Order Maintained	| Yes (insertion order)	| Yes	| Yes	| Yes (stack order = insertion)	| Yes |
| Sorting	| Not sorted by default (can sort using Collections.sort())	|  Same as ArrayList	| Same as ArrayList	| Same as Vector	| Same as ArrayList |
|Null Allowed	| Multiple nulls allowed	| Multiple nulls allowed	| Multiple nulls allowed	| Multiple nulls allowed	| Only one null allowed (since iteration makes copies) |
| Random Access Performance	| O(1) (fast)	| O(n) (slow)	| O(1) (fast)	| O(1) (fast)	| O(1) |
| Performance	| Fast (fail-fast Iterator)	| Fast (fail-fast Iterator)	| Moderate (fail-fast Iterator)	| Moderate	| Good but costlier (creates a snapshot copy) |
| Use Case	| Frequent reads, fewer writes	| Frequent insert/delete	|Legacy multi-threaded apps	| Stack/LIFO operations	| Read-heavy multi-threaded apps |
Thread-Safe	| No	| No	| Yes (synchronized)	| Yes (synchronized, since extends Vector)	| Yes (designed for concurrency) |




## MAP

| Feature | **HashMap** | **LinkedHashMap** | **TreeMap** | **Hashtable** | **ConcurrentHashMap** |
|---------|-------------|-------------------|-------------|---------------|----------------------|
| **Order Maintained**          |  No order | Insertion order | Sorted by keys (natural/comparator)       | No order  | No order |
| **Sorting**                   | Not sorted | Not sorted | Sorted (ascending by default) | Not sorted | Not sorted |
| **Duplicates Allowed**        | Keys must be unique; values can duplicate | Keys must be unique; values can duplicate | Keys must be unique; values can duplicate | Keys must be unique; values can duplicate | Keys must be unique; values can duplicate |
| **Null Allowed**              | One `null` key, multiple `null` values    | One `null` key, multiple `null` values    | No `null` key, but multiple `null` values | No `null` key, no `null` value | No `null` key, no `null` value |
| **Thread-Safe** | No | No | No | Yes (synchronized) | Yes (lock-striping, better than Hashtable) |
| **Performance**     | Fast, fail-fast iterator | Predictable (insertion order) | Sorted order (slower) | Slow, legacy | Good for concurrency |
| **Use Case** | General-purpose lookup, best performance    | When predictable **insertion order** needed | When **sorted keys** required               | Legacy multi-threaded apps       | Multi-threaded, high-concurrency apps        |











## Common Methods of Collection Framework

| Collection Framework →    | Set (HashSet, LinkedSet, TreeSet )     | List (ArrayList, LinkedList)         | Map (HashMap, LinkedHashMap, TreeMap)     |
|---------------------------|----------------------------------------|--------------------------------------|-------------------------------------------|
| Methods ↓                 | add(e) c e - element                   | add(e) → element                     | put(key, value) → key-value pair          |
|                           | addAll(collection) → add multi element | add(index, e) → element              | putAll(Map m) → multiple pairs/a map      |
|                           | -                                      | set(index, e) → add element at index | -                                         |
|                           | -                                      | get(index) → value at index          | get(key) → get value based on key         |
|                           | clear() → remove all                   | remove(index) → delete element       | -                                         |
|                           | remove(object) → delete object/element | remove(object) → delete object       | remove(Object key) → key-value pair       |     
|                           | size() → total no. of elements         | size() → total no. of elements       | size() → total no. of elements            |
|                           | contains(object) → check element       | contains(object) → check element     | containsKey(key) or containsValue(value)  |
|                           | isEmpty() → check element              | isEmpty() → check element            | isEmpty() → empty check                   |
|                           | -                                      | -                                    | keySet() → get all Keys                   |
|                           | -                                      | -                                    | values() → get all values                 |
|                           | -                                      | -                                    | entrySet() → get all key-values           |