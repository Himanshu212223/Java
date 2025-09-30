# Difference between Comparator and Comparable

| **Feature**                   | **Comparator**                                                        | **Comparable**                                        |
|-------------------------------|-----------------------------------------------------------------------|-------------------------------------------------------|
| **Package**                   | java.util                                                             | java.lang                                             |
| **Interface Method**          | int compare(T obj1, T obj2)                                           | int compareTo(T obj)                                  |
| **Sorting Logic Location**    | Defined outside the class (custom ordering).                          | Defined inside the class itself (natural ordering).   |
| **Number of Sorting Sequences**   | Can define multiple sorting orders by creating multiple comparators.  | Only one (natural order).                             |
| **Affects Original Class?**   | No → separate comparator class.                                       | Yes → class must implement Comparable.                |
| **Use Case**                  | When you want custom or multiple sorting logics (e.g., Student by name, marks, age, etc.). | When an object has a default sorting (e.g., Student by roll number, String alphabetically). |