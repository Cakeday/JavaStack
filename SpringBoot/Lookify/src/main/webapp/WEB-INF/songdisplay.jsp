<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>

<p><a href="/dashboard">Dashboard</a></p>

<h5>Title: ${song.title}</h5>
<h5>Artist: ${song.artist}</h5>
<h5>Rating: ${song.rating}</h5>

<p><a href="/songs/${song.id}/delete">Delete this binch</a></p>

    
</body>
</html>