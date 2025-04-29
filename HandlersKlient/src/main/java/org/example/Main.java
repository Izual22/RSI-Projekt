package org.example;

import javax.swing.*;
import javax.xml.ws.soap.MTOMFeature;
import java.time.temporal.WeekFields;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ImplService sis=new ImplService();
        Impl im=sis.getImplPort(new MTOMFeature());
        System.out.println("Download done");
        Event test=im.getById(1);
        //List lista=im.getByWeek(LocalDate.of(2025,3,10));
        System.out.println(test);
        //System.out.println(lista.get(0));
    }
}