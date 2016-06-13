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

package com.datiodb.generator;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.datiodb.generator.output.Sink;
import com.datiodb.generator.producer.DataProducer;
import static com.google.common.base.Preconditions.*;

public class GenConfig {
	
	private static final String DEFAULT_ID="DEFAULT_CONFIG";
	
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
			if(id!=null && !id.isEmpty()) {
				generator.id=id;
			}
			else {
				generator.id=DEFAULT_ID;
			}
		}
		
		@Override
		public GenConfig create() {
			generator.producers=Collections.unmodifiableList(producersList);
			return generator;
		}

		@Override
		public Out with(DataProducer producer) {
			checkNotNull(producer,"producer can't be a null reference");
			producersList.add(producer);
			return this;
		}

		@Override
		public Capacity output(Sink sink) {
			checkNotNull(sink,"sink can't be a null reference");
			generator.sink=sink;
			return this;
		}

		@Override
		public Builder numberOfTuples(long nTuples) {
			checkNotNull(nTuples,"number of tuples is null");
			if(nTuples > 0) {
				generator.nTuples=nTuples;
			}
			else {
				throw new DatioGeneratorException("number of tuples not is valid value: "+nTuples);
			}
			return this;
		}

	}

}
