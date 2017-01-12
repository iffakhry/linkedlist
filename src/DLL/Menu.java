/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DLL;
import javax.swing.JOptionPane;
/**
 *
 * @author Fakhry
 */
public class Menu 
{
    private DoubleLinkedList dll = new DoubleLinkedList();
    private int data1, data2;
    
    public void MenuUtama()
    {
        String menu = JOptionPane.showInputDialog(""
                + "======Menu Utama=====\n"
                + "1. Insert\n"
                + "2. Delete\n"
                + "3. Sort\n"
                + "4. FindNode\n"
                + "5. Keluar\n"
                + "=====================\n");
        switch (Integer.parseInt(menu))
        {
            case 1 : MenuInsert(); break;
            case 2 : MenuDelete(); break;
            case 3 : MenuSort(); break;
            case 4 : MenuFindN(); break;
            case 5 : break;
            default : MenuUtama(); break;    
        }
    }
    
    private void MenuInsert()
    {
        String menu = JOptionPane.showInputDialog(""
                + "======Menu Insert======\n"
                + "1. Insert First\n"
                + "2. Insert Last\n"
                + "3. Insert After\n"
                + "4. Insert At Index\n"
                + "5. Kembali\n"
                + "=======================\n");
        switch (Integer.parseInt(menu))
        {
            
            case 1 : data1 = Integer.parseInt(JOptionPane.showInputDialog("Masukkan nilainya"));
                     System.out.printf("%-45s : ", "Mengisi \"" + data1 + "\" pada List pertama");
                     dll.InsertFirst(data1); break;
            case 2 : data1 = Integer.parseInt(JOptionPane.showInputDialog("Masukkan nilainya"));
                     System.out.printf("%-45s : ", "Mengisi \"" + data1 + "\" pada List terakhir");
                     dll.InsertLast (data1); break;
            case 3 : data1 = Integer.parseInt(JOptionPane.showInputDialog("Madukkan nilainya"));
                     data2 = Integer.parseInt(JOptionPane.showInputDialog("Setelah Nilai"));     
                     System.out.printf("%-45s : ", "Mengisi \"" + data1 + "\" setelah nilai \"" + data2 + "\" dari List" );
                     dll.InsertAfter(data2, data1); break;
            case 4 : data1 = Integer.parseInt(JOptionPane.showInputDialog("Masukkan nilainya"));
                     data2 = Integer.parseInt(JOptionPane.showInputDialog("Masukkan Indexnya"));
                     System.out.printf("%-45s : ", "Mengisi \"" + data1 + "\" pada index ke \"" + data2 + "\" dari List" );
                     dll.InsertAtIndex(data2, data1); break;
            case 5 : MenuUtama(); break;
            default : MenuInsert(); break;         
        }
        MenuUtama();
    }
    
    private void MenuDelete()
    {
        String menu = JOptionPane.showInputDialog(""
                + "=======Menu Delete=======\n"
                + "1. Delete First\n"
                + "2. Delete Last\n"
                + "3. Delete Value\n"
                + "4. Delete After\n"
                + "5. Delete At Index\n"
                + "6. Kembali\n"
                + "=========================\n");
        switch(Integer.parseInt(menu))
        {
            case 1 : System.out.printf("%-45s : ", "Menghapus nilai pertama dari List" );
                     dll.DeleteFirst(); break;
            case 2 : System.out.printf("%-45s : ", "Menghapus nilai terakhir dari List" );
                     dll.DeleteLast(); break;
            case 3 : data2 = Integer.parseInt(JOptionPane.showInputDialog("Nilai yang akan dihapus"));
                     System.out.printf("%-45s : ", "Menghapus \"" + data2 + "\" dari List" );
                     dll.DeleteValue(data2); break;
            case 4 : data2 = Integer.parseInt(JOptionPane.showInputDialog("Hapus nilai setelah "));
                     System.out.printf("%-45s : ", "Menghapus nilai setelah \"" + data2 + "\" dari List" );
                     dll.DeleteAfter(data2); break;
            case 5 : data2 = Integer.parseInt(JOptionPane.showInputDialog("Masukkan index keberapa"));
                     System.out.printf("%-45s : ", "Menghapus nilai pada index \"" + data2 + "\" dari List" );
                     dll.DeleteAtIndex(data2); break;
            case 6 : MenuUtama(); break;
            default : MenuDelete(); break;    
        }
        MenuUtama();
    }
    
    private void MenuSort()
    {
        System.out.printf("%-45s : ", "List mengalami Sort");
        dll.Sort(); 
        MenuUtama();
    }
    
    private void MenuFindN()
    {
        data2 = Integer.parseInt(JOptionPane.showInputDialog("Masukkan nilai yang dicari"));
        System.out.printf("%-45s : ", "Mencari \"" + data2 + "\" pada sort");        
        dll.FindNode(data2);
        MenuUtama();
    }
}
