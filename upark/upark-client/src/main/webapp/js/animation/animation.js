
$(document).ready(function(){
	$(".link-sidebar").mouseover(function(){
		$("#extended-page").stop();
		$("#extended-page").css("display","inline-block");
  		$("#extended-page").css("width","0px").animate({width:'70%'},"slow",function(){});
	
	});	
	$("#sidebar"&&"#extended-page").mouseleave(function(){
		$("#extended-page").stop(true,true);
		$("#extended-page").css("display","none");
		$("#extended-page").css("width","0px");
	});

	$("#sign-in").click(function(){
		$("#modal-sign-in").modal().css({'margin-top': function(){return ($(this).height()/2-120);}});
	});
});
