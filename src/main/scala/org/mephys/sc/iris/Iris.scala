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

package org.mephys.sc.iris

import org.apache.spark.mllib.tree.DecisionTree
import org.apache.spark.mllib.tree.model.DecisionTreeModel
import org.apache.spark.mllib.util.MLUtils
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf
import org.apache.spark.mllib.linalg.{ Vector, Vectors }
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.rdd.RDD

object Iris {

  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("org.mephys.sc.iris.Example01")
    val sc = new SparkContext(conf)

    val lines = sc.textFile("src/main/resources/iris.data")

    val rdd: RDD[LabeledPoint] = lines filter (line => !line.isEmpty) map { line =>
      val v = line.split(",")
      LabeledPoint(v(4) match {
        case "Iris-setosa" => 0.0
        case "Iris-versicolor" => 1.0
        case "Iris-virginica" => 2.0
        case _ => -1.0 // should never occur
      }, Vectors.dense(v(0).toDouble, v(1).toDouble, v(2).toDouble, v(3).toDouble))
    }

    val Array(data, test) = rdd.randomSplit(Array(0.8,0.2))

    // Count
    println("#data = "+data.count)
    println("#test = "+test.count)

    // Train a DecisionTree model.
    //  Empty categoricalFeaturesInfo indicates all features are continuous.
    val numClasses = 3
    val categoricalFeaturesInfo = Map[Int, Int]()
    val impurity = "gini"
    val maxDepth = 5
    val maxBins = 32

    val model = DecisionTree.trainClassifier(data, numClasses, categoricalFeaturesInfo,
      impurity, maxDepth, maxBins)

    test.foreach{
      element =>
      println(element.label + "=" + model.predict(element.features))
    }

println("Learned classification tree model:\n" + model.toDebugString)
    
  }
}
