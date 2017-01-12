/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package SLL;
import javax.swing.JOptionPane;
/**
 *
 * @author Fakhry
 */

public class Menu 
{
    private SingleLinkedList sll = new SingleLinkedList();

    
    public void MenuUtama()
    {
        int menu = Integer.parseInt(JOptionPane.showInputDialog(""
                + "---===Menu===---\n"
                + "1. Insert\n"
                + "2. Delete\n"
                + "3. Find Node\n"
                + "4. Sort\n"
                + "5. Keluar\n"));
        switch (menu)
        {
            case 1  : InsertM(); break;
            case 2  : DeleteM(); break;
            case 3  : FindNodeM(); break;
            case 4  : SortM(); break;    
            case 5  : break; 
            default    : MenuUtama(); break;
        }    
    }
    
    private void InsertM()
    {
        int menu = Integer.parseInt(JOptionPane.showInputDialog(""
                + "---===Menu Insert===---\n"
                + "1. Insert First\n"
                + "2. Insert Last\n"
                + "3. Insert After\n"
                + "4. Insert At Index\n"));
        switch (menu)
        {
            case 1  : sll.InsertFirst(Byte.parseByte(JOptionPane.showInputDialog("Masukkan Datanya"))); PrintM(); break;
            case 2  : sll.InsertLast (Byte.parseByte(JOptionPane.showInputDialog("Masukkan Datanya"))); PrintM(); break;
            case 3  : sll.InsertAfter(Byte.parseByte(JOptionPane.showInputDialog("Masukkan Nilainya")),
                                        Byte.parseByte(JOptionPane.showInputDialog("Masukkan Datanya"))); PrintM(); break;
            case 4  : sll.InsertAtIndex(Integer.parseInt(JOptionPane.showInputDialog("Masukkan Indexnya")),
                                                           Byte.parseByte(JOptionPane.showInputDialog("Masukkan Datanya"))); PrintM(); break;
            default   : InsertM(); break;
        }
    }
    
    private void DeleteM()
    {
         int menu = Integer.parseInt(JOptionPane.showInputDialog(""
                 + "---===Menu Delete===---\n"
                 + "1. Delete First\n"
                 + "2. Delete Last\n"
                 + "3. Delete Value\n"
                 + "4. Delete After\n"
                 + "5. Delete At Index\n"));
         switch(menu)
         {
             case 1   : sll.DeleteFirst(); PrintM();break;
             case 2   : sll.DeleteLast(); PrintM();break;
             case 3   : sll.DeleteValue(Byte.parseByte(JOptionPane.showInputDialog("Masukkan Datanya"))); PrintM(); break;
             case 4   : sll.DeleteAfter(Byte.parseByte(JOptionPane.showInputDialog("Masukkan Datanya"))); PrintM(); break;
             case 5   : sll.DeleteAtIndex(Integer.parseInt(JOptionPane.showInputDialog("Masukkan Indexnya"))); PrintM(); break;
             default    : DeleteM();  break;
         }
    }
    
    private void SortM()
    {
        int menu = Integer.parseInt(JOptionPane.showInputDialog(""
                + "---===Sort Menu===---\n"
                + "1. Max ----> Min\n"
                + "2. Min ----> Max\n"));
        switch(menu)
        {
            case 1 : sll.SortMm(); PrintM(); break;
            case 2 : sll.SortmM(); PrintM(); break;
            default :SortM(); break;    
        }
    }
    
    private void FindNodeM()
    {
        sll.FindNode(Byte.parseByte(JOptionPane.showInputDialog("Masukkan Datanya")));
        MenuUtama();
    }
    
    private void PrintM()
    {
        System.out.println(sll.toString());
        MenuUtama();
    }
}
