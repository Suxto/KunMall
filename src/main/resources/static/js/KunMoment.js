let moment_idx = -1;

Dropzone.options.myDropzone = {
    maxFiles: 9, // 最大上传文件数量
    maxFilesize: 5,
    addRemoveLinks: true,
    acceptedFiles: ".jpg,.jpeg",
    dictRemoveFile: "删除",
    dictDefaultMessage: "拖放图片到这里或点击上传",
    thumbnailWidth: 120,
    thumbnailHeight: 120,
    parallelUploads: 9,
    autoProcessQueue: false,
    params: {id: moment_idx},

    dictMaxFilesExceeded: "最多只能上传" + 9 + "个文件！",
    dictResponseError: '文件上传失败!',
    dictInvalidFileType: "文件类型只能是*.jpg,*.gif,*.png,*.jpeg",
    dictFallbackMessage: "浏览器不受支持",
    dictFileTooBig: "文件过大上传文件最大支持.",
    dictRemoveLinks: "删除",
    dictCancelUpload: "取消",
    init: function () {
        let submitButton = document.querySelector("#submit-button");
        let that = this;
        submitButton.addEventListener("click", function () {
            $.post("/UploadKunMomentMetaData", {
                text: $('#postText').val()
            }, function (data) {
                console.log(data)
                moment_idx = data
            }).done(
                function () {
                    that.options.params = {"id": moment_idx};
                    that.processQueue();
                    // $('#uploadModal').modal('hide');
                    location.reload();
                }
            )
            // console.log($("#postText").val());

        });


    }
};


