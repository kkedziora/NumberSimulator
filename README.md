
#### About The Project

Application does operation on random numbers from different sources

Sources:
1. Java random numbers
2. www.random.org

#### Technologies
- Java 11
- Spring Boot 2.3.X
- Gradle
    
#### Run the Application

To run the application, run the following command in a terminal window:
gradlew bootRun

Application running on default port 8090

#### REST Api
**GET http://localhost:8090/api/number-operations/results/integers?operationType=?&sources=?**

Using parameter you can configure:
* operationType - type of operation [ ADDITION, SUBTRACTION ]
* sources - list of sources [ SYSTEM, WEB ]

Example:
GET http://localhost8090/api/number-operations/results/integers?operationType=ADDITION&sources=WEB&sources=SYSTEM

That will return result of adding integer numbers
