package com.Server.GreenOrange.Fing_ing;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class Server {
    @SuppressWarnings("InfiniteLoopStatement")
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10828);
        while (true) {
            Socket socket = serverSocket.accept();
            Thread t = new Handle(socket);
            t.start();
        }
    }
}
