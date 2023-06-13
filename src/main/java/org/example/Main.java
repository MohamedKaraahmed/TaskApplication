package org.example;

import org.example.core.Controller;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Controller controller = new Controller();
        controller.run();
    }
}
