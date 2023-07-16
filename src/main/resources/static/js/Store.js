function ChangeSubmit(btn, attribute) {
    // 获取当前按钮所在的行
    let row = btn.parentNode.parentNode;

    // 获取名称、价格和剩余量
    let name = row.cells[0].textContent;
    let price = row.cells[1].querySelector('input');
    let quantity = row.cells[2].querySelector('input');
    let cost = price.value;//价格
    let num = quantity.value;//数量
    if (btn.textContent === "编辑") {
        price.readOnly = true;
        quantity.readOnly = true;
        let attrs = attribute.split("_")
        // 在控制台输出名称、价格和剩余量
        // console.log("名称：" + name + "，价格：" + price + "，剩余量：" + quantity);
        $.ajax({
            url: '/Admin/UpdateComponent',
            type: 'POST',
            data: {
                id: attrs.at(1),
                type: attrs.at(0),
                price: cost,
                amount: num
            },
            success: function (data) {
                window.alert("更新成功");
                // location.reload();
            },
            error: function (xhr, status, error) {
                window.alert("失败");
                console.error('Error updating password: ' + error);
            }
        });
    } else {
        price.readOnly = false;
        quantity.readOnly = false;

    }
}

function Clicked(ElemID) {
    const btn = document.getElementById(ElemID);
    if (btn.textContent === "编辑") {
        btn.innerText = "提交";
    } else {
        btn.innerText = "编辑";
    }
    ChangeSubmit(btn, ElemID);
    console.log('按钮被点击了！');
}
