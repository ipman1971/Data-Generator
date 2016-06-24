package com.datiodb.sd.producer;

import com.datiodb.sd.data.AbstractData;
import com.datiodb.sd.data.StringAbstractBase;
import com.datiodb.sd.producer.strategy.DataProducerStrategy;
import com.datiodb.sd.producer.strategy.DefaultPANNumberStrategy;

/**
 * Created by jcorredera on 23/06/16 - 15:46.
 */
public class PANNumberProducer implements DataProducer {

    private DataProducerStrategy<?> strategy;

    public PANNumberProducer() {
        this.strategy = new DefaultPANNumberStrategy();
    }

    @Override
    public DataProducer setStrategy(DataProducerStrategy<?> strategy) {
        this.strategy = strategy;
        return this;
    }

    @Override
    public AbstractData createData() {
        return new PANNumber();
    }

    private class PANNumber extends StringAbstractBase {

        private PANNumber() {
            super("PAN-NUMBER");
        }

        @Override
        public String getGenerateValue() {
            return this.apply((String) strategy.create(), null);
        }

    }

}
