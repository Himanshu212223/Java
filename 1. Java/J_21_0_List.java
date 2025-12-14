
/*
    List :-
    ------------------

    - List is ordered collection of elements.
    - Different List Implementations are -
    1. ArrayList    :- Dynamic Array (whose size can change based on contents), Maintain insertion order, Fast, Not synchronized.
    2. LinedList    :- Doubly Linked List, Maintain insertion order, Slow, Not Synchronized.
    3. Vector       :- Dynamic Array, Maintain Insertion Order, Fast, Synchronized.
    4. Stack        :- Dynamic Array (LIFO), LIFO Order, Fast, Synchronized.


    When to use ..?
    ------------------------
    Array List  - Fast Random Access.
    Linked List - Frequent insertion or deletion in between list.
    Vector      - Thread Safe List Required.
    Stack       - When LIFO operation required.
*/



import java.util.List;
import java.util.Stack;
import java.util.Vector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;


class School implements Comparable<School>{
	public int srNo ;
	
	School(){}
	
	School(int srNo){
		this.srNo = srNo ;
	}
	
	
	@Override
	public int compareTo(School school) {
		//	for doing this, we have to implement the Comparable<>.
		if(this.srNo == school.srNo) {
			return 0 ;
		}
		else if(this.srNo > school.srNo) {
			return 1 ;
		}
		else {
			return -1;
		}
	}
};


public class J_21_0_List {
	public static void main(String [] args) {
		
        
        //  --------------- Array List ---------------

        //  C - Create
        List<Integer> arrayList = new ArrayList<>() ;

        arrayList.add(3);                     //  arrayList.add(value);
        arrayList.add(56);                    //  arrayList.add(value);

        arrayList.add(1, 45);   //  arrayList.add(index, value);
        arrayList.add(0, 92);   //  arrayList.add(index, value);

        //  R - Read any element from List
        int valueAtIndx0 = arrayList.get(0);    //  arrayList.get(index);
        int valueAtIndx2 = arrayList.get(2);    // arrayList.get(index);

        //  U - Update List
        arrayList.set(0, 12) ;                  //  arrayList.set(index, newValue) ;

        // D - Delete List or its items
        arrayList.remove(12);       //  arrayList.remove(index);
        arrayList.clear();              //  remove all elements


        arrayList = null ;

        /*
        | Method              | Usage                    |
        | ------------------- | ------------------------ |
        | add(E e)            | Insert element at end    |
        | add(int index, E e) | Insert at specific index |
        | get(int index)      | Returns element          |
        | set(int index, E e) | Replace element          |
        | remove(int index)   | Remove element           |
        | remove(Object o)    | Remove specific object   |
        | size()              | Current size             |
        | contains(Object o)  | Check existence          |
        | isEmpty()           | Check empty              |
        | clear()             | Remove all elements      |
        | indexOf(o)          | Return first index       |
        | lastIndexOf(o)      | Return last index        |
        */


        //  --------------- Linked List ---------------

        //  C - Create
        List<Integer> linkedList = new LinkedList<>();

        linkedList.add(44);             //  Add value at the end.
        linkedList.addFirst(12);     // Add value at the beginning.
        linkedList.addLast(99);      // Add Value at the end.
        linkedList.add(2, 45);  //  linkedList.add(index, value);

        // R - Read
        int linkedListFirst = linkedList.getFirst();        //  To get First Element
        int linkedListLast = linkedList.getLast();          //  To get Last Element
        int linkedListValueAtIndex2 = linkedList.get(2);    //  linkedList.get(index);

        //  U - Update
        linkedList.set(3, 65) ;             //  linkedList.set(index, value);

        //  D - Delete
        linkedList.remove(2);         // linkedList.remove(index);
        linkedList.removeFirst();           // Remove First Element
        linkedList.removeLast();            // Remove Last Element
        linkedList.clear();                 //  removes all elements

        linkedList = null ;

        /*
        | Category | Methods                                                                 | Description          |
        | -------- | ----------------------------------------------------------------------- | -------------------- |
        | Add      | `add()`, `addFirst()`, `addLast()`, `add(index, obj)`                   | Insert items         |
        | Read     | `get()`, `getFirst()`, `getLast()`                                      | Fetch elements       |
        | Update   | `set(index, obj)`                                                       | Modify item at index |
        | Remove   | `remove()`, `removeFirst()`, `removeLast()`, `remove(index)`, `clear()` | Delete elements      |
        | Search   | `contains(obj)`, `indexOf(obj)`, `lastIndexOf(obj)`                     | Search values        |
        | Utility  | `size()`, `isEmpty()`, `offer()`, `peek()`, `poll()`                    | Queue-related usage  |
        */




        //  --------------- Vector ---------------

        //  C - Create
        Vector<Integer> vector = new Vector<>();

        vector.add(34);                     //  vector.add(value);
        vector.addElement(12);          //  vector.addElement(object);
        vector.add(1, 23);    //  vector.add(index, element);

        //  R - Read
        int vectorValueAtIndex1 = vector.get(1);    //  vector.get(index);
        int vectorFirstValue = vector.getFirst();   //  Read First value
        int vectorLastValue = vector.getLast();     //  Read Last value

        //  U - Update
        vector.set(1, 66);                  //  vector.set(index, value);

        //  D - Delete
        vector.remove(1);           //  vector.remove(index);
        vector.removeElement(66);     //   vector.remove(element);
        vector.clear();                   // Remove all elements.

        /*
        | Category | Method                                                    | Description         |
        | -------- | --------------------------------------------------------- | ------------------- |
        | Add      | `add()`, `addElement()`, `add(index, obj)`                | Insert new elements |
        | Read     | `get()`, `firstElement()`, `lastElement()`, `elementAt()` | Fetch elements      |
        | Update   | `set(index, obj)`                                         | Modify element      |
        | Remove   | `remove()`, `removeElement()`, `remove(index)`, `clear()` | Delete elements     |
        | Search   | `contains(obj)`, `indexOf(obj)`, `lastIndexOf(obj)`       | Find elements       |
        | Capacity | `size()`, `capacity()`, `ensureCapacity()`                | Check capacity      |
        | Extra    | `clone()`, `trimToSize()`                                 | Utility operations  |
        */



        //  --------------- Stack ---------------

        //  C - Create
        Stack<Integer> stack = new Stack<>();

        stack.push(12);     //  stack.push(value);
        stack.push(34);     //  stack.push(value);

        //  R - Read value
        int stackValue1 = stack.peek(); //  Read top element
        int stackValueIndex = stack.search(34);     //  stack.search(element); -> Returns position of element

        //  U - Update
        stack.set(1, 45);       //  stack.set(index, value);

        //  D - Delete
        stack.remove(1);        //  stack.remove(index);
        stack.clear();                //  to remove all elements

        stack = null ;

        /*
        | Method                | Operation | Description                       |
        | --------------------- | --------- | --------------------------------- |
        | `push(element)`       | Create    | Inserts element at top            |
        | `peek()`              | Read      | Gets top element without removing |
        | `search(element)`     | Read      | Returns position of element       |
        | `set(index, value)`   | Update    | Modify by index                   |
        | `pop()`               | Delete    | Removes and returns top element   |
        | `remove(index/value)` | Delete    | Removes by index or value         |
        | `isEmpty()`           | Utility   | Checks if stack is empty          |
        | `size()`              | Utility   | Number of elements in stack       |
        */


	}
}