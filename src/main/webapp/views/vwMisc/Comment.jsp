<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>E-Commerce Web Application</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        body {
            margin: 0 auto;
            }

        .comment-wrap{border:1px solid #e6e6e6;border-radius:5px;padding:25px 25px 20px}
        .comment-wrap.mt-30{
            margin-top:30px
        }
        .comment-title{font-size:20px;line-height:26px;color:#333;font-weight:600;font-family:"Inter",-apple-system,BlinkMacSystemFont,"Segoe UI","Helvetica Neue","Arial","Apple Color Emoji","Segoe UI Emoji","Segoe UI Symbol",sans-serif;display:flex;align-items:center}
        .comment-title svg{position:relative;left:-5px;margin:0 10px 0 0}
        .comment-action{font-family:"Inter",-apple-system,BlinkMacSystemFont,"Segoe UI","Helvetica Neue","Arial","Apple Color Emoji","Segoe UI Emoji","Segoe UI Symbol",sans-serif;font-weight:500;color:gray}
        .comment-action>*:not(:first-child){margin:0 0 0 7px}
        .comment-action button{padding:0;background:transparent none;border:0;color:#2361ff;cursor:pointer;display:flex;align-items:center;font-weight:500;font-family:"Inter",-apple-system,BlinkMacSystemFont,"Segoe UI","Helvetica Neue","Arial","Apple Color Emoji","Segoe UI Emoji","Segoe UI Symbol",sans-serif}
        .comment-action button:not(:nth-child(1))::before{content:"";position:relative;width:0;height:18px;border-left:1px solid #ccc;margin:0 7px 0 0}
        .comment-box .textarea{background:#f1f5f9 none;border-radius:5px;padding:12px;color:#333;border:0;width:50%;height:140px;display:block;outline:none;resize:none}
        .comment-box .action{margin:8px 0 0;display:flex;justify-content:space-between;align-items:center;min-height:34px}
        .comment-box .note{flex:0 0 auto;max-width:100%;width:calc(100% - 140px);color:gray;display: flex;justify-content: left;padding-left:15% }
        .comment-box .submit{border:0;padding:1px 0 0;border-radius:5px;background:#1a7900 none;color:#f8fafc;font-weight:600;  ;font-size:14px;line-height:18px;width:120px;height:34px;font-family:"Inter",-apple-system,BlinkMacSystemFont,"Segoe UI","Helvetica Neue","Arial","Apple Color Emoji","Segoe UI Emoji","Segoe UI Symbol",sans-serif;cursor:pointer}
        .comment-box.dark .textarea{background-color:#1e293b;color:#b3b3b3}
        .comment-container{margin:20px 0 0}
        .comment-nav>*{float:left}
        .comment-nav>*:not(:first-child){margin:0 0 0 20px}
        .comment-nav button{border:0;padding:7px 0;background:transparent none;font-size:14px;line-height:16px;font-weight:600;color:gray;font-family:"Inter",-apple-system,BlinkMacSystemFont,"Segoe UI","Helvetica Neue","Arial","Apple Color Emoji","Segoe UI Emoji","Segoe UI Symbol",sans-serif;position:relative;cursor:pointer}
        .comment-nav button .comment-nav.dark button{color:#b3b3b3}
        .comment-list{margin:0;padding:0;list-style:none}
        .comment-list>li{margin:20px 0 0}
        .comment-list>li:not(:first-of-type){border-top:1px solid #e6e6e6;padding:20px 0 0}



        .comment-empty{position:relative;text-align:center}
        .comment-empty svg{stroke:#999}
        .comment-empty span{margin:10px 0 0;display:block}
        .comment-avatar img{width:100%;border-radius:50%}





        .comment-box .textarea {
            background: #f1f5f9 none;
            border-radius: 5px;
            padding: 12px;
            margin-left: 15%;
            margin-right: 25%;
            color: #333;
            border: 0;
            width: 70%;
            display: flex;
            height: 175px;
            outline: none;
            resize: none;
            text-align: left;
            justify-content: center;
        }

        .flex-jcb {
            display: flex;
            align-items: center;
            justify-content: space-between;
            margin: 0px 300px;
            padding-bottom: 10px;
        }
        *, ::after, ::before {
            box-sizing: border-box;
        }

    </style>
</head>
<body>
<form action="" method="post">
<div id="comment " data-module="comment" data-objectid="20230102121759718"  >
    <div class="comment-wrap mt-30  ">
        <div class="comment-head flex-jcb ">
            <div class="comment-title flex-jcc ">
                <svg viewBox="0 0 53 45" fill="none" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" width="53" height="45">
                    <path d="M25 33a2.667 2.667 0 0 0 2.667 2.667h16L49 41V19.667A2.667 2.667 0 0 0 46.333 17H27.667A2.667 2.667 0 0 0 25 19.667V33Z" fill="#2361FF" fill-opacity="0.6">
                    </path>
                    <path d="M35 25a3.333 3.333 0 0 1-3.333 3.333h-20L5 35V8.333A3.333 3.333 0 0 1 8.333 5h23.334A3.333 3.333 0 0 1 35 8.333V25Z" fill="#1A7900" opacity="0.5">
                    </path>
                </svg>
                Bình luận (0)
            </div>
            <div class="comment-action flex-jcc"><div class="comment-author">
                Cao Ngoc Quy
            </div>
                <button type="button" class="login">
                    Đăng xuất
                </button>
            </div>
        </div>
        <div class="comment-box ">

            <textarea class="textarea" name="comment" placeholder="Bạn nghĩ gì về thông tin này?"> </textarea>
            <div class="action ">
                <div class="note ">
                    Ý kiến của bạn sẽ được xét duyệt trước khi đăng. Xin vui lòng gõ tiếng Việt có dấu
                </div>
                    <button type="submit" class="submit flex-jcc" disabled="">
                        Gửi bình luận
                        <%--                    <svg aria-hidden="true" width="18" height="18" viewBox="0 0 32 32" fill="none" xmlns="http://www.w3.org/2000/svg">--%>
                        <%--                        <path d="M13 22L19 16L13 10" stroke="#F8FAFC" stroke-width="2.5" stroke-linecap="round" stroke-linejoin="round">--%>
                        <%--                        </path>--%>
                        <%--                    </svg>--%>
                    </button>

            </div>
        </div>
        <div class="comment-container">
        <ul class="comment-list ">
            <li>
                <div class="comment-empty">
                    <svg aria-hidden="true" width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M4 22V15" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round">

                        </path>
                        <path d="M4 15C4 15 5 14 8 14C11 14 13 16 16 16C19 16 20 15 20 15V3C20 3 19 4 16 4C13 4 11 2 8 2C5 2 4 3 4 3V15Z" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round">

                        </path>
                    </svg>
                    <span>
                        Hiện chưa có bình luận nào, hãy trở thành người đầu tiên bình luận cho bài viết này!
                    </span>
                </div>
            </li>
        </ul>
    </div>
    </div>
</div>
</form>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>

</body>
</html>
