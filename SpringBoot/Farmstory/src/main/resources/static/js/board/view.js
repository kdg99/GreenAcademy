$(function(){

    $('.needLogin').click(function(){

        alert('로그인이 필요합니다.');
        location.href='/Farmstory/user/login';

        return false;
    });

});