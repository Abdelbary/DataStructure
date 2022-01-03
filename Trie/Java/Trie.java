import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Node {
    
    Node[] alp = new Node[26];
    int  size = 0;
    
    
    
    private Node getNode(char c)
    {
        return alp[c-'a'];
    }
    
    public void add(String s)
    {
        add(s,0);
    }
    
    private void add(String s, int indx)
    {
        size++;
        if(indx == s.length())
        {
            return;
        }
        char nextChar     = s.charAt(indx);
        Node nextCharNode = getNode(nextChar);
        
        if(nextCharNode == null)
        {
            nextCharNode = new Node();
            alp[nextChar-'a']   = nextCharNode;
        }
            nextCharNode.add(s,indx+1);
    }
    
    public int find(String s)
    {
        return find(s,0);
    }
    
    private int find(String s,int indx)
    {
        if(indx == s.length())
        {
            return size;
        }
        
        Node nextCharNode = getNode(s.charAt(indx));
        if(nextCharNode == null)
        {
            return 0;
        }
        
        return nextCharNode.find(s,indx+1);
    }
}
