package de.kaiserpfalzedv.ocpmeetup.knative;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Map;
import java.util.TreeMap;

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

    @ConfigProperty(name = "K_REVISION", defaultValue = "-pod-name-not-set-")
    String revision;

    @ConfigProperty(name = "HOSTNAME", defaultValue = "-pod-name-not-set-")
    String podName;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String greet() {
        Map<String, String> env = new TreeMap<>(System.getenv());

        StringBuilder result = new StringBuilder("Hello from ")
                .append(podName).append("(").append(revision).append("), ")
                .append(target).append("!\n");

        for (String key :
                env.keySet()) {
            result.append("\n").append(key).append("=").append(env.get(key));
        }

        return result.toString();
    }
}
