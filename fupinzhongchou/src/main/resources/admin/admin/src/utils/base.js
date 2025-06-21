const base = {
    get() {
        return {
            url : "http://localhost:8080/fupinzhongchou/",
            name: "fupinzhongchou",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/fupinzhongchou/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "扶贫众筹系统"
        } 
    }
}
export default base
