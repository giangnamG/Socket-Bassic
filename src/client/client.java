package client;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;


public class client {
    public static void main(String[] agre){
        while(true){
            try {
                Socket socket = new Socket("127.0.0.1",6666);
                //push username,password in stream for server login.
                Scanner scan = new Scanner(System.in);
                DataOutputStream usernameOutStream = new DataOutputStream(socket.getOutputStream());
                System.out.print("root: ");
                String username = scan.next();
                usernameOutStream.writeUTF(username);
                DataOutputStream passwordOutStream = new DataOutputStream(socket.getOutputStream());
                System.out.print("passwd: ");
                String password = scan.next();
                passwordOutStream.writeUTF(password);

                // wait for server response and get response
                DataInputStream get_res = new DataInputStream(socket.getInputStream());
                String res = get_res.readUTF();
                System.out.println("Response: " + res);
                if(res.equals("wrong!")){
                    System.out.println("Try again!!");
                    socket.close();
                }else{
                // login server success, wait result of server.
                    System.out.println("hi admin");
                    while(true){
                        menuDisplayClient menu = new menuDisplayClient();
                        menu.display(); // display menu
                        int n = scan.nextInt();
                        DataOutputStream select = new DataOutputStream(socket.getOutputStream());
                        select.writeInt(n); 
                        select.flush();// push select to server

                        // nhan du lieu cua menu tra tu server
                        switch(n){
                            case 1: String getInfo = menu.displayOption1();
                                    DataOutputStream pushData = new DataOutputStream(socket.getOutputStream());
                                    pushData.writeUTF(getInfo);
                                    pushData.flush();
                                break;
                            case 2: // list student current
                                    DataInputStream colectData = new DataInputStream(socket.getInputStream());
                                    String data = colectData.readUTF();
                                    System.out.println("--------------------Info Student--------------------");
                                    System.out.println("ID\tFullName\tClass\tGPA\n");
                                    System.out.print(data);
                                    while(true){
                                        System.out.print("Press 0 and ENTER to continue !!! : ");
                                        int x = scan.nextInt();
                                        if(x==0)
                                            break;
                                    }
                                break;
                            case 3: ;
                                break;
                            case 4: ;
                                break;
                            case 5: ;
                                break;
                            default:
                                break;
                        }
                    }

                }


                socket.close();
    
            }catch (Exception e) {
                e.getStackTrace();
            }
        }
    }
}

