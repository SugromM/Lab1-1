package com.example.Lab1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class writeFile {

    public static void createFileLog (String createNameFile){
        try {
            new File(createNameFile).createNewFile();
        } catch(IOException x) { x.printStackTrace(); }
    }

    public static void writeUsingBufferedWriter(String data, String nameFile) {
        FileWriter fr = null;
        BufferedWriter br = null;
        String dataWithNewLine = data + System.getProperty("line.separator");
        try{
            fr = new FileWriter(nameFile,true);
            br = new BufferedWriter(fr);
                br.write(dataWithNewLine);
                br.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e);
        }finally{
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
