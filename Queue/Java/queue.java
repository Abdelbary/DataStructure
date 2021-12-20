import java.io.*;
import java.util.Arrays;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

// Main class should be named 'Solution'
class Solution {
    public static void main(String[] args) {
        System.out.println("Hello, World");
    }
}

interface queue{
    public void add(int val);
    public int get();
    public int front();
    public boolean isEmpty();
}
class QueueLinkedListImp implements queue{
    
    private class Node{
        int val;
        Node next;
    }
    Node Head;
    Node Tail;
    
    @Override
    public void add(int val)
    {
        Node tmp = new Node();
        tmp.next = null;
        if(isEmpty())
        {
            Head = tmp;
            Tail = tmp;
            return;
        }
        
        Tail.next = tmp;
        Tail = tmp;
    }
    
    @Override
    public int get()
    {
        if(isEmpty())
        {
            return Integer.MIN_VALUE;
        }
        
        int val = Head.val;
        Head = Head.next;
        return val;
    }
    
    @Override
    public int front()
    {
        if(isEmpty())
        {
            return Integer.MIN_VALUE;
        }
        
        return Head.val;
    }
    
    @Override
    public boolean isEmpty()
    {
        return (Head==null);
    }
}
class QueueArrImp implements queue{
    int[] queuArr;
    int capacity;    
    private class CircularBuffer{
        int[] bufferArr;
        int capacity;
        int readIndx;
        int writeIndx;
        CircularBuffer(int capacity)
        {
            bufferArr = new int[capacity];
            this.capacity = capacity;
            readIndx = 0;
            writeIndx = 0;
        }
        
        public void writeBuffer(int val)
        {
            ensureCapacity();
            bufferArr[writeIndx] = val;
            writeIndx = (writeIndx+1)%capacity;
        }
        
        public int readBuffer()
        {
            if(readIndx == writeIndx)
            {
                System.out.println("Buffer is Empty");
                return Integer.MIN_VALUE;
            }
            int val = bufferArr[readIndx];
            readIndx = (readIndx+1)%capacity;
            return val;
        }
        
        public int front()
        {
            if(readIndx == writeIndx)
            {
                System.out.println("Buffer is Empty");
                return Integer.MIN_VALUE;
            }
            return bufferArr[readIndx];
        }
        
        public boolean isEmpty()
        {
            return (readIndx == writeIndx);
        }
        
        public boolean isFull()
        {
            int nextIndx = (writeIndx+1)%capacity;
            return (nextIndx == readIndx);
        }
        public void ensureCapacity()
        {
            if(isFull())
            {
                bufferArr = Arrays.copyOf(bufferArr, 2*capacity);
                this.capacity = 2*this.capacity;
            }
        }
    }
    
    CircularBuffer queueBuffer;
    
    QueueArrImp(int capacity)
    {
        queueBuffer = new CircularBuffer(10);    
    }
    
    @Override
    public void add(int val)
    {
        queueBuffer.writeBuffer(val);
    }
    
    @Override
    public int get()
    {
        return queueBuffer.readBuffer();
    }
    
    @Override
    public int front()
    {
       return queueBuffer.front();
    }
    
    @Override
    public boolean isEmpty()
    {
        return queueBuffer.isEmpty();
    }
}
