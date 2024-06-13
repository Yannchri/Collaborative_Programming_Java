# Collaborative Programming - Twint-like System

## Description
This Java-developed project establishes communication between a server and a client using `.jar` files. 
It leverages three principal design patterns: 
- Chain of Responsibility
- Command
- State 
 
These design patterns enhance the system's modularity and extensibility. 
The "Twint-like" allows real-time interaction between users and the server.

## Installation
To install and run this project, follow these steps:
1. Download the `.jar` files from the GitHub repository.
2. Open a terminal or command prompt.
3. Navigate to the directory where you saved the files.
4. To launch the server, execute the following command:
```
java -jar Server.jar
```

5. To launch the client, execute in another terminal:
```
java -jar Client.jar
```


## Usage
Once the server and client applications are launched:
- **Server**: The server automatically starts listening for incoming connections.
- **Client**: Connect the client to the server by specifying the server's IP address. Once connected, you will be able to send and receive messages in real-time. The client interface also allows sending specific commands to interact with the server.
- The client interface allows sending specific commands to interact with the server.

- The usage of the program is described in the User Manual.