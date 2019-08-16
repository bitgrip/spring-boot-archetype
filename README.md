[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=de.bitgrip.archetypes%3Aspring-boot-service&metric=alert_status)](https://sonarcloud.io/dashboard?id=de.bitgrip.archetypes%3Aspring-boot-service) [![Build Status](https://travis-ci.org/bitgrip/spring-boot-archetype.svg?branch=master)](https://travis-ci.org/bitgrip/spring-boot-archetype) [![Maven Central](https://img.shields.io/maven-central/v/de.bitgrip.archetypes/spring-boot-service.svg)](http://search.maven.org/#search%7Cga%7C1%7Cde.bitgrip.archetypes)
# spring-boot-archetype
Archetype for generating a spring-boot service based on Spring Boot 2.1.6

It creates a typical spring-boot-service with Controller, Service and domain (data) layer. Additionally, it creates a FeignClient for access to this service based on API description.

## Usage

```mvn archetype:generate -DarchetypeGroupId=de.bitgrip.archetypes -DarchetypeArtifactId=spring-boot-service -DarchetypeVersion=0.1.0```

## Archetype Structure:

```
project
   |-- pom.xml
   |-- .editorconfig
   |-- api #API definition of the service
   |   |-- pom.xml
   |   `-- src
   |       |-- main
   |       |   `-- java
   |       `-- test
   |           `-- java
   |-- client #FeignClient based on API-Definition
   |   |-- pom.xml
   |   `-- src
   |       |-- main
   |       |   `-- java
   |       `-- test
   |           `-- java
   |-- controller #controller layer, implementation of the api, validation, mapping from API - Model to Domain-Model
   |   |-- pom.xml
   |   `-- src
   |       |-- main
   |       |   `-- java
   |       `-- test
   |           `-- java
   |-- service #service layer for business logic
   |   |-- pom.xml
   |   `-- src
   |       |-- main
   |       |   `-- java
   |       `-- test
   |           `-- java
   |-- domain #domain layer for persistence, defining Entities and Repositories
   |   |-- pom.xml
   |   `-- src
   |       |-- main
   |       |   `-- java
   |           ``- resources #includes liquibase scripts (in this example sql)
   |       `-- test
   |           `-- java
   |-- application #application, having the typical main class as application entrypoint
   |   |-- pom.xml
   |   `-- src
   |       |-- main
   |       |   `-- java
   |       `-- test
   |           `-- java
```


