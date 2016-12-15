$(document).ready(function() {

    $.fn.responsiveTable = function() { 

    var toggleColumns = function($table) {
    	
		var selectedControls = [];
		$table.find(".Accordion").each( function() {
	        selectedControls.push( $(this).attr("aria-selected") );
	    });
		
		var cellCount = 0; 
		var colCount = 0;
		var setNum = $table.find(".Rtable-cell").length / $table.find(".Accordion").length;
		
		$table.find(".Rtable-cell").each( function() {
	        $(this).addClass("hiddenSmall");
	        $(".Rtable-form > .Rtable-cell").addClass("Rtable-form-shopping-cart");
	        
	        if ( selectedControls[colCount] === "true" ) {
	        	$(this).removeClass("hiddenSmall");
	        	
	        }
	        cellCount++;
	        
	        if ( cellCount % setNum === 0 ) {
	        	colCount++; 
	        }
		});
	
    };
    
    $(this).each(function() { 
    	toggleColumns($(this)); 
	});

    $(this).find(".Accordion").click( function() {
    	$(this).attr("aria-selected", $(this).attr("aria-selected") !== "true" );
    	toggleColumns( $(this).parents(".Rtable") );
    });

  };

$(".js-RtableAccordions").responsiveTable();

});