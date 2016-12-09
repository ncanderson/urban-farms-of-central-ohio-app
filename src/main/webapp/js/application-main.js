$(document).ready(function() {

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

