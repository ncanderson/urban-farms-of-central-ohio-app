$(document).ready(function() {

	
//	Add logout button to main nav drop-down when media query triggers change
	checkSize();
	
	$(window).resize(checkSize);
	
	function checkSize() {
		if ($(".navbar-collapse").css("text-align") === "center") {
			var logoutButton = $("#logout-button").detach();
			logoutButton.appendTo("#main-nav");
		}
	}
	
//	submit the logout POST when the link is clicked
	$("#logoutLink").click(function(event){
		$("#logoutForm").submit();
	});
	
//	submit form with 'enter' press
	$("input, textarea").keypress(function(event) {
	    if (event.which == 13) {
	        event.preventDefault();
	        $("form").submit();
	    }
	});
	
//	Make ajax call to update crop variety when a selected type is chosen
    $("#crop-type").change(function() {
        
    	var cropType = $(this).val();
    	
        $.ajax ({
            url: "cropPicker?cropType=" + cropType,
            method: "GET", 
            dataType: "json"
        })
        .done(function(data) {
        	$("#crop-variety").empty();
            $.each(data, function(index, cropType) {
            	var option = document.createElement("option");
            	$(option).attr("value", cropType.variety);
            	$(option).text(cropType.variety);
                $("#crop-variety").append(option);
            });
            
            if ($("#crop-variety").children().length === 1) {
            	
        		$("#pricePerPound").val("");
        		
            	$.ajax ({
            		url: "noVarietyPriceGetter?cropType=" + cropType,
            		method: "GET",
            		dataType: "json"            		
            	})
            	.done(function(subData) {
            		$("#pricePerPound").val("$" + subData);
            	})
            	.fail(function(xhr, status, error) {
            		console.log(error);
            	});
        	};
           
        })
        .fail(function(xhr, status, error) {
            console.log(error);
        });
    });
    
    $("#crop-variety").change(function() {
       	
        $.ajax ({
            url: "priceGetter?cropType=" + $("#crop-type").val() + "&cropVariety=" + $("#crop-variety").val(),
            method: "GET", 
            dataType: "json"
        })
        .done(function(data) {
        	$("#pricePerPound").val("");
        	$("#pricePerPound").val("$" + data);
        })
        .fail(function(xhr, status, error) {
            console.log(error);
        });
    });
});
    

