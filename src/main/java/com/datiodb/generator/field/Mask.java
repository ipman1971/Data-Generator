package com.datiodb.generator.field;

public interface Mask<T> {

	public String apply(T value,String mask);

}
