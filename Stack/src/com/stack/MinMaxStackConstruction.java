package com.stack;

import java.util.Stack;

public class MinMaxStackConstruction {

    static class MinMaxStack {

        Stack<MinStack> stack = new Stack<>();

        public int peek() {
            if(stack.isEmpty())
                return -1;
            MinStack minStack = stack.peek();
            return minStack.number;
        }

        public int pop() {
            if(stack.isEmpty())
                return -1;
            MinStack minStack = stack.pop();
            return minStack.number;
        }

        public void push(Integer number) {
            int prevMin = Integer.MIN_VALUE, prevMax = Integer.MIN_VALUE;
            if(stack.isEmpty()){
                prevMin = number;
                prevMax = number;
            } else {
                prevMin = (stack.peek().min < number) ? stack.peek().min : number;
                prevMax = (stack.peek().max > number) ? stack.peek().max : number;
            }
            MinStack minStack = new MinStack(number, prevMin, prevMax);
            stack.push(minStack);
        }

        public int getMin() {
            if(stack.isEmpty())
                return -1;
            MinStack minStack = stack.peek();
            return minStack.min;
        }

        public int getMax() {
            if(stack.isEmpty())
                return -1;
            MinStack minStack = stack.peek();
            return minStack.max;
        }
    }

    static class MinStack {
        int number;
        int min;
        int max;

        public MinStack(int number, int min, int max) {
            this.number = number;
            this.min = min;
            this.max = max;
        }
    }

    public static void main(String[] args) {
        MinMaxStackConstruction.MinMaxStack stack = new MinMaxStackConstruction.MinMaxStack();
        stack.push(2);
        stack.push(7);
        stack.push(1);
        System.out.println(stack.getMin());
        System.out.println(stack.getMax());
        System.out.println(stack.peek());
    }

}
