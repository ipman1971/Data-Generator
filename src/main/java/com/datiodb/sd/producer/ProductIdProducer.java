package com.datiodb.sd.producer;

import com.datiodb.sd.data.AbstractData;
import com.datiodb.sd.data.StringAbstractBase;
import com.datiodb.sd.producer.strategy.DataProducerStrategy;
import com.datiodb.sd.producer.strategy.DefaultProductIdtrategy;

/**
 * Created by jcorredera on 23/06/16 - 15:46.
 */
public class ProductIdProducer implements DataProducer {

    private DataProducerStrategy<?> strategy;

    public ProductIdProducer() {
        this.strategy = new DefaultProductIdtrategy();
    }

    @Override
    public DataProducer setStrategy(DataProducerStrategy<?> strategy) {
        this.strategy = strategy;
        return this;
    }

    @Override
    public AbstractData createData() {
        return new ProductId();
    }

    private class ProductId extends StringAbstractBase {

        private ProductId() {
            super("PRODUCT_ID");
        }

        @Override
        public String getGenerateValue() {
            return this.apply((String) strategy.create(), null);
        }

    }

}
