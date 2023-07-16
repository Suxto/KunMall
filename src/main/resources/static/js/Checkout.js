function submit() {
    const data = {
        CPUName: document.getElementById("cpuName").innerText,
        GPUName: document.getElementById("gpuName").innerText,
        MemoryName: document.getElementById("memoryName").innerText,
        DriveName: document.getElementById("driveName").innerText,
        sum: document.getElementById("money").innerText,
        address: document.getElementById("address").value,
        common: document.getElementById("comment").value
    };
    // console.log(data)
    // 填充表单数据
    document.getElementById("hidden_cpuName").value = data.CPUName;
    document.getElementById("hidden_gpuName").value = data.GPUName;
    document.getElementById("hidden_memoryName").value = data.MemoryName;
    document.getElementById("hidden_driveName").value = data.DriveName;
    document.getElementById("hidden_sum").value = data.sum;
    document.getElementById("hidden_address").value = data.address;
    document.getElementById("hidden_comment").value = data.common;
    console.log(document.getElementById("hiddenForm"));
    // 提交表单
    // document.getElementById("hiddenForm").submit();
    document.getElementById("sb").click();
}