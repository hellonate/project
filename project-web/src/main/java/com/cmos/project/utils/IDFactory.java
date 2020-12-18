package com.cmos.project.utils;

import java.util.UUID;

public class IDFactory {
    public static String GetUUID(){
        return UUID.randomUUID().toString();
    }
}
