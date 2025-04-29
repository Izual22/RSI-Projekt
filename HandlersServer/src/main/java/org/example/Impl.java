package org.example;

import javax.imageio.ImageIO;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.MTOM;
import javax.xml.ws.soap.SOAPBinding;
import java.awt.*;
import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.Locale;

@MTOM
@WebService
@BindingType(value= SOAPBinding.SOAP11HTTP_MTOM_BINDING)
public class Impl {
    int id;
    List<Event> oddaj = new ArrayList<Event>();
    protected Impl(){
        super();
        id=5;
        oddaj.add(new Event(1,"Event 1","Typ 1",LocalDate.now(),"Informacja przykładowa"));
        oddaj.add(new Event(2,"Event 2","Typ 2",LocalDate.of(2025,1,10),"Informacja przykładowa"));
        oddaj.add(new Event(3,"Event 3","Typ 3",LocalDate.of(2025,2,10),"Informacja przykładowa"));
        oddaj.add(new Event(4,"Event 4","Typ 4",LocalDate.of(2025,3,10),"Informacja przykładowa"));
    }

    @WebMethod
    public String getServerName() {
        return "Witam";
    }
    public int getId(){
        return id;
    }
    public List getEventsByDate(LocalDate date){
        List<String> ret=new ArrayList<String>();
        for(Event check:oddaj){
            if(check.getDate().equals(date)){
                ret.add(check.toString());
            }
        }
        return ret;
    }
    public List getByWeek(LocalDate date){
        List<String> ret=new ArrayList<String>();
        for(Event check:oddaj){
            if(check.getWeek()==date.get(WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear()) && check.getYear()==date.getYear()){
                ret.add(check.toString());
            }
        }
        return ret;
    }
    public Image eventImage(int id){
        for(Event ret:oddaj){
            if(ret.getId()==id){
                try{
                    File image=new File(ret.getImage());
                    return  ImageIO.read(image);
                }catch(IOException e){
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return null;
    }
    public void setImage(int id, String s){
        for(Event ret:oddaj){
            if(ret.getId()==id){
                ret.setImage(s);
            }
        }
    }
    public String getInfo(int id){
        for(Event ret:oddaj){
            if(ret.getId()==id){
                return ret.getInfo();
            }
        }
        return null;
    }
    public Event getById(int id){
        for(Event ret:oddaj){
            if(ret.getId()==id){
                return ret;
            }
        }
        return null;
    }
    public void edit(Event changed){
        for(Event ret:oddaj){
            if(ret.getId()==changed.getId()){
                oddaj.remove(ret);
                oddaj.add(changed);
            }
        }
    }
    public void make(Event added){
        oddaj.add(added);
        id+=1;
    }

}
