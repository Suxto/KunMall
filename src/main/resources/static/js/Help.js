function AdminPush(id) {
    const push = document.getElementById("talk");//获取输入框
    const pushValue = push.value;
    console.log(push, pushValue);
    $.ajax({
        url: '/Admin/Reply', type: 'POST', data: {
            id: id,
            content: pushValue
        }, success: function (data) {
            location.reload();
        }, error: function (xhr, status, error) {
            window.alert("发送失败");
            console.error('Error updating role: ' + error);
        }
    });
}

function Push() {
    const push = document.getElementById("talk");//获取输入框
    const pushValue = push.value;
    // console.log(push, pushValue);
    $.ajax({
        url: '/SendMsg', type: 'POST', data: {
            content: pushValue
        }, success: function (data) {
            location.reload();
        }, error: function (xhr, status, error) {
            window.alert("发送失败");
            console.error('Error updating role: ' + error);
        }
    });
}

function Refresh() {
    location.reload();
}