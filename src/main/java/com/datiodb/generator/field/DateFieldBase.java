package com.datiodb.generator.field;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class DateFieldBase extends AbstractField implements Mask<Date> {
	
	@Override
	public String apply(Date value, String mask) {
		return new SimpleDateFormat(mask).format(value);
	}

}
