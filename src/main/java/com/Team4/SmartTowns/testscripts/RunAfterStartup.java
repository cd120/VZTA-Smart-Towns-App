package com.Team4.SmartTowns.testscripts;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import org.springframework.stereotype.Component;
import org.springframework.context.event.EventListener;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class RunAfterStartup {

    private final DefaultsGenerator defaultsGenerator;

    @Autowired
    public RunAfterStartup(DefaultsGenerator defaultsGenerator) {
        this.defaultsGenerator = defaultsGenerator;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup() {
        System.out.println("Starting to generate default trails and users.");
        defaultsGenerator.generateTrailsAndUsers();
    }
}
