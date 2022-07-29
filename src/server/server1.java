package server;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class server1 {
    public static void main(String[] agre) {
        while(true){
            try {
                ServerSocket serversocket = new ServerSocket(6666);
                System.out.println("SERVER LISTENING ...");  
                System.out.println("CLIENT connecting ... ");
                Socket socket = serversocket.accept();
                
                // get username and pass from stream
                DataInputStream getUsername = new DataInputStream(socket.getInputStream());
                String username = getUsername.readUTF();
                System.out.println("username: " + username);
                DataInputStream getPassword = new DataInputStream(socket.getInputStream());
                String password = getPassword.readUTF();
                System.out.println("password: " + password);

                // response
                DataOutputStream res = new DataOutputStream(socket.getOutputStream());
                if(!username.equals("admin") || !password.equals("hackerlord")){
                    System.out.println("connection failed\n");
                    res.writeUTF("wrong!");
                    res.flush();
                    socket.close();
                }else{
                    res.writeUTF("connect success!");
                    res.flush();
                    System.out.println("client logged!");
                    System.out.println("Waiting request client ... \n");

                }
                // after login success; get select client
                while(true){
                    DataInputStream select = new DataInputStream(socket.getInputStream());
                    int n = select.readInt();
                    processFile process = new processFile();

                    switch(n){
                        case 1: 
                                DataInputStream getData = new DataInputStream(socket.getInputStream());
                                String data_1 = getData.readUTF();
                                process.choose1(data_1);
                            break;
                        case 2: 
                                String data_2 = process.choose2();
                                System.out.print("Response: \n"+data_2);
                                DataOutputStream response = new DataOutputStream(socket.getOutputStream());
                                response.writeUTF(data_2);
                                response.flush();
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
                }catch (Exception e) {
                    e.getStackTrace();
            }
        }
    }  
    
}

