package com.datiodb.generator.output;

import static org.junit.Assert.*;

import org.junit.Test;

public class FileSinkTest {

	@Test
	public void testBasicConfig() {
		SinkIO sink=FileSink.path(null).filename(null).create();
	}
	
	@Test
	public void testFileSeparatorConfig() {
		SinkIO sink=FileSink.path(null).filename(null).withSeparator(null).create();
	}

	@Test
	public void testBufferSizeConfig() {
		FileSink sink=FileSink.path(null).filename(null).bufferSize().create();
	}

	@Test
	public void testBufferSizeAndSeparatorConfig() {
		FileSink sink=FileSink.path(null).filename(null).bufferSize().withSeparator(null).create();
	}

}
