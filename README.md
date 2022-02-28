# Evidence Pojistnych Udalosti Wrapper
Database wrapper study for my project that shows approximate functionality of an app an a real database tables


## Motivation

The second step towards programming my first database app, this console application communicates with two database tables through manually written queries


## Technologies

- Java 11
- mysql-connector-java-8.0.28
- MySQL



### To run this console app you should install the technologies as above and create to tables in your database as shown:


<mark>Pojistene:</mark>

| id | jmeno | prijmeni | datum_narozeni | tel_cislo | email |
|:--:| :---: | :------: | :------------: | :-------: | :---: |
|    |       |          |                |           |       |


<mark>Pojisteni:</mark>

| id | pojisteny_id | nazev_pojisteni | typ_pojisteni | pojistna_castka |
|:--:| :----------: | :-------------: | :-----------: | :-------------: |
|    |              |                 |               |                 | 


The database should have a name as <mark>evidence_pojistnych_udalosti</mark> or you can change this in each function in Pojisteny and Pojisteni classes.



## Features

Console application has functionality approximately as future application should have:

- Create of Insured person (Pojisteny)
- Create of insurance (Pojisteni)
- Show detail of insured, including his insurance
- Show detail of insurance
- Show list of insured
- Delete insured, include with his insurance
- Delete insurance
- Edit ensured
- Edit insurance of insured
