<!DOCTYPE html>
<html>
<head>
    <title>Pending Requests</title>
</head>
<body>
    <h2>Pending Software Access Requests</h2>
    <table>
        <thead>
            <tr>
                <th>Request ID</th>
                <th>Software Name</th>
                <th>Username</th>
                <th>Status</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <!-- Iterate over pending requests here -->
            <c:forEach var="request" items="${requests}">
                <tr>
                    <td>${request.id}</td>
                    <td>${request.softwareName}</td>
                    <td>${request.username}</td>
                    <td>${request.status}</td>
                    <td>
                        <form action="approveRequest" method="post">
                            <input type="hidden" name="requestId" value="${request.id}">
                            <input type="submit" value="Approve">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
