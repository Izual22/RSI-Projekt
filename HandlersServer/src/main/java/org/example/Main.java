package org.example;
import javax.xml.ws.Endpoint;

public class Main {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9999/WebServicesGlass/hello", new Impl());
        System.out.println("Web serwis cheka na klienta...");
    }

}