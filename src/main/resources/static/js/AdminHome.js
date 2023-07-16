function changeRole(id) {
    $.ajax({
        url: '/Admin/ChangeRole', type: 'POST', data: {
            id: id
        }, success: function (data) {
            window.alert("更新成功");
            location.reload();
        }, error: function (xhr, status, error) {
            window.alert("更改失败");
            console.error('Error updating role: ' + error);
        }
    });
}

function changePassword(id) {
    const userInput = window.prompt("输入新密码:", "");
    if (userInput != null && userInput.length > 0) {
        $.ajax({
            url: '/Admin/ChangePassword', type: 'POST', data: {
                id: id, password: userInput
            }, success: function (data) {
                window.alert("更新成功");
            }, error: function (xhr, status, error) {
                window.alert("更改失败");
                console.error('Error updating password: ' + error);
            }
        });
    }
}