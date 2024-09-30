package Lab01;
import javax.swing.JOptionPane;
public class ChoosingOption {
    public static void main(String[] args){
        int option = JOptionPane.showConfirmDialog(null,  //Hien thi hop thoai de user confirm yes/no
                                "Do you want to change to the first class ticket?");
        
        JOptionPane.showMessageDialog(null, "You've chosen: " //Hien thi hop thoai in thong bao ve lua chon cua user
        + (option == JOptionPane.YES_OPTION?"Yes":"No"));
         System.exit(0);
    }
}
