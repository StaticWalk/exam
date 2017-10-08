var t;
function timedCount() {
    var temptextmin = document.getElementById('txt');
    var now = new Date();//定义一个现在的时间
    var SetStart = new Date();//设置开始考试时间
     // SetStart.setHours(21, 30, 00);//时，分，秒
    var SetEnd = new Date();//设置结束考试时间
    SetEnd.setHours(22, 30, 00);//时，分，秒

    var leftTime=SetEnd.getTime()-now.getTime();
    var leftsecond = parseInt(leftTime/1000);
    var hour=Math.floor(leftsecond/3600);
    var minute=Math.floor((leftsecond-hour*3600)/60);
    var second=Math.floor(leftsecond-hour*3600-minute*60);
    if((hour==0)&(minute ==0)&(second == 0))
    {//判断时间和考试开始时间是否一致
        alert("考试结束，接下来将自动帮你提交试卷");

        document.getElementById("myform").submit();

        // btn.submit();  //提交
    }
    temptextmin.value = hour + "时" + minute + "分" + second + "秒";
    t=setTimeout("timedCount()",1000);
}

function changeColor(num){
    var button = document.getElementById(num);
    button.style.background="#429AB7";
    button.style.color="white";
}
function clickMove(index){
    document.getElementsByTagName("p")[index].scrollIntoView(true);
}

window.onload=function() {
    timedCount();
    var Botton = document.getElementById('btn');
        Botton.onclick = function () {
            if (confirm("确认提交?")) {
                window.open("loading.html", "_self");
                document.getElementById("myform").submit();
            } else {
            }
        }
    }
//



