import Controller from '@ember/controller';
import { computed } from '@ember/object';
import { inject as service } from '@ember/service';
//https://www.npmjs.com/package/ember-sweetalert
import swal from 'ember-sweetalert';


//Colocar Delante https://cors-anywhere.herokuapp.com/ para los cors
//url de las apis de los backend que van a ser consumidos
var urlApiNode   = 'https://backend-arrendamiento-jansel.herokuapp.com/v1/homes';
var urlApiScala  = 'https://scad-app-empresariales.herokuapp.com/v1/homes';
var urlApiPython = 'https://cors-anywhere.herokuapp.com/https://pawpatrolhouses.herokuapp.com/v1/homes';
var urlApiSpring = 'https://cors-anywhere.herokuapp.com/https://arrenda-santafe.herokuapp.com/v1/homes';

export default Controller.extend({
	//inyeccion de la sesssion
	session: service(),

	fechaLlegada: computed(function() {
		let fecha = new Date();
		let fechaFormato = formatoFechaAMD(fecha);
		return fechaFormato;
	}),

	fechaSalida: computed('fechaLlegada', function() {
		let fecha = new Date(this.get('fechaLlegada') + "T12:00:00");
		fecha.setDate(fecha.getDate()+ 1);
		let fechaFormato = formatoFechaAMD(fecha);
		return fechaFormato;
	}),

	hoy: computed(function() {
		let fecha = new Date();
		let fechaFormato = formatoFechaAMD(fecha);
		return fechaFormato;
	}),

	entrada: computed('fechaLlegada', function() {
		let fecha = new Date();
		let fechaFormato;
		
		if(this.get('fechaLlegada') == ''){
			fechaFormato = formatoFechaAMD(fecha);
		}
		else{
			fecha = new Date(this.get('fechaLlegada') + "T12:00:00");
			fechaFormato = formatoFechaAMD(fecha);
		}
		return fechaFormato;
	}),

	type_id: "1",
	types: [
		{"name":"Apartamento","id":"1"},
		{"name":"Casa","id":"2"},
		{"name":"Luxury","id":"3"},
	],
	
	city_id: "CO-MDE",
	cities: [
		{"name":"Medellín","id":"CO-MDE"},
		{"name":"Cali","id":"CO-CLO"},
		{"name":"Bogotá","id":"CO-BOG"},
		{"name":"Cartagena","id":"CO-CTG"},
		{"name":"Santa Marta","id":"CO-SMR"},
	],

	actions: {
		selectType(type) {
			this.set('type_id', type);
		},

		selectCity(city) {
			this.set('city_id', city);
		},

		async buscar(){
			document.getElementById('searchResults').style.display = 'none';
			document.getElementById('searchBtn').className = "btn btn-default ld-ext-right running";
			const options = {
				method: 'POST',
				headers: {'Content-Type': 'application/json'},
				body: JSON.stringify({
					checkIn: formatoFechaDMA(this.get("fechaLlegada")),
					checkOut: formatoFechaDMA(this.get("fechaSalida")),
					city: this.get("city_id"),
					type: this.get("type_id")
				})
			};
			// llamado a los metodos encargados de consumir la api de los distintos backends
			var node = await postSearch(options,urlApiNode,"/search");
			var scala = await postSearch(options,urlApiScala,"/search");
			var python = await postSearch(options,urlApiPython,"/search");
			var spring = await postSearch(options,urlApiSpring,"/search");
			//console.log(python);
			var resultado = [];
			
			//if(!node.message){
				resultado.push(node);
			//}
			//if(!scala.message || Object.keys(node.scala.homes).length !== 0){
				resultado.push(scala);
			//}
			resultado.push(python);
			resultado.push(spring);
			this.set('model',resultado);
			document.getElementById('searchBtn').className = "btn btn-default ld-ext-right";
			document.getElementById('searchResults').style.display = 'block';
		}, 

		async reservar(rental, agencia){
			document.getElementById('bookingBtn').className = "btn btn-default ld-ext-right running";
			//var rentalName = rental.name;
			var agencyName = agencia.agency.name;
			var rentalId = rental.id;
			var token =  this.get('session.currentUser.Yd');
			var urlservice = "/booking";
			
			const options = {
				method: 'POST',
				headers: {'Content-Type': 'application/json', 'token': token},
				body: JSON.stringify({
					checkIn: formatoFechaDMA(this.get("fechaLlegada")),
					checkOut: formatoFechaDMA(this.get("fechaSalida")),
					id: rentalId
				})
			};

			var resultado = [];
			var result;
			// agregar confirm  
			if(this.get('session.isAuthenticated')) {
				switch (agencyName) { 
					case "Arriendamientos Jansel": 
						result = await postBooking(options,urlApiNode,urlservice);
						break; 
					case "Arrendamientos SCAD": 
						result = await postBooking(options,urlApiScala,urlservice);
						break; 
					case "PawPatrol": 
						result = await postBooking(options,urlApiPython,urlservice);
						break; 
					default: 
						result = await postBooking(options,urlApiSpring,urlservice);
						//console.log(result);
						break; 
				}
				this.set('model2',resultado);
				document.getElementById('bookingBtn').className = "btn btn-default ld-ext-right";
				resultado.push(result);
				/*Se refresca la pantalla volviendo a realizar la busqueda para que no este el home
				que ya fue reservado*/
				this.send('buscar');
				//console.log(result);
				let type="warning";
				if (result.codigo==1) {
					type="success"
				}
				swal({
					title: "Reserva",
					text: result.mensaje || result.message,
					type: type,
				});
			}
			else{
				document.getElementById('bookingBtn').className = "btn btn-default ld-ext-right";
				swal({
					title: "Reserva",
					text: "Actualmete no te encuentras logueado en la página "
					+ "debes iniciar sesion antes de realizar alguna reserva",
					type:"warning",
					//showCancelButton: true,
					confirmButtonText: "login"

				}).then((willDelete) => {
					if (willDelete) {
						location.href='/inicio';
					} else {
						swal("recuerda que para realizar reservas se debe estar logueado en el sistema");
					}
				});		
			}
		}
	},
});

function formatoFechaAMD(fecha) {
	return fecha.getFullYear().toString()
		+ '-' + ('0' + (fecha.getMonth() + 1)).slice(-2).toString() 
		+ '-' + ('0' + fecha.getDate()).slice(-2).toString();
}

function formatoFechaDMA(fecha) {
	return fecha.substring(8, 10) + fecha.substring(4, 8) + fecha.substring(0, 4)
}

function postSearch(options,urlApi,urlService) {
	var targetUrl = urlApi+urlService;

	return fetch(targetUrl, options)
		.then(blob => blob.json())
		.then(data => {return data;})
		.catch(e => {return e;});
}

function postBooking(options,urlApi,urlService) {
	var targetUrl = urlApi+urlService;

	return fetch(targetUrl, options)
		.then(blob => blob.json())
		.then(data => {return data;})
		.catch(e => {return e;});
}