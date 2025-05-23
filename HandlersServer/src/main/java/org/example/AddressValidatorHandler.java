package org.example;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import javax.xml.namespace.QName;
import javax.xml.soap.Node;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import javax.xml.ws.soap.SOAPFaultException;

public class AddressValidatorHandler implements SOAPHandler<SOAPMessageContext>{
    @Override
    public boolean handleMessage(SOAPMessageContext context){
        System.out.println("Server: handleMessage() ");
        Boolean isRequest = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        if(!isRequest){ try{
            SOAPMessage soapMsg = context.getMessage();
            SOAPEnvelope soapEnv = soapMsg.getSOAPPart().getEnvelope();
            SOAPHeader soapHeader = soapEnv.getHeader();
            System.out.println("1");
            //if no header, add one
            if (soapHeader == null){
                soapHeader = soapEnv.addHeader();
                //throw exception
                generateSOAPErrMessage(soapMsg, "No SOAP header.");
            }

            //Get client mac address from SOAP header
            Iterator it = soapHeader.extractHeaderElements(SOAPConstants.URI_SOAP_ACTOR_NEXT);

            //if no header block for next actor found? throw exception
            if (it == null || !it.hasNext()){
                generateSOAPErrMessage(soapMsg, "No header block for next actor.");
            }
            System.out.println("2");
            //if no mac address found? throw exception
            Node username = (Node) it.next();
            String raw = (username  == null) ? null : username .getValue();
            System.out.println(raw);
            String[] userPass=raw.split(":");
            System.out.println(userPass[0] + " "+userPass[1]);
            if (userPass[0]== null || userPass[1] == null){
                generateSOAPErrMessage(soapMsg, "No password or username header block.");
            }


            //if mac address is not match, throw exception
            if(!userPass[0].equals("User") || !userPass[1].equals("Password")){
                generateSOAPErrMessage(soapMsg, "Invalid username or password, access is denied.");
            }

            //tracking
            soapMsg.writeTo(System.out);

        }
        catch(SOAPException e){
            System.err.println(e);
        }catch(IOException e){
            System.err.println(e);
        }}
        return true;
    }
    @Override
    public boolean handleFault(SOAPMessageContext context) {

        System.out.println("Server : handleFault()......");

        return true;
    }
    @Override
    public void close(MessageContext context) {
        System.out.println("Server : close()......");
    }
    @Override
    public Set<QName> getHeaders() {
        System.out.println("Server : getHeaders()......");
        return null;
    }
    private void generateSOAPErrMessage(SOAPMessage msg, String reason) {
        try {
            SOAPBody soapBody = msg.getSOAPPart().getEnvelope().getBody();
            SOAPFault soapFault = soapBody.addFault();
            soapFault.setFaultString(reason);
            throw new SOAPFaultException(soapFault);
        }
        catch(SOAPException e) { }
    }
}
