var postsave = {
    init : function(){
        var _this = this;
        $('#btn-save').on('click', function(){_this.save();});
        $('#btn-update').on('click', function(){_this.update();});
        $('#btn-delete').on('click', function(){_this.delete();});
    },

    update : function(){
        var data ={
            title: $('#title').val(),
            content: $('#content').val()
        };

        var id = $('#id').val();

        $.ajax({
            type: 'PUT',
            url: '/api/v1/posts/' + id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function(){
            alert('글이 수정되었습니다.');
            window.location.href = '/posts/list'; //전체 조회화면 이동
        }).fail(function(){
            alert(JSON.stringify(error));
        });
    },

    delete : function(){
        var id = $('#id').val();

        $.ajax({
            type: 'DELETE',
            url: '/api/v1/posts/' + id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8'
            }).done(function(){
                alert('글이 삭제되었습니다.');
                window.location.href = '/posts/list'; //전체 조회화면 이동
            }).fail(function(){
                alert(JSON.stringify(error));
            });
    },

    save : function(){
        var data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('textarea#content').val() //textarea는 # 앞에 textarea를 지정해줘야 함.
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/posts',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function(){
            alert('글이 등록되었습니다.');
            window.location.href = '/posts/list'; //전체 조회화면 이동
        }).fail(function(error){
            alert(JSON.stringify(error));
        });

    }
};

postsave.init();