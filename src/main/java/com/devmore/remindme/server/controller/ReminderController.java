package com.devmore.remindme.server.controller;

import com.devmore.remindme.server.entity.Remind;
import com.devmore.remindme.server.service.ReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class ReminderController {

    @Autowired
    private ReminderService service;

    @RequestMapping(value = "/reminders", method = RequestMethod.GET)
    @ResponseBody
    public List<Remind> getAllReminders(){
        return service.getAll();
    }

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    @ResponseBody
    public List<Remind> getRemind(){
        List<Remind> list = new ArrayList<Remind>();
        Remind r = new Remind();
        r.setId(1);
        r.setTitle("test");
        r.setRemindDate(new Date());
        list.add(r);
        r.setId(1);
        r.setTitle("test2");
        r.setRemindDate(new Date());
        list.add(r);
        return list;
    }

    @RequestMapping(value = "/reminders/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Remind getReminder(@PathVariable("id") long remindID){
        return service.getByID(remindID);
    }

    @RequestMapping(value = "/reminders", method = RequestMethod.POST)
    @ResponseBody
    public Remind saveReminder(@RequestBody Remind remind){
        return service.save(remind);
    }

    @RequestMapping(value = "/reminders/{id}", method = RequestMethod.POST)
    @ResponseBody
    public void deleteReminder(@PathVariable("id") long remindID){
        service.remove(remindID);
    }

}
