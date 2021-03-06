package be.jcrafters.pastebin;

import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import be.jcrafters.pastebin.event.DumpEvent;
import be.jcrafters.pastebin.event.listeners.DumpEventPersisterBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/dump")
public class DumpRestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(DumpRestController.class);

    @Inject DumpRecogniser dumpRecogniser;
    @Inject BeanManager beanManager;

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String dumpPost(String dump) {
        LOGGER.info("hello");
        LOGGER.info(dump);


        beanManager.fireEvent(dump, () -> DumpEvent.class);

        return dump;
    }
}
