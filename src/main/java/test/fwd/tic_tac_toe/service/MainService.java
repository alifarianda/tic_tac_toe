package test.fwd.tic_tac_toe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.fwd.tic_tac_toe.model.Blocks;
import test.fwd.tic_tac_toe.model.Player;

@Service
public class MainService
{
    public static Player player1;
    public static Player player2;
    public static Blocks blocks;

    public void setTotalBlocks(int totalBlocks, String player1Name, String player2Name)
    {
        try
        {
            player1 = new Player(totalBlocks, totalBlocks, player1Name);
            player2 = new Player(totalBlocks, totalBlocks, player2Name);
            blocks  = new Blocks(totalBlocks, totalBlocks);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public String setMark(int row, int col, String mark, String player)
    {
        String output = "";

        try
        {
            // Check if Mark already assigned
            if (blocks.getBlocks()[row][col].isEmpty())
            {
                if (player.equals("player1"))
                {
                    // Set Mark
                    player1.setBlocksCoordinate(row, col, mark);
                    blocks.setBlocksCoordinate(row, col, mark);

                    // Check Winner
                    if (checkWinner(player1).equals("winner"))
                    {
                        output = "player1_winner";
                        player1.setStatus("winner");
                    }
                }
                else if (player.equals("player2"))
                {
                    player2.setBlocksCoordinate(row, col, mark);
                    blocks.setBlocksCoordinate(row, col, mark);

                    // Check Winner
                    if (checkWinner(player2).equals("winner"))
                    {
                        output = "player2_winner";
                        player2.setStatus("winner");
                    }
                }
            }
            else
            {
                output = "This Coordinate Already Assigned";
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return output;
    }

    public String checkWinner(Player player)
    {
        String output = "";
        String mark = "";

        if (player.getName().equals("player1"))
        {
            mark = "X";
        }
        else if (player.getName().equals("player2"))
        {
            mark = "O";
        }

        // Check Horizontal
        boolean lineHorizontal = false;
        for (int i = 0; i < player.getBlocks().length; i++) // Vertical Loop
        {
            boolean check = false;

            for (int j = 0; j < player.getBlocks()[i].length; j++) // Horizontal Loop
            {
                if (player.getBlocks()[i][j].equals(mark))
                {
                    check = true;
                }
                else
                {
                    check = false;
                    break;
                }
            }

            if (check)
            {
                lineHorizontal = true;
                break;
            }
        }

        // Check Vertical
        boolean lineVertical = false;
        for (int i = 0; i < player.getBlocks()[0].length; i++) // Horizontal Loop
        {
            boolean check = false;

            for (int j = 0; j < player.getBlocks().length; j++) // Vertical Loop
            {
                if (player.getBlocks()[j][i].equals(mark))
                {
                    check = true;
                }
                else
                {
                    check = false;
                    break;
                }
            }

            if (check)
            {
                lineVertical = true;
                break;
            }
        }

        // Check Diagonal 1
        boolean lineDiagonal1 = false;
        for (int i = 0; i < player.getBlocks().length; i++)
        {
            if (player.getBlocks()[i][i].equals(mark))
            {
                lineDiagonal1 = true;
            }
            else
            {
                lineDiagonal1 = false;
                break;
            }
        }

        // Check Diagonal 2
        boolean lineDiagonal2 = false;
        int incD = 0;
        for (int i = (player.getBlocks().length-1); i >= 0; i--)
        {
            if (player.getBlocks()[incD][i].equals(mark))
            {
                lineDiagonal2 = true;
            }
            else
            {
                lineDiagonal2 = false;
                break;
            }

            incD++;
        }

        if (lineHorizontal || lineVertical || lineDiagonal1 || lineDiagonal2)
        {
            output = "winner";
        }

        return output;
    }

    public String[][] getBlocks(String player)
    {
        if (player.equals("player1"))
        {
            return player1.getBlocks();
        }
        else if (player.equals("player2"))
        {
            return player2.getBlocks();
        }
        else
        {
            return blocks.getBlocks();
        }
    }
}
