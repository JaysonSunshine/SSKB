#! /bin/bash

grep "<li><a href" |
grep -o "wiki\/[^\"]*" |
sed "s/wiki\///g" |
sed "s/_/\ /g" |
grep -v "Help" |
grep -v "Category" |
grep -v "list" |
tr '[:upper:]' '[:lower:]' 
