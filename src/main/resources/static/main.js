var lat, lng;
navigator.geolocation.getCurrentPosition(function(position) {
	console.log("fetching geolocation cords");
	mylat = position.coords.latitude;
	lng = position.coords.longitude;
	console.log(mylat + ":" + lng);
});
$('#location').click(function() {
	var lat = $("#lat");
	lat.val(mylat);
	lat.trigger('input');
	var longitude = $("#long");
	longitude.val(lng);
	longitude.trigger('input');
});
