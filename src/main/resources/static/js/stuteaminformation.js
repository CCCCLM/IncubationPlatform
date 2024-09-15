$(document).ready(function () {
    classificationClick();
    mainPeasonClick();
    peasonClone();
    $("#baoming").validate();
})

/*
负责人人数点击事件
根据负责人人数对成员人数进行选择
 */
function mainPeasonClick(){
    $("#mainPeason").change(function () {
        var classification = $('#classification option:selected').val();
        var mainPeason = $('#mainPeason option:selected').val();
        getPeason(classification,mainPeason);
    })
}
/*项目分类点击事件
* 根据项目分类进行成员人数的选择*/
function classificationClick(){
    $("#classification").change(function () {
        var classification = $('#classification option:selected').val();
        var mainPeason = $('#mainPeason option:selected').val();
        getPeason(classification,mainPeason);
    })
}
/*得到项目种类以及负责人人数
* 对成员人数进行选择*/
function getPeason(classification,mainPeason){
    if((classification==2||classification==3)&&mainPeason==1){
        $("#peason option").remove()
        for(var i=1;i<=5;i++){
            $("#peason").append("<option value="+i+">"+i+'人'+"</option>");
        }
        $("#peason option[value='1']").attr("selected","selected")
    }
    if (classification == 1 && mainPeason == 1) {
        $("#peason option").remove()
        for(var i=2;i<=7;i++){
            $("#peason").append("<option value="+i+">"+i+'人'+"</option>");
        }
        $("#peason option[value='2']").attr("selected","selected")
    }
    if (classification == 1 && mainPeason == 2) {
        $("#peason option").remove()
        for(var i=1;i<7;i++){
            $("#peason").append("<option value="+i+">"+i+'人'+"</option>");
        }
        $("#peason option[value='1']").attr("selected","selected")
    }
    if((classification==2||classification==3)&&mainPeason==2){
        $("#peason option").remove()
        for(var i=1;i<=4;i++){
            $("#peason").append("<option value="+i+">"+i+'人'+"</option>");
        }
        $("#peason option[value='1']").attr("selected","selected")
    }
}

/*随着点击的成员人数进行成员信息表格的添加和删除*/
function peasonClone(){
    addPeason();
    $("#peason").change(function () {
        for (var i = 0; i<=$('#Peasons').children().length+4; i++) {
            $("#people"+i).remove()
        }
        addPeason();
    })
}
/*添加一个填写成员的表格*/
function addPeason(){
    var peason = $('#peason option:selected').val();
    for (var i = 0; i < peason ; i++) {
        ($("#people").clone()).attr('id','people'+i).show().insertAfter($("#people"));
    }
}
/*负责人人数的显示*/
$("#mainPeason").bind("change",function() {
    var value = $("#mainPeason option:selected").val();
    if(value==2){
        $('#oneMainPeason').css("display","none");
        $('#twoMainPeason').css("display","block");
    }else {
        $('#oneMainPeason').css("display","block");
        $('#twoMainPeason').css("display","none");
    }
})

/*指导老师人数的显示*/
$("#tutorNumber").bind("change",function() {
    var value = $("#tutorNumber option:selected").val();
    if(value==2){
        $('#onetutor').css("display","none");
        $('#twotutor').css("display","block");
    }else {
        $('#onetutor').css("display","block");
        $('#twotutor').css("display","none");
    }
})

/*
表单验证
 */
$.validator.setDefaults({
    submitHandler: function() {
        alert("提交事件!");
    }
});

var person = [
    {text:'2人',value:'2'},
    {text:'3人',value:'3'},
    {text:'4人',value:'4'},
    {text:'5人',value:'5'},
    {text:'6人',value:'6'},
    {text:'7人',value:'7'},
    ]
var projectVue = new Vue({
    el:'#changeProject',
    data:{
        data:[],
        team:[],
        teacherList:[],
        person:[]
    },
    created: function () {
        var that=this;
        $.ajax({
            url:"student/declare",
            method:"POST",
            success:function (data) {
                that.data=data;
                that.team=data.data.team;
                that.teacherList=data.data.teacherList;
                this.person = person;
            }
        });
    },
    computed: {
        partMainPersonNum:function () {
            var count=0;
            while(team.length>0){
                if(this.team.is_main==true){
                    count++;
                }
            }
            return count;
        },
        mainPerson:function () {
            while(team.length>0){
                if(this.team.is_main==true){
                    return this.team;
                }
            }
        },
        personNum:function () {
            var count= 0;
            while (team.length>0){
                if(this.team.is_main!=true){
                    count++;
                }
            }
            return count;
        },
        person:function () {
            while(team.length>0){
                if(this.team.is_main!=true){
                    return this.team;
                }
            }
        }
    }
});