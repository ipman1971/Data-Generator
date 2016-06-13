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

package com.datiodb.generator.producer;

import com.datiodb.generator.data.AbstractData;
import com.datiodb.generator.producer.strategy.DataProducerStrategy;

public interface DataProducer {
	
	public DataProducer setStrategy(DataProducerStrategy<?> strategy);
	public AbstractData createData();

}
