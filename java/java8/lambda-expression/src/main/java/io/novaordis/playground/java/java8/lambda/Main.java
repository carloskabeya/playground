/*
 * Copyright (c) 2016 Nova Ordis LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.novaordis.playground.java.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ovidiu Feodorov <ovidiu@novaordis.com>
 * @since 11/27/16
 */
public class Main {

    // Constants -------------------------------------------------------------------------------------------------------

    // Static ----------------------------------------------------------------------------------------------------------

    public static void main(String[] args) throws Exception {

        //
        // we declare state in the closure's context, so the closure can access it from wherever it is invoked
        //

        List<String> results = new ArrayList<>();

        operateOnDataInAnotherScope((String s) -> {

            //
            // perform arbitrary processing on data ...
            //

            String result = Character.toUpperCase(s.charAt(0)) + s.substring(1);

            //
            // ... and collect it in the array from the closure's scope
            //

            results.add(result);
        });

        //
        // display the results
        //

        //noinspection Convert2streamapi
        for(String r: results) {

            System.out.println(r);
        }
    }

    private static void operateOnDataInAnotherScope(Closure closure) {

        //
        // this array in outside the scope of the closure
        //

        List<String> colors = new ArrayList<>(Arrays.asList("blue", "red", "green"));

        //noinspection Convert2streamapi
        for(String color: colors) {

            closure.behavior(color);
        }
    }

    // Attributes ------------------------------------------------------------------------------------------------------

    // Constructors ----------------------------------------------------------------------------------------------------

    // Public ----------------------------------------------------------------------------------------------------------

    // Package protected -----------------------------------------------------------------------------------------------

    // Protected -------------------------------------------------------------------------------------------------------

    // Private ---------------------------------------------------------------------------------------------------------

    // Inner classes ---------------------------------------------------------------------------------------------------

}
