package org.example;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Set;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class InjectHandler  implements SOAPHandler<SOAPMessageContext>{

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
    System.out.println("Client : handleMessage()......");
    Boolean isRequest = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        if(isRequest){
            try{
                SOAPMessage soapMsg = context.getMessage();
                SOAPEnvelope soapEnv = soapMsg.getSOAPPart().getEnvelope();
                SOAPHeader soapHeader = soapEnv.getHeader();
                if (soapHeader == null){
                    soapHeader = soapEnv.addHeader();
                }
                String test="User";
                QName qname = new QName("http://localhost:9999/WebServicesGlass/hello", "test");
                SOAPHeaderElement soapHeaderElement = soapHeader.addHeaderElement(qname);
                soapHeaderElement.setActor(SOAPConstants.URI_SOAP_ACTOR_NEXT);
                soapHeaderElement.addTextNode("User");
                soapHeaderElement.addTextNode(":Password");
                soapMsg.saveChanges();
                soapMsg.writeTo(System.out);
            }catch(SOAPException e){
                System.err.println(e);
            }catch(IOException e){
                System.err.println(e);
            }
        }
        return true;
    }
    @Override
    public boolean handleFault(SOAPMessageContext context) {
        System.out.println("Client : handleFault()......");
        return true;
    }

    @Override
    public void close(MessageContext context) {
        System.out.println("Client : close()......");
    }

    @Override
    public Set<QName> getHeaders() {
        System.out.println("Client : getHeaders()......");
        return null;
    }
    private String getMACAddress(){

        InetAddress ip;
        StringBuilder sb = new StringBuilder();

        try {

            ip = InetAddress.getLocalHost();
            System.out.println("Current IP address : " + ip.getHostAddress());

            NetworkInterface network = NetworkInterface.getByInetAddress(ip);

            byte[] mac = network.getHardwareAddress();

            System.out.print("Current MAC address : ");

            for (int i = 0; i < mac.length; i++) {

                sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));

            }
            System.out.println(sb.toString());

        } catch (UnknownHostException e) {

            e.printStackTrace();

        } catch (SocketException e){

            e.printStackTrace();

        }

        return sb.toString();
    }

}
