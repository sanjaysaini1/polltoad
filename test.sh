#!/bin/bash

 while read line
 do 
 state=`echo $line|cut -d, -f1` 
 district=`echo $line|cut -d, -f2`
echo "insert into district(name,stateId) values ('$district', (select state_id from state where name like '$state'));"  
  done<states-districts.list 
