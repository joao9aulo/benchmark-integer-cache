package com.benchmark.integer.cache;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BenchMark {

    @Benchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public List cached1() {
        return instantiateNumbers(1, true);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public List cached100() {
        return instantiateNumbers(100, true);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public List cached1000() {
        return instantiateNumbers(1000, true);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public List cached10000() {
        return instantiateNumbers(10000, true);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public List cached100000() {
        return instantiateNumbers(100000, true);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public List cached1000000() {
        return instantiateNumbers(1000000, true);
    }

    ////////////////////////////////////////////////
    @Benchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public List OutOfRangeCache1() {
        return instantiateNumbers(1, false);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public List OutOfRangeCache100() {
        return instantiateNumbers(100, false);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public List OutOfRangeCache1000() {
        return instantiateNumbers(1000, false);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public List OutOfRangeCache10000() {
        return instantiateNumbers(10000, false);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public List OutOfRangeCache100000() {
        return instantiateNumbers(100000, false);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public List OutOfRangeCache1000000() {
        return instantiateNumbers(1000000, false);
    }

    public static List instantiateNumbers(int quantity, boolean minorThan128) {
        List<Integer> numeros = new ArrayList<>();
        if (minorThan128) {
            for (int i = 0; i < 128 && i < quantity; i++) {
                numeros.add(i);
            }
        } else {
            for (int i = 128; i < Integer.MAX_VALUE && numeros.size() < quantity; i++) {
                numeros.add(i);
            }
        }

        return numeros;
    }
}