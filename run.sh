sbt package
spark-submit \
   --class org.mephys.sc.iris.Iris \
   --master local[2] \
   target/scala-2.11/iris_2.11-0.1.jar
