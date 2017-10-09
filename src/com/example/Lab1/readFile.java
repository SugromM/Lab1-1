package com.example.Lab1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class readFile {

    public static ArrayList<String> readBufferedReader(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader( new FileReader(fileName));
        ArrayList<String> list = new ArrayList<String>();
        String line = null;
        StringBuilder stringBuilder = new StringBuilder();
        String ls = System.getProperty("line.separator");
        while( ( line = reader.readLine() ) != null ) {
            stringBuilder.append( line );
            stringBuilder.append( ls );
            list.add(line);
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return list;
    }
}
