package com.Client.GreenOrange.Find_ing;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Client2 {
    @SuppressWarnings("InfiniteLoopStatement")

    public static void main(String[] args) throws IOException{

        String ServerAddress = "172.17.49.246";
        Socket socket = new Socket(ServerAddress, 10828);

        try (OutputStream oup = socket.getOutputStream()) {
            try (InputStream inp = socket.getInputStream()) {
                while (true){
                    String request = new Scanner(System.in).nextLine();
                    oup.write(request.getBytes(StandardCharsets.UTF_8));
                    oup.flush();
                    byte[] bytes = new byte[4096];
                    int len = inp.read(bytes);
                    String response = new String(bytes, 0, len);
                    System.out.println(response);
                }

            } catch (IOException e) {
                    e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
