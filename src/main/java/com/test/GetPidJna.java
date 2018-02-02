package com.test;

import com.sun.jna.Library;
import com.sun.jna.Native;

/**
 * Direct Mapping
 * <p>
 * https://github.com/java-native-access/jna/blob/master/www/DirectMapping.md
 */
public class GetPidJna {

    public interface LibC extends Library {
        long getpid();
    }

    public static void main(String[] args) {
        LibC libc = Native.loadLibrary("c", LibC.class);
        System.out.println(libc.getpid());
    }
}