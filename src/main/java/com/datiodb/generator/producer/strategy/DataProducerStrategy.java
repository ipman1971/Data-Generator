package com.datiodb.generator.producer.strategy;

public interface DataProducerStrategy<T> {
	
	public T create();

}
