package com.saggu.cli.command;

import org.springframework.shell.Availability;
import org.springframework.shell.standard.AbstractShellComponent;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class HelloCommand {

    @ShellMethod
    public String hello(@ShellOption String user) {

        return "Hello " + user + " from the Spring Shell World :)";
    }
}