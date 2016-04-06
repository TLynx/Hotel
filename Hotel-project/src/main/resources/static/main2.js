/**
 * Created by Администратор on 23.02.2016.
 */
$(document).on({
        mouseenter: function() {
        $( this ).addClass( "scale" );
    }, mouseleave: function() {
        $( this ).removeClass( "scale" );
    }
},".offer");

$(document).on("click",".selectDateB",function(){
    $("#selectDate").css("display","none");
    $(".changeDate").css("display","block");
    $("#offersHolder").css("display","block");

});

$(document).on("click",".changeDate",function(){
    $("#offersHolder").css("display","none");
    $("#selectDate").css("display","block");
    $(this).css("display","none");
    $("#userData").css("display","none");
    $(".changeRoom").css("display","none");
});

$(document).on("click",".resButton",function(){
    $("#offersHolder").css("display","none");
    $("#userData").css("display","block");
    $(".changeRoom").css("display","block");

});

$(document).on("click",".changeRoom",function(){
    $("#offersHolder").css("display","block");
    $("#userData").css("display","none");
    $(".changeRoom").css("display","none");
});

$(document).on("click",".resButton1",function(){
    $("#offersHolder").css("display","none");
    $("#userData").css("display","none");
    $(".changeRoom").css("display","none");
    $("#selectDate").css("display","none");
    $(".changeDate").css("display","none");
    $("#success").text("Success");
});