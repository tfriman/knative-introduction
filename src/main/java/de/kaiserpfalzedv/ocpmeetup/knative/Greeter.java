package de.kaiserpfalzedv.ocpmeetup.knative;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * The default greeter returning a hello world ...
 *
 * @author rlichti
 * @version 1.0.0 2020-09-12
 * @since 1.0.0 2020-09-12
 */
@Path("/")
public class Greeter {
    @ConfigProperty(name = "TARGET", defaultValue="World")
    String target;

    @ConfigProperty(name = "PODNAME", defaultValue = "-pod-name-not-set-")
    String podName;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String greet() {
        return "Hello from pod '" + podName + "', " + target + "!";
    }
}
