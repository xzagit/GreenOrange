package com.Client.GreenOrange.Find_ing;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Client {
    @SuppressWarnings("InfiniteLoopStatement")

    public static void main(String[] args) throws IOException{

        String ServerAddress = "172.17.49.246";
        Socket socket = new Socket(ServerAddress, 10828);

        try (OutputStream oup = socket.getOutputStream()) {
            try (InputStream inp = socket.getInputStream()) {
                for (;;) {
                    String request = new Scanner(System.in).nextLine();
                    oup.write(request.getBytes(StandardCharsets.UTF_8));
                    oup.flush();
                    byte[] bytes = new byte[4096];
                    int len = inp.read(bytes);
                    String response = new String(bytes, 0, len);
                    System.out.println(response);
//                    System.out.println("111");
//                    handle(inp, oup);
                }

            } catch (IOException e) {
                    e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

/*    private static void handle(InputStream input, OutputStream output) throws IOException {
        var writer = new BufferedWriter(new OutputStreamWriter(output, StandardCharsets.UTF_8));
        var reader = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));
        Scanner scanner = new Scanner(System.in);
        for (;;) {
            System.out.print(">>> "); // 打印提示
            String s = scanner.nextLine(); // 读取一行输入
            writer.write(s);
            writer.newLine();
            writer.flush();
            String resp = reader.readLine();
            System.out.println("<<< " + resp);
            if (resp.equals("bye")) {
                break;
            }
        }
    }*/
}
