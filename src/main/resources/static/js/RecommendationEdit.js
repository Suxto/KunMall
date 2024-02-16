window.onload = function () {
    Select();
};

function Select() {
    // 获取选中的单选按钮的值和 ID
    let cpuRadio = document.querySelector('input[name="optradio-cpu"]:checked');
    let gpuRadio = document.querySelector('input[name="optradio-gpu"]:checked');
    let memoryRadio = document.querySelector('input[name="optradio-memory"]:checked');
    let diskRadio = document.querySelector('input[name="optradio-disk"]:checked');
    if (cpuRadio) {
        Import(cpuRadio, 'cpu');
    }
    if (gpuRadio) {
        Import(gpuRadio, 'gpu');
    }
    if (memoryRadio) {
        Import(memoryRadio, 'memory');
    }
    if (diskRadio) {
        Import(diskRadio, 'disk');
    }
    SumMoney();
}

var cpuName, gpuName, memoryName, driveName;
var cpuID, gpuID, memoryID, driveID;

function Import(selectedRadio, type) {
    let table = selectedRadio.parentNode.querySelector('table');
    let tdElements = table.querySelectorAll('tr > td:nth-child(2)');
    let nameValue = tdElements[0].textContent;
    let name = tdElements[0].previousElementSibling.textContent;
    switch (type) {
        case 'cpu': {
            let cpu_select = document.getElementById('cpu-select');
            let cpuValue_select = document.getElementById('cpuValue-select');
            cpuName = name;
            cpuID = selectedRadio.value;
            cpu_select.textContent = 'CPU型号：' + name;
            cpuValue_select.textContent = '价格：' + nameValue;
            break;
        }
        case 'gpu': {
            let gpu_select = document.getElementById('gpu-select');
            let gpuValue = document.getElementById('gpuValue-select');
            gpuName = name;
            gpuID = selectedRadio.value;
            gpu_select.textContent = '显卡型号：' + name;
            gpuValue.textContent = '价格：' + nameValue;
            break;
        }
        case 'memory': {
            let memory_select = document.getElementById('memory-select');
            let memoryValue_select = document.getElementById('memoryValue-select');
            memoryName = name;
            memoryID = selectedRadio.value;
            memory_select.textContent = '内存型号：' + name;
            memoryValue_select.textContent = '价格：' + nameValue;
            break;
        }
        case 'disk': {
            let disk_select = document.getElementById('disk-select');
            let diskValue_select = document.getElementById('diskValue-select');
            driveName = name;
            driveID = selectedRadio.value;
            disk_select.textContent = '硬盘型号：' + name;
            diskValue_select.textContent = '价格：' + nameValue;
            break;
        }
    }
}

var c, g, m, d, sum;

function SumMoney() {
    const cpuValue = document.getElementById('cpuValue-select');
    const gpuValue = document.getElementById('gpuValue-select');
    const memoryValue = document.getElementById('memoryValue-select');
    const diskValue = document.getElementById('diskValue-select');
    sum = 0;
    c = parseFloat(cpuValue.textContent.split("：").at(1));
    g = parseFloat(gpuValue.textContent.split("：").at(1))
    m = parseFloat(memoryValue.textContent.split("：").at(1))
    d = parseFloat(diskValue.textContent.split("：").at(1))
    if (c) sum += c;
    if (g) sum += g;
    if (m) sum += m;
    if (d) sum += d;
    const SumMoney = document.getElementById('SumMoney');
    SumMoney.value = sum;
    console.log(SumMoney.value);
}


function Submit() {
    var comment = document.getElementById('description').value;
    window.location.href = '/SubmitCommends?'
        + 'cpuID=' + cpuID
        + '&gpuID=' + gpuID
        + '&memoryID=' + memoryID
        + '&driveID=' + driveID
        + '&comment=' + comment;
}