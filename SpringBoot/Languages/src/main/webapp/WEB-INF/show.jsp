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

    <h3>${language.name}</h3>
    <h3>${language.creator}</h3>
    <h3>${language.currentVersion}</h3>

    <h3><a href="/languages/${language.id}/edit">Edit</a></h3>
    <h3><a href="/languages/${language.id}/delete">Delete</a></h3>
    
</body>
</html>