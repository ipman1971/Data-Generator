package com.datiodb.generator.output;

import com.datiodb.generator.producer.Tuple;

public class ConsoleSink implements Sink {

	@Override
	public void process(Tuple tuple) {
		System.out.println(tuple.toString());
	}

}
