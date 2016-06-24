package com.datiodb.sd.producer;

import com.datiodb.sd.data.AbstractData;
import com.datiodb.sd.data.NumberAbstractBase;
import com.datiodb.sd.producer.strategy.DataProducerStrategy;

/**
 * Created by jcorredera on 17/06/16 - 10:10
 */
public class AmountProducer implements DataProducer {

  private DataProducerStrategy<?> strategy;
  private final int length;
  private final int decimalLength;

  public AmountProducer(int length, int decimalLength) {
    this.length=length;
    this.decimalLength=decimalLength;
  }

  @Override
  public DataProducer setStrategy(DataProducerStrategy<?> strategy) {
    this.strategy=strategy;
    return this;
  }

  @Override
  public AbstractData createData() {
    return new AmountField();
  }

  public int getLength() {
    return length;
  }

  public int getDecimalLength() {
    return decimalLength;
  }

  private class AmountField extends NumberAbstractBase {

    public AmountField() {
      super("AMOUNT");
    }

    @Override
    public String getGenerateValue() {
      return this.apply((Double)strategy.create(),this.createMask());
    }

    private String createMask() {
      StringBuilder buffer= new StringBuilder();
      for(int i=0;i<length;i++) {
        buffer.append("0");
      }
        if (decimalLength != 0) {
            buffer.append(".");
            for (int i = 0; i < decimalLength; i++) {
                buffer.append("0");
            }
      }
      return buffer.toString();
    }

  }

}
