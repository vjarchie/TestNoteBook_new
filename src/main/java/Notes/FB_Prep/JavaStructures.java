package Notes.FB_Prep;

import java.util.*;

public class JavaStructures {

    public static void  main(String[] args){
        Queue<Integer>  queue1 = new LinkedList<>();
        boolean res = queue1.add(1); // Exception if fails to add
        Integer i = queue1.remove(); //Exception if fails to remove
        int size = queue1.size();
        int p1 = queue1.peek();
        queue1.poll(); // null if queue empty
        boolean result = queue1.offer(1) ; // return false if fails to add

        //Heap

        PriorityQueue<Integer> pq= new PriorityQueue<>(); //min heap
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());//max heap

        Deque<Integer> dque = new LinkedList<>();
       //adding

        //  push- pop - like a stack at the begining;
        //
        boolean resl = dque.add(1); // == addLast()
        boolean res2 = dque.offer(7); // == offerLast()
        dque.push(4); // == addFirst()

        dque.addFirst(2); // void + Exception
        boolean  resb = dque.offerFirst(3);

        dque.addLast(3); // void + Exception
        boolean resc = dque.offerLast(5);

        dque.addAll(new LinkedList<>());



        // removing
        dque.remove(); // == removeFirst()
        dque.poll(); // == pollFirst()
        dque.pop(); // == removeFirst()
        dque.pollFirst();
        dque.pollLast();
        // vieweing
        Integer q1 = dque.peek();
        Integer q2 = dque.peekFirst(); // return null  if empty
        Integer q3 = dque.peekLast(); // return null if empty


        int o = dque.getFirst(); // trhows exception
        int o1 = dque.getLast(); // throws exception


        // Arrays





    }
}
