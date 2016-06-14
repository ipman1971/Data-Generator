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

import com.datiodb.sd.output.Sink;
import com.datiodb.sd.producer.Tuple;

public class SyntheticDataGenerator implements Generator {
	
	private static final String ID=SyntheticDataGenerator.class.getSimpleName();
	
	protected GeneratorConfig config;
	protected String id;
	
	public SyntheticDataGenerator(String id) {
		this.id=id;
	}
	
	public SyntheticDataGenerator() {
		this(ID);
	}

	@Override
	public void setConfiguration(GeneratorConfig config) {
		this.config=config;
	}

	@Override
	public void run() {
		Sink sink=config.getOutput();
		sink.begin();
		for(int i=0;i<config.getItems();i++) {
			 sink.process(new Tuple(config.getProducers()));
		}
		sink.end();
	}

}
