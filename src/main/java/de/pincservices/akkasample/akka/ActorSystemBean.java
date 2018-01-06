package de.pincservices.akkasample.akka;

import akka.actor.Actor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.PreDestroy;

@Slf4j
public class ActorSystemBean {

    private final ActorSystem actorSystem;
    private final SpringExtension springExtension;

    public ActorSystemBean(ActorSystem actorSystem, SpringExtension springExtension) {
        this.actorSystem = actorSystem;
        this.springExtension = springExtension;
    }

    @PreDestroy
    public void terminateActorSystem() {
        log.info("Terminate actor system");
        actorSystem.terminate();
        log.info("Actor system terminated");
    }

    public ActorRef actorOf(Class<? extends Actor> actorClass) {
        return actorSystem.actorOf(springExtension.props(actorClass));
    }
}
