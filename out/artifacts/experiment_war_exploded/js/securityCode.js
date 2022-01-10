function initCode() {
    var code="";
    for (let num=0;num<4;num++)
    {
        var index = randomInteger(1, 3);
        switch (index)
        {
            case 1:
                code+=String.fromCharCode(randomInteger(48,10));
                break;
            case 2:
                code+=String.fromCharCode(randomInteger(65,26));
                break;
            case 3:
                code+=String.fromCharCode(randomInteger(97,26));
                break;
        }
    }
    return code;
}


function randomInteger(start,length) {
    return Math.ceil(Math.random()*length+start-1);
}

//在canvas上画画
function drawCode(eleId,codeStr) {
    // var c=document.getElementById("security-code-img");
    let canvas=document.getElementById(eleId);
    let width = canvas.width;
    let height = canvas.height;
    let ctx=canvas.getContext("2d");
    ctx.fillStyle = randomColor(180, 240);
    //颜色若太深可能导致看不清
    ctx.fillRect(0,0,width,height);

    for(let i=0;i<20;i++) {
        ctx.strokeStyle = randomColor(40, 180);
        ctx.beginPath();
        ctx.moveTo(randomInteger(width/6,width), randomInteger(0,height/2));
        ctx.lineTo(randomInteger(0,width), randomInteger(0,height));
        ctx.stroke();
    }
    /**绘制干扰点**/
    for(let i=0;i <50;i++) {
        ctx.fillStyle = randomColor(255);
        ctx.beginPath();
        ctx.arc(randomInteger(0, width), randomInteger(0, height),1,0,2* Math.PI);
        ctx.fill();
    }

    for(let i = 0;i < codeStr.length; i++) {

        ctx.fillStyle = randomColor(50,160);
        //随机生成字体颜色
        ctx.font = randomInteger(90,20) +'px SimHei';
        //随机生成字体大小
        let x = 10 + i * 50;
        let y = randomInteger(100, 35);
        let deg = randomInteger(-30, 60);
        //修改坐标原点和旋转角度
        ctx.translate(x, y);
        ctx.rotate(deg * Math.PI /180);
        ctx.fillText(codeStr[i],0,0);
        //恢复坐标原点和旋转角度
        ctx.rotate(-deg * Math.PI /180);
        ctx.translate(-x, -y);
    }


}
//随机颜色
function randomColor(min, max) {
    let r = randomInteger(min, max-min);
    let g = randomInteger(min, max-min);
    let b= randomInteger(min, max-min);
    return "rgb(" + r + "," + g + "," + b + ")";
}