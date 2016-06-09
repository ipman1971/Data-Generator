package com.datiodb.generator.output;

import com.datiodb.generator.producer.Tuple;

public class SinkNullAdapter implements Sink, SinkIO {

	@Override
	public void begin() {}

	@Override
	public void process(Tuple tuple) {}

	@Override
	public void end() {}

}
