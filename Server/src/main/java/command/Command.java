package command; // Package declaration

import java.io.PrintWriter; // Importing PrintWriter class from java.io package

// Interface representing a command
public interface Command {

    // Method signature for executing a command, taking a PrintWriter as a parameter
    void execute(PrintWriter writer);
}
