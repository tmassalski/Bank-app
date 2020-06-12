(Work in progress)

This is simple bank application with REST api that consumes Kafka messages created by Auction-app https://gitlab.com/tmassalski/auction-app.

To create user, use POST request to {ip_address}:8081/bank-app/users/create

{
  "email": "string",
  "firstName": "string",
  "lastName": "string",
  "login": "string",
  "password": "string"
}

To create account, use POST request to  {ip_address}:8081/bank-app/accounts/users/{userId}

All endpoints are available via Swagger under {ip_address}:8081/bank-app/swagger-ui.html

To provide communication between Bank-app and Auction-app you need Kafka server
https://kafka.apache.org/quickstart
To Start zookeeper on Windows machine:
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
To Start Kafka server on Windows machine:
.\bin\windows\kafka-server-start.bat .\config\server.properties

Application will consume messages published on "transfer" topic.