package org.acme;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Incoming;

import io.smallrye.reactive.messaging.MutinyEmitter;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/amqp")
public class AMQPChannels {

    @Incoming("in")
    public void consume(String message) {
        System.out.println("received " + message);
    }

    @Channel("out")
    MutinyEmitter<String> emitter;

    @POST
    @Path("/send")
    public void send(String message) {
        emitter.sendAndAwait(message);
    }

}
