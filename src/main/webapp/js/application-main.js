$(document).ready(function() {

	$("#crop-type").change(function() {
		var $titleId = $(this).attr("id");
		Cookies.set("crop-type", $(this).val);
		$(this).val(Cookies.get("crop-type"));
		
        window.location.href = window.location.href + '?value=' + this.value;
        
	});
	
});


