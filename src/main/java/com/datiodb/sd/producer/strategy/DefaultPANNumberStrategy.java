package com.datiodb.sd.producer.strategy;

import java.security.SecureRandom;

/**
 * Created by jcorredera on 20/06/16 - 10:44.
 */
public class DefaultPANNumberStrategy implements DataProducerStrategy<String> {

    private static final String[] MASTERCARD_PREFIX_LIST = new String[]{"51", "52", "53", "54", "55"};
    private static final String NUMBERS = "0123456789";
    private final SecureRandom random;

    public DefaultPANNumberStrategy() {
        random = new SecureRandom();
    }

    @Override
    public String create() {
        StringBuilder buffer = new StringBuilder();
        buffer.append(MASTERCARD_PREFIX_LIST[random.nextInt(MASTERCARD_PREFIX_LIST.length)]);
        buffer.append(createBlock(2));
        buffer.append(createBlock(12));
        return buffer.toString();
    }

    private String createBlock(int length) {
        StringBuilder block = new StringBuilder();
        for (int i = 0; i < length; i++) {
            block.append(NUMBERS.charAt(random.nextInt(NUMBERS.length())));
        }
        return block.toString();
    }

}
