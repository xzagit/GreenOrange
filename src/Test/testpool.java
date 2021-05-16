package Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class testpool {
    public static Map<String, String> map = new HashMap<>();

    public static void setMap(Map<String, String> map) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("comp.txt");
        fileOutputStream.write(map.toString().getBytes(StandardCharsets.UTF_8));
        fileOutputStream.close();
    }

    public static void getMap() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("comp.txt");
        byte[] bytes = new byte[4096];
        int len = fileInputStream.read(bytes);
        System.out.println(new String(bytes, 0, len));
    }

    public static void main(String[] args) throws IOException {
        Map<String, String> ma = new HashMap<>();
        ma.put("test1", "ans1");
        ma.put("test2", "ans2");
        ma.put("test3", "ans3");
        ma.put("test4", "ans4");
        setMap(ma);
        getMap();
    }
}
