package com.digitalhouse.ej2.chainofresponsability.chain;

import com.digitalhouse.ej2.chainofresponsability.model.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Handler {
    protected final String asignedEmail;
    protected final String subject;
    protected final Handler nextHandler;
    public abstract String check(Email email);

    protected boolean isEmailValid(Email email) {
        return (email.destino().equalsIgnoreCase(this.asignedEmail)) ||
                (email.asunto().equalsIgnoreCase(this.subject));
    }
}