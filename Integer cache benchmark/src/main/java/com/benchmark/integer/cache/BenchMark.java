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
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public int sumCached1() {
        return somaNumeros(1, true);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public int sumCached100() {
        return somaNumeros(100, true);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public int sumCached1000() {
        return somaNumeros(1000, true);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public int sumCached10000() {
        return somaNumeros(10000, true);
    }
////////////////////////////////////////////////
    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public int sumOutOfRangeCache1() {
        return somaNumeros(1, false);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public int sumOutOfRangeCache100() {
        return somaNumeros(100, false);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public int sumOutOfRangeCache1000() {
        return somaNumeros(1000, false);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public int sumOutOfRangeCache10000() {
        return somaNumeros(10000, false);
    }

    public static Integer somaNumeros(int quantidade, boolean somarMenoresQue128) {
        if (quantidade <= 0) {
            return 0;
        }

        List<Integer> numeros = new ArrayList<>();
        if (somarMenoresQue128) {
            for (int i = 0; i < 128 && i < quantidade; i++) {
                numeros.add(i);
            }
        } else {
            for (int i = 128; i < Integer.MAX_VALUE && numeros.size() < quantidade; i++) {
                numeros.add(i);
            }
        }

        Integer soma = 0;
        for (Integer numero : numeros) {
            soma += numero;
        }

        return soma;
    }
}