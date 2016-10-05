/*
Copyright (c) 2016 David Emmanuel Costa

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
package org.mephys.iris;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.*;


public class Example01 {

    public static void main(String[] args) {
	 SparkConf conf = new SparkConf().setAppName("Iris").setMaster("local");
         JavaSparkContext context = new JavaSparkContext(conf);
       
    }
}
