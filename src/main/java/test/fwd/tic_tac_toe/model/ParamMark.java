package test.fwd.tic_tac_toe.model;

public class ParamMark
{
    int row;
    int col;
    String mark;
    String player;

    public ParamMark()
    {

    }

    public ParamMark(int row, int col, String mark, String player)
    {
        this.row = row;
        this.col = col;
        this.mark = mark;
        this.player = player;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }
}
