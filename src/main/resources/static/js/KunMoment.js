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
                    setTimeout(function () {
                        location.reload();
                    }, 300);
                }
            )
            // console.log($("#postText").val());

        });


    }
};

function toggle_text(id) {
    let div_id = "#momentText" + id;
    let btn_id = "#toggleButton" + id;
    let contentDiv = $(div_id);
    let toggleButton = $(btn_id);
    let object_height = parseFloat(contentDiv.css("line-height")) * 3
    // console.log(div_id, '--', btn_id);
    let currentMaxHeight = parseFloat(contentDiv.css("max-height").replace("px", ""));

    // if (contentDiv.css("max-height").replace("px", "") <= object_height) {
    //     contentDiv.stop().animate({'max-height': '1000em'}, 500);
    //     toggleButton.text('收起');
    // } else {
    //     contentDiv.stop().animate({'max-height': object_height}, 500);
    //     toggleButton.text('展开');
    // }
    if (currentMaxHeight <= object_height) {
        contentDiv.stop().animate({'max-height': '100em'}, {
            duration: 800,
            complete: function () {
                toggleButton.text('收起');
            }
        });
    } else {
        contentDiv.stop().animate({'max-height': object_height + 'px'}, {
            duration: 800,
            complete: function () {
                toggleButton.text('展开');
            }
        });
    }
}


function judge(id) {
    let div_id = "#momentText" + id;
    let btn_id = "#toggleButton" + id;
    let contentDiv = $(div_id);
    let toggleButton = $(btn_id);
    let object_height = parseFloat(contentDiv.css("line-height")) * 3
    let line_height = contentDiv.outerHeight();
    contentDiv.css("max-height", object_height + "px")
    // console.log(id, '-------', line_num)
    if (line_height <= object_height) toggleButton.hide();
}

function comment(id) {
    let text_id = "#commentInput" + id;
    let text_area = $(text_id)
    let text = text_area.val();
    $.post("addComment", {moment_id: id, content: text}, function (result) {
        console.log(result);
    })
    text_area.val("");
    setTimeout(function () {
        refresh(id);
    }, 300);
    let comment_num = $('#commentNun' + id);
    let num = parseInt(comment_num.text());
    comment_num.text(num + 1);
}

function toggle_comment(id) {
    let btn_id = '#commentToggleBtn' + id;
    let toggle_btn = $(btn_id);
    let status = toggle_btn.attr('aria-expanded') === 'true';
    // console.log(status)
    if (status) {
        refresh(id)
    }
}

function refresh(id) {
    let comment_area_div = $('#comments' + id);
    $.getJSON("/getComments", {moment_id: id}, function (data) {
        // console.log(data)
        comment_area_div.empty();
        $.each(data, function (index, comment) {
            let commentHtml = '<div class="card card-body comment"><span class="comment-user-name">' +
                comment.userName + '</span>' + comment.content + '</div>';
            comment_area_div.append(commentHtml);
        });
    })
}

function like(id) {

}