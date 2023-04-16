package com.saggu.cli.command;

import org.springframework.shell.Availability;
import org.springframework.shell.component.StringInput;
import org.springframework.shell.standard.AbstractShellComponent;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class LoginCommand extends AbstractShellComponent {

    private boolean loggedIn;

    @ShellMethod(key = "login", value = "String input")
    public String login() {
        String userName = stringInput("User Name", false);
        String password = stringInput("Password", true);

        if(password.equals("right")) {
            loggedIn = true;
            return "Logged In";
        }else {
         return "login Fail";
        }
    }
    public String stringInput(String prompt, boolean mask) {
        StringInput component = new StringInput(getTerminal(), prompt, "");
        component.setResourceLoader(getResourceLoader());
        component.setTemplateExecutor(getTemplateExecutor());

        if (mask) {
            component.setMaskCharacter('*');
        }

        StringInput.StringInputContext context = component.run(StringInput.StringInputContext.empty());
        return context.getResultValue();
    }

    @ShellMethodAvailability({"hw", "foo"})
    public Availability availability() {
        return loggedIn
                ? Availability.available()
                : Availability.unavailable("you are not loggedin to the system yet! \nCall: login");
    }
}