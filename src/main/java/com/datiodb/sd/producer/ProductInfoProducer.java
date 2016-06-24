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

package com.datiodb.sd.producer;

import com.datiodb.sd.data.AbstractData;
import com.datiodb.sd.data.MultipleStringAbstractBase;
import com.datiodb.sd.producer.strategy.DataProducerStrategy;

public class ProductInfoProducer implements DataProducer {

    private DataProducerStrategy<?> strategy;
    private String delimiter;

    public ProductInfoProducer(String delimiter) {
        this.delimiter = delimiter;
    }

    @Override
    public DataProducer setStrategy(DataProducerStrategy<?> strategy) {
        this.strategy = strategy;
        return this;
    }

    @Override
    public AbstractData createData() {
        return new ProductInfo(new String[]{"PRODUCT_ID", "PRICE"});
    }

    private class ProductInfo extends MultipleStringAbstractBase {

        private ProductInfo(String... names) {
            super(names);
        }

        @Override
        public String getGenerateValue() {
            StringBuilder buffer = new StringBuilder();
            String[] fields = (String[]) strategy.create();
            for (int i = 0; i < fields.length; i++) {
                buffer.append(fields[i]);
                if (i != fields.length - 1) {
                    buffer.append(delimiter);
                }
            }
            return buffer.toString();
        }

    }

}
