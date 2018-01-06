package de.pincservices.akkasample.akka;

import akka.actor.Actor;
import akka.actor.IndirectActorProducer;
import org.springframework.context.ApplicationContext;

public class SpringActorByNameProducer implements IndirectActorProducer {

    private final ApplicationContext applicationContext;
    private final String actorBeanName;

    public SpringActorByNameProducer(ApplicationContext applicationContext,
                                     String actorBeanName) {
        this.applicationContext = applicationContext;
        this.actorBeanName = actorBeanName;
    }

    @Override
    public Actor produce() {
        return (Actor) applicationContext.getBean(actorBeanName);
    }

    @Override
    public Class<? extends Actor> actorClass() {
        return (Class<? extends Actor>) applicationContext.getType(actorBeanName);
    }
}
