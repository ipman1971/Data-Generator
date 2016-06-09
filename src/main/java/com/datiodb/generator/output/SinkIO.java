package com.datiodb.generator.output;

public interface SinkIO extends Sink {
	
	public void begin();
	public void end();

}
