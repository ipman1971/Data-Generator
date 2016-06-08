package com.datiodb.generator.data;

public abstract class AbstractData implements Data {
	
	protected final String name;
	
	public AbstractData(String name ) {
		this.name=name;
	}
	
	public String getName() {
		return this.name;
	}

}
