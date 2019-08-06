import Controller from '@ember/controller';
//import { computed } from '@ember/object';
import { inject as service } from '@ember/service';
import swal from 'ember-sweetalert';

//Colocar Delante https://cors-anywhere.herokuapp.com/ para los cors
var urlApiNode   = 'https://backend-arrendamiento-jansel.herokuapp.com/v1/homes';
var urlApiScala  = 'https://scad-app-empresariales.herokuapp.com/v1/homes';
var urlApiPython = 'https://cors-anywhere.herokuapp.com/https://pawpatrolhouses.herokuapp.com/v1/homes';
var urlApiSpring = 'https://cors-anywhere.herokuapp.com/https://arrenda-santafe.herokuapp.com/v1/homes';

export default Controller.extend({
	session: service(),

	actions: {
		async consultar(){
            document.getElementById('results').style.display = 'none';
			document.getElementById('searchBtn').className = "btn btn-default ld-ext-right running";
			var token =  this.get('session.currentUser.Yd');
			const options = {
				method: 'POST',
				headers: {'Content-Type': 'application/json','token': token},
			};
			var node = await postMyBooking(options,urlApiNode,"/myBooking");
			var scala = await postMyBooking(options,urlApiScala,"/myBooking");
			var python = await postMyBooking(options,urlApiPython,"/myBooking");
			var spring = await postMyBooking(options,urlApiSpring,"/myBooking");
			var resultado = [];
			resultado.push(node);
			resultado.push(scala);
			resultado.push(python);
			resultado.push(spring);
			this.set('model',resultado);
			document.getElementById('searchBtn').className = "btn btn-default ld-ext-right";
			document.getElementById('results').style.display = 'block';          
		},

		async cancelar(rental, agencia, bookingId){
			document.getElementById('cancelarBtn').className = "btn btn-default ld-ext-right running";
			var agencyName = agencia.agency.name;
			var token =  this.get('session.currentUser.Yd');
			var urlservice = "/removeBooking";
			
			const options = {
				method: 'DELETE',
				headers: {'Content-Type': 'application/json','token': token},
				body: JSON.stringify({bookingId: bookingId})
			};

			var resultado = [];
			var result;

			if(this.get('session.isAuthenticated')) {
				switch (agencyName) { 
					case "Arriendamientos Jansel": 
						result = await postMyBooking(options,urlApiNode,urlservice);
						break; 
					case "Arrendamientos SCAD": 
						result = await postMyBooking(options,urlApiScala,urlservice);
						break; 
					case "PawPatrol": 
						result = await postMyBooking(options,urlApiPython,urlservice); 
						break; 
					default:  
						result = await postMyBooking(options,urlApiSpring,urlservice);
						break; 
				}
				document.getElementById('cancelarBtn').className = "btn btn-default ld-ext-right";
				resultado.push(result);
				//this.set('model2',resultado);
				//Se refresca la pantalla volviendo a realizar la busqueda para que no este el booking que fue cancelado
				this.send('consultar');	
				let type="warning";
				if (result.codigo==1) {
					type="success"
				}
				swal({
					title: "Cancelación De Reserva",
					text: result.mensaje || result.message,
					type: type,
				});			
			}
			else{
				alert("Actualmete no te encuentras logueado en la página... \n"
					+ "Se debe iniciar session antes de realizar alguna reserva");
				location.href='/inicio';
			}        
		}
	},
});

function postMyBooking(options,urlApi,urlService) {
	var targetUrl = urlApi+urlService;

	return fetch(targetUrl, options)
		.then(blob => blob.json())
		.then(data => {return data;})
		.catch(e => {return e;});
}