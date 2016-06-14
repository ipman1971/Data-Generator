package com.datiodb.sd.output;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

import com.datiodb.sd.producer.Tuple;

public class ConsoleSinkTest {

	@Test
	public void testInstance() {
		Sink consoleSink=new ConsoleSink();
		assertThat(consoleSink,is(notNullValue()));
	}
	
	@Test(expected=NullPointerException.class)
	public void testProcess_with_null_tuple() {
		Sink consoleSink=new ConsoleSink();
		assertThat(consoleSink,is(notNullValue()));
		
		consoleSink.process(null);
	}
	
	@Test
	public void testProcess() {
		Sink consoleSink=new ConsoleSink();
		assertThat(consoleSink,is(notNullValue()));
		
		consoleSink.process(new Tuple());
		assertTrue(true);
	}

}
