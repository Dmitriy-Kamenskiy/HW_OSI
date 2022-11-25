package ru.netology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) {
        try (Socket clientSocket = new Socket("localhost", 8181);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                out.println("Сервер");
                String toServerString = in.readLine();
                System.out.println(toServerString);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}