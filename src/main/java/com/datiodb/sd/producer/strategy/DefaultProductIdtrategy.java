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

import java.security.SecureRandom;

public class DefaultProductIdtrategy implements DataProducerStrategy<String> {
    private static final String LETTER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";

    @Override
    public String create() {
        StringBuilder buffer = new StringBuilder();
        SecureRandom rnd = new SecureRandom();
        for (int i = 0; i < 2; i++) {
            buffer.append(LETTER.charAt(rnd.nextInt(LETTER.length())));
        }
        for (int i = 0; i < 10; i++) {
            buffer.append(DIGITS.charAt(rnd.nextInt(DIGITS.length())));
        }
        buffer.append(LETTER.charAt(rnd.nextInt(LETTER.length())));
        return buffer.toString();
    }

}
