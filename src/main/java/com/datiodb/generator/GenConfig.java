package com.datiodb.generator;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.datiodb.generator.output.Sink;
import com.datiodb.generator.producer.DataProducer;

public class GenConfig {
	
	private String id;
	private List<DataProducer> producers;
	private Sink sink;
	private long nTuples;
	
	private GenConfig() {}
	
	public String getId() {
		return id;
	}
	
	public List<DataProducer> getProducers() {
		return producers;
	}
	
	public Sink getOutput() {
		return sink;
	}
	
	public long getNumberOfTuples() {
		return nTuples;
	}
	
	public static Input name(String id) {
		return new GenConfig.Builder(id);
	}
	
	public interface Input {
		public Out with(DataProducer producer);
	}
	
	public interface Out extends Input {
		public Capacity output(Sink exporter);
	}
	
	public interface Capacity {
		public Creator numberOfTuples(long nTuples);
	}
	
	public interface Creator {
		public GenConfig create();
	}
	
	public static class Builder implements Input, Creator, Out, Capacity {
		
		private GenConfig generator=new GenConfig();
		private List<DataProducer> producersList=new LinkedList<>();
		
		private Builder(String id) {
			generator.id=id;
		}
		
		@Override
		public GenConfig create() {
			generator.producers=Collections.unmodifiableList(producersList);
			return generator;
		}

		@Override
		public Out with(DataProducer producer) {
			if(producer!=null) {
				producersList.add(producer);
			}
			return this;
		}

		@Override
		public Capacity output(Sink exporter) {
			if(exporter!=null) {
				generator.sink=exporter;
			}
			return this;
		}

		@Override
		public Builder numberOfTuples(long nTuples) {
			generator.nTuples=nTuples;
			return this;
		}

	}

}
