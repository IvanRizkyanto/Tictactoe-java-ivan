package com.ivanzkyanto.ttt.game;

import java.util.Scanner;

import com.ivanzkyanto.ttt.other.ClearScreen;

public class Game {
    private ClearScreen clearscreen = new ClearScreen();
    private Scanner in = new Scanner(System.in);
    private Board board = new Board();
    private Message message = new Message();

    private final String ANSI_RESET = "\u001B[0m";
    private final String ANSI_RED_BOLD_BRIGHT = "\033[1;91m";
    private final String ANSI_GREEN_BOLD_BRIGHT = "\033[1;92m";
    private final String ANSI_BLUE_BOLD_BRIGHT = "\033[1;94m";

    private final String XMark = ANSI_BLUE_BOLD_BRIGHT + "x" + ANSI_RESET;
    private final String OMark = ANSI_RED_BOLD_BRIGHT + "o" + ANSI_RESET;

    private int shift;

    public Game() {
        clearscreen.set();
        welcome();
    }

    private void welcome() {
        String args = ""
        + ANSI_GREEN_BOLD_BRIGHT
        + "\n\n+---------------------+\n"
        + "|     TIC TAC TOE     |\n"
        + "+---------------------+\n"
        + "  by.  Ivan Rizkyanto\n\n"
        + ANSI_RESET
        + "Press any key to start...\n"
        + "(or press 'q' for exit)\n"
        + "> ";
        System.out.print(args);
        String key = in.nextLine();
        if ("q".equals(key)) {
            System.exit(0);
        } else {
            shift = 0;
            getDefaultMark();
            playerXTurn();
        }
    }

    private void getDefaultMark() {
        for (int i = 0; i < board.mark.length; i++) {
            board.mark[i] = Integer.toString(i+1);
        }
    }

    private void playerXTurn() {
        clearscreen.set();
        board.show();
        playerXMark();
    }

    private void playerXMark() {
        System.out.print("\n\n " + ANSI_BLUE_BOLD_BRIGHT + "[ PLAYER X ]" + ANSI_RESET + " > ");
        try {
            String mark = null;
            mark = in.nextLine();
            if (OMark.equals(board.mark[Integer.parseInt(mark)-1]) || XMark.equals(board.mark[Integer.parseInt(mark)-1])) {
                System.out.print("\n" + message.errGridHasMarked);
                playerXMark();
            } else { board.mark[Integer.parseInt(mark)-1] = XMark; shift++; playerXWinCheck(); }
        } catch (NumberFormatException e) {
            System.out.print("\n" + message.errNumberFormatExc);
            playerXMark();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.print("\n" + message.errArrayIndexOutOfBoundsExc);
            playerXMark();
        } catch (Exception e) {
            System.out.print("\n" + message.errUnknown + e);
            playerXMark();
        }
    }

    private void playerOTurn() {
        clearscreen.set();
        board.show();
        playerOMark();
    }

    private void playerOMark() {
        System.out.print("\n\n " + ANSI_RED_BOLD_BRIGHT + "[ PLAYER O ]" + ANSI_RESET + " > ");
        try {
            String mark = null;
            mark = in.nextLine();
            if (XMark.equals(board.mark[Integer.parseInt(mark)-1]) || OMark.equals(board.mark[Integer.parseInt(mark)-1])) {
                System.out.print("\n" + message.errGridHasMarked);
                playerOMark();
            } else { board.mark[Integer.parseInt(mark)-1] = OMark; shift++; playerOWinCheck(); }
        } catch (NumberFormatException e) {
            System.out.print("\n" + message.errNumberFormatExc);
            playerOMark();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.print("\n" + message.errArrayIndexOutOfBoundsExc);
            playerOMark();
        } catch (Exception e) {
            System.out.print("\n" + message.errUnknown + e);
            playerOMark();
        }
    }

    private void playerXWinCheck() {
        if (
            XMark.equals(board.mark[0]) &&
            XMark.equals(board.mark[1]) &&
            XMark.equals(board.mark[2]) ||

            XMark.equals(board.mark[3]) &&
            XMark.equals(board.mark[4]) &&
            XMark.equals(board.mark[5]) ||

            XMark.equals(board.mark[6]) &&
            XMark.equals(board.mark[7]) &&
            XMark.equals(board.mark[8]) ||

            XMark.equals(board.mark[0]) &&
            XMark.equals(board.mark[3]) &&
            XMark.equals(board.mark[6]) ||

            XMark.equals(board.mark[1]) &&
            XMark.equals(board.mark[4]) &&
            XMark.equals(board.mark[7]) ||

            XMark.equals(board.mark[2]) &&
            XMark.equals(board.mark[5]) &&
            XMark.equals(board.mark[8]) ||

            XMark.equals(board.mark[0]) &&
            XMark.equals(board.mark[4]) &&
            XMark.equals(board.mark[8]) ||

            XMark.equals(board.mark[2]) &&
            XMark.equals(board.mark[4]) &&
            XMark.equals(board.mark[6])
        ) {
            System.out.println(ANSI_GREEN_BOLD_BRIGHT + "\n    [ PLAYER X WIN ]" + ANSI_RESET);
            board.show();
            welcome();
        } else {
            drawCheck();
            playerOTurn();
        }
    }

    private void playerOWinCheck() {
        if (
            OMark.equals(board.mark[0]) &&
            OMark.equals(board.mark[1]) &&
            OMark.equals(board.mark[2]) ||

            OMark.equals(board.mark[3]) &&
            OMark.equals(board.mark[4]) &&
            OMark.equals(board.mark[5]) ||

            OMark.equals(board.mark[6]) &&
            OMark.equals(board.mark[7]) &&
            OMark.equals(board.mark[8]) ||

            OMark.equals(board.mark[0]) &&
            OMark.equals(board.mark[3]) &&
            OMark.equals(board.mark[6]) ||

            OMark.equals(board.mark[1]) &&
            OMark.equals(board.mark[4]) &&
            OMark.equals(board.mark[7]) ||

            OMark.equals(board.mark[2]) &&
            OMark.equals(board.mark[5]) &&
            OMark.equals(board.mark[8]) ||

            OMark.equals(board.mark[0]) &&
            OMark.equals(board.mark[4]) &&
            OMark.equals(board.mark[8]) ||

            OMark.equals(board.mark[2]) &&
            OMark.equals(board.mark[4]) &&
            OMark.equals(board.mark[6])
        ) {
            System.out.println(ANSI_GREEN_BOLD_BRIGHT + "\n    [ PLAYER O WIN ]" + ANSI_RESET);
            board.show();
            welcome();
        } else {
            drawCheck();
            playerXTurn();
        }
    }

    private void drawCheck() {
        if (shift >= 9) {
            System.out.println(ANSI_GREEN_BOLD_BRIGHT + "\n  [ DRAW, NO WINNER ]" + ANSI_RESET);
            board.show();
            welcome();
        }
    }
}
