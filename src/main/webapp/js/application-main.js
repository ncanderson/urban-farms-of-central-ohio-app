$(document).ready(function() {

	  var selectItem = $('<table/>').appendTo($('ul.form-flex-outer'));
	  $.getJSON('farmer-dashboard-views/enterInventory', function(persons) {
	    persons.each(function(i, person) {
	        $('<tr/>').appendTo(table)
	            .append($('<td/>').text(person.name))
	            .append($('<td/>').text(person.address));
	    });
	  });
	
});


