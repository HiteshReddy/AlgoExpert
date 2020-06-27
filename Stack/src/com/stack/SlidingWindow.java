package com.stack;

import java.lang.reflect.Array;
import java.util.*;

public class SlidingWindow {

    public static ArrayList<Integer> slidingWindow(final List<Integer> A, int B) {
        Deque<Integer> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < B ; i++) {
            while(!queue.isEmpty() && A.get(queue.peek()) < A.get(i)) {
                queue.pop();
            }
            queue.push(i);
        }
        result.add(A.get(queue.peekLast()));

        for(int i = B; i < A.size(); i++) {
            while(!queue.isEmpty() && queue.peekLast() <= (i-B)) {
                queue.pollLast();
            }
            while(!queue.isEmpty() && A.get(queue.peek()) < A.get(i)) {
                queue.pop();
            }
            queue.push(i);
            result.add(A.get(queue.peekLast()));
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> result = slidingWindow(Arrays.asList(10, 9 , 8, 7, 6, 5, 4, 3, 2, 1), 2);
        result.forEach(i -> System.out.println(i));
    }

}
