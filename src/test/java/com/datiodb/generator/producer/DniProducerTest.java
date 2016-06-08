package com.datiodb.generator.producer;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

import com.datiodb.generator.data.AbstractData;
import com.datiodb.generator.producer.DataProducer;
import com.datiodb.generator.producer.DniProducer;
import com.datiodb.generator.producer.strategy.DefaultDniStrategy;

public class DniProducerTest {

	@Test
	public void testSetStrategy() {
		DataProducer producer=new DniProducer();
		producer.setStrategy(new DefaultDniStrategy());
		assertThat(producer,is(notNullValue()));
	}

	@Test
	public void testCreate() {
		DataProducer producer=new DniProducer();
		assertThat(producer,is(notNullValue()));
		producer.setStrategy(new DefaultDniStrategy());
		for(int i=0;i<100;i++) {
			AbstractData field=producer.createData();
			System.out.println(field.getName()+ ": " + field.getGenerateValue().toString());		
			assertThat(field,is(notNullValue()));
			assertThat(field.getGenerateValue(),is(instanceOf(String.class)));
		}
	}

}
