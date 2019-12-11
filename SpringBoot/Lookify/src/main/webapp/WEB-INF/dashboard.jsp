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

    <div>
        <p><a href="/songs/new">Add New</a></p>
        <p><a href="/search">Top Songs</a></p>
        <form action="/search" method="POST">
            <input type="text" name="search" placeholder="Search..">
            <input type="submit" value="Search">
        </form>
    </div>

        <h3>All Songs</h3>
        <table>
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Artist</th>
                    <th>Rating</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${songs}" var="song">
                <tr>
                    <td><a href="/songs/${song.id}"><c:out value="${song.title}"/></a></td>
                    <td><c:out value="${song.artist}"/></td>
                    <td><c:out value="${song.rating}"/></td>
                    <td><a href="/songs/${song.id}/edit">Edit</a>|<a href="/songs/${song.id}/delete">Delete</a></td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    
</body>
</html>