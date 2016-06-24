package com.datiodb.sd.producer;

import com.datiodb.sd.data.AbstractData;
import com.datiodb.sd.data.DateAbstractBase;
import com.datiodb.sd.producer.strategy.DataProducerStrategy;
import com.datiodb.sd.producer.strategy.DefaultDateStrategy;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jcorredera on 24/06/16 - 9:17.
 */
public class DateOperationProducer implements DataProducer {

    private DataProducerStrategy<?> strategy;

    public DateOperationProducer() {
        strategy = new DefaultDateStrategy(1);
    }

    @Override
    public DataProducer setStrategy(DataProducerStrategy<?> strategy) {
        this.strategy = strategy;
        return this;
    }

    @Override
    public AbstractData createData() {
        return new DateOperation();
    }

    private class DateOperation extends DateAbstractBase {

        private SimpleDateFormat mask;

        public DateOperation() {
            super("DATE_OPERATION");
            mask = new SimpleDateFormat("yyyyMMddhhmmss");
        }

        @Override
        public String getGenerateValue() {
            return this.apply((Date) strategy.create(), mask);
        }

    }
}
