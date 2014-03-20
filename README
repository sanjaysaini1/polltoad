Polltoad - Twitter based political statistics application
==========================================================

Introduction:
--------------
The application polltoad is a web based application, which reads twitter data, to come up with statistics
regarding elections for the Indian Parliamentaty Elections of April-May 2014. The application reads the twitter firehose for data related to
either a politician, political party or a constituency. It then does an analysis to come up with trends based on the tweets.

The project is currently in development stage with following goals achieved:
- Creation of data for all Indian states(provinces), districts, constituencies, political parties.
- An application to enter new data on states, districts, constituencies, political parties and politicians
- Tabular display of all the data generated.

Following need to be done for creation of a basic application with all its goals achieved:
- Code for retrieving data for twitter 
- Code for analysing data from twitter
- RESTful Api for pushing of stats from analysis of twitter data
- Emberjs based single page application which consumes the RESTFul api to show user with the stats and analysis

Installation Requirements:
--------------------------
- Java version 6 or higher
- Play Framework vesion 2.1.3
- Mysql Database
- Git

Installation Steps:
---------------------
Please follow the following steps to install the application in its current state.

Create database:
- If you don't want to make changes to conf/application.conf file change password of user root to "password" (without quotes).You can alternatively 
change db.default.user to value of your choice and similar for db.default.password.
- Create Database polltoad in the mysql db.

Clone application:
- At command prompt run

	> git clone https://github.com/sanjaysaini1/polltoad.git

Run Application:
- After creation of database, in the application directory type 

	> play run.
- In your web browser open http://localhost:9000
- The evolution will ask you to "Apply this script". Click on the "Apply this script" button.
- You will get an application with 0 policians, 0 political parties etc.

 To populate the data tables do the following:
- go to sql directory in the application directory

	>cd sql	
- login to mysql to polltoad database and source fullrun.sql

	>mysql -p -u root

	mysql>use polltoad

	mysql>source fullrun.sql

- You will get fully populated tables.

On your web browser check http://localhost:9000/districts, you will see 647 districs. You can add by clicking add to add new districts.
Similarly you will see data in all tabs except politicians which has 0, you can add more politican by clicking the add.

--------------------------------------------------------------------------------------------------------------------------------------------------
