package gels.modelo.db;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import gels.connection.Session;
import gels.modelo.jpa.Pedido;
import gels.zap.throwable.DbConnectionException;


public class PedidoDB {

	private EntityManager em;


	public PedidoDB() {
		em = Session.get().createEntityManager();
	}
	
	/**
	 * Registra un nuevo pedido
	 * @param PedidoView
	 * @return ID insertado
	 * @throws DbConnectionException
	 */

	public long registrar(Pedido ped) throws DbConnectionException  {		
		
	
		long last_inserted_id = -1;

		if (em.isOpen()) {
			try {
	            em.getTransaction().begin();
	            Pedido pedido = em.merge(ped);
	            em.persist(pedido);
	            em.getTransaction().commit(); //actualizamos la bdd
	            last_inserted_id = pedido.getIdPedido();
			}
			catch(Exception e) {
				em.getTransaction().rollback();
				throw new DbConnectionException("Error al registrar pedido ERROR :" + e.getMessage());
			}
		}

		return last_inserted_id;
	}


	public List<Pedido> obtener() {
	    TypedQuery <Pedido> query =  em.createNamedQuery("Pedido.findAll", Pedido.class);
		List<Pedido> pedido = query.getResultList();
		return pedido;
	}
	


	public Pedido obtenerPorId(long id_pedido) {
		return  em.find(Pedido.class, id_pedido);
	}


	public List<Pedido> obtenerPorFecha(String fecha)  {
	    TypedQuery <Pedido> query =  em.createNamedQuery("Pedido.finByDate", Pedido.class);
	    query.setParameter("fechaPedido", fecha);
		List<Pedido> pedido = query.getResultList();
		return pedido;
	}


	public boolean actualizar(Pedido pedido) throws DbConnectionException  {
		boolean todoBien = false;
	    try {
	        em.getTransaction().begin();
	        //obtenemos el Pedido y lo ponemos en control del entityManager con merge
	        Pedido ped = em.find(Pedido.class, pedido.getIdPedido());
	        
	        //actualizamos los datos
	        ped.setArticulo(pedido.getArticulo());
	        ped.setCantidadArticulo(pedido.getCantidadArticulo());
	        ped.setCliente(pedido.getCliente());
	        ped.setPedidoEnviado(pedido.getPedidoEnviado());
	        ped.setPrecio(pedido.getPrecio());
	        ped.setFechaPedido(pedido.getFechaPedido());
	        em.merge(ped);
	        em.getTransaction().commit();
	        todoBien = true;
	      } catch (Exception e) {
	    	todoBien = false;
		    em.getTransaction().rollback();
			throw new DbConnectionException("Error al actualizar Pedido" + pedido.getIdPedido() + " || ERROR : " + e.getMessage());
	      }
	
		return todoBien;
	}


	public boolean eliminar(Pedido pedido) throws DbConnectionException {
		boolean todoBien = false;
	    try {
	        em.getTransaction().begin();       
	        em.merge(pedido);
	        em.remove(pedido);
	        em.getTransaction().commit();
	        todoBien = true;
	      } catch (Exception e) {
	    	todoBien = false;
		    em.getTransaction().rollback();
			throw new DbConnectionException("Error al actualizar Pedido" + pedido.getIdPedido() + " || ERROR : " + e.getMessage());
	      }
		return todoBien;
	}

	public boolean eliminar(long p) throws DbConnectionException {
		return this.eliminar(this.obtenerPorId(p));
	}

	public boolean enviaPedido(long p) throws DbConnectionException {
		Pedido pedido = this.obtenerPorId(p);
		pedido.setPedidoEnviado(true);		
		return this.actualizar(pedido);
	}	

}
