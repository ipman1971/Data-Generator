package com.datiodb.generator.producer;

import java.util.LinkedList;
import java.util.List;

public class Tuple {
	
	private List<? extends DataProducer> producerList;
	
	public Tuple(List<? extends DataProducer> producerList) {
		this.producerList=producerList;
	}

	public List<? extends DataProducer> getProducerList() {
		return producerList;
	}
	
	public void setProducerList(List<? extends DataProducer> producerList) {
		this.producerList = producerList;
	}
	
	public String getName(int column) {
		validateColumn(column);
		return producerList.get(column).createData().getName();
	}
	
	public String getValue(int column) {
		validateColumn(column);
		return producerList.get(column).createData().getGenerateValue();
	}
	
	public List<String> get() {
		List<String> values=new LinkedList<>();
		for(DataProducer producer:producerList) {
			values.add(producer.createData().getGenerateValue());
		}
		return values;
	}
	
	public int getLength() {
		int sumatory=0;
		for(String s: get()) {
			sumatory=+ s.getBytes().length;
		}
		return sumatory;
	}

	public int getSize() {
		return producerList.size();
	}
	
	private void validateColumn(int column) {
		if(column < 0 || column > producerList.size()) {
			throw new IllegalArgumentException("column out of range");
		}
		
	}
	
	@Override
	public String toString() {
		StringBuffer buffer=new StringBuffer();
		for(DataProducer producer:producerList) {
			buffer.append(producer.createData().getGenerateValue()).append(" ");
		}
		return buffer.toString();
	}

}
