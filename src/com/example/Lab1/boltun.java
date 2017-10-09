package com.example.Lab1;

import java.util.ArrayList;
import java.util.Date;
import java.io.IOException;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class boltun {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");

    public static void main (String [] args) throws IOException  {

        String fileName = "D:/SBQA/L1/answers.txt"; //���� � ����� �����������
        Date date = new Date(); //����-����� �� ������

        //�������� ����� �����������
        String createNameFile = ("D:/SBQA/L1/"+sdf.format( System.currentTimeMillis())+".txt");
        writeFile.createFileLog(createNameFile);

        //���������� ����� � ������
        ArrayList<String> listBL = new ArrayList<String>();
        listBL.addAll(readFile.readBufferedReader(fileName));

        //����������� � ����� � ���������
        System.out.println("���� �� ������� - " + date.toString());
        logger(date.toString(),createNameFile);
        System.out.println("��������� ����: "+listBL.get(0));
        logger(listBL.get(0),createNameFile);

        //���������� ��������� ������������ � ���� + ����� ������ �������
        int b = listBL.size();
        String userMessage=null;
        String userCommand=null;

        Scanner userMessageScan = new Scanner(System.in); //������� ���������� ������ � �������

        boolean startStop=true;

        do {
            if (startStop) {
                int random_maessage = 1 + (int) (Math.random() * (listBL.size() - 2));
                System.out.println("��������� ����: " + listBL.get(random_maessage));
                logger(listBL.get(random_maessage), createNameFile);
            }
            System.out.println("��������� ������������: ");
            userMessage = userMessageScan.nextLine();
            logger(userMessage, createNameFile);

            switch (userMessage) {
                case "�Stop talking�":
                    startStop=false;
                    break;
                case  "�Start talking�":
                    startStop=true;
                    break;
                case "�Goodbye�":
                    System.out.println(listBL.get(listBL.size()-1));
                    logger(listBL.get(listBL.size()-1),createNameFile);
                    userMessage = userCommand;
                    break;
                default: //�Use another file: XXXXX� - �Use another file: d:/SBQA/newAnswers.txt�
                    if(userMessage.indexOf("�Use another file: ")==0) {
                        String newPath = userMessage.substring(19,userMessage.length()-1);
                        //System.out.println(newPath);
                        listBL.clear();
                        listBL.addAll(readFile.readBufferedReader(newPath));
                    }
                    break;
            }
        }
            while (userMessage != userCommand);
    }

    private static void logger (String logMessage, String nameFile){ //����� �� ����� ������ �����, �� ����� �����, ��� �������� ������
             writeFile.writeUsingBufferedWriter(logMessage, nameFile);
     }
}
