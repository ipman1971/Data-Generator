package com.datiodb.generator.producer.strategy;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

import com.datiodb.generator.producer.strategy.DataProducerStrategy;
import com.datiodb.generator.producer.strategy.DefaultDniStrategy;

public class DefaultDniStrategyTest {

	@Test
	public void testCreate() {
		DataProducerStrategy<?> strategy=new DefaultDniStrategy();
		for(int i=0;i<100;i++)
			System.out.println(strategy.create());
		assertThat(strategy.create(),is(notNullValue()));
	}

}
