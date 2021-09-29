package com.Server.GreenOrange.Find_ing;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class Server {
    @SuppressWarnings("InfiniteLoopStatement")
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10820);
        System.out.println("Server Running...");
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println(socket.getLocalSocketAddress());
            Thread t = new Handler(socket);
            t.start();
        }
    }
}
