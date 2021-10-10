package test.fwd.tic_tac_toe.model;

public class Blocks
{
    private String[][] blocks;

    public Blocks()
    {

    }

    public Blocks(int totRow, int totCol)
    {
        this.blocks = new String[totRow][totCol];

        for (int i = 0; i < this.blocks.length; i++)
        {
            for (int j = 0; j < this.blocks[i].length; j++)
            {
                this.blocks[i][j] = "";
            }
        }
    }

    public String[][] getBlocks()
    {
        return blocks;
    }

    public void setBlocks(String[][] blocks)
    {
        this.blocks = blocks;
    }

    public void setBlocksCoordinate(int row, int col, String mark)
    {
        this.blocks[row][col] = mark;
    }
}
