package org.example;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.ws.Endpoint;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws DatatypeConfigurationException {
        Endpoint.publish("http://localhost:9999/WebServicesGlass/hello", new Impl());
        System.out.println("Web service waits for client...");
    }

}