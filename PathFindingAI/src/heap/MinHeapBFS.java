/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heap;

import java.util.ArrayList;
import models.Pixel;

public class MinHeapBFS {

    private ArrayList<Pixel> list;

    public MinHeapBFS() {

        this.list = new ArrayList<Pixel>();
    }

    public MinHeapBFS(ArrayList<Pixel> items) {

        this.list = items;
        buildHeap();
    }

    public void insert(Pixel item) {

        list.add(item);
        int i = list.size() - 1;
        int parent = parent(i);

        while (parent != i && list.get(i).getCloseness() < list.get(parent).getCloseness()) {

            swap(i, parent);
            i = parent;
            parent = parent(i);
        }
    }

    public void buildHeap() {

        for (int i = list.size() / 2; i >= 0; i--) {
            minHeapify(i);
        }
    }

    public Pixel extractMin() {

        if (list.size() == 0) {

            throw new IllegalStateException("MinHeap is EMPTY");
        } else if (list.size() == 1) {

            Pixel min = list.remove(0);
            return min;
        }

        // remove the last item ,and set it as new root
        Pixel min = list.get(0);
        Pixel lastItem = list.remove(list.size() - 1);
        list.set(0, lastItem);

        // bubble-down until heap property is maintained
        minHeapify(0);

        // return min key
        return min;
    }

//    public void decreaseKey(int i, int key) {
//
//        if (list.get(i) < key) {
//
//            throw new IllegalArgumentException("Key is larger than the original key");
//        }
//
//        list.set(i, key);
//        int parent = parent(i);
//
//        // bubble-up until heap property is maintained
//        while (i > 0 && list.get(parent) > list.get(i)) {
//
//            swap(i, parent);
//            i = parent;
//            parent = parent(parent);
//        }
//    }

    private void minHeapify(int i) {

        int left = left(i);
        int right = right(i);
        int smallest = -1;

        // find the smallest key between current node and its children.
        if (left <= list.size() - 1 && list.get(left).getCloseness() < list.get(i).getCloseness()) {
            smallest = left;
        } else {
            smallest = i;
        }

        if (right <= list.size() - 1 && list.get(right).getCloseness() < list.get(smallest).getCloseness()) {
            smallest = right;
        }

        // if the smallest key is not the current key then bubble-down it.
        if (smallest != i) {

            swap(i, smallest);
            minHeapify(smallest);
        }
    }

    public Pixel getMin() {

        return list.get(0);
    }

    public boolean isEmpty() {

        return list.size() == 0;
    }

    private int right(int i) {

        return 2 * i + 2;
    }

    private int left(int i) {

        return 2 * i + 1;
    }

    private int parent(int i) {

        if (i % 2 == 1) {
            return i / 2;
        }

        return (i - 1) / 2;
    }

    private void swap(int i, int parent) {

        Pixel temp = list.get(parent);
        list.set(parent, list.get(i));
        list.set(i, temp);
    }
    
    public int getSize(){
        return list.size();
    }

}
