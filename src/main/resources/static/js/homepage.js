/*
  大图背景自适应
   */
$(function () {
    var mydiv = $("#jumbotron-img");
    var mydiv_resize = function () {
        $(mydiv).css("width", $(window).width());
    };
    mydiv_resize();
    $(window).resize(function () {
        mydiv_resize();
    });
});


/*
通知通告
 */
var TZTG, message;
$.ajax({
    url: '/home/message',
    type: 'get',
    success: function (response) {
        message = response.data;
        TZTG = new Vue({
            el: '#message1',
            data: {
                message: message,
            },
            methods: {
                getMessageId(id) {
                    location.href = "message/detail/" + id;
                }
            },
            filters: {
                formatDate(time) {
                    var date = new Date(time);
                    var year = date.getFullYear();
                    var month = date.getMonth();
                    var day = date.getDate();
                    return year + '-' + (month + 1) + '-' + day;
                }
            },

        });
        return;
    }
});


var projectVue = new Vue({
    el:'#projectVue',
    data: {
        data:[],
        talent: [],
        link:[],
        venture:[],
        innovate:[],
        practice:[]
    },
    created: function () {
        var that=this;
        $.ajax({
            url:"/home/approval",
            method:"GET",
            success:function (data) {
                that.data=data;
                that.talent=data.data.talent;
                that.link=data.data.link;
                that.venture=data.data.venture;
                that.innovate=data.data.innovate;
                that.practice=data.data.practice;
            }
        });
    },
    computed: {
        partTalent: function () {
            if (this.talent.length > 5) {
                return this.talent.slice(0, 5);
            } else {
                console.log(this.talent)
                return this.talent;
            }
        }
    },
    methods: {
        //创新训练
        getCXXLId(id) {
            location.href = "approval/detail" + id;
        },
        //创业训练
        getCYXLId(id) {
            location.href = "approval/detail" + id;
        },
        //创业实践
        getCYSJId(id) {
            location.href = "approval/detail" + id;
        }
    }
});

<!--首屏渲染-->
var homeVue = new Vue({
    el: '#homeVue',
    filters: {
        abbreviationContent: function (content) {
            if (content.length > 40) {
                return (content.slice(0, 40)).concat("......");
            } else {
                return content;
            }
        }
    },
    data: {
        data:[],
        talent: [],
        link:[],
        excellentVenture:[],
        excellentInnovate:[],
        excellentPractice:[]
    },
    created: function () {
        var that=this;
        $.ajax({
            url:"/home",
            method:"GET",
            success:function (data) {
                that.data=data;
                that.talent=data.data.talent;
                that.link=data.data.link;
                that.excellentVenture=data.data.excellentVenture;
                that.excellentInnovate=data.data.excellentInnovate;
                that.excellentPractice=data.data.excellentPractice;
            }
        });
    },
    computed: {
        partTalent: function () {
            if (this.talent.length > 5) {
                return this.talent.slice(0, 5);
            } else {
                console.log(this.talent)
                return this.talent;
            }
        }
    },
    methods: {
        //创新训练
        getCXXLJXId(id) {
                location.href = "approval/detail" + id;
        },
        //创业训练
        getCYXLJXId(id) {
            location.href = "approval/detail" + id;
        },
        //创业实践
        getCYSJJXId(id) {
            location.href = "approval/detail" + id;
        }
    }
});

<!--创业年会-->
var videoVue = new Vue({
    el: '#videoVue',
    filters: {
        abbreviationContent: function (title) {
            if (title.length > 20) {
                return (title.slice(0, 20)).concat("......");
            } else {
                return title;
            }
        }
    },
    created: function () {
        $.ajax({
            url:'/home/annual_meeting',
            method:"GET",
            success:function (result) {
                if (result.net === 2000) {
                    this.videoList=result.data.videlList;
                }else {
                    alert(result.msg)
                }
            }
        })
    },
    data: {
        videoList: []
    },
    methods: {
        partVideoList: function (index, Offset) {
            return this.videoList.slice(index * Offset - 2, index * Offset)
        }
    }
});