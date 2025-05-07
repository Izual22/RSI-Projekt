package org.example;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.MTOM;
import javax.xml.ws.soap.SOAPBinding;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


@MTOM
@WebService
@BindingType(value = SOAPBinding.SOAP11HTTP_MTOM_BINDING)
public class Impl {

    private int id;
    private List<Event> oddaj = new ArrayList<>();

    public Impl() throws DatatypeConfigurationException {
        super();
        id = 5;
        oddaj.add(new Event(1, "Event 1", "Typ 1", DatatypeFactory.newInstance().newXMLGregorianCalendar("2025-04-10"), "Informacja przykładowa"));
        oddaj.add(new Event(2, "Event 2", "Typ 2", DatatypeFactory.newInstance().newXMLGregorianCalendar("2025-03-10"), "Informacja przykładowa"));
        oddaj.add(new Event(3, "Event 3", "Typ 3", DatatypeFactory.newInstance().newXMLGregorianCalendar("2025-02-10"), "Informacja przykładowa"));
        oddaj.add(new Event(4, "Event 4", "Typ 4", DatatypeFactory.newInstance().newXMLGregorianCalendar("2025-01-10"), "Informacja przykładowa"));
    }

    @WebMethod
    public String getServerName() {
        return "Witam";
    }

    @WebMethod
    public int getId() {
        return id;
    }

    @WebMethod
    public List<String> getEventsByDate(XMLGregorianCalendar date) {
        List<String> ret = new ArrayList<>();
        for (Event check : oddaj) {
            if (check.getDate().getYear() == date.getYear() &&
                    check.getDate().getMonth() == date.getMonth() &&
                    check.getDate().getDay() == date.getDay()) {
                ret.add(check.toString());
            }
        }
        return ret;
    }


    @WebMethod
    public List<String> getByWeek(XMLGregorianCalendar date) {
        List<String> ret = new ArrayList<>();
        int inputWeek = LocalDate.of(date.getYear(), date.getMonth(), date.getDay())
                .get(WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear());

        for (Event check : oddaj) {
            if (check.getWeek() == inputWeek && check.getYear() == date.getYear()) {
                ret.add(check.toString());
            }
        }
        return ret;
    }

    @WebMethod
    public DataHandler eventImage(int id) {
        for (Event ret : oddaj) {
            if (ret.getId() == id) {
                try {
                    File image = new File(ret.getImage());
                    return new DataHandler(new FileDataSource(image));
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return null;
    }

    @WebMethod
    public void setImage(int id, DataHandler imageData) {
        for (Event e : oddaj) {
            if (e.getId() == id) {
                File out = new File("images", id + ".jpg");

                File parent = out.getParentFile();
                if (!parent.exists() && !parent.mkdirs()) {
                    throw new RuntimeException("Could not create directory: " + parent.getAbsolutePath());
                }

                try (InputStream in = imageData.getInputStream();
                     FileOutputStream fos = new FileOutputStream(out)) {
                    byte[] buf = new byte[4096];
                    int len;
                    while ((len = in.read(buf)) > 0) {
                        fos.write(buf, 0, len);
                    }
                    e.setImage(out.getAbsolutePath());
                } catch (IOException ex) {
                    throw new RuntimeException("Failed to save image for event " + id, ex);
                }
                return;
            }
        }
    }

    @WebMethod
    public String getInfo(int id) {
        for (Event ret : oddaj) {
            if (ret.getId() == id) {
                return ret.getInfo();
            }
        }
        return null;
    }

    @WebMethod
    public Event getById(int id) {
        for (Event ret : oddaj) {
            if (ret.getId() == id) {
                return ret;
            }
        }
        return null;
    }

    @WebMethod
    public void edit(Event changed) {
        Event toRemove = null;
        for (Event ret : oddaj) {
            if (ret.getId() == changed.getId()) {
                toRemove = ret;
                break;
            }
        }
        if (toRemove != null) {
            oddaj.remove(toRemove);
            oddaj.add(changed);
        }
    }

    @WebMethod
    public void make(Event added) {
        oddaj.add(added);
        id += 1;
    }
}
