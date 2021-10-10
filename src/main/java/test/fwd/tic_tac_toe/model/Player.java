package test.fwd.tic_tac_toe.model;

public class Player extends Blocks
{
    private String name;
    private String status;

    public Player()
    {

    }

    public Player(int totRow, int totCol, String name)
    {
        super(totRow, totCol);

        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    @Override
    public void setBlocksCoordinate(int row, int col, String mark)
    {
        super.setBlocksCoordinate(row, col, mark);
    }
}
