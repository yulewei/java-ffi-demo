package com.test;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import com.sun.jna.Native;

import jnr.ffi.LibraryLoader;

public class BenchmarkFFI {

    // ==== GetPidJni ===

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void testGetPidJni() {
        GetPidJni.getpid();
    }

    // ==== GetPidJna ===

    static GetPidJna.LibC libcjna = Native.loadLibrary("c", GetPidJna.LibC.class);

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void testGetPidJna() {
        libcjna.getpid();
    }

    // ==== GetPidJnaDirect ===

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void testGetPidJnaDirect() {
        GetPidJnaDirect.getpid();
    }

    // ==== GetPidJnr ===

    static GetPidJnr.LibC libcjnr = LibraryLoader.create(GetPidJnr.LibC.class).load("c");

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void testGetPidJnr() {
        libcjnr.getpid();
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .warmupIterations(10)
                .measurementIterations(10)
                .forks(1)
                .build();
        new Runner(opt).run();
    }
}