<!DOCTYPE html>
<html>
<head>
    <title>Create Software</title>
</head>
<body>
    <h2>Create New Software</h2>
    <form action="createSoftware" method="post">
        <label>Software Name: </label>
        <input type="text" name="softwareName" required><br>
        <label>Description: </label>
        <textarea name="description" required></textarea><br>
        <input type="submit" value="Create Software">
    </form>
</body>
</html>
