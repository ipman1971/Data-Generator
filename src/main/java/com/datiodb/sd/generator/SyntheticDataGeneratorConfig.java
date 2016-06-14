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

package com.datiodb.sd.generator;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.datiodb.sd.SyntheticDataException;
import com.datiodb.sd.output.Sink;
import com.datiodb.sd.producer.DataProducer;

import static com.google.common.base.Preconditions.*;

public class SyntheticDataGeneratorConfig implements GeneratorConfig {
	
	private static final String DEFAULT_ID=SyntheticDataGeneratorConfig.class.getSimpleName();
	
	private String id;
	private List<DataProducer> producers;
	private Sink sink;
	private long items;
	
	private SyntheticDataGeneratorConfig() {}
	
	public String getId() {
		return id;
	}
	
	public List<DataProducer> getProducers() {
		return producers;
	}
	
	public Sink getOutput() {
		return sink;
	}
	
	public long getItems() {
		return items;
	}
	
	public static Input name(String id) {
		return new SyntheticDataGeneratorConfig.Builder(id);
	}
	
	public interface Input {
		public Out with(DataProducer producer);
	}
	
	public interface Out extends Input {
		public Capacity output(Sink exporter);
	}
	
	public interface Capacity {
		public Creator items(long items);
	}
	
	public interface Creator {
		public SyntheticDataGeneratorConfig create();
	}
	
	public static class Builder implements Input, Creator, Out, Capacity {
		
		private SyntheticDataGeneratorConfig generator=new SyntheticDataGeneratorConfig();
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
		public SyntheticDataGeneratorConfig create() {
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
		public Builder items(long items) {
			checkNotNull(items,"number of items can't be null");
			if(items > 0) {
				generator.items=items;
			}
			else {
				throw new SyntheticDataException("number of items not is valid value: "+items);
			}
			return this;
		}

	}

}
