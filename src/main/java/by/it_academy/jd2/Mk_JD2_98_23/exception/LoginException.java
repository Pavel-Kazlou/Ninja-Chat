package by.it_academy.jd2.Mk_JD2_98_23.exception;

public class LoginException extends Exception {
    public LoginException() {
        super("Invalid username or password!");
    }

    public LoginException(String message) {
        super(message);
    }
}
