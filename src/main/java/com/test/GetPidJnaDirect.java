package com.test;

import com.sun.jna.Native;
import com.sun.jna.Platform;

/**
 * Direct Mapping
 * <p>
 * https://github.com/java-native-access/jna/blob/master/www/DirectMapping.md
 */
public class GetPidJnaDirect {

    public static native long getpid();

    static {
        Native.register(Platform.C_LIBRARY_NAME);
    }

    public static void main(String[] args) {
        System.out.println(getpid());
    }
}
