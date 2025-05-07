package org.example;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.Locale;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Event")
public class Event implements Serializable {

    private int id;
    private String name;
    private String type;

    @XmlSchemaType(name = "dateTime")
    private XMLGregorianCalendar date;

    private int week;
    private int month;
    private int year;
    private String info;
    private String image;

    public Event() {}

    public Event(int id, String name, String type, XMLGregorianCalendar date, String info) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.date = date;
        this.info = info;
        this.year = date.getYear();
        this.month = date.getMonth();
        LocalDate localDate = LocalDate.of(date.getYear(), date.getMonth(), date.getDay());
        this.week = localDate.get(WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear());
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public XMLGregorianCalendar getDate() { return date; }
    public void setDate(XMLGregorianCalendar date) { this.date = date; }

    public int getWeek() { return week; }
    public void setWeek(int week) { this.week = week; }

    public int getMonth() { return month; }
    public void setMonth(int month) { this.month = month; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public String getInfo() { return info; }
    public void setInfo(String info) { this.info = info; }

    public String getImage() {
        return image != null ? image : "This event lacks an image";
    }
    public void setImage(String image) { this.image = image; }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", date=" + date +
                ", week=" + week +
                ", month=" + month +
                ", year=" + year +
                ", info='" + info + '\'' +
                '}';
    }
}
