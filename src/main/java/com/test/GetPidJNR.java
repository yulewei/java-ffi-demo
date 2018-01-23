package com.test;

import jnr.ffi.LibraryLoader;

public class GetPidJNR {
    public interface LibC {
        long getpid();
    }

    public static void main(String[] args) {
        // JNR 获取 pid
        LibC libc = LibraryLoader.create(LibC.class).load("c");
        System.out.println(libc.getpid());

        // JNI 获取 pid
        System.out.println(GetPidJNI.getpid());
    }
}