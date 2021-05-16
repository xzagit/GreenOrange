package com.Server.GreenOrange.Find_ing;

import java.util.ArrayList;

public class IpAddress {
    public static ArrayList<String> ipaddress = new ArrayList<>();

    public static ArrayList<String> getIpaddress() {
        return ipaddress;
    }

    public static synchronized void addIpaddress(String ip) {
        ipaddress.add(ip);
    }
}
