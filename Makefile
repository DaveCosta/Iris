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

.PHONY : clean

clean :
	@rm -rf $(BINDIR) 
	@find . -name ".DS_STORE" | xargs rm -f
	@find . -name "*~" | xargs rm -f
	
