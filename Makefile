##########################################################
### Author: David Emanuel da Costa
### Email: david.emanuel.da.costa@gmail.com
### Creation date: 24/08/2016
### Updated: 05/10/2016

BUILDDIR=target/make

###########################################################

main : $(BUILDDIR) run.sh

$(BUILDDIR) : 
	@mkdir -p $@


###########################################################

run.sh : 
	@echo sbt package > $@
	@echo "spark-submit \\" >> $@
	@echo "--class "org.mephys.sc.iris.Iris" \\" >> $@
	@echo "--master local[2] \\" >> $@
	@echo "target/scala-2.11/iris_2.11-0.1.jar" >> $@
	@chmod u+x $@

###########################################################

.PHONY : clean cleandeep sync pyrun scrun jvmrun


clean :
	@rm -rf $(BUILDDIR) 
	@find . -name ".DS_STORE" | xargs rm -f
	@find . -name "*~" | xargs rm -f

cleandeep :
	@rm -rf .classpath .gradle .idea .project .settings
	@rm -rf project build target *.iml

pyrun : src/main/python/Example01.py
	@spark-submit $<

scrun : target/scala-2.11/iris_2.11-0.1.jar
	@spark-submit \
	--class "org.mephys.sc.iris.Example01" \
	--master local[2] \
	$<

jvmrun : target/iris-0.1.jar    
	@spark-submit \
	--class "org.mephys.iris.Example01" \
	--master local[2] \
	$<

sync :
	@git push -u origin master
