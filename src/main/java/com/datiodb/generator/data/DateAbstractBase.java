package com.datiodb.generator.data;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class DateAbstractBase extends AbstractData implements Mask<Date> {
	
	public DateAbstractBase(String name) {
		super(name);
	}

	@Override
	public String apply(Date value, String mask) {
		return new SimpleDateFormat(mask).format(value);
	}

}
