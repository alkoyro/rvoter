# rvoter
Restaurant voter

## How do I get set up? ##

### Dependencies ###
* [JDK 6 (or later)](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
* [Tomcat 7 (or later)](http://tomcat.apache.org/index.html)
* [MySQL 5.5 (or later)](https://www.mysql.com/downloads/)
* [Maven 3.0.5 (or later)](https://maven.apache.org/download.cgi)
* [Git](https://git-scm.com/downloads)

### Configuration ###

### Database configuration ###

### Running Application (cURL) ###
* Login into app
```
curl -X GET "http://localhost:8080/rv-rest/login" --data "username=root&password=root"
```
** Note: response will return an X-AUTH-TOKEN which will be used for accessing protected resources (via header)

* Load all restaurants
```
curl -H "X-AUTH-TOKEN:YOUR_TOKEN" -H "Content-Type: application/json" -X GET "http://localhost:8080/rv-rest/restaurants?page=0&size=15"
```

### Other guidelines ###
