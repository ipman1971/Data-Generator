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

/**
 * Define el ciclo de vida para cualquier posible forma de volcar datos generados
 * 
 * @author jcorredera
 *
 */
public interface Sink {
	
	/**
	 * Realiza cualquier tipo de operación previa al procesamiento de todas las tuplas
	 */
	public void begin();

	/**
	 * Procesa una a una cada tupla de datos generados de acuerdo a la forma de su volcado
	 * 
	 * @param tuple		Este objeto representa el conjunto de datos generados
	 */
	public void process(Tuple tuple);
	
	/**
	 * Realiza cualquier tipo de operación posterior al procesamiento de todas las tuplas
	 */
	public void end();

}
