package com.saggu.cli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.shell.command.CommandExceptionResolver;
import org.springframework.shell.command.CommandHandlingResult;

@SpringBootApplication
public class SpringShellApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringShellApplication.class, args);
    }
}