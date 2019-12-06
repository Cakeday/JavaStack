<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <h1>Hi</h1>

    <form action="/submitted" method="post">
        Your Name <input type="text" name="name">
        Dojo Location
        <select name="location">
            <option value="San Jose">San Jose</option>
            <option value="Berkeley">Berkeley</option>
            <option value="Orange County">Orange County</option>
        </select>
        <select name="language">
            <option value="Python">Python</option>
            <option value="Java">Java</option>
            <option value="CSS">CSS</option>
        </select>
        <textarea name="comment" cols="10" rows="1"></textarea>
        <input type="submit" value="Button">
    </form>
</body>
</html>