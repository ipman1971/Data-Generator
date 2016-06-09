package com.datiodb.generator.output;

import com.datiodb.generator.producer.Tuple;

public interface Sink {

	public void process(Tuple tuple);

}
