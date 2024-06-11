package Command; // Package declaration

import java.io.PrintWriter; // Importing PrintWriter class from java.io package
import java.util.Map; // Importing Map interface from java.util package
import java.util.HashMap; // Importing HashMap class from java.util package

// Class responsible for invoking commands
public class Invoker {
    private Map<String, Command> commands; // Declaring a private member variable to store commands

    // Constructor to initialize the Invoker with an empty map of commands
    public Invoker() {
        commands = new HashMap<>(); // Initializing the commands map as an empty HashMap
    }

    // Method to register a command with a command name
    public void registerCommand(String commandName, Command command) {
        commands.put(commandName, command); // Putting the command into the commands map with the specified name
    }

    // Method to execute a command by its name
    public void executeCommand(String commandName, PrintWriter writer) {
        Command command = commands.get(commandName); // Retrieving the command associated with the specified name
        if (command != null) { // Checking if the command exists
            command.execute(writer); // Executing the command by passing the PrintWriter
        } else {
            System.out.println("No command registered for: " + commandName); // Printing a message if the command is not found
        }
    }
}
