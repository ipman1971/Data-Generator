package com.datiodb.generator;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.datiodb.generator.exporter.DataExporter;
import com.datiodb.generator.producer.DataProducer;

public class DatioGenerator {
	
	private String id;
	private List<DataProducer> producers;
	private DataExporter exporter;
	private String separator;
	private long totalRows;
	private long rowsByChunk;
	
	private DatioGenerator() {}
	
	public List<DataProducer> getProducers() {
		return producers;
	}
	
	public DataExporter getDataExporter() {
		return exporter;
	}
	
	public String getDataSeparator() {
		return separator;
	}
	
	public long getTotalRows() {
		return totalRows;
	}
	
	public long getRowsByChunk() {
		return rowsByChunk;
	}
	
	public static Configurator configure(String id) {
		return new DatioGenerator.Configurator(id);
	}
	
	public interface Input {
		public Configurator with(DataProducer producer);
	}
	
	public interface Out {
		public Configurator output(DataExporter exporter);
		public Configurator separator(String separator);
	}
	
	public interface Capacity {
		public Configurator totalRows(long nRows);
		public Configurator withChunksOf(long nRows);
	}
	
	public interface Builder {
		public DatioGenerator build();
	}
	
	public static class Configurator implements Input, Builder, Out, Capacity {
		
		private DatioGenerator generator=new DatioGenerator();
		private List<DataProducer> producersList=new LinkedList<>();
		
		private Configurator(String id) {
			generator.id=id;
		}
		
		@Override
		public DatioGenerator build() {
			generator.producers=Collections.unmodifiableList(producersList);
			return generator;
		}

		@Override
		public Configurator with(DataProducer producer) {
			if(producer!=null) {
				producersList.add(producer);
			}
			return this;
		}

		@Override
		public Configurator output(DataExporter exporter) {
			if(exporter!=null) {
				generator.exporter=exporter;
			}
			return this;
		}

		@Override
		public Configurator separator(String separator) {
			if(separator!=null && !separator.isEmpty()) {
				generator.separator=separator;
			}
			return this;
		}

		@Override
		public Configurator totalRows(long nRows) {
			generator.totalRows=nRows;
			return this;
		}

		@Override
		public Configurator withChunksOf(long nRows) {
			generator.rowsByChunk=nRows;
			return this;
		}
		
	}

}
