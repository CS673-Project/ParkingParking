//implement the animations of sidebar
$(document).ready(function(){
	$(".link-sidebar").mouseover(function(){
		var top = $("#sidebar").offset().top;
		var left = parseInt($("#sidebar").css("width").slice(0,-2))+parseInt($("#sidebar").offset().left);
		$("#extended-page").stop();
		$("#extended-page").css({"display":"block","top":top,"left":left+'px'});
  		$("#extended-page").css("width","0px").animate({width:'700px'},"slow",function(){});
	
	});	
	$("#sidebar"&&"#extended-page").mouseleave(function(){
		$("#extended-page").stop(true,true);
		$("#extended-page").css("display","none");
		$("#extended-page").css("width","0px");
	});
});