function Clicked(ElemID) {
    console.log("clicked");
    const btn = document.getElementById(ElemID);
    let row = btn.parentNode.parentNode;
    let price = row.cells[1].querySelector('input');
    let quantity = row.cells[2].querySelector('input');
    if (price.readOnly !== false) {
        btn.innerText = "提交";
        price.readOnly = false;
        quantity.readOnly = false;
    } else {
        btn.innerText = "编辑";
        price.readOnly = true;
        quantity.readOnly = true;
        let attrs = ElemID.split("_");
        $.ajax({
            url: '/Admin/UpdateComponent', type: 'POST', data: {
                id: attrs.at(1),
                type: attrs.at(0),
                price: price.value,
                amount: quantity.value
            }, success: function (data) {
                window.alert("更新成功");
            }, error: function (xhr, status, error) {
                window.alert("失败");
                console.error('Error updating password: ' + error);
            }
        });
    }
}

function Remove(type, id) {
    $.ajax({
        url: '/Admin/DeleteComponent',
        type: 'POST',
        data: {
            id: id,
            type: type
        }, success: function (data) {
            window.alert("删除成功");
            location.reload();
        }, error: function (xhr, status, error) {
            window.alert("失败");
            console.error('Error updating password: ' + error);
        }
    });
}
