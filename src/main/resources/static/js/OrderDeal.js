function changeStatus(id) {
    var sel = document.getElementById("status_" + id);
    // console.log(id,'   ',sel.value);
    $.ajax({
        url: '/Admin/ChangeStatus',
        type: 'POST',
        data: {
            id: id,
            status: sel.value
        }, success: function (data) {
            window.alert("修改成功");
        }, error: function (xhr, status, error) {
            console.error('Error updating password: ' + error);
            window.alert("失败");
        }
    });
}