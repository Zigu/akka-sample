package de.pincservices.akkasample.actors;

import akka.actor.AbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import de.pincservices.akkasample.commands.CreateTask;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class TaskCreationActor extends AbstractActor {

    private final LoggingAdapter log = Logging.getLogger(getContext().system(), TaskCreationActor.class.getSimpleName());

    @Override
    public Receive createReceive() {
        return receiveBuilder().match(CreateTask.class, command -> log.info("I should create task " + command)).build();
    }
}
