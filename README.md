# api_task

api_task is a project which contains tests to check CRUD operations on users.

## Installation

Before running tests make sure JVM and Maven are installed and set up.

## Usage

To run test navigate to the project directory and execute the following command:

- for Windows(Powershell)
```bash
mvn clean test -DsuiteXmlFile="./src/test/java/XMLs/testng.xml"
```
- for MacOS(terminal)
```bash
mvn clean test -DsuiteXmlFile=./src/test/java/XMLs/testng.xml
```bash

To see Allure reports execute the following in the same project directory:

```bash
allure serve allure-results
```
