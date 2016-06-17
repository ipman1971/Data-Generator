package com.datiodb.sd.producer.strategy;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * Created by jcorredera on 17/06/16 - 11:09 - 14:16.
 */
public class DefaultAmountStrategyTest {

  @Test
  public void create() throws Exception {
    DefaultAmountStrategy strategy=new DefaultAmountStrategy(6,3);
    assertThat(strategy,is(notNullValue()));
    assertThat(strategy.create(),is(instanceOf(Double.class)));
  }

}