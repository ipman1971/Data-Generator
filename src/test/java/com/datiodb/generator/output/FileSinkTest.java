package com.datiodb.generator.output;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class FileSinkTest {

	@Test
	public void testBasicConfig() {
		SinkIO sink=FileSink.path(null).filename(null).create();
		assertThat(sink,is(notNullValue()));
	}
	
	@Test
	public void testFileSeparatorConfig() {
		SinkIO sink=FileSink.path(null).filename(null).withSeparator(null).create();
		assertThat(sink,is(notNullValue()));
	}

	@Test
	public void testBufferSizeConfig() {
		FileSink sink=FileSink.path(null).filename(null).bufferSize(1024*8).create();
		assertThat(sink,is(notNullValue()));
	}

	@Test
	public void testBufferSizeAndSeparatorConfig() {
		FileSink sink=FileSink.path(null).filename(null).bufferSize(1024*8).withSeparator(null).create();
		assertThat(sink,is(notNullValue()));
	}

}
