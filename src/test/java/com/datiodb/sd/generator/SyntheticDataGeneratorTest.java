/*
 * Copyright (C) 2016 DatioBD 
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.datiodb.sd.generator;

import com.datiodb.sd.output.FileSink;
import com.datiodb.sd.producer.AmountProducer;
import com.datiodb.sd.producer.CountryCodeProducer;
import com.datiodb.sd.producer.DateOperationProducer;
import com.datiodb.sd.producer.DniProducer;
import com.datiodb.sd.producer.PANNumberProducer;
import com.datiodb.sd.producer.ProductIdProducer;
import com.datiodb.sd.producer.ProductInfoProducer;
import com.datiodb.sd.producer.QuantityProducer;
import com.datiodb.sd.producer.strategy.CountryCodeStrategyFromFile;
import com.datiodb.sd.producer.strategy.DefaultAmountStrategy;
import com.datiodb.sd.producer.strategy.DefaultQuantyStrategy;
import com.datiodb.sd.producer.strategy.ProductInfoStrategyFromFile;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SyntheticDataGeneratorTest {
	private static final String FILE_DAT="inputs/countries.dat";
    private static final String PRODUCT_INFO_DAT = "inputs/productinfo.dat";

    @Test
    public void testRun() {
        SyntheticDataGeneratorConfig config = SyntheticDataGeneratorConfig.name("TEST-GENERATOR")
                .with(new DniProducer())
                .with(new AmountProducer(5,2).setStrategy(new DefaultAmountStrategy(5,2)))
				.with(new CountryCodeProducer().setStrategy(new CountryCodeStrategyFromFile(FILE_DAT)))
				.output(FileSink.path("/tmp").filename("dataflow-test.dat").withSeparator(";").bufferSize(1024*16).create())
				.items(1000)
				.create();

		SyntheticDataGenerator executor=new SyntheticDataGenerator();
		executor.setConfiguration(config);
		executor.run();

        assertTrue(true);
    }

    @Test
    public void testCreateProductInfoFile() {
        SyntheticDataGeneratorConfig config = SyntheticDataGeneratorConfig.name("TEST-GENERATOR")
                .with(new ProductIdProducer())
                .with(new QuantityProducer(3, 2).setStrategy(new DefaultAmountStrategy(3, 2)))
                .output(FileSink.path("/tmp").filename("productInfo.dat").withSeparator(";").bufferSize(1024 * 16).create())
                .items(1000)
                .create();

        SyntheticDataGenerator executor = new SyntheticDataGenerator();
        executor.setConfiguration(config);
        executor.run();

        assertTrue(true);
    }

    @Test
    public void testCreatePanNumberFile() {
        SyntheticDataGeneratorConfig config = SyntheticDataGeneratorConfig.name("TEST-GENERATOR")
                .with(new PANNumberProducer())
                .output(FileSink.path("/tmp").filename("pannumber.dat").withSeparator(";").bufferSize(1024 * 16).create())
                .items(1000)
                .create();

        SyntheticDataGenerator executor = new SyntheticDataGenerator();
        executor.setConfiguration(config);
        executor.run();

        assertTrue(true);
    }

    @Test
    public void testCreateBigQueryFile() {
        SyntheticDataGeneratorConfig config = SyntheticDataGeneratorConfig.name("TEST-GENERATOR")
                .with(new DateOperationProducer())
                .with(new PANNumberProducer())
                .with(new ProductInfoProducer(";").setStrategy(new ProductInfoStrategyFromFile(PRODUCT_INFO_DAT, ";")))
                .with(new QuantityProducer(1, 0).setStrategy(new DefaultQuantyStrategy(1)))
                .output(FileSink.path("/tmp").filename("cardproduct-dataset.dat").withSeparator(";").bufferSize(1024 * 16).create())
                .items(1000)
                .create();

        SyntheticDataGenerator executor = new SyntheticDataGenerator();
        executor.setConfiguration(config);
        executor.run();

        assertTrue(true);
    }


}
