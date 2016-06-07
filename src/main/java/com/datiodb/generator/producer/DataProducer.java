package com.datiodb.generator.producer;

import com.datiodb.generator.field.AbstractField;
import com.datiodb.generator.producer.strategy.DataProducerStrategy;

public interface DataProducer {
	
	public void setStrategy(DataProducerStrategy<?> strategy);
	public AbstractField createData();

}
