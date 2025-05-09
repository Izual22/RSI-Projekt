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
import java.io.*;
import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import be.quodlibet.boxable.BaseTable;
import be.quodlibet.boxable.Row;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import org.apache.pdfbox.pdmodel.common.PDRectangle;
import java.io.File;
import java.io.IOException;

@MTOM
@WebService
@BindingType(value = SOAPBinding.SOAP11HTTP_MTOM_BINDING)
public class Impl {
    private int id;
    private List<Event> oddaj = new ArrayList<>();

    public Impl() throws DatatypeConfigurationException {
        super();
        try {
            id = 5;
            oddaj.add(new Event(1, "Event 1", "Typ 1", DatatypeFactory.newInstance().newXMLGregorianCalendar("2025-04-10"), "Info1"));
            oddaj.add(new Event(2, "Event 2", "Typ 2", DatatypeFactory.newInstance().newXMLGregorianCalendar("2025-03-10"), "Info2"));
            oddaj.add(new Event(3, "Event 3", "Typ 3", DatatypeFactory.newInstance().newXMLGregorianCalendar("2025-02-10"), "Info2"));
            oddaj.add(new Event(4, "Event 4", "Typ 4", DatatypeFactory.newInstance().newXMLGregorianCalendar("2025-01-10"), "Info4"));
            System.out.println("Impl constructor executed successfully.");
        } catch (DatatypeConfigurationException e) {
            System.err.println("Error during DatatypeFactory initialization: " + e.getMessage());
            throw e;
        } }

    @WebMethod
    public String getServerName() {
        System.out.println("getServerName() called.");
        return "Witam";
    }

    @WebMethod
    public int getId() {
        System.out.println("getId() called.");
        return id;
    }

    @WebMethod
    public List<String> getEventsByDate(XMLGregorianCalendar date) {
        System.out.println("getEventsByDate() called for date: " + date.toXMLFormat());
        List<String> ret = new ArrayList<>();
        try {
            for (Event check : oddaj) {
                if (check.getDate().getYear() == date.getYear() &&
                        check.getDate().getMonth() == date.getMonth() &&
                        check.getDate().getDay() == date.getDay()) {
                    ret.add(check.toString());
                }
            }
        } catch (Exception e) {
            System.err.println("Error in getEventsByDate(): " + e.getMessage());
        }
        return ret;
    }


    @WebMethod
    public List<String> getByWeek(XMLGregorianCalendar date) {
        System.out.println("getByWeek() called for date: " + date.toXMLFormat());
        List<String> ret = new ArrayList<>();
        try {
            int inputWeek = LocalDate.of(date.getYear(), date.getMonth(), date.getDay())
                    .get(WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear());

            for (Event check : oddaj) {
                if (check.getWeek() == inputWeek && check.getYear() == date.getYear()) {
                    ret.add(check.toString());
                }
            }
        } catch (Exception e) {
            System.err.println("Error in getByWeek(): " + e.getMessage());
        }
        return ret;
    }

    @WebMethod
    public DataHandler eventImage(int id) {
        System.out.println("eventImage() called for event ID: " + id);
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
        System.out.println("setImage() called for event ID: " + id);
        for (Event e : oddaj) {
            if (e.getId() == id) {
                File out = new File("images", id + ".jpg");

                File parent = out.getParentFile();
                if (!parent.exists() && !parent.mkdirs()) {
                    System.err.println("Could not create directory: " + parent.getAbsolutePath());
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
                    System.out.println("Image saved successfully for event ID: " + id);
                } catch (IOException ex) {
                    System.err.println("Failed to save image for event ID: " + id + " - " + ex.getMessage());
                    throw new RuntimeException("Failed to save image for event " + id, ex);
                }
                return;
            }
        }
    }

    @WebMethod
    public String getInfo(int id) {
        System.out.println("getInfo() called for event ID: " + id);
        try {
            for (Event ret : oddaj) {
                if (ret.getId() == id) {
                    return ret.toString();
                }
            }
        } catch (Exception e) {
            System.err.println("Error in getInfo(): " + e.getMessage());
        }
        return null;
    }

    @WebMethod
    public Event getById(int id) {
        System.out.println("getById() called for event ID: " + id);
        try {
            for (Event ret : oddaj) {
                if (ret.getId() == id) {
                    return ret;
                }
            }
        } catch (Exception e) {
            System.err.println("Error in getById(): " + e.getMessage());
        }
        return null;
    }

    @WebMethod
    public void edit(Event changed) {
        System.out.println("edit() called for event ID: " + changed.getId());
        try {
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
                System.out.println("Event ID " + changed.getId() + " successfully edited.");
            }
        } catch (Exception e) {
            System.err.println("Error in edit(): " + e.getMessage());
        }
    }

    @WebMethod
    public int make(Event added) {
        System.out.println("make() called to add new event.");
        try {
            added.setId(id);
            oddaj.add(added);
            System.out.println("New event added successfully with ID: " + id);
            return id++;
        } catch (Exception e) {
            System.err.println("Error in make(): " + e.getMessage());
        }
        return -1;
    }

    private DataHandler createPDF(List<Event> events) throws IOException {
        System.out.println("createPDF() called.");
        try {
            PDDocument doc = new PDDocument();
            PDPage page = new PDPage(PDRectangle.LETTER);
            doc.addPage(page);

            float margin = 50;
            float yStart = page.getMediaBox().getHeight() - margin;
            float tableWidth = page.getMediaBox().getWidth() - 2 * margin;
            float bottomMargin = 50;

            BaseTable table = new BaseTable(
                    yStart,
                    yStart,
                    bottomMargin,
                    tableWidth,
                    margin,
                    doc,
                    page,
                    true,
                    true
            );

            Row<PDPage> header = table.createRow(15f);
            header.createCell(5,  "ID");
            header.createCell(20, "Name");
            header.createCell(15, "Type");
            header.createCell(20, "Date");
            header.createCell(40, "Info");
            table.addHeaderRow(header);

            for (Event e : events) {
                Row<PDPage> row = table.createRow(12f);
                row.createCell(5,  String.valueOf(e.getId()));
                row.createCell(20, e.getName());
                row.createCell(15, e.getType());
                String dateOnly = e.getDate().toXMLFormat().substring(0, 10);
                row.createCell(20, dateOnly);
                row.createCell(40, e.getInfo());
            }

            table.draw();

            File tmp = File.createTempFile("events_", ".pdf");
            doc.save(tmp);
            doc.close();
            System.out.println("PDF created successfully.");
            return new DataHandler(new FileDataSource(tmp));
        } catch (IOException e) {
            System.err.println("Error in createPDF(): " + e.getMessage());
            throw e;
    }
    }

    @WebMethod
    public DataHandler getPDFByYear(int year) {
        try {
            List<Event> filtered = oddaj.stream()
                    .filter(e -> e.getDate().getYear() == year)
                    .collect(Collectors.toList());
            System.out.println("PDF sent to client.");
            return createPDF(filtered);
        } catch (IOException ex) {
            System.err.println("PDF creation failed for year " + year + ": " + ex.getMessage());
            throw new RuntimeException("PDF creation failed for year " + year, ex);
        }
    }

}
