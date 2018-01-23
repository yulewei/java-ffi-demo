package com.test;

public class GetPidJNI {
    public static native long getpid();

    static {
        System.loadLibrary("getpidjni");
    }

    public static void main(String[] args) {
        System.out.println(getpid());
    }

}