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

package com.datiodb.sd.producer.strategy;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

import com.datiodb.sd.producer.strategy.DataProducerStrategy;
import com.datiodb.sd.producer.strategy.DefaultCountryCodeStrategy;

public class DefaultCountryStrategyTest {

	@Test
	public void testCreate() {
		DataProducerStrategy<?> strategy=new DefaultCountryCodeStrategy();
		assertThat(strategy,is(notNullValue()));
		assertThat(strategy.create(),is(instanceOf(String.class)));
	}

}
