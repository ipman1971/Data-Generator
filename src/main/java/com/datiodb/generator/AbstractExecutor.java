package com.datiodb.generator;

import com.datiodb.generator.output.Sink;
import com.datiodb.generator.producer.Tuple;

public class AbstractExecutor implements Executor {
	
	private static final String ID="DATIO-GEN";
	
	protected GenConfig config;
	protected String id;
	
	public AbstractExecutor(String id) {
		this.id=id;
	}
	
	public AbstractExecutor() {
		this(ID);
	}

	@Override
	public void setConfiguration(GenConfig config) {
		this.config=config;
	}

	@Override
	public void run() {
		Sink sink=config.getOutput();
		for(int i=0;i<config.getNumberOfTuples();i++) {
			 sink.process(new Tuple(config.getProducers()));
		}
	}

}
