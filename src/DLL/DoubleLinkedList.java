/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DLL;

/**
 *
 * @author Fakhry
 */
class Node
{
    int data;
    Node next, prev;

    Node(int data)
    {
        this.data = data;
        next = prev = null;
    }
}


public class DoubleLinkedList 
{
    private Node first, last;
    
    
    private boolean isIndexAvailable(int data)
    {
        boolean bol = false;
        int counter = -1;
        for(Node insert = first; insert != last.next; insert = insert.next, counter++);
        if (counter >= data)
            bol = true;
        return bol;
    }
    
    private boolean isDataAvailable(int data)
    {
        boolean bol = false;
        for(Node check = first;check != last.next; check = check.next)
            if (check.data == data)
            {
                bol = true;
                break;
            }
        return bol;
    }
    
    private boolean isEmpty()
    {
        return first == null;
    }
    
    private void InsertData(Node before, int data)
    {
        Node insert = new Node(data);
        insert.next = before.next;
        before.next = before.next.prev = insert;
        insert.prev = before;
    }
    
    public void InsertFirst(int data)
    {
        Node insert = new Node(data);
        if(isEmpty())
            last = insert;
        else
        {
            insert.next = first;
            first.prev = insert;
        }
        first = insert;
        Print();
    }
    
    public void InsertLast(int data)
    {
        Node insert = new Node(data);
        if(isEmpty())
            first = insert;
        else
        {
            insert.prev = last;
            last.next = insert;
        }
        last = insert;
        Print();
    }
    
    public void InsertAfter(int after, int data)
    {
        if(isEmpty())
            System.out.println("List masih Kosong");
        else if(isDataAvailable(after))
        {
            if(last.data == after)
                InsertLast(data);
            else
                for(Node insert = first; insert != last; insert = insert.next)
                    if (insert.data == after)
                    {
                        InsertData(insert, data);
                        insert = insert.next;
                    }
            Print();
        }
        else
            System.out.println("Data \"" + after + "\" tidak ada didalam List");
    }
    
    public void InsertAtIndex(int index, int data)
    {
        if(isEmpty())
            System.out.println("List masih Kosong");
        else if(isIndexAvailable(index))
        {
            if(index == 0)
                InsertFirst(data);
            else 
            {
                Node insert = first.next;
                for(int counter = 1; counter != index; counter++, insert = insert.next);
                InsertData(insert.prev, data);
                Print();
            }
        }
        else
            System.out.println("Index \"" + index + "\" diluar jangkauan");
    }
    
    public void DeleteFirst()
    {
        if(isEmpty())
            System.out.println("List masih Kosong");
        else 
        {
            if (first == last)
                first = last = null;
            else if(first.next == last)
                first = last;        
            else
                first = first.next;
            Print();
        }
    }
    
    public void DeleteLast()
    {
        if(isEmpty())
            System.out.println("List masih Kosong");
        else if (first == last)
            DeleteFirst();
        else 
        {
            if(first.next == last)
                last = first;
            else 
                last = last.prev;
            Print();
        }
    }
    
    public void DeleteAfter(int data)
    {
        if(isEmpty())
            System.out.println("List masih Kosong");
        else if (isDataAvailable(data))
        {
            for(Node delete = first; delete.next != last; delete = delete.next)
                if (delete.data == data)
                {
                    delete.next = delete.next.next;
                    delete.next.prev = delete.next.prev.prev;
                }
            if (last.prev.data == data)
                DeleteLast();
            else
                Print();
        }
        else
            System.out.println("Data \"" + data + "\" tidak terdapat dalam list");
    }
    
    public void DeleteAtIndex(int index)
    {
        if(isEmpty())
            System.out.println("List masih Kosong");
        else if(isIndexAvailable(index))
        {
            Node delete = first;
            for(int counter = 0; counter != index; counter++, delete = delete.next);
            if (delete == first)
                DeleteFirst();
            else if (delete == last)
                DeleteLast();
            else
            {
                delete.prev.next = delete.next;
                delete.next.prev = delete.prev;
                Print();
            }  
        }
        else
            System.out.println("Index \"" + index + "\" diluar jangkauan");
    }
    
    public void DeleteValue(int data)
    {
        if(isEmpty())
            System.out.println("List masih Kosong");
        else if(isDataAvailable(data))
        {
            while(!isEmpty() && isDataAvailable(data))
                if (first.data == data)
                    DeleteFirst();
                else if (last.data == data)
                    DeleteLast();
                else
                {
                    for(Node delete = first; delete != last.next; delete = delete.next)
                        if(delete.data == data)
                        {
                            delete.prev.next = delete.next;
                            delete.next.prev = delete.prev;
                        }
                    Print();
                }
        }
        else
            System.out.println("Nilai \"" + data + "\" tidak ada didalam list");
    }
    
    public void Sort()
    {
        if (isEmpty())
            System.out.println("List masih Kosong");
        else
        {
            for(Node sortA = first; sortA != last.next; sortA = sortA.next)
                for(Node sortB = last; sortB != sortA; sortB = sortB.prev)
                    if(sortB.data <= sortB.prev.data)
                    {
                        int temp = sortB.data;
                        sortB.data = sortB.prev.data;
                        sortB.prev.data = temp;
                    }
            Print();
        }
    }
    
    public void SortMm()
    {
        if (isEmpty())
            System.out.println("List masih Kosong");
        else
        {
            for(Node sortA = first; sortA != last.next; sortA = sortA.next)
                for(Node sortB = last; sortB != sortA; sortB = sortB.prev)
                    if(sortB.data > sortB.prev.data)
                    {
                        int temp = sortB.data;
                        sortB.data = sortB.prev.data;
                        sortB.prev.data = temp;
                    }
            Print();
        }
    }
    
    public void FindNode(int data)
    {
        if(isEmpty())
            System.out.println("List masih Kosong");
        else if (isDataAvailable(data))
        {
            int count = 0;
            System.out.print("\"" + data + "\" Terdapat pada index : ");
            for (Node find = first; find != last.next; find = find.next, count++)
                if(find.data == data)
                    System.out.print(count + "  ");
            System.out.println();
        }
    }
    
    public String FindNodeGUI(int data)
    {
        String hasil = null;
        if(isEmpty())
            hasil = "List masih Kosong";
        else if (isDataAvailable(data))
        {
            int count = 0;
           hasil = "\"" + data + "\" Terdapat pada index : ";
            for (Node find = first; find != last.next; find = find.next, count++)
                if(find.data == data)
                    hasil = count + "  ";
            System.out.println();
        }
        return hasil;
    }
    
    private void Print()
    {
        if(isEmpty())
            System.out.println("List masih Kosong");
        else 
        {
            for(Node print = first; print != last.next; print = print.next)
                System.out.printf("%d -> ", print.data);
            System.out.println("NULL");
        }
    }
    
    public String toString()
    {
        String str = "";
        if(isEmpty())
            str = "Link masih kosong";
        else
        {
            for(Node print = first; print != last.next; print = print.next, str += " <-> ")
                str += String.valueOf(print.data);
            str += "Null";
        }
        return str;
    }
}
