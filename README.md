# Evidence Pojistnych Udalosti Wrapper
Database wrapper study for my project that shows approximate functionality of an app an a real database tables


## Motivation

The second step towards programming my first database app, this console application communicates with two database tables through manually written queries using JDBC technology


## Technologies

- Java 11
- mysql-connector-java-8.0.28
- MySQL



### To run this console app you should install the technologies as above and create to tables in your database as shown:


> **Pojistene**:
> 
> | id | jmeno | prijmeni | datum_narozeni | tel_cislo | email |
> |:--:| :---: | :------: | :------------: | :-------: | :---: |
> |    |       |          |                |           |       |
> 

> **Pojisteni**:
> 
> | id | pojisteny_id | nazev_pojisteni | typ_pojisteni | pojistna_castka |
> |:--:| :----------: | :-------------: | :-----------: | :-------------: |
> |    |              |                 |               |                 | 
> 



### The database should have a name as evidence_pojistnych_udalosti or you can change this in each function in *Pojisteny* and *Pojisteni* classes.



> **Instead, you can just copy and paste next SQL queries**:
> 
> ```sql 
> {
>     CREATE DATABASE `evidence_pojistnych_udalosti` CHARACTER SET utf8 COLLATE utf8_czech_ci;
> }
> ```
> 
> ```sql 
> {
>     CREATE TABLE `pojistene` (
> 	    id int AUTO_INCREMENT,
> 	    jmeno VARCHAR (30),
> 	    prijmeni VARCHAR (30),
> 	    datum_narozeni date,
> 	    tel_cislo VARCHAR (13),
> 	    email VARCHAR (60),
> 	    PRIMARY KEY (id)
>     );
> 
> }
> ```
> 
> ```sql 
> {
>     CREATE TABLE `pojisteni` (
> 	    id int AUTO_INCREMENT,
> 	    pojisteny_id int,
> 	    nazev_pojisteni VARCHAR (100),
> 	    typ_pojisteni VARCHAR (100),
> 	    pojistna_castka int,
> 	    PRIMARY KEY (id)
>     );
> 
> }
> ```
> 



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

## Security

> Database security of this app is managed by the { Database.query() } function, it uses { setObject() } function to protect application from SQL injections