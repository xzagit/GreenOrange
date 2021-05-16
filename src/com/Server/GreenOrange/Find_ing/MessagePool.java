package com.Server.GreenOrange.Find_ing;

import java.util.HashMap;
import java.util.Map;

public class MessagePool {
    public  static  Map<String, String>  message = new HashMap<>();

    public static synchronized void addMessage(String ip, String message) {
        System.out.println("uiuiui");
        MessagePool.message.put(ip, message);
        System.out.println(MessagePool.message);
    }

    public static Map<String, String> getMessage() {
        return message;
    }
}
