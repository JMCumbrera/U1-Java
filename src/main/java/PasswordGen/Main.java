package PasswordGen;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Integer num;
            String password = "";

            Scanner readline = new Scanner(System.in);  // Creamos la clase readline, de tipo Scanner
            System.out.println("¿Cuál va a ser la longitud de la contraseña?"); // Aquí pide la longitud
            num = readline.nextInt(); // Lo lee y lo asigna a la variable num

            if (num <= 0) {
                throw new NotZeroOrLessLenghtException();
            }

            password = passwordGen(num);
            System.out.println(password);
        } catch (NotZeroOrLessLenghtException e) {
            System.out.println(e.getMessage());
        }
    }

    @Contract(pure = true)
    public static @NotNull String passwordGen(Integer lenght) {
        Integer leftLimit = 33;
        Integer rightLimit = 126;
        Random random = new Random();

        String password = random.ints(leftLimit,rightLimit + 1)
                .limit(lenght)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return password;
    }
}

