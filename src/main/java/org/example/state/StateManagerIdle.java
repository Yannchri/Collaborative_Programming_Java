package org.example.state;

public class StateManagerIdle implements StateManager {

    @Override
    public void connection() {
        System.out.println("Connexion");
    }

    @Override
    public void disconnection() {
        System.out.println("Deconnexion");
    }
}
