package com.datiodb.sd.producer.strategy;

import java.security.SecureRandom;

/**
 * Created by jcorredera on 17/06/16 - 10:27 - 14:16.
 */
public class DefaultAmountStrategy implements DataProducerStrategy<Double> {

  private static final int DEFAULT_LENGTH=3;
  private static final int DEFAULT_DECIMAL_LENGTH=2;

    private final SecureRandom r;
  private final int length;
  private final int decimalLength;

  public DefaultAmountStrategy(int length, int decimalLength) {
      r = new SecureRandom();
    this.length=length;
    this.decimalLength=decimalLength;
  }

  public DefaultAmountStrategy() {
    this(DEFAULT_LENGTH,DEFAULT_DECIMAL_LENGTH);
  }

  @Override
  public Double create() {
    return integerRandom()+decimalRandom();
  }

  public int getLength() {
    return length;
  }

  public int getDecimalLength() {
    return decimalLength;
  }

  private int integerRandom() {
    return r.nextInt((int)Math.pow(10,length));
  }

  private double decimalRandom() {
    return r.nextInt((int)Math.pow(10,decimalLength))/ Math.pow(10,decimalLength);
  }

}
