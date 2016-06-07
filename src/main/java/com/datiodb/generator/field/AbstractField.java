package com.datiodb.generator.field;

public abstract class AbstractField implements Field {
	
	private int length;
	
	public AbstractField() {
		this(0);
	}
	
	public AbstractField(int length) {
		this.length=length;
	}

	@Override
	public int getLength() {
		return length;
	}

	@Override
	public void setLength(int length) {
		this.length=length;
	}

}
