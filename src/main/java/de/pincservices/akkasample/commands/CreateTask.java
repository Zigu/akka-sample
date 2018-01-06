package de.pincservices.akkasample.commands;

import lombok.Value;

@Value
public class CreateTask {

    private String id;
    private String name;
}
