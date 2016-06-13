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

import static org.junit.Assert.*;

import org.junit.Test;

import com.datiodb.generator.output.FileSink;
import com.datiodb.generator.producer.CountryCodeProducer;
import com.datiodb.generator.producer.DniProducer;
import com.datiodb.generator.producer.strategy.CountryCodeStrategyFromFile;

public class DatioGeneratorTest {
	private static final String FILE_DAT="inputs/countries.dat";

	@Test
	public void testRun() {
		GenConfig config=GenConfig.name("TEST-GENERATOR")
				.with(new DniProducer())
				.with(new CountryCodeProducer().setStrategy(new CountryCodeStrategyFromFile(FILE_DAT)))
				.output(FileSink.path("/tmp").filename("test.out").withSeparator(";").bufferSize(1024*16).create())
				.numberOfTuples(100000)
				.create();
		
		DatioGenerator executor=new DatioGenerator();
		executor.setConfiguration(config);
		executor.run();
		
		assertTrue(true);
	}

}
