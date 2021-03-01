package com.example.taxiAppEE.web.command;

import com.example.taxiAppEE.web.command.admin.AdminCommand;

import java.util.HashMap;
import java.util.Map;

public class CommandContainer {

    private static final Map<String, Command> commands=new HashMap<>();

    static {
        commands.put("login", new LoginCommand());
        commands.put("login-post", new LoginPostCommand());
        commands.put("main", new MainCommand());
        commands.put("noCommand", new NoCommand());
        commands.put("prices", new PricesCommand());
        commands.put("logout", new LogoutCommand());
        commands.put("admin", new AdminCommand());
        commands.put("registration", new RegistrationCommand());
        commands.put("registration-post", new RegistrationPostCommand());
        commands.put("profile", new ProfileCommand());
        commands.put("make-order", new MakeOrderGetCommand());
        commands.put("make-order-post", new MakeOrderPostCommand());
        commands.put("confirmationPage", new ConfirmationCommand());
        commands.put("confirmationPage-post", new ConfirmationCommandPost());
    }

    public static Command get(String commandName) {
        if (commandName == null || !commands.containsKey(commandName)) {
            return commands.get("noCommand");
        }

        return commands.get(commandName);
    }

}
