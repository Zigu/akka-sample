package de.pincservices.akkasample.akka;


import akka.actor.Actor;
import akka.actor.Extension;
import akka.actor.Props;
import org.springframework.context.ApplicationContext;

public class SpringExtension implements Extension {

    private ApplicationContext applicationContext;

    public void initialize(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public Props props(String actorBeanName) {
        return Props.create(SpringActorByNameProducer.class, applicationContext, actorBeanName);
    }

    public Props props(Class<? extends Actor> actorClass) {
        return Props.create(SpringActorByClassProducer.class, applicationContext, actorClass);
    }
}
