# search api status

[![Build Status](https://travis-ci.com/chorpitman/search-api.svg?branch=master)](https://travis-ci.com/chorpitman/search-api)

Prerequisites
==============
| **Tool** | **Required Version** | **How to check**  | **Comments** |
| ----- | ------ | ---- | ---- |
| Java | 1.8.x | java -version | |
| Maven | 3.2.3 or 3.2.5 | mvn -version | Newer versions should also work |
| Git | any (latest preferable) | git --version | |
| PostgreSQL | 9.5 |  | Newer versions should also work|

Setup
======
Java
----------
Download and install latest JDK from `http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html`

PostgreSQL settings
----------
 1. create databse: **api_db**
 2. change user name to: **postgres**
 3. change password to: **root**
 4. change datasource.url: **jdbc:postgresql://localhost:5432/api_db**
or make changes in application.properties file

Endpoints  
----------
> GET `http://localhost:8080/hello/contacts?nameFilter=^A.*$`

> GET `http://localhost:8080/hello/contacts?nameFilter=^.*[AEI].*$`

Before you send request you make sure that pattern is url encoded.
for example:
 - `^A.*$` the same `%5EA.*%24`
 - `^.*[AEI].*$` the same `%5E.*%5BAEI%5D.*%24%20`
[online url decoder/encoder](https://meyerweb.com/eric/tools/dencoder/)

Enable Lombok
-----------

Run Project
-----------

    $ mvn spring-boot:run
