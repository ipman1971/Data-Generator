package com.datiodb.sd.producer;

import com.datiodb.sd.data.AbstractData;
import com.datiodb.sd.producer.strategy.DefaultAmountStrategy;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * Created by jcorredera on 17/06/16 - 12:53 - 14:10.
 */
public class AmountProducerTest {

  @Test
  public void setStrategy() throws Exception {
    AmountProducer producer=new AmountProducer(4,2);
    assertThat(producer,is(notNullValue()));

    producer.setStrategy(new DefaultAmountStrategy(producer.getLength(),producer.getDecimalLength()));
    assertTrue(true);
  }

  @Test
  public void createData() throws Exception {
    AmountProducer producer=new AmountProducer(4,3);
    assertThat(producer,is(notNullValue()));

    producer.setStrategy(new DefaultAmountStrategy(producer.getLength(),producer.getDecimalLength()));
    AbstractData data = producer.createData();
    assertThat(data.getName(),is(equalTo("AMOUNT")));
    assertThat(data.getGenerateValue(),is(instanceOf(String.class)));
    assertThat(data.getGenerateValue().length(),is(8));
  }

}