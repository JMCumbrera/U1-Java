package PasswordGen;

public class NotZeroOrLessLenghtException extends Exception {
    public NotZeroOrLessLenghtException() {
        super("Ha insertado una longitud de contraseña no válida");
    }
    public NotZeroOrLessLenghtException(String errorMessage) {
        super(errorMessage);
    }
}