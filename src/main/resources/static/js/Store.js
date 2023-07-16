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

function showForm() {
    // 创建一个新的<tr>元素
    const tbody = document.querySelector('.Module tbody');
    const firstRow = tbody.querySelector('tr');
    const newRow = document.createElement('tr');
// 添加新行的HTML内容，包括四个<td>元素
    newRow.innerHTML = '<td><input  type="text" name="name" style="width: 100px;"></td>' +
        '<td><input  type="number" name="price" style="width: 100px;">元</td>' +
        '<td><input  type="number" name="amount" style="width: 100px;">件</td>' +
        '<td><button id="save" type="button" class="btn btn-primary" onclick="SaveNewChange()">保存</button></td>';

// 将新行插入到第一个行的前面
    tbody.insertBefore(newRow, firstRow);

}

function SaveNewChange() {
    const save = document.getElementById("save").parentNode.parentNode;
}

