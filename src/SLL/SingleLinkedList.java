/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package SLL;

/**
 *
 * @author Fakhry
 */

class Node
{
    byte data;
    Node next;
    Node()
    {
        next = null;
    }
    
    Node(byte data)
    {
        this.data = data;
        next = null;
    }
}

public class SingleLinkedList 
{
    private Node first, last;
    private int index;
    
    SingleLinkedList()
    {
        first = last = null;
    }    
    
    private boolean isEmpty()
    {
        return first == null;
    } 
    
    private boolean isNothing(byte data)
    {
        boolean cek = true;
        if(isEmpty())
            cek = true;
        else
        {
            for(Node nothing = first; nothing != last.next; nothing = nothing.next)
                if(nothing.data == data) 
                {
                    cek = false;
                    break;
                }
                else cek = true;  
        }
        return cek;
    }
    
    private boolean isIndexAvailable(int index)
    {
        this.index = 0;
        boolean cek = false;
        for(Node available = first; available != last.next; available = available.next, this.index++)
            if(this.index == index)
            {
                cek = true;
                break;
            }
            else cek = false;
        return cek;
    }
    
    private void InsertAfter(Node head, byte data)
    {
        Node insert = new Node(data);
        insert.next = head.next;
        head.next = insert; 
    }
    
    private String EmptyData()
    {
        return "List Masih Kosong";
    }
    
    public void InsertFirst(byte data)
    {
        Node insert = new Node(data);
        if(isEmpty())
            last = insert;
        else
            insert.next = first;
        first = insert; 
    }
    
    public void InsertLast(byte data)
    {
        Node insert = new Node(data);
        if(isEmpty())
            first = insert;
        else 
            last.next = insert;
        last = insert;
    }
    
    public void InsertAfter(byte nilai, byte data)
    {
        if(isEmpty())
            System.out.println(EmptyData());
        else if(isNothing(nilai))
            System.out.println("Tidak ada : " + nilai + " dalam urutan");
        else
        {
            for(Node head = first; head != last; head = head.next)
                if(head.data == nilai)
                {
                    InsertAfter(head, data);
                    head = head.next;
                }
            if (last.data == nilai)
                InsertLast(data);
        }
    }
    
    public void InsertAtIndex(int index, byte data)
    {
        if (isEmpty())
            System.out.println(EmptyData());
        else if (isIndexAvailable(index))
        {
            if(index == 0)
                InsertFirst(data);
            else
            {
                Node head = first;
                for(int i = 1 ; i!= index; i++, head = head.next);
                    InsertAfter(head, data);
            }
        }
        else 
            System.out.println("Index \"" + index + "\" diluar jangkauan");
    }
    
    public void DeleteFirst()
    {
        if(isEmpty())
            System.out.println(EmptyData());
        else if (first == last)
            first = last = null;
        else
            first = first.next;
    }
    
    public void DeleteLast()
    {
        if(isEmpty())
            System.out.println(EmptyData());
        else if (first == last)
            first = last = null;
        else
        {
            Node delete;
            for(delete = first; delete.next != last; delete = delete.next);
            last = delete;
        }
    } 

    public void DeleteValue(byte data)
    {
        if(isEmpty())
            System.out.println(EmptyData());
        else if(isNothing(data))
            System.out.println("Tidak ada \" " + data + " \" pada Linked List");
        else   
            while (!isNothing(data))
                if(first.data == data)
                    DeleteFirst();
                else if(last.data == data)
                    DeleteLast();
                else
                {
                    for(Node delete = first; delete != last; delete = delete.next)
                        while(delete.next.data == data)
                            delete.next = delete.next.next;
                }
    }
    
    public void DeleteAtIndex(int index)
    {
        if(isEmpty())
            System.out.println(EmptyData());
        else if(index == 0)
            DeleteFirst();
        else if(isIndexAvailable(index))
        {
            Node delete = first;
            for(int i = 1; i < index; i++, delete = delete.next);
            delete.next = delete.next.next;
        }
        else
            System.out.println("Index \""+ index + "\" diluar jangkauan");
    }
    
    public void DeleteAfter(byte data)
    {
        if(isEmpty())
            System.out.println(EmptyData());
        else if(isNothing(data))
            System.out.println("\""+ data + "\" tidak ada dalam list");
        else
        {
            for(Node delete = first; delete != last; delete = delete.next)
                if(delete.next != last & delete.data == data)
                    delete.next = delete.next.next;
        }
    }
    
    public void SortMm()
    {
        if(isEmpty())
            System.out.println(EmptyData());
        else if (first != last)
        {
            for(Node i = first; i != last.next; i = i.next)
                for(Node j = first; j != last.next; j = j.next)
                    if(i.data > j.data)
                    {
                        byte tmp = j.data;
                        j.data = i.data;
                        i.data = tmp;
                    }
        }
    }
    
    public void SortmM()
    {
        if(isEmpty())
            System.out.println(EmptyData());
        else if(first != last)
        {
            for(Node i = first; i != last.next; i = i.next)
                for(Node j = first; j != last.next; j = j.next)
                    if(i.data < j.data)
                    {
                        byte tmp = j.data;
                        j.data = i.data;
                        i.data = tmp;
                    }
        }
    }
    
    public void FindNode(byte data)
    {
        if(isEmpty())
            System.out.println(EmptyData());
        else if(isNothing(data))
            System.out.println("Tidak ada \"" + data + "\" dalam List");
        else
        {
            String count = "";
            Node find = first;
            for(int i = 0; find != last.next; i++, find = find.next)
                if(find.data == data)
                    count += String.valueOf(i) + "  ";
            System.out.println("\""+ data + "\" ada pada index ke : " + count);
        }
    }
    
    public String FindNodeGUI(byte data)
    {
        String hasil = null;
        if(isEmpty())
           hasil = EmptyData();
        else if(isNothing(data))
            hasil = "Tidak ada \"" + data + "\" dalam List";
        else
        {
            String count = "";
            Node find = first;
            for(int i = 0; find != last.next; i++, find = find.next)
                if(find.data == data)
                    count += String.valueOf(i) + "  ";
            hasil = "\""+ data + "\" ada pada index ke : " + count;
        }
        return hasil;
    }
    
    public String toString()
    {
        String str = "";
        if(isEmpty())
            str = new String(EmptyData());
        else
        {
            for(Node print = first; print != last.next; print = print.next, str += " -> ")
                str += String.valueOf(print.data);
            str += "Null";
        }
        return str;
    }    
}
