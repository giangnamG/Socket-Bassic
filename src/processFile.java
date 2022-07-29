import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class processFile {
    
    // create student
    public void choose1(String data){
        String path = "D:\\code-java\\socket_demo\\de06\\src\\info.log";
        // try{ // cach nay khong kha dung, noi dung moi ghi de len noi dung cu
        //     FileWriter fw = new FileWriter(path);
        //     fw.write(data);
        //     fw.close();
        // }catch (Exception e){
        //     System.out.println(e);
        // } 
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            File file = new File(path);
            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }
            // true = append file
            fw = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            bw.write(data);
            System.out.println("Success...");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();
                if (fw != null)
                    fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    // list student current
    public String choose2(){
        try {
            String path = "D:\\code-java\\socket_demo\\de06\\src\\info.log";
            File myFile = new File(path);
            Scanner myReader = new Scanner(myFile);  
            String data = "";
            while (myReader.hasNextLine()) {
                String oneLine = myReader.nextLine();
                data += oneLine + "\n";
            }
            myReader.close();
            return data;
      }catch (FileNotFoundException e) {
            System.out.println("fail open file");
            e.printStackTrace();
            return "fail open file";
        } 
    }
   

}