package com.datiodb.generator;

import static org.junit.Assert.*;

import org.junit.Test;

import com.datiodb.generator.output.ConsoleSink;
import com.datiodb.generator.producer.CountryCodeProducer;
import com.datiodb.generator.producer.DniProducer;
import com.datiodb.generator.producer.strategy.CountryCodeStrategyFromFile;

public class AbstractExecutorTest {
	private static final String FILE_DAT="inputs/countries.dat";

	@Test
	public void testRun() {
		GenConfig config=GenConfig.name("TEST-GENERATOR")
				.with(new DniProducer())
				.with(new CountryCodeProducer().setStrategy(new CountryCodeStrategyFromFile(FILE_DAT)))
				.output(new ConsoleSink())
				.numberOfTuples(100000)
				.create();
		
		AbstractExecutor executor=new AbstractExecutor();
		executor.setConfiguration(config);
		executor.run();
		
		assertTrue(true);
	}

}
