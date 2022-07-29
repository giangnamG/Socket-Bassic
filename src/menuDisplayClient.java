import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class menuDisplayClient {
   
    public void display(){
        System.out.println("--------------------OPTION ADMIN--------------------");
        System.out.println("Create Student        --  1");
        System.out.println("List Student Current  --  2");
        System.out.println("Delete Student        --  3");
        System.out.println("Find student by id    --  4");
        System.out.println("Sort Student from a-z --  5");
        System.out.println("---------QUIT!----------  6");
        System.out.print("\n Your select: ");
    }
    public String displayOption1(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Full Name: ");
        String name = scan.nextLine();
        System.out.print("ID: ");
        String id = scan.nextLine();
        System.out.print("Class: ");
        String Class = scan.nextLine();
        System.out.print("GPA: ");
        String gpa = scan.nextLine();
        return "\n"+"("+id+") ("+name+") ("+Class+") ("+gpa+")"+"n";
    }
}


