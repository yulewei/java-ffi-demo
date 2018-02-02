package com.test;

import jnr.posix.POSIX;
import jnr.posix.POSIXFactory;

public class GetPidJnrPosix {

    private static POSIX posix = POSIXFactory.getPOSIX();

    public static void main(String[] args) {
        System.out.println(posix.getcwd());
        posix.chdir("..");
        System.out.println(posix.getcwd());
        System.out.println(posix.getpid());
    }
}
