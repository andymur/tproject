/* Switcher */
	
	 jQuery('.picker-btn').on("click",function(){
	  if(jQuery('.color-picker').css('right')=='0px'){
	   jQuery('.color-picker').animate({ "right": "-200px" }, "slow" );
	  }else{
	   jQuery('.color-picker').animate({ "right": "0px" }, "slow" );
	  }
	 });
    setTimeout(function(){
    jQuery('.color-picker').animate({ "right": "-200px" }, "slow" );}, 1000);
	
	$('.layout-1').on("click",function(){
		$('body').removeClass('body-padding-2');
		$('body').addClass('body-padding');
		wpgmappity_maps_loaded();
	});
	$('.layout-2').on("click",function(){
		$('body').removeClass('body-padding');
		$('body').addClass('body-padding-2');
		wpgmappity_maps_loaded();
	});
	$('.layout-3').on("click",function(){
		$('body').removeClass('body-padding');
		$('body').removeClass('body-padding-2');
		$('body').addClass('body-no-padding');
		wpgmappity_maps_loaded();
	});
	
	$('.pattern-1').on("click",function(){
		$('body').removeClass('pattern2');
		$('body').removeClass('pattern3');
		$('body').removeClass('pattern4');
		$('body').addClass('pattern1');
		wpgmappity_maps_loaded();
	});
	
	$('.pattern-2').on("click",function(){
		$('body').removeClass('pattern1');
		$('body').removeClass('pattern3');
		$('body').removeClass('pattern4');
		$('body').addClass('pattern2');
		wpgmappity_maps_loaded();
	});
	
	$('.pattern-3').on("click",function(){
		$('body').removeClass('pattern2');
		$('body').removeClass('pattern1');
		$('body').removeClass('pattern4');
		$('body').addClass('pattern3');
		wpgmappity_maps_loaded();
	});
	
	$('.pattern-4').on("click",function(){
		$('body').removeClass('pattern2');
		$('body').removeClass('pattern3');
		$('body').removeClass('pattern1');
		$('body').addClass('pattern4');
		wpgmappity_maps_loaded();
	});

