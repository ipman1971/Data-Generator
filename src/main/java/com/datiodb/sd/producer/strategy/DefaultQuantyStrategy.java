package com.datiodb.sd.producer.strategy;

import java.security.SecureRandom;

/**
 * Created by jcorredera on 17/06/16 - 10:27 - 14:16.
 */
public class DefaultQuantyStrategy implements DataProducerStrategy<Integer> {

    private static final int DEFAULT_LENGTH = 1;

    private final SecureRandom r;
    private final int length;

    public DefaultQuantyStrategy(int length) {
        r = new SecureRandom();
        this.length = length;
    }

    public DefaultQuantyStrategy() {
        this(DEFAULT_LENGTH);
    }

    @Override
    public Integer create() {
        int newValue = r.nextInt((int) Math.pow(10, length));
        if (newValue == 0) {
            newValue = create();
        }
        return newValue;
    }

}
