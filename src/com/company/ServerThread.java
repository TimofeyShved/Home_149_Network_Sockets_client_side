package com.company;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerThread {
    public static void main(String[] args){
        try (ServerSocket serverSocket = new ServerSocket(8189);){
            while (true){
                Socket socket = serverSocket.accept();
                new Thread(new ThisServer(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ThisServer implements Runnable{

    Socket socket;
    public ThisServer(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try(Scanner scanner = new Scanner(socket.getInputStream());
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);) {
                 if (scanner.hasNextLine()){
                    printWriter.println("you sea: "+scanner.nextLine());
                 }
             } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
