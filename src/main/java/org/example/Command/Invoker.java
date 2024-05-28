package org.example.Command;

import java.io.PrintWriter;
import java.util.Map;
import java.util.HashMap;

public class Invoker {
    private Map<String, Command> commands;

    public Invoker() {
        commands = new HashMap<>();
    }

    public void registerCommand(String commandName, Command command) {
        commands.put(commandName, command);
    }

    public void executeCommand(String commandName, PrintWriter writer) {
        Command command = commands.get(commandName);
        if (command != null) {
            command.execute(writer);
        } else {
            System.out.println("No command registered for: " + commandName);
        }
    }
}

