$(document).on("click",".log",function(){
   if($("#name").val()=="admin"&&$("#pass").val()=="1234") {
      window.location.href = 'admin.html';
   }else if($("#name").val()=="administrator"&&$("#pass").val()=="1111"){
      window.location.href = 'administrator.html';
   }else{
      $("#status").text("No such user");
   }
});
