let moment_idx = -1;
let moment_del = -1
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
    let like_num_text = $('#likeNum' + id);
    let like_num = parseInt(like_num_text.text());
    console.log(like_num)
    // showLikeToast('点赞成功');
    $.post("/likeMoment", {moment_id: id}, function (data) {
        console.log(data)
        if (data === 1) {
            like_num++
            like_num_text.text(like_num)
            showLikeToast('点赞成功');
        } else {
            like_num--
            like_num_text.text(like_num)
            showLikeToast('已赞过，现取消点赞')
        }
    });
}

function showLikeToast(message) {
    // 创建一个toast元素
    let likeStatusToast = $('#likeStatusToast');
    let toastBody = likeStatusToast.find('.toast-body');

    // 设置toast的文字
    toastBody.text(message);
    likeStatusToast.removeClass('toast-fade-out');
    // 添加动画类，实现淡入效果
    likeStatusToast.addClass('toast-fade-in');

    // 显示toast
    likeStatusToast.toast('show');

    setTimeout(function () {
        likeStatusToast.removeClass('toast-fade-in').addClass('toast-fade-out');
    }, 300);

    // 隐藏toast后移除动画类
    likeStatusToast.on('hidden.bs.toast', function () {
        likeStatusToast.removeClass('toast-fade-out');
    });

}

function queryRemove(id) {
    moment_del = id
    $('#confirmationModal').modal('show');
}


function removeMomentSel() {
    if (moment_del === -1) {
        return
    }
    $.post("/Admin/RemoveMoment", {moment_id: moment_del}, function (data) {
        // console.log(data, data === 'ok')
        if (data === 'ok') {
            $('#confirmationModal').modal('hide');
            showLikeToast("已删除")
            let id = 'moment' + moment_del.toString();
            console.log(id);
            // $('#' + id).empty();
            $('#' + id).remove();
        } else {
            showLikeToast("删除失败")
        }
        moment_del = -1
    });

}

