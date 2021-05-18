package com.Client.GreenOrange.Find_ing;

import com.Frame.GreenOrange.Find_ing.MainFrame;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Client {
    @SuppressWarnings("InfiniteLoopStatement")

    public static void main(String[] args) throws IOException{

        String ServerAddress = "172.17.49.246";
        Socket socket = new Socket(ServerAddress, 10828);
        MainFrame frame =  new MainFrame();
        try (OutputStream oup = socket.getOutputStream()) {
            try (InputStream inp = socket.getInputStream()) {
                while (true){

                    oup.write(frame.Test.getBytes(StandardCharsets.UTF_8));
                    oup.flush();
                    byte[] bytes = new byte[4096];
                    int len = inp.read(bytes);
                    String response = new String(bytes, 0, len);
                    frame.message = response;
//                    System.out.println(frame.message);
                    if (response.equals(" ")) continue;
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
