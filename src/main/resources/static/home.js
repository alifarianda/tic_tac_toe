var turn = 1;

// A $( document ).ready() block.
$(document).ready(function()
{
    refreshUI();

    $("#resetButton").click(function()
    {
        turn = 1;
        $("#screen").text("PLAYER 1 TURN");

        // Assign Data
        var data =
        {
            totalBlocks:parseInt($("#totalBlocks").val()),
            player1Name:"player1",
            player2Name:"player2"
        };

        // Set resultBlocks
        $("#resultBlocks").html($("#totalBlocks").val() + "x" + $("#totalBlocks").val());

        // Exec Ajax
        $.ajax(
        {
            url: "/fwd/set-total-blocks",
            type: "POST",
            contentType : "application/json",
            dataType: "json",
            data:JSON.stringify(data),
            timeout: 10000,
            success: function (dataP,status,xhr)
            {
                // Set Table Data
                var strHTML = "<tr><td colspan='"+ parseInt($("#totalBlocks").val()) +"'></tr>";
                for (var i = 0; i < parseInt($("#totalBlocks").val()); i++)
                {
                    strHTML += "<tr>";

                    for (var j = 0; j < parseInt($("#totalBlocks").val()); j++)
                    {
                        strHTML += "<td><button class='btnBlock' data-row='"+ i +"' data-col='"+ j +"'></button></td>";
                    }

                    strHTML += "</tr>";
                }

                $("#tableData").html(strHTML);

                refreshUI();
            },
            error: function (jqXhr, textStatus, errorMessage)
            {
                console.log("error: " + errorMessage);
            }
        });
    });


});

function refreshUI()
{
    $("button").click(function()
    {
        if($(this).hasClass("fa fa-circle") || $(this).hasClass("fa fa-times"))
        {
            // $(this).css("background-color", "red");
            // $(this).delay(3000).css("background-color", "white");
            // setTimeout(function(){ $(this).css("background-color", "white"); console.log("HAHA"); }, 800);
        }
        else
        {
            if(turn == 1) // Player 1
            {
                var row = $(this).data("row");
                var col = $(this).data("col");
                var btn = $(this);

                // Assign Data
                var data =
                {
                    row:parseInt(row),
                    col:parseInt(col),
                    mark:"X",
                    player:"player1"
                };

                // Exec Ajax
                $.ajax(
                {
                    url: "/fwd/set-mark",
                    type: "POST",
                    contentType : "application/json",
                    dataType: "json",
                    data:JSON.stringify(data),
                    timeout: 10000,
                    success: function (dataP,status,xhr)
                    {
                        if (dataP.status == "success" && dataP.msg == "")
                        {
                            $("#screen").text("PLAYER 2 TURN");

                            // Check sign font from font-awesome
                            btn.addClass("fa fa-times");
                            turn = 2;
                        }
                        else if (dataP.status == "success" && dataP.msg == "player1_winner")
                        {
                            $("#screen").text("PLAYER 1 WIN !!!");

                            // Check sign font from font-awesome
                            btn.addClass("fa fa-times");
                            turn = 2;
                        }
                    },
                    error: function (jqXhr, textStatus, errorMessage)
                    {
                        console.log("error: " + errorMessage);
                    }
                });
            }
            else // Player 2
            {
                var row = $(this).data("row");
                var col = $(this).data("col");
                var btn = $(this);

                // Assign Data
                var data =
                {
                    row:parseInt(row),
                    col:parseInt(col),
                    mark:"O",
                    player:"player2"
                };

                // Exec Ajax
                $.ajax(
                {
                    url: "/fwd/set-mark",
                    type: "POST",
                    contentType : "application/json",
                    dataType: "json",
                    data:JSON.stringify(data),
                    timeout: 10000,
                    success: function (dataP,status,xhr)
                    {
                        if (dataP.status == "success" && dataP.msg == "")
                        {
                            $("#screen").text("PLAYER 1 TURN");

                            // Cross sign font from font-awesome
                            btn.addClass("fa fa-circle");
                            turn = 1;
                        }
                        else if (dataP.status == "success" && dataP.msg == "player2_winner")
                        {
                            $("#screen").text("PLAYER 2 WIN !!!");

                            // Cross sign font from font-awesome
                            btn.addClass("fa fa-circle");
                            turn = 1;
                        }
                    },
                    error: function (jqXhr, textStatus, errorMessage)
                    {
                        console.log("error: " + errorMessage);
                    }
                });
            }
        }
    });
}