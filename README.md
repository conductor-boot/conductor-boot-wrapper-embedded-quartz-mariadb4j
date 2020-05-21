# Conductor Boot Wrapper - Quartz Bundle

conductor-quartz-workflow-scheduler-bundle

Conductor Boot Wrapper + Quartz Bundle = Conductor Quartz Workflow Scheduler Bundle


The idea is to build a single suite of loosely coupled open source tools to perform scheduling i.e. triggering a Netflix Conductor workflow at a defined time or regular intervals of time, with a pre defined input, WITHOUT THE NEED TO CODE (To the maximum extent possible), by implementing

 • Spring Boot - Quartz Scheduler - embedded MariaDB support & external MySQL DB support.


The catch point being, it will be a UI and Scheduler Jar  which will enable Conductor Workflows to be scheduled by user using UI interface 

How ? 

By bridging the communication with RestFUL JSON based web services / APIs.

By combining Quartz with Conductor, the Workflows that are otherwise triggered manually are now automatically triggered in scheduled manner and Quartz does the Scheduler part.

Though the idea of making Scheduler for Conductor is good, it still needs a lot of knowledge on JSON, to write up the Web Service calls and lot of knowledge on Quartz, to define the Scheduler part.

## Build Status - ![Java CI with Maven](https://github.com/conductor-boot/conductor-boot-wrapper-embedded-quartz-mariadb4j/workflows/Java%20CI%20with%20Maven/badge.svg)

## Pre-Requisites
1. openjdk8 or Java 8
2. Maven / mvn

## Setup Instructions

 • Clone / Download and extract the Repo

## Startup Instructions

 • To start the scheduler with embedded mariadb4j as persistence, use Maven run. 
To use a permanent Port for mariadb4j or persistent dataDir, please uncomment and provide corresponding details in application.yml
To use external mysql database as persistence unit, please change db=mysql and provide the DB url and driver class accordingly. The properties are already pasted , commented in application.yml file.

Also an important property to be configured in application.yml is conductor.server.api.endpoint , which internally is used to trigger the workflows through rest API call.

cd conductor-boot-wrapper-embedded-quartz-mariadb4j

mvn spring-boot:run

In case, you would like to package the jar first and then run.

mvn install

cd target

java -jar conductor-boot-wrapper-${conductor.version}-quartz.jar

Access the UI : http://localhost:8080/openapi (Quartz Swagger) and http://localhost:8080 (Conductor Swagger) 

## Screenshots

1) Swagger UI Home - Conductor Quartz Workflow Scheduler Jar

![alt text](https://raw.githubusercontent.com/maheshyaddanapudi/images/master/CQWSchedulerSwaggerUIHome.png)

2) Swagger UI - Conductor Quartz Workflow Scheduler - API Part 1

![alt text](https://raw.githubusercontent.com/maheshyaddanapudi/images/master/CQWSchedulerSwaggerUIAPI1.png)

3) Swagger UI - Conductor Quartz Workflow Scheduler - API Part 2

![alt text](https://raw.githubusercontent.com/maheshyaddanapudi/images/master/CQWSchedulerSwaggerUIAPI2.png)


## Motivation

There is a saying from recent times that "Every idea comes from a pain point"

Scheduler in daily IT life are more needed in areas where implementation of Microservice Orchestrators like Netflix Conductor etc. is done. As known, not everywhere is comfortable, easy to plugin scheduler without coding available.
For such scenarios, usually a dependency is created on external scheduler tools, usually org wide tools like Control M or Autosys. That is where Quartz came into picture to ease the scheduler dependency with some efficient standards. Then the final hurdle of making a framework which hosts the configured Schedules and executes the schedule on time or maintain a history of what happened to a configured schedule etc. 

To avoid all this pain of below listed, this idea of Conductor Boot Wrapper - Quartz Bundle came up.

 • Learning to code at least moderately even though it's an easier JSON API

 • Learning new, though simple tools, like Quartz

 • Dependency on external schedulers 


## Features

 • Schedule Netflix Conductor Workflows with Predefined inputs JSON payload, with a variety of Minute / Hourly / Daily / Weekly / Yearly scheduling options.

 • View a comprehensive list of all the Netflix Conductor Workflow trigger schedules, scheduled through Quartz & API

 • View a summary of run history of each and every Netflix Conductor Workflow trigger schedules, scheduled through Quartz & API


## Tech/framework used

 • conductor-server - Presumably downloaded from Maven repository

 • Java Spring Boot : Quartz + Mariadb4j

## Inspiration

 • Netflix Conductor

 • Quartz Scheduler


## Credits

 • Mahesh Yaddanapudi - zzzmahesh@live.com
