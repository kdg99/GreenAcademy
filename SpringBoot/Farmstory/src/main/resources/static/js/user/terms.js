$(function(){

    $('.btnNext').click(function(){

        let isCheck1 = $('input[class=terms]').is(':checked');
        let isCheck2 = $('input[class=privacy]').is(':checked');

        if(isCheck1 && isCheck2){
            return true;
        }else{
            alert('약관에 동의하셔야 진행 가능합니다.');
            return false;
        }
    });

});