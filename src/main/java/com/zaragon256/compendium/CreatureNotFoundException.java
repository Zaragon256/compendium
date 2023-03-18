package com.zaragon256.compendium;

public class CreatureNotFoundException extends RuntimeException{
    public CreatureNotFoundException(Long id) {
        super("Could not find creature " + id);
    }
}
