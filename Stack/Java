import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

// Main class should be named 'Solution'
class Solution {
    public static void main(String[] args) {
        System.out.println("Hello, World");
    }
}
interface Stack{
    public void push(int x);
    public int pop();
    public int peek();
}


class StackArrImp implements Stack{
    int[] stackArr;
    int sp;
    int capacity;
    StackArrImp(int size)
    {
        stackArr = new int[size];
        sp = 0;
        capacity = size;
    }
    
    @Override
    public void push(int x)
    {
        ensureCapacity();
        stackArr[sp] = x;
        sp++;
    }
    
    @Override
    public int pop()
    {
        if(sp == 0)
        {
            throw new IllegalStateException();
        }
        
        sp--;
        return stackArr[sp];
    }
    
    @Override
    public int peek()
    {
        return stackArr[sp];
    }
    
    public void ensureCapacity()
    {
        if(sp == capacity)
        {
            stackArr = Arrays.copyOf(stackArr, 2*capacity);
            capacity = 2*capacity;
        }
    }
}

class StackLinkedListImp implements Stack{
    
    private class Node{
        int val;
        Node next;
    }
    
    Node top;
    
    StackLinkedListImp()
    {
        this.top = null;
    }
    
    
    @Override
    public void push(int x)
    {
        Node tmp = new Node();
        
        if(tmp == null)
        {
            throw new StackOverflowError();
        }
        tmp.val = x;
        tmp.next = top;
        top = tmp;

    }
    
    @Override
    public int pop()
    {
        if(top == null)
        {
            System.out.println("Stack UnderFlow");
            return Integer.MIN_VALUE;
        }
        
        int val = top.val;
        top = top.next;
        return val;
    }
    
    @Override
    public int peek()
    {
        if(top == null)
        {
            System.out.println("Stack UnderFlow");
            return Integer.MIN_VALUE;
        }
        
        return top.val;
      
    }
}
