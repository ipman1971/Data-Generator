/*
 * Copyright (C) 2016 DatioBD 
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.datiodb.sd.producer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Tuple {
	
	private List<DataProducer> producerList;
	
	public Tuple(List<DataProducer> producerList) {
		this.producerList=producerList;
	}
	
	public Tuple() {
		this.producerList=new ArrayList<>();
	}
	
	public void addProducer(DataProducer producer) {
		this.producerList.add(producer);
	}

	public List<? extends DataProducer> getProducerList() {
		return producerList;
	}
	
	public void setProducerList(List<DataProducer> producerList) {
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
