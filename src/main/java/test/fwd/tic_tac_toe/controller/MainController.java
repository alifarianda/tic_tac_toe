package test.fwd.tic_tac_toe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import test.fwd.tic_tac_toe.model.ParamMark;
import test.fwd.tic_tac_toe.model.ParamTotalBlocks;
import test.fwd.tic_tac_toe.service.MainService;

import java.util.Arrays;
import java.util.HashMap;

@Controller
@RequestMapping(value = "/fwd")
public class MainController
{
    @Autowired
    MainService mainService;

    @ResponseBody
    @PostMapping(value = "/set-total-blocks")
    public HashMap<String, Object> setTotalBlocks(@RequestBody ParamTotalBlocks paramTotalBlocks)
    {
        HashMap<String, Object> dataReturn = new HashMap<>();

        try
        {
            mainService.setTotalBlocks(paramTotalBlocks.getTotalBlocks(), paramTotalBlocks.getPlayer1Name(), paramTotalBlocks.getPlayer2Name());

            dataReturn.put("status", "success");
            dataReturn.put("msg", "");
        }
        catch (Exception e)
        {
            e.printStackTrace();

            dataReturn.put("status", "error");
            dataReturn.put("msg", e.getMessage());
        }

        return dataReturn;
    }

    @ResponseBody
    @PostMapping(value = "/set-mark")
    public HashMap<String, Object> setMark(@RequestBody ParamMark paramMark)
    {
        HashMap<String, Object> dataReturn = new HashMap<>();

        try
        {
            String resultMark = mainService.setMark(paramMark.getRow(), paramMark.getCol(), paramMark.getMark(), paramMark.getPlayer());

            dataReturn.put("status", "success");
            dataReturn.put("msg", resultMark);
        }
        catch (Exception e)
        {
            e.printStackTrace();

            dataReturn.put("status", "error");
            dataReturn.put("msg", e.getMessage());
        }

        return dataReturn;
    }

    @ResponseBody
    @GetMapping(value = "/get-blocks")
    public HashMap<String, Object> getBlocks(@RequestParam(value = "player", defaultValue = "") String player)
    {
        HashMap<String, Object> dataReturn = new HashMap<>();

        try
        {
            String[][] resultBlocks = mainService.getBlocks(player);

            System.out.println("resultBlocks: ");
            System.out.println("--------------");
            System.out.println(Arrays.deepToString(resultBlocks));

            dataReturn.put("status", "success");
            dataReturn.put("msg", resultBlocks);
        }
        catch (Exception e)
        {
            e.printStackTrace();

            dataReturn.put("status", "error");
            dataReturn.put("msg", e.getMessage());
        }

        return dataReturn;
    }

    @GetMapping("/home")
    public String greeting(Model model)
    {
        return "home";
    }
}
