package test.fwd.tic_tac_toe.model;

public class ParamTotalBlocks
{
    int totalBlocks;
    String player1Name;
    String player2Name;

    public ParamTotalBlocks()
    {

    }

    public ParamTotalBlocks(int totalBlocks, String player1Name, String player2Name)
    {
        this.totalBlocks = totalBlocks;
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public int getTotalBlocks() {
        return totalBlocks;
    }

    public void setTotalBlocks(int totalBlocks) {
        this.totalBlocks = totalBlocks;
    }

    public String getPlayer1Name() {
        return player1Name;
    }

    public void setPlayer1Name(String player1Name) {
        this.player1Name = player1Name;
    }

    public String getPlayer2Name() {
        return player2Name;
    }

    public void setPlayer2Name(String player2Name) {
        this.player2Name = player2Name;
    }
}
