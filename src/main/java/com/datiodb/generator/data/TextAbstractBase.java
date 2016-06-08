package com.datiodb.generator.data;

public abstract class TextAbstractBase extends AbstractData implements Mask<String> {
	
	public TextAbstractBase(String name) {
		super(name);
	}

	@Override
	public String apply(String value,String mask) {
		return value;
	}

}
