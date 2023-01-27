$(function(){
    $('#track').click(function(){

        // 1.빈창 팝업 생성
        var url = "/Farmstory/popup/track";
        var windowTargetName = "targetName";
        var features = "scrollbars=yes,width=1000,height=800,location=no, resizable=yes";
        window.open(url, windowTargetName, features);

        // 2.POST로 데이터 전달
        myForm.action=url; // 이동
        myForm.method="get";
        myForm.target=windowTargetName;
        myForm.submit();

    });
});