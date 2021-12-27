package com.company;

import java.util.*;

public class PriorityQueue extends AbstractQueue<Pixel> implements Queue<Pixel> {
    private int capacity = 100;
    private myArrayList data;
    private int size;
    private Comparator<Pixel> comparator;

    public int getSize() {
        return size;
    }

    public PriorityQueue(Comparator<Pixel> comparator){
        this.comparator = comparator;
        data = new myArrayList();
        size = 0;
    }



    @Override
    public Iterator<Pixel> iterator() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean offer(Pixel pixel) {
        data.add(pixel);
// child is newly inserted item.
        int child = (data.size()-1);
        int parent = (child-1)/2;  // Find child's parent.
// Reheap
        while (parent >= 0 && comparator.compare(data.get(parent), data.get(child)) < 0) {
                    swap(parent, child);
                    child = parent;
                    parent = (child-1)/2;
        }
            return true;
    }

    private void swap(int parent, int child) {
        Pixel temp = data.get(parent);
        data.set(parent,data.get(child));
        data.set(child,temp);
    }

    @Override
    public boolean isEmpty() {
        if (data.size() == 0){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Pixel poll() {
        if (isEmpty()) {
            return null;
        }
// Save the top of the heap.
        Pixel result = data.get(0);
// If only one item then remove it.
        if (data.size() == 1) {
            data.remove(0);
            return result;
        }
/* Remove the last item from the ArrayList and place it into
the first position. */
        data.set(0, data.remove(data.size()-1));
// The parent starts at the top.
        int parent = 0;
        while (true) {
            int leftChild = 2 * parent + 1;
            if (leftChild >= data.size()) {
                break; // Out of heap.
            }
            int rightChild = leftChild + 1;
            int minChild = leftChild; // Assume leftChild is smaller.
// See whether rightChild is smaller.
            if (rightChild < data.size()
                    && comparator.compare(data.get(leftChild),
                    data.get(rightChild)) < 0) {
                minChild = rightChild;
            }
// assert: minChild is the index of the smaller child.
// Move smaller child up heap if necessary.
            if (comparator.compare(data.get(parent),
                    data.get(minChild)) < 0) {
                swap(parent, minChild);
                parent = minChild;
            } else { // Heap property is restored.
                break;
            }
        }
        return result;
    }

    @Override
    public Pixel peek() {
        return null;
    }
}
