package com.example.account.service.command;

import com.example.account.command.CreateAccountCommand;
import com.example.account.command.UpdateAccountCommand;

public interface CommandService {

    void createAccount(CreateAccountCommand command);
    void update(UpdateAccountCommand updateAccountCommand);

}
