package org.example;

import javax.jws.WebMethod;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class Event implements Serializable{
    String name;
    int id;
    String type;
    XMLGregorianCalendar date;
    int week;
    int month;
    int year;
    String info;
    String image;
    Event(int id,String name, String type, XMLGregorianCalendar date, String Info){
        this.id=id;
        this.name=name;
        this.type=type;
        this.date=date;
        this.info=Info;
        this.year=date.getYear();
        this.month=date.getMonth();
        LocalDate localDate = LocalDate.of(
                date.getYear(),
                date.getMonth(),
                date.getDay());
        this.week=localDate.get(WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear());
    }
    @WebMethod
    public int getId(){
        return id;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public XMLGregorianCalendar getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(XMLGregorianCalendar date) {
        this.date = date;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public int getMonth() {
        return month;
    }
    public void setImage(String s){
        this.image=s;
    }

    public String getImage() {
        if(image==null){
            return "This event lacks an image";
        }
        return image;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getWeek() {
        return week;
    }

    public String getInfo() {
        return info;
    }

    @Override
    @WebMethod
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", date=" + date +
                ", week=" + week +
                ", month=" + month +
                ", year=" + year +
                ", info='" + info + '\'' +
                '}';
    }
}
