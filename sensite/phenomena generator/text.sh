#! /bin/bash

sed 's/([^)]*)//g' |
sed 's/-/ /g' |
sed 's/%e2%80%93/ /g' |
sed 's/#[^9]*9//g' |
sed "s/%27/\'/g" |
sed 's/_/ /g' |
tr '[:upper:]' '[:lower:]' |
sort -u
