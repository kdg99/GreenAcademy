<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>jQuery UI Tabs - Default functionality</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#tabs" ).tabs();
  } );
  </script>
</head>
<body>
 
<div id="tabs">
    <ul>
        <li><a href="#tabs-1">공지사항</a></li>
        <li><a href="#tabs-2">1:1 고객문의</a></li>
        <li><a href="#tabs-3">자주묻는 질문</a></li>
    </ul>
    <div id="tabs-1">
    </div>
    <div id="tabs-2">
        <ul class="txt">
        </ul>
    </div>
    <div id="tabs-3">
        <ul class="txt">
        </ul>
    </div>
</div>
 
 
</body>
</html>