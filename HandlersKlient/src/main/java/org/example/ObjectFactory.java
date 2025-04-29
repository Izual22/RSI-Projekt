
package org.example;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.example package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetInfoResponse_QNAME = new QName("http://example.org/", "getInfoResponse");
    private final static QName _EditResponse_QNAME = new QName("http://example.org/", "editResponse");
    private final static QName _GetById_QNAME = new QName("http://example.org/", "getById");
    private final static QName _GetEventByDateResponse_QNAME = new QName("http://example.org/", "getEventByDateResponse");
    private final static QName _GetIdResponse_QNAME = new QName("http://example.org/", "getIdResponse");
    private final static QName _GetServerNameResponse_QNAME = new QName("http://example.org/", "getServerNameResponse");
    private final static QName _Make_QNAME = new QName("http://example.org/", "make");
    private final static QName _GetByIdResponse_QNAME = new QName("http://example.org/", "getByIdResponse");
    private final static QName _GetEventByDate_QNAME = new QName("http://example.org/", "getEventByDate");
    private final static QName _MakeResponse_QNAME = new QName("http://example.org/", "makeResponse");
    private final static QName _GetInfo_QNAME = new QName("http://example.org/", "getInfo");
    private final static QName _Edit_QNAME = new QName("http://example.org/", "edit");
    private final static QName _GetByWeek_QNAME = new QName("http://example.org/", "getByWeek");
    private final static QName _GetId_QNAME = new QName("http://example.org/", "getId");
    private final static QName _GetByWeekResponse_QNAME = new QName("http://example.org/", "getByWeekResponse");
    private final static QName _GetServerName_QNAME = new QName("http://example.org/", "getServerName");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.example
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetEventByDate }
     * 
     */
    public GetEventByDate createGetEventByDate() {
        return new GetEventByDate();
    }

    /**
     * Create an instance of {@link MakeResponse }
     * 
     */
    public MakeResponse createMakeResponse() {
        return new MakeResponse();
    }

    /**
     * Create an instance of {@link GetByIdResponse }
     * 
     */
    public GetByIdResponse createGetByIdResponse() {
        return new GetByIdResponse();
    }

    /**
     * Create an instance of {@link GetInfo }
     * 
     */
    public GetInfo createGetInfo() {
        return new GetInfo();
    }

    /**
     * Create an instance of {@link Edit }
     * 
     */
    public Edit createEdit() {
        return new Edit();
    }

    /**
     * Create an instance of {@link GetByWeek }
     * 
     */
    public GetByWeek createGetByWeek() {
        return new GetByWeek();
    }

    /**
     * Create an instance of {@link GetId }
     * 
     */
    public GetId createGetId() {
        return new GetId();
    }

    /**
     * Create an instance of {@link GetServerName }
     * 
     */
    public GetServerName createGetServerName() {
        return new GetServerName();
    }

    /**
     * Create an instance of {@link GetByWeekResponse }
     * 
     */
    public GetByWeekResponse createGetByWeekResponse() {
        return new GetByWeekResponse();
    }

    /**
     * Create an instance of {@link GetInfoResponse }
     * 
     */
    public GetInfoResponse createGetInfoResponse() {
        return new GetInfoResponse();
    }

    /**
     * Create an instance of {@link EditResponse }
     * 
     */
    public EditResponse createEditResponse() {
        return new EditResponse();
    }

    /**
     * Create an instance of {@link GetById }
     * 
     */
    public GetById createGetById() {
        return new GetById();
    }

    /**
     * Create an instance of {@link GetEventByDateResponse }
     * 
     */
    public GetEventByDateResponse createGetEventByDateResponse() {
        return new GetEventByDateResponse();
    }

    /**
     * Create an instance of {@link GetServerNameResponse }
     * 
     */
    public GetServerNameResponse createGetServerNameResponse() {
        return new GetServerNameResponse();
    }

    /**
     * Create an instance of {@link Make }
     * 
     */
    public Make createMake() {
        return new Make();
    }

    /**
     * Create an instance of {@link GetIdResponse }
     * 
     */
    public GetIdResponse createGetIdResponse() {
        return new GetIdResponse();
    }

    /**
     * Create an instance of {@link LocalDate }
     * 
     */
    public LocalDate createLocalDate() {
        return new LocalDate();
    }

    /**
     * Create an instance of {@link Event }
     * 
     */
    public Event createEvent() {
        return new Event();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://example.org/", name = "getInfoResponse")
    public JAXBElement<GetInfoResponse> createGetInfoResponse(GetInfoResponse value) {
        return new JAXBElement<GetInfoResponse>(_GetInfoResponse_QNAME, GetInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://example.org/", name = "editResponse")
    public JAXBElement<EditResponse> createEditResponse(EditResponse value) {
        return new JAXBElement<EditResponse>(_EditResponse_QNAME, EditResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://example.org/", name = "getById")
    public JAXBElement<GetById> createGetById(GetById value) {
        return new JAXBElement<GetById>(_GetById_QNAME, GetById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEventByDateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://example.org/", name = "getEventByDateResponse")
    public JAXBElement<GetEventByDateResponse> createGetEventByDateResponse(GetEventByDateResponse value) {
        return new JAXBElement<GetEventByDateResponse>(_GetEventByDateResponse_QNAME, GetEventByDateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://example.org/", name = "getIdResponse")
    public JAXBElement<GetIdResponse> createGetIdResponse(GetIdResponse value) {
        return new JAXBElement<GetIdResponse>(_GetIdResponse_QNAME, GetIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetServerNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://example.org/", name = "getServerNameResponse")
    public JAXBElement<GetServerNameResponse> createGetServerNameResponse(GetServerNameResponse value) {
        return new JAXBElement<GetServerNameResponse>(_GetServerNameResponse_QNAME, GetServerNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Make }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://example.org/", name = "make")
    public JAXBElement<Make> createMake(Make value) {
        return new JAXBElement<Make>(_Make_QNAME, Make.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://example.org/", name = "getByIdResponse")
    public JAXBElement<GetByIdResponse> createGetByIdResponse(GetByIdResponse value) {
        return new JAXBElement<GetByIdResponse>(_GetByIdResponse_QNAME, GetByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEventByDate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://example.org/", name = "getEventByDate")
    public JAXBElement<GetEventByDate> createGetEventByDate(GetEventByDate value) {
        return new JAXBElement<GetEventByDate>(_GetEventByDate_QNAME, GetEventByDate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MakeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://example.org/", name = "makeResponse")
    public JAXBElement<MakeResponse> createMakeResponse(MakeResponse value) {
        return new JAXBElement<MakeResponse>(_MakeResponse_QNAME, MakeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://example.org/", name = "getInfo")
    public JAXBElement<GetInfo> createGetInfo(GetInfo value) {
        return new JAXBElement<GetInfo>(_GetInfo_QNAME, GetInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Edit }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://example.org/", name = "edit")
    public JAXBElement<Edit> createEdit(Edit value) {
        return new JAXBElement<Edit>(_Edit_QNAME, Edit.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetByWeek }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://example.org/", name = "getByWeek")
    public JAXBElement<GetByWeek> createGetByWeek(GetByWeek value) {
        return new JAXBElement<GetByWeek>(_GetByWeek_QNAME, GetByWeek.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://example.org/", name = "getId")
    public JAXBElement<GetId> createGetId(GetId value) {
        return new JAXBElement<GetId>(_GetId_QNAME, GetId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetByWeekResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://example.org/", name = "getByWeekResponse")
    public JAXBElement<GetByWeekResponse> createGetByWeekResponse(GetByWeekResponse value) {
        return new JAXBElement<GetByWeekResponse>(_GetByWeekResponse_QNAME, GetByWeekResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetServerName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://example.org/", name = "getServerName")
    public JAXBElement<GetServerName> createGetServerName(GetServerName value) {
        return new JAXBElement<GetServerName>(_GetServerName_QNAME, GetServerName.class, null, value);
    }

}
