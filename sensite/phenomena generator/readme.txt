Phenomena Generator version v1.0
joon812@gmail.com Sung Baek

steps/descriptions:

1.  Pass html file into web.sh 
2.  web.sh will extract wikipedia objects
 (specifically wikipedia table entires that are not categories or help)
3.  Keep the outputs from web.sh in one file 
 (ex: cat output.txt >> holder.txt)
4. Pass the file with all the outputs to "text.sh"
 (ex: ./text.sh < holder.txt)
 text.sh will do following things
	1) remove duplicates
	2) convert everything to lower cases
	3) fix chracter errors
		(ex: "-" breaks sometimes and " ' ")
5.  Push the textfile into MongoDB.  