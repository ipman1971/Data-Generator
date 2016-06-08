package com.datiodb.generator;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

import com.datiodb.generator.producer.CountryCodeProducer;
import com.datiodb.generator.producer.DniProducer;
import com.datiodb.generator.producer.strategy.CountryCodeStrategyFromFile;
import com.datiodb.generator.producer.strategy.DefaultDniStrategy;

public class DatioGeneratorTest {
	
	private static final String FILE_DAT="inputs/countries.dat";

	@Test
	public void testGenerator() {
		DatioGenerator generator=DatioGenerator.configure("TEST-GENERATOR")
				.with(new DniProducer().setStrategy(new DefaultDniStrategy()))
				.with(new CountryCodeProducer().setStrategy(new CountryCodeStrategyFromFile(FILE_DAT)))
				.output(null)
				.separator(";")			//no aplica es del output
				.totalRows(1000000)		//no aplica es del output
				.withChunksOf(100000)	//no aplica es del output
				.build();
		
		assertThat(generator,is(notNullValue()));
		assertThat(generator.getProducers().size(),is(2));
		assertThat(generator.getDataSeparator(),is(equalTo(";")));
		assertThat(generator.getDataExporter(),is(nullValue()));
		assertThat(generator.getTotalRows(),is(equalTo(new Long(1000000))));
		assertThat(generator.getRowsByChunk(),is(equalTo(new Long(100000))));
	}
	
}
