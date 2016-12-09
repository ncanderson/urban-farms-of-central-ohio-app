$(document).ready(function() {

    $("#crop-type").change(function() {
        
        
        $.ajax ({
            url: "cropPicker?cropType=" + $(this).val(),
            method: "GET", 
            dataType: "json"
        })
        .done(function(data) {
            $("#crop-variety").empty();

            $.each(data, function() {
                $("#crop-variety").append("<option value=" + crop-type + ">" + crop-type + "</option>");
            });
            
            console.log(data);
        })
        .fail(function(xhr, status, error) {
            console.log(error);
        });
    });
});

