package com.example.account.service.command;

import com.example.account.command.CreateAccountCommand;

public interface CommandService {

    void createAccount(CreateAccountCommand command);

}
