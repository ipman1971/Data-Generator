package com.datiodb.sd.data;

/**
 * Created by jcorredera on 23/06/16 - 17:16.
 */
public abstract class MultipleStringAbstractBase extends AbstractData {

    protected String[] names;

    public MultipleStringAbstractBase(String... name) {
        super(name[0]);
        this.names = names;
    }

}
