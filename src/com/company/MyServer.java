package com.company;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyServer {

    public static void main(String[] args){
        // Создаём метод сервера
        try(
                // Серверный сокет и порт на который он слушает 8189
                ServerSocket serverSocket = new ServerSocket(8189);
                Socket socket = serverSocket.accept();

                //Создаём сканер для входящих данных
                Scanner scanner = new Scanner(socket.getInputStream());
        ) {
            // а так же поток записи текста выходящих данных
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);

            // в данном случае отправим обратно текст
            printWriter.println("text");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
