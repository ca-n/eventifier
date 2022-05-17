# Eventifier
Système de Gestion d'Événements
Eventifier est un site internet où l’on peut soumettre et s'inscrire aux événements (ex.: conférences). 

## Backend
### Requirements

For building and running the application you need:

- [JDK 1.17](https://www.oracle.com/java/technologies/downloads/#java17)
- [Maven 3](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `xyz.carn.eventifier.EventifierApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

## Frontend
### Prerequisites

#### Install Node JS
Refer to https://nodejs.org/en/ to install nodejs

#### Install create-react-app
Install create-react-app npm package globally. This will help to easily run the project and also build the source files easily. Use the following command to install create-react-app

```bash
npm install -g create-react-app
```

## Cloning and Running the Application in local

Clone the project into local

Install all the npm packages. Go into the project folder under 'eventifier-react' and type the following command to install all npm packages

```bash
npm install
```

In order to run the application Type the following command

```bash
npm start
```

The Application Runs on **localhost:3000**
