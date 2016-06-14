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

package com.datiodb.sd.output;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

import com.datiodb.sd.output.FileSink;
import com.datiodb.sd.output.Sink;

public class FileSinkTest {

	@Test
	public void testBasicConfig() {
		Sink sink=FileSink.path(null).filename("prueba.out").create();
		assertThat(sink,is(notNullValue()));
	}
	
	@Test
	public void testFileSeparatorConfig() {
		Sink sink=FileSink.path(null).filename(null).withSeparator(null).create();
		assertThat(sink,is(notNullValue()));
	}

	@Test
	public void testBufferSizeConfig() {
		Sink sink=FileSink.path(null).filename(null).bufferSize(1024*8).create();
		assertThat(sink,is(notNullValue()));
	}

	@Test
	public void testBufferSizeAndSeparatorConfig() {
		Sink sink=FileSink.path(null).filename(null).bufferSize(1024*8).withSeparator(null).create();
		assertThat(sink,is(notNullValue()));
	}

}
