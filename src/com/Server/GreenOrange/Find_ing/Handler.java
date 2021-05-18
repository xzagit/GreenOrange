package com.Server.GreenOrange.Find_ing;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

@SuppressWarnings("InfiniteLoopStatement")

public class Handler extends Thread{
    Socket sock;
    public Handler(Socket sock) {
        this.sock = sock;
    }

    @Override
    public void run() {
        try (InputStream inp = this.sock.getInputStream()) {
            try (final OutputStream oup = this.sock.getOutputStream()) {
                handle(inp, oup);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handle(InputStream inputStream, OutputStream outputStream) throws IOException{

        System.out.println("连接成功现在可以开始发消息了");
        String font = "init";

        while (true) {
            byte[] bytes = new byte[4096];
            int len;
            len = inputStream.read(bytes);
            String inp = new String(bytes, 0, len);

            if (!font.equals(inp)) {
                System.out.println(inp);
                font = inp;
            }
            System.out.println("请输入回复：");
            String rens = new Scanner(System.in).nextLine();
            outputStream.write(rens.getBytes(StandardCharsets.UTF_8));
            outputStream.flush();
        }

    }
}
