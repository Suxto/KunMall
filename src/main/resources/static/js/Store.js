function ChangeSubmit(btn) {
    // 获取当前按钮所在的行
    let row = btn.parentNode.parentNode;

    // 获取名称、价格和剩余量
    let name = row.cells[0].textContent;
    let price = row.cells[1].querySelector('input');
    let quantity = row.cells[2].querySelector('input');
<<<<<<< Updated upstream
    let cost=price.value;//价格
    let num=quantity.value;//数量
    if (btn.textContent === "编辑") {
        price.readOnly=true;
        quantity.readOnly=true;
=======
<<<<<<< Updated upstream
    if (price.readOnly !== false) {
=======
    let cost = price.value;//价格
    let num = quantity.value;//数量
    if (btn.textContent === "编辑") {
        price.readOnly = true;
        quantity.readOnly = true;
    } else {
        price.readOnly = false;
        quantity.readOnly = false;
    }
    // 在控制台输出名称、价格和剩余量
    console.log("名称：" + name + "，价格：" + price + "，剩余量：" + quantity);

}

function Clicked(ID) {
    const btn = document.getElementById(ID);
    if (btn.textContent === "编辑") {
>>>>>>> Stashed changes
        btn.innerText = "提交";
        price.readOnly = false;
        quantity.readOnly = false;
>>>>>>> Stashed changes
    } else {
        price.readOnly=false;
        quantity.readOnly=false;
    }
    // 在控制台输出名称、价格和剩余量
    console.log("名称：" + name + "，价格：" + price + "，剩余量：" + quantity);

}
function showForm() {
    // 获取表格的<tbody>元素和第一行
    const tbody = document.querySelector('.Module tbody');
    const firstRow = tbody.querySelector('tr');

<<<<<<< Updated upstream
function Clicked(ID) {
    const btn = document.getElementById(ID);
    if (btn.textContent === "编辑") {
        btn.innerText = "提交";
    } else {
        btn.innerText = "编辑";
    }
    ChangeSubmit(btn);
    console.log('按钮被点击了！');
    /*btn.addEventListener('click', function (event) {
        console.log('按钮被点击了！');
    });*/
}

/*Uncaught ReferenceError: Clicked is not defined
    at HTMLButtonElement.onclick (Store.html:124:88)*/
=======
<<<<<<< Updated upstream
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
=======
    // 创建一个新的<tr>元素
    const newRow = document.createElement('tr');

    // 添加新行的HTML内容，包括四个<td>元素
    newRow.innerHTML = '<td><input  type="text" name="name" style="width: 100px;"></td>' +
        '<td><input  type="number" name="price" style="width: 100px;">元</td>' +
        '<td><input  type="number" name="amount" style="width: 100px;">件</td>' +
        '<td><button id="save" type="button" class="btn btn-primary" onclick="SaveNewChange()">保存</button></td>';

    // 将新行插入到第一个行的前面
    tbody.insertBefore(newRow, firstRow);
}
/*function showForm() {
    // 获取表格的<tbody>元素
    const tbody = document.querySelector('.Module tbody');

    // 创建一个新的<tr>元素
    const newRow = document.createElement('tr');

    // 添加新行的HTML内容，包括四个<td>元素
    newRow.innerHTML = '<td><input  type="text" name="name" style="width: 100px;"></td>' +
        '<td><input  type="number" name="price" style="width: 100px;">元</td>' +
        '<td><input  type="number" name="amount" style="width: 100px;">件</td>' +
        '<td><button id="save" type="button" class="btn btn-primary" onclick="SaveNewChange()">保存</button></td>';
    // 将新行添加到表格的<tbody>元素中
    tbody.appendChild(newRow);
}*/
function SaveNewChange(){
    const save=document.getElementById("save").parentNode.parentNode;


}
/*Uncaught ReferenceError: Clicked is not defined
    at HTMLButtonElement.onclick (Store.html:124:88)*/
>>>>>>> Stashed changes
>>>>>>> Stashed changes
