package com.datiodb.sd.producer;

import com.datiodb.sd.data.AbstractData;
import com.datiodb.sd.data.StringAbstractBase;
import com.datiodb.sd.producer.strategy.DataProducerStrategy;

/**
 * Created by jcorredera on 17/06/16 - 10:10
 */
public class QuantityProducer implements DataProducer {

    private DataProducerStrategy<?> strategy;
    private final int length;
    private final int decimalLength;

    public QuantityProducer(int length, int decimalLength) {
        this.length = length;
        this.decimalLength = decimalLength;
    }

    @Override
    public DataProducer setStrategy(DataProducerStrategy<?> strategy) {
        this.strategy = strategy;
        return this;
    }

    @Override
    public AbstractData createData() {
        return new QuantityField();
    }

    public int getLength() {
        return length;
    }

    public int getDecimalLength() {
        return decimalLength;
    }

    private class QuantityField extends StringAbstractBase {

        public QuantityField() {
            super("QUANTITY_PRODUCT");
        }

        @Override
        public String getGenerateValue() {
            Integer value = (Integer) strategy.create();
            return this.apply(String.valueOf(value), null);
        }

    }

}
