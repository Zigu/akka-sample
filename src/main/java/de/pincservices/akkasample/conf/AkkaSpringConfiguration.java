package de.pincservices.akkasample.conf;

import akka.actor.ActorSystem;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import de.pincservices.akkasample.akka.ActorSystemBean;
import de.pincservices.akkasample.akka.SpringExtension;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AkkaSpringConfiguration {


    @Bean
    public SpringExtension springExtension() {
        return new SpringExtension();
    }

    @Bean
    public ActorSystemBean actorSystem(SpringExtension springExtension, ApplicationContext applicationContext) {
        ActorSystem system = ActorSystem.create("AkkaTaskProcessing", akkaConfiguration());
        springExtension.initialize(applicationContext);
        return new ActorSystemBean(system, springExtension);
    }

    @Bean
    public Config akkaConfiguration() {
        return ConfigFactory.load();
    }
}
