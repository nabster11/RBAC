# RBAC

Components Used:

1) Maven

2) Java (JDK 8 or higher)

3) Guice (dependency injection)

4) Junit 4 (Unit tests)

5) Google Guava

##Entry point
Please look at com.rbac.Main

##How to run the system
I've kept maven exec plugin, if you have jdk 8+, maven 3 installed on your system.

Please run
```$xslt
mvn clean install exec:java
```
It should output this at the end of the execution.
```
Starting the system
 ------ Printing the output here ----------
true
true
true
false
false
false
false
true
true
true
false
--------- System Stop ----------------
```

## How packages are organized

As no database is used here, com.rbac.db defines users, roles and 
resources as in-memory store.

###db

UserDB:- defines list of users with userId and Set of roles

RolesDb:- defines list of roles with Valid action-types 
and a resource-id attached to it.

ResourceDB:- defines list of resources.

###guice
Responsible for dependency injection in the system.

###models
Pojo for user, role, resource

###enums
Defines enum in the application like ActionTypes (WRITE, DELETE, READ)

###dao
Responsible for exposing functions like add, remove, getAll id's for that particular entity.

###service
Meant for business logic, example:- given a userId, actionType and resource, output whether the userId is allowed to access the resource

## Unit tests
Please find it under tests/
