/**
 * 
 */

$(document).ready(function(){
	
	$("#pedidosFormBox form").submit(function(e){
		
		e.preventDefault(); // para q no recargue la pagina
		$(".alert").remove(); // borro cualquier cartel de exito/error q haya quedado.
		
		// tomo los valores de los elementos del form
		nombre = $(this).find("input").eq(0).val();
		monto = parseInt($(this).find("input").eq(1).val());
		descuento = $(this).find("input").eq(2).val()!="" ? parseInt($(this).find("input").eq(2).val()) : 0; // si no ingresa descuento q x default sea cero
		
		// creo un objeto JSON
		pedido = {
			"nombre" : nombre,
			"monto" : monto,
			"descuento" : descuento
		}
		
		// envio el JSON al metodo q va a llamar a Ajax
		guardarPedido(pedido);
		
	});
});