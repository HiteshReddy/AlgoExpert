package com.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class MinHeapConstruction {
    static class MinHeap {
        List<Integer> heap = new ArrayList<Integer>();

        public MinHeap(List<Integer> array) {
            heap = buildHeap(array);
        }

        public List<Integer> buildHeap(List<Integer> array) {
            int firstParentIdx = (array.size()-2)/2;
            for(int i = firstParentIdx; i >= 0; i--) {
                siftDown(i, array.size()-1, array);
            }
            return array;
        }

        public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
            int childOneIdx = currentIdx * 2 + 1;
            while(childOneIdx <= endIdx) {
                int childTwoIdx = currentIdx * 2 + 2;
                if(childTwoIdx > endIdx)
                    childTwoIdx = -1;
                int idxToSwap = -1;
                if(childTwoIdx != -1 && heap.get(childOneIdx) > heap.get(childTwoIdx)) {
                    idxToSwap = childTwoIdx;
                } else {
                    idxToSwap = childOneIdx;
                }
                if(heap.get(idxToSwap) < heap.get(currentIdx)) {
                    swap(currentIdx, idxToSwap, heap);
                    currentIdx = idxToSwap;
                    childOneIdx = currentIdx * 2 + 1;
                } else {
                    return;
                }
            }
        }

        public void siftUp(int currentIdx, List<Integer> heap) {
            int parentIdx = (currentIdx-1)/2;
            while(parentIdx >=0 && heap.get(parentIdx) > heap.get(currentIdx)) {
                swap(parentIdx, currentIdx, heap);
                currentIdx = parentIdx;
                parentIdx = (currentIdx-1)/2;
            }
        }

        public int peek() {
            return heap.get(0);
        }

        public int remove() {
            int valToRemove = heap.get(0);
            int size = heap.size();
            heap.set(0, heap.get(size-1));
            heap.remove(size-1);
            this.siftDown(0, size-1, this.heap);
            return valToRemove;
        }

        public void insert(int value) {
            heap.add(value);
            this.siftUp(heap.size()-1, heap);
        }

        private void swap(int parentIdx, int currentIdx, List<Integer> heap) {
            heap.set(parentIdx, heap.set(currentIdx, heap.get(parentIdx)));
        }
    }

    public static void main(String[] args) {
        MinHeap heap = new MinHeap(Arrays.asList(48, 12, 24, 7, 8, -5, 24, 391, 24, 56, 2, 6, 8, 41));
        heap.insert(76);
        heap.heap.stream().forEach(elem -> System.out.println(elem));
    }

}
