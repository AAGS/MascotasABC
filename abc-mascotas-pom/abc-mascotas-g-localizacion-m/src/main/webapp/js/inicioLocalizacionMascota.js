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
	$.ajax({
			url: "rest/ConsultaMascota/posicionActual/3", 
			type: 'GET',
			dataType: "json",	
			success: function(resultado){
						var puntoMascota = resultado;
						if (puntoMascota != null ){
							  var puntoM = {lat: puntoMascota.latitud, lng: puntoMascota.longitud};
							  var marker = new google.maps.Marker({
								    position: puntoM,
								    map: mapa,
								    title: puntoMascota.nombreMascota
								  });
						}
					 },
			error: function (request, status, error) {
			      		alert(request.responseText);
				   }
	}); 
}