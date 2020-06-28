package com.ivanriz.tictactoe;

public class ClearScreen {

    // constructor
    public void set() {
        clearScreen();
    }

    private static void clearScreen() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                // clear screen for Windows
                new ProcessBuilder("cmd","/c","cls")
                    .inheritIO()
                    .start()
                    .waitFor();
            } else {
                // clear screen for another Windows
                Runtime.getRuntime().exec("clear");
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            System.out.println("Error!\n" + e.getMessage());
        }
    }
}