package com.test;

import jnr.ffi.LibraryLoader;

public class GetPidJnr {

    public interface LibC {
        long getpid();
    }

    public static void main(String[] args) {
//        System.setProperty("jaffl.compiler.dump", "true");

        // JNR 获取 pid
        LibC libc = LibraryLoader.create(LibC.class).load("c");
        System.out.println(libc.getpid());

        // JNI 获取 pid
        System.out.println(GetPidJni.getpid());
    }
}