# Project1 wikipedia viewcount
This project takes data files from wikipedia of how many views each page has as retrievable here https://dumps.wikimedia.org/other/pageviews/

It then combines the views from each country and discards any pieces with less than 100 views

## Technologies Used

* Hadoop
* Big-Data-Europe's hadoop docker container - https://github.com/big-data-europe/docker-hadoop
* More in 2nd part at the link at the bottom of this README

## Features

List of features ready and TODOs for future development
* Combine the the count of views from each region
* Discards any pages with less than 100 views
* Store the results in an easy to retrieve format

To-do list:
* Implement a Easy to understand script that can be ran for the below lines

## How to run
Set up Big Data Europes hadoop container
```bash
git clone https://github.com/big-data-europe/docker-hadoop && cd docker-hadoop
docker-compose up -d
```
prepare a jar and give it to the container
```bash
sbt assembly
docker cp target/scala-2.13/view-count-assembly-1.0.jar {NAMENODE CONTAINER ID}:view-count-assembly.jar
```
copy your data to the namenode container then access it and prepare the data
```bash
docker cp {YOUR WIKIPEDIA DATA PATH} {NAMENODE CONTAINER ID}:wikidata
docker exec -it namenode bash
mkdir input
mv wikidata input
hdfs dfs -put input/* input
```
While still in the name node container run the jar and view the data
```bash
hadoop jar view-count-assembly.jar input output
hdfs dfs -cat output/part-r-00000
```

## See Hive Data processing part of this project!
https://github.com/Trenton-Serpas/Tserpas-project1
