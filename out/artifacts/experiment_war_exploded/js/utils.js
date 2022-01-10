
let Utils={
    USER_AUTH_KEY: "Authorization",
    USER_INFO_KEY :"UserInformation",
    BASE_URL: "http://localhost:8083",
    setUserInfo(info){
        window.sessionStorage.setItem(this.USER_INFO_KEY,JSON.stringify(info))
    },
    getUserInfo(){
        let userInfo=null
        axios.get(`${this.BASE_URL}/user/getInfo/${this.getSessionInfo().username}`).then(rs => {
            userInfo = rs//rs.data.data.result;
        }).catch(err => { console.log(err) })
        return this.getSessionInfo()
        // return JSON.parse(window.sessionStorage.getItem(this.USER_INFO_KEY));
    },
    
    

    //登录过后的信息保存
    getSessionInfo(){
        return JSON.parse(window.sessionStorage.getItem(this.USER_AUTH_KEY));
    },
    setSessionInfo(info){
        window.sessionStorage.setItem(this.USER_AUTH_KEY,JSON.stringify(info))
    },
    checkLogin()
    {
        let info=this.getSessionInfo()
        if(info == null || info=='')
        {
            window.location.href="./login.html"
        }
    },
    initAxios(){
        axios.defaults.headers.common[this.USER_AUTH_KEY] = this.getSessionInfo().token
    },

}

function warningMsg(box,msg){
    box({
        showClose: true,
        message: msg,
        type: 'warning'
    });
}
function errorMsg(box,msg){
    box({
        showClose: true,
        message: msg,
        type: 'error'
    });
}
function successMsg(box,msg){
    box({
        showClose: true,
        message: msg,
        type: 'success'
    });
}