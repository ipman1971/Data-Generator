package com.datiodb.sd.generator;

import java.util.List;

import com.datiodb.sd.output.Sink;
import com.datiodb.sd.producer.DataProducer;

public interface GeneratorConfig {
	
	public String getId();
	public long getItems();
	public Sink getOutput();
	public List<DataProducer> getProducers();

}
