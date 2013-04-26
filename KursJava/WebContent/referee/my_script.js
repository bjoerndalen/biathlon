// JavaScript Document
	var a=0;
		var div;
		var b;
		var not=-1;
		var div2;
$(document).ready(function(e) {



    $(".divRight").droppable({
		accept:".drag",
		drop:function(event,ui) {
			if($(".divRight").find(".drag").length==0)
			$("<div class='drag'><p>Словил</p></div>").draggable({ containment: ".work", scroll: false}).appendTo('.divRight');
			//$(".divLeft").find("div").remove();
		}
	});
	$(".divLeft").droppable({
		accept:".drag",
		drop:function(event,ui) {
			//$(".divLeft").find("div").remove();
		}
	});
	$("div").mousemove(function(e){
		if(a==1){
      $(div).offset({top:e.pageY-10, left:e.pageX-10});
      if(e.pageX>=670){
	  not=1;
	  }else{
		  not=0;
  }
}
    });
	$(".drag").click(function () {
		
		if(b==0){
		b=1;
		}
		if(a==1){
			a=0;
		}else{
      $(this).draggable({ containment: ".work", scroll: false});
      div=$(this);
      div2=div.clone();
      a=1;
      b=0;
      if(div.parent().is(".divRight")){
		$("<div class='drag'><p>Словил</p></div>").draggable({ containment: ".work", scroll: false}).appendTo('.divRight');
		return;
		}
  }
    });
    
    $(".divLeft").click(function () {
		if((b==1)&&(not==0)){
      div.remove();
		b=0;
	}else{
	if(not==1){
		//div.offset({top:65, left:310});
		$('.divRight').append(div2);
		div.remove();
		//$(this).removeChild(div);
		//$(".divRight").addChild(div);
	not=-1;
	}
	}
    });
    
    
     $(".divRight").click(function () {
		 //div.appendTo($(".divRight"));
      $("<div class='drag'><p>Словил</p></div>").draggable({ containment: ".work", scroll: false}).appendTo('.divRight');
		a=0;
		b=0;
		not=0;

    });
    
    $("option").click(function(e){
    	$.ajax({
            url : "/updt_startlist.jsp",
            type: "GET",
            data: "cuprace="+this.val(),
            success: function(back){
                alert('Message is sending!!!');
            }
           
        });
	});
    
});


