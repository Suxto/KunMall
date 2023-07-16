function ChangeSubmit(btn) {
    // 获取当前按钮所在的行
    let row = btn.parentNode.parentNode;

    // 获取名称、价格和剩余量
    let name = row.cells[0].textContent;
    let price = row.cells[1].querySelector('input');
    let quantity = row.cells[2].querySelector('input');
    let cost=price.value;//价格
    let num=quantity.value;//数量
    if (btn.textContent === "编辑") {
        price.readOnly=true;
        quantity.readOnly=true;
    } else {
        price.readOnly=false;
        quantity.readOnly=false;
    }
    // 在控制台输出名称、价格和剩余量
    console.log("名称：" + name + "，价格：" + price + "，剩余量：" + quantity);

}

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