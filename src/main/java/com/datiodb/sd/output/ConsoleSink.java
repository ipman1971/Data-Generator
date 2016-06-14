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

import com.datiodb.sd.producer.Tuple;
import static com.google.common.base.Preconditions.*;

/**
 * Envia a System.out los datos generados
 * 
 * @author jcorredera
 *
 */
public class ConsoleSink implements Sink {

	@Override
	public void process(Tuple tuple) {
		checkNotNull(tuple,"tuple object can't be null");
		System.out.println(tuple.toString());
	}

	/**
	 * No aplica, implementacion vacia
	 */
	@Override
	public void begin() {}

	/**
	 * No aplica, implementacion vacia
	 */
	@Override
	public void end() {}

}
