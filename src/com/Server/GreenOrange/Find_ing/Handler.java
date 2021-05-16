package com.Server.GreenOrange.Find_ing;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

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
                handle(inp, oup, sock.getRemoteSocketAddress().toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handle(InputStream inputStream, OutputStream outputStream, String ipAddress) throws IOException{

        System.out.println(ipAddress+", 连接成功现在可以开始发消息了! ");

        while (true) {
            byte[] bytes = new byte[4096];
            int len;
            len = inputStream.read(bytes);
            String inp = new String(bytes, 0, len);

            //把客户端消息放到消息池
            MessagePool.addMessage(ipAddress, inp);

            System.out.println("客户端信息：" + inp);

            //发送消息池的消息
            Map<String, String> response;
            response = MessagePool.message;
            response.remove(ipAddress);

            outputStream.write(("ServerResponse回应: "+(response.isEmpty() ? response : " ")).getBytes(StandardCharsets.UTF_8));
            outputStream.flush();
        }

    }
}
