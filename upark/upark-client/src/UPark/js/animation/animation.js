$(document).ready(function(){
	$("#link-news").mouseover(function(){
			// div.stop(true,true);
			// div.css("height","100px");
			// div.css("width","100px");
			// div.css("display","none");
			// div=$("#flyanimate1");
			// div.css("display","block");
			// $("#flydown1").css("display","inline-block");
		$("#extended-page").css("display","inline-block");
  		$("#extended-page").animate({width:'70%'},"slow",function(){});
	
	});	
	$("#sidebar"&&"#extended-page").mouseleave(function(){
		$("#extended-page").css("display","none");
		$("#extended-page").css("width","0px");
	})
});