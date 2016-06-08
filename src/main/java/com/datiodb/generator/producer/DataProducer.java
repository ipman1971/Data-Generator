package com.datiodb.generator.producer;

import com.datiodb.generator.data.AbstractData;
import com.datiodb.generator.producer.strategy.DataProducerStrategy;

public interface DataProducer {
	
	public DataProducer setStrategy(DataProducerStrategy<?> strategy);
	public AbstractData createData();

}
