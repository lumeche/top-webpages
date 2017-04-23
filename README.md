# top-webpages
This is a simple project to play a bit with spring-boot and angular together.

It consist of a simple application who stores some data related to the most visited web sited weekly

1. The back-end was made with JAVA using spring-boot. 
2. The front-end was made using AngularJS and bootstrap.
3. It is backed by a H2 database embedded in the same application for simplicity

##Interfaces available
It exposes three ways to get data.
1. There is a webpage that allows filtering the top visited websited by date or by URL
2. Since the front-end is made angular, it consumes a REST API that provides json objects
3. To illustrate the template support of spring-boot, also was created an extra acces point that generates a CSV file with the content of the database
 

## How to compile the application
```bash
mvn clean package
```
## To run the application
```bash
java -jar ./target/top-webpages-0.0.1-SNAPSHOT.jar 
```
 
## Heroku
This application was deployed in heroku. So it can be acceded online throw the following URL
```html
https://serene-depths-79791.herokuapp.com/
```

## REST API paths
| PATH | Resource offered |
| ------ | ------ |
| /visits | Full list of visit records stored in the database in csv format|
| /visitByURL?url=<website> | All the visits for the given website in json|
| /topVisits/{dateInWeek} | Top 5 visits for the week in the date provided in json |

 
 
 
 