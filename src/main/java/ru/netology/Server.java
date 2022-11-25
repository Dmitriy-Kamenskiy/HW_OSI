package ru.netology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8181);){
            try (Socket socket = serverSocket.accept();
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));) {
                System.out.println("Соединение установленно");
                String inClientSting = in.readLine();
                out.println("Соединение с " + inClientSting + ", на порту " + socket.getPort());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
