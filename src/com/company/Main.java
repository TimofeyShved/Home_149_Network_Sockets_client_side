package com.company;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        // Создаём класс для подключения-соединения с другим компьютером
        Socket socket = new Socket();
        // устанавливаем связь можно и 46.50.190.17, через порт 13, с таймингом 2000 мкс
        socket.connect(new InetSocketAddress("india.colorado.edu", 13), 2000);

        //далее нужно всё считать, приходящий поток
        Scanner scanner = new Scanner(socket.getInputStream());
        // выводим на экран
        while (scanner.hasNextLine()){
            System.out.println(scanner.nextLine());
        }

    }
}