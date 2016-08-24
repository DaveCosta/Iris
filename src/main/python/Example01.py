from pyspark import SparkConf, SparkContext
from pyspark.mllib.tree import DecisionTree, DecisionTreeModel
from pyspark.mllib.util import MLUtils

resources = "src/resources"

conf=SparkConf().setMaster("local").setAppName("iris")
sc=SparkContext(conf=conf)

log4jLogger = sc._jvm.org.apache.log4j
LOGGER = log4jLogger.LogManager.getLogger(__name__)
LOGGER.info("pyspark script logger initialized")

lines = sc.textFile(resources + "/iris.data")

print lines.count()



