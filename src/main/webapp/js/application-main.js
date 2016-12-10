$(document).ready(function() {

//	submit the logout POST when the link is clicked
	$("#logoutLink").click(function(event){
		$("#logoutForm").submit();
	});
	
//	submit form with 'enter' press
	$("input").keypress(function(event) {
	    if (event.which == 13) {
	        event.preventDefault();
	        $("form").submit();
	    }
	});
	
//	Make ajax call to update crop variety when a selected type is chosen
    $("#crop-type").change(function() {
        
        $.ajax ({
            url: "cropPicker?cropType=" + $(this).val(),
            method: "GET", 
            dataType: "json"
        })
        .done(function(data) {
            $.each(data, function(index, cropType) {
            	var option = document.createElement("option");
            	$(option).attr("value", cropType.variety);
            	$(option).text(cropType.variety);
                $("#crop-variety").append(option);
            });
            
            console.log(data);
        })
        .fail(function(xhr, status, error) {
            console.log(error);
        });
    });
    
});

