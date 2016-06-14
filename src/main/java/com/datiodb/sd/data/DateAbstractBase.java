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

package com.datiodb.sd.data;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.google.common.base.Preconditions.*;

public abstract class DateAbstractBase extends AbstractData implements Mask<Date,SimpleDateFormat> {
	
	protected static final String DEFAULT_MASK="dd/MM/yyyy - hh:mm:ss";
	
	public DateAbstractBase(String name) {
		super(name);
	}

	@Override
	public String apply(Date value, SimpleDateFormat mask) {
		checkNotNull(value,"Date value can't be null reference");
		checkNotNull(mask,"mask can't be null reference");
		return mask.format(value);
	}

}
