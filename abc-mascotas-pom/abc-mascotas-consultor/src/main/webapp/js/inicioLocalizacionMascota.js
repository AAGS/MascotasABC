$( document ).ready(function() {
	iniciar();
	setInterval(dibujarPosicionMascota, 1000);
});

var mapa = null;

function iniciar() {
  mapa = new google.maps.Map(document.getElementById('divMapaMascota'), {
    center: {lat: 4.624335, lng: -74.063644},
    zoom: 8
  });
}

function dibujarPosicionMascota(){
	var data = {
		  	 "login":"usuario1",
		  	 "password":"3V0kt+hsqcgIMoM0RERNMg==",
		  	 "idRuta":3
			};
	$.ajax({
			url: "rest/ConsultaMascota/posicionActual", 
			type: 'POST',
			headers: { 
			        	'Accept': 'application/json',
			        	'Content-Type': 'application/json' 
			    		},
			data: JSON.stringify(data),
			success: function(resultado){
						var puntoMascota = resultado;
						if (puntoMascota != null ){
							  var puntoM = {lat: puntoMascota.latitud, lng: puntoMascota.longitud};
							  var marker = new google.maps.Marker({
								    position: puntoM,
								    map: mapa,
								    title: puntoMascota.nombreMascota
								  });
							  marker.position;
						}
					 },
			error: function (request, status, error) {
						console.log(error);
					}
	}); 
}