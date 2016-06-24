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

package com.datiodb.sd.producer.strategy;

import com.datiodb.sd.input.AbstractSourceFromFile;

import java.security.SecureRandom;
import java.util.List;

public class ProductInfoStrategyFromFile extends AbstractSourceFromFile implements DataProducerStrategy<String[]> {

    private List<String> lines;
    private String delimiter;

    public ProductInfoStrategyFromFile(String pathToFile, String delimiter) {
        super(pathToFile);
        lines = (List<String>) this.getOptionList();
        this.delimiter = delimiter;
    }

    @Override
    public String[] create() {
        SecureRandom rnd = new SecureRandom();
        return lines.get(rnd.nextInt(lines.size() - 1)).split(delimiter);
    }

}
