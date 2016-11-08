/**
 * 
 */


function guardarPedido(pedido){
	
	console.log(pedido);

	 $.ajax({
	      type: 'POST',
	      url: 'http://localhost:8080/api/pedidos/guardar',
	      data:  pedido,
	      success: function(data) { 
	    	  success_box = $("<div>");
	    	  success_box.addClass("alert alert-success");
	    	  success_box.html("<strong>Guardado!</strong> Su pedido fue guardado.");
	    	  $("#pedidosFormBox").append(success_box);
	      },
	      error: function(data) { 
	    	  error_box = $("<div>");
	    	  error_box.addClass("alert alert-danger");
	    	  error_box.html("<strong>Error!</strong> Su pedido no fue guardado.");
	    	  $("#pedidosFormBox").append(error_box);
	     }
	    });

}