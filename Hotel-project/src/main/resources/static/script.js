$(document).on("click", ".room", function() {
	$(this).next().toggleClass("displ") ;
});

$(document).on("click", ".addAction", function() {
	$(".addRoom").toggleClass("displa") ;
})