package org.acme;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @GET
    @Transactional
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        MyEntity myEntity = new MyEntity();
        myEntity.field = "hello";
        myEntity.persist();
        return "Hello from Quarkus REST";
    }
}
