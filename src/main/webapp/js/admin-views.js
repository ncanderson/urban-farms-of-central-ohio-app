$(document).ready(function() {
	
	$(window).resize(function(){
		   var width = $(window).width();
		   var resizeImage = $("img.crop-image-medium");
		   if (width >= 0 && width <= 794) {
			   $(resizeImage).removeClass("crop-image-medium").addClass("crop-image-small");
		   }
		   if (width >= 795) {
			   $(resizeImage).removeClass("crop-image-small").addClass("crop-image-medium");
		   }
		})
		.resize();
});