import java.lang.reflect.Array;
import java.util.Arrays;

public class Heap {
    int capacity = 0;
    int size = 0;
    int[] heapArr = new int[capacity];

    int getParentIndex(int node) { return (node-1)/2;}
    int getParent(int node){return heapArr[getParentIndex(node)];}
    int getRightChildIndx(int node){return (node*2)+1;}
    int getLeftChildIndx(int node){return (node*2)+2;}
    int getLeftChild(int node){return heapArr[getLeftChildIndx(node)];}
    int getRightChild(int node){return heapArr[getRightChildIndx(node)];}
    boolean parentExist(int node){ return (getParentIndex(node) >= 0);}//??
    boolean rightChildExist(int node){return (getRightChild(node)<size);}
    boolean leftChildExist(int node){return (getLeftChild(node)<size);}

    void swap(int node1 , int node2)
    {
        int temp = heapArr[node1];
        heapArr[node2] = heapArr[node1];
        heapArr[node1] = temp;
    }

    void add(int value)
    {
        ensureCapacity(size);
        heapArr[size] = value;
        heapifyUp();
        size++;

    }

    int peek()
    {
        if(size == 0)
        {
            throw new IllegalStateException();
        }

        return heapArr[0];
    }


    int pull()
    {
        if(size == 0)
        {
            throw new IllegalStateException();
        }

        int top = heapArr[0];
        heapArr[0] = heapArr[size-1];
        size--;
        heapifyDown();
        return top;
    }

    private void heapifyDown() {
        int index = 0;
        while(leftChildExist(index))
        {
            int minChildIndex = getLeftChildIndx(index);
            if(rightChildExist(index) && getRightChild(index) < heapArr[minChildIndex])
            {
                minChildIndex = getRightChild(index);
            }
            swap(minChildIndex,index);
        }
    }

    private void heapifyUp() {
        int index = size-1;
        while(parentExist(index) && getParent(index) < heapArr[index] )
        {
            swap(getParentIndex(index),index);
            index = getParent(index);
        }
    }



    private void ensureCapacity(int size) {
        if(size == capacity)
        {
            heapArr = Arrays.copyOf(heapArr,capacity*2);
            capacity = capacity*2;
        }
    }
}
