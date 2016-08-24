##########################################################
### Author: David Emanuel da Costa
### Email: david.emanuel.da.costa@gmail.com
### Creation date: 24/08/2016
### Updated: 24/08/2016

BINDIR=build

###########################################################

main : $(BINDIR)

$(BINDIR) : 
	@mkdir -p $@

###########################################################

.PHONY : clean pyrun

clean :
	@rm -rf $(BINDIR) 
	@find . -name ".DS_STORE" | xargs rm -f
	@find . -name "*~" | xargs rm -f

pyrun : src/main/python/Example01.py
	@spark-submit $<
    