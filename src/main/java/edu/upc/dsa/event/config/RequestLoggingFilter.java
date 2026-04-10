package edu.upc.dsa.event.config;

import org.apache.log4j.Logger;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class RequestLoggingFilter implements ContainerRequestFilter, ContainerResponseFilter {

    private static final Logger LOGGER = Logger.getLogger(RequestLoggingFilter.class);
    private static final String START_TIME_PROPERTY = "request-start-nanos";

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        requestContext.setProperty(START_TIME_PROPERTY, System.nanoTime());
    }

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        Object startObj = requestContext.getProperty(START_TIME_PROPERTY);
        long elapsedMs = -1;

        if (startObj instanceof Long) {
            elapsedMs = (System.nanoTime() - ((Long) startObj)) / 1_000_000;
        }

        String method = requestContext.getMethod();
        String path = requestContext.getUriInfo().getRequestUri().toString();
        int status = responseContext.getStatus();

        if (elapsedMs >= 0) {
            LOGGER.info(method + " " + path + " -> " + status + " (" + elapsedMs + " ms)");
        } else {
            LOGGER.info(method + " " + path + " -> " + status);
        }
    }
}
