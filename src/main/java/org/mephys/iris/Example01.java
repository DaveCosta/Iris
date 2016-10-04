package org.mephys.iris;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.*;


public class Example01 {

    public static void main(String[] args) {
	 SparkConf conf = new SparkConf().setAppName("Iris").setMaster("local");
         JavaSparkContext context = new JavaSparkContext(conf);
    }
}
