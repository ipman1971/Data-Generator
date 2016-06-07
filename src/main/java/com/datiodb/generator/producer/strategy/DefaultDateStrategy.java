package com.datiodb.generator.producer.strategy;

import java.util.Calendar;
import java.util.Date;

public class DefaultDateStrategy implements DataProducerStrategy<Date> {
	
	private int intervalOfYears;
	
	public DefaultDateStrategy(int intervalOfYears) {
		this.intervalOfYears=intervalOfYears;
	}

	@Override
	public Date create() {
		Calendar calendar=Calendar.getInstance();
		long endTime=calendar.getTime().getTime();
		calendar.add(Calendar.YEAR,this.intervalOfYears*-1);
		long beginTime=calendar.getTime().getTime();
		return new Date(getRandomTime(beginTime, endTime));
	}
	
	private long getRandomTime(long beginTime,long endTime) {
	    long diff = endTime - beginTime + 1;
	    return beginTime + (long) (Math.random() * diff);
	}

}
