package com.company;

import java.io.IOException;
import java.net.*;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class HTMLtoHTTP {

    public static void main(String[] args) throws IOException {
        // для получения HTML с сайта по HTTP, создаем коннект
        URLConnection connection = new URL("http://www.google.com/").openConnection();
        // сканер для считывания
        Scanner scanner = new Scanner(connection.getInputStream());
        // где отделять, для получения более полного файла HTML
        scanner.useDelimiter("\\Z");
        // вывод на экран
        System.out.println(scanner.nextLine());

        // Создаем лист о дополнительной информации
        Map<String, List<String>> handlarFile = connection.getHeaderFields();
        // вывод на экран
        for (Map.Entry<String, List<String>> entry : handlarFile.entrySet()){
            System.out.println(entry.getKey() +" # "+ entry.getValue());
        }
    }
}
