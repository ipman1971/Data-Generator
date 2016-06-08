package com.datiodb.generator.data;

public interface Mask<T> {

	public String apply(T value,String mask);

}
