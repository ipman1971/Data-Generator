package com.datiodb.generator.field;

public abstract class TextFieldBase extends AbstractField implements Mask<String> {
	
	public TextFieldBase(int length) {
		super(length);
	}
	
	@Override
	public String apply(String value,String mask) {
		return value;
	}

}
