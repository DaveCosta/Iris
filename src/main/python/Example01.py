from pyspark import SparkConf, SparkContext

conf=SparkConf().setMaster("local").setAppName("iris")
sc=SparkContext(conf=conf)

