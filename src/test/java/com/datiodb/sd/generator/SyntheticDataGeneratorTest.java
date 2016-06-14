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

import static org.junit.Assert.*;

import org.junit.Test;

import com.datiodb.sd.generator.SyntheticDataGenerator;
import com.datiodb.sd.generator.SyntheticDataGeneratorConfig;
import com.datiodb.sd.output.FileSink;
import com.datiodb.sd.producer.CountryCodeProducer;
import com.datiodb.sd.producer.DniProducer;
import com.datiodb.sd.producer.strategy.CountryCodeStrategyFromFile;

public class SyntheticDataGeneratorTest {
	private static final String FILE_DAT="inputs/countries.dat";

	@Test
	public void testRun() {
		SyntheticDataGeneratorConfig config=SyntheticDataGeneratorConfig.name("TEST-GENERATOR")
				.with(new DniProducer())
				.with(new CountryCodeProducer().setStrategy(new CountryCodeStrategyFromFile(FILE_DAT)))
				.output(FileSink.path("/tmp").filename("test.out").withSeparator(";").bufferSize(1024*16).create())
				.items(100000)
				.create();
		
		SyntheticDataGenerator executor=new SyntheticDataGenerator();
		executor.setConfiguration(config);
		executor.run();
		
		assertTrue(true);
	}

}
