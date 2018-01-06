package de.pincservices.akkasample.controller;

import akka.actor.ActorRef;
import de.pincservices.akkasample.actors.TaskCreationActor;
import de.pincservices.akkasample.akka.ActorSystemBean;
import de.pincservices.akkasample.commands.CreateTask;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class TaskController {

    private ActorSystemBean actorSystemBean;

    public TaskController(ActorSystemBean actorSystemBean) {
        this.actorSystemBean = actorSystemBean;
    }

    @PostMapping("/tasks")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void createTask() {
        ActorRef taskActor = actorSystemBean.actorOf(TaskCreationActor.class);
        taskActor.tell(new CreateTask(UUID.randomUUID().toString(), "SampleTask"), ActorRef.noSender());
    }
}
