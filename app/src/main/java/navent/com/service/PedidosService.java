package navent.com.service;

import navent.com.cache.impl.BumexMemcached;
import navent.com.dao.PedidosDao;
import navent.com.domain.Pedido;

public class PedidosService {

	private BumexMemcached bumexMemcached;
	
	public PedidosService() {
		this.bumexMemcached = BumexMemcached.getInstance();
	}

	public Pedido crearPedido(Pedido pedido){ 
		
		PedidosDao.insertOrUpdate(pedido); // lo guardo en la base. Se asume que los objetos ya tienen su respectivo id. De no ser asi el metodo insertOrUpdate no deberia ser void y deberia devolver la entidad persistida con su id autoincremental generado(como el save() de spring data).
		this.bumexMemcached.set(pedido.getIdPedido().toString().concat("_Pedido"), pedido); // lo guardo en la cache concatenando el id con el nombre de la clase como key(agrego el nombre de la clase asi puedo guardar en la cache objetos de distintas clases y no se pisan).
		return pedido;
	}
	
	public void actualizarPedido(Pedido pedido){
	
		PedidosDao.insertOrUpdate(pedido); // lo actualizo en la base
		this.bumexMemcached.set(pedido.getIdPedido().toString().concat("_Pedido"), pedido); // asumo que el metodo set de bumexMemcached si la key ya se encuentra en la cache actualiza su objeto de valor, lo pisa con el objeto nuevo.

	}
	
	public void borrarPedido(Pedido pedido){
		
		// asumo que estos metodos si no encuentran el elemento no pinchan. Simplemente no hacen nada.
		PedidosDao.delete(pedido); // borrarlo de la base
		this.bumexMemcached.delete(pedido.getIdPedido().toString().concat("_Pedido")); // borrarlo de la cache
	}
	
	public Pedido buscarPedidoPorId(Integer id){ 
		
		Pedido pedido = (Pedido) this.bumexMemcached.get(id.toString().concat("_Pedido")); // busco en la cache el pedido. Lo tengo q castear porque devuelve Object
		
		if(pedido != null){ // si lo encontró en la cache..
			return pedido; // .. lo devuelvo
		}
		
		return PedidosDao.select(id); // si no lo encontró en la cache lo busco en la base(si no lo encuentra en la base deberia tirar una excepcion para avisar)
	}

}
