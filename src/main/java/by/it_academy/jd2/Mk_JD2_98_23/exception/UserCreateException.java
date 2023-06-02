package by.it_academy.jd2.Mk_JD2_98_23.exception;

public class UserCreateException extends Exception {
    public UserCreateException() {
        super("All fields must be filled!");
    }

    public UserCreateException(String message) {
        super(message);
    }
}
