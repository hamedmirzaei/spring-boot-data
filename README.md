# Spring Boot + Spring Data

This is a simple example to show you how Spring Data works with Spring Boot.

# Libraqries and Tools
* [Module] `Spring Boot`
* [Module] `Spring Data`
* [Library for auto-generating getters, setters, constructors, slf4j and others] `Lombok`
* [Database] `H2`

# How it works
It is just a maven Spring Boot application which you can build and run it like any other Spring Boot application. 
It has a `Customer` entity and a `CustomerRepository` interface. There is no implementation for that interface
and `Spring Data` will handle that for us. `H2` has been used as the in-memory database. Also, `Lombok` has been used to generate constructors, getter and setter methods, toString method and slf4j log.
