package com.test;

import com.sun.jna.Library;
import com.sun.jna.Native;

public class GetPidJNA {

    public interface LibC extends Library {
        long getpid();
    }

    public static void main(String[] args) {
        LibC libc = Native.loadLibrary("c", LibC.class);
        System.out.println(libc.getpid());
    }
}