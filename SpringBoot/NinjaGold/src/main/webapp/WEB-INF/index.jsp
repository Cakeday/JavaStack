<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Index</title>
    <link rel="stylesheet" type="text/css" href="/css/styles.css">
</head>
<body>

    <div class="wrapper">

        <h3 class="header">Your Gold: <span>0</span></h3>

        <div class="grid">
            <div class="place">
                <h4>Farm</h4>
                <p>(earns 10-20 gold)</p>
                <form action="/getgold" method="POST">
                    <input type="hidden" name="place" value="farm">
                    <input type="submit" value="Find Gold!">
                </form>
            </div>
            
            <div class="place">
                <h4>Cave</h4>
                <p>(earns 5-10 gold)</p>
                <form action="/getgold" method="POST">
                    <input type="hidden" name="place" value="cave">
                    <input type="submit" value="Find Gold!">
                </form>
            </div>

            <div class="place">
                <h4>House</h4>
                <p>(earns 2-5 gold)</p>
                <form action="/getgold" method="POST">
                    <input type="hidden" name="place" value="house">
                    <input type="submit" value="Find Gold!">
                </form>
            </div>

            <div class="place">
                <h4>Casino!</h4>
                <p>(earns/takes 0-50 gold)</p>
                <form action="/getgold" method="POST">
                    <input type="hidden" name="place" value="casino">
                    <input type="submit" value="Find Gold!">
                </form>
            </div>

        </div>



        <h3>Activities:</h3>

        <div class="scrollbar">
            <% for(int ) %>
            <p></p>

        </div>














    </div>

</body>
</html>