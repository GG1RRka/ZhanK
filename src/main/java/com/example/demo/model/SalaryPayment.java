package com.example.demo.model;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.stream.Stream;

@Slf4j
public class SalaryPayment implements Callable<Integer> {
    @Override
    public Integer call() {
        Integer sum = Stream.iterate(0, n -> n + 1).limit(5)
                .reduce(0, (x, y) -> {
                    log.info("Paying salary #" + x + " to team #" + y);
                    //
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return x + 1;
                });
        return sum;
    }
}