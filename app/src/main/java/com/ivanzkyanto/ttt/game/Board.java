package com.ivanzkyanto.ttt.game;

public class Board {
    String[] mark = new String[9];

    private String board() {
        String boardTemplate = ""
        + "       |       |       \n"
        + "   "+ mark[0] +"   |   "+ mark[1] +"   |   "+ mark[2] +"   \n"
        + "       |       |       \n"
        + "-------+-------+-------\n"
        + "       |       |       \n"
        + "   "+ mark[3] +"   |   "+ mark[4] +"   |   "+ mark[5] +"   \n"
        + "       |       |       \n"
        + "-------+-------+-------\n"
        + "       |       |       \n"
        + "   "+ mark[6] +"   |   "+ mark[7] +"   |   "+ mark[8] +"   \n"
        + "       |       |       ";
        return boardTemplate;
    }

    public void show() {
        System.out.print(board());
    }
}
