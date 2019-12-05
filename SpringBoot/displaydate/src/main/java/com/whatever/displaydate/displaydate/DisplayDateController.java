package com.whatever.displaydate.displaydate;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * DIsplayDateController
 */
@Controller
public class DisplayDateController {

    @RequestMapping("/")
    public String home(){
        return "index.jsp";
    }
    
    @RequestMapping("/date")
    public String date(Model model){
        Date date = new Date();
        SimpleDateFormat formatYear = new SimpleDateFormat("yyyy");
        SimpleDateFormat formatMonth = new SimpleDateFormat("MMMM");
        SimpleDateFormat formatDay = new SimpleDateFormat("d");
        SimpleDateFormat formatDOTW = new SimpleDateFormat("EEEEE");

        String year = formatYear.format(date);
        String month = formatMonth.format(date);
        String day = formatDay.format(date);
        String DOTW = formatDOTW.format(date);

        model.addAttribute("year", year);
        model.addAttribute("month", month);
        model.addAttribute("day", day);
        model.addAttribute("DOTW", DOTW);
        return "date.jsp";
    }
    
    @RequestMapping("/time")
    public String time(Model model){
        Date date = new Date();
        SimpleDateFormat formatHour = new SimpleDateFormat("h");
        SimpleDateFormat formatMinute = new SimpleDateFormat("m");
        SimpleDateFormat formatMarker = new SimpleDateFormat("a");

        String hour = formatHour.format(date);
        String minute = formatMinute.format(date);
        String marker = formatMarker.format(date);

        model.addAttribute("hour", hour);
        model.addAttribute("minute", minute);
        model.addAttribute("marker", marker);
        return "time.jsp";
    }
    
}