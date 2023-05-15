package gels.modelo.db;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import gels.connection.Session;
import gels.modelo.jpa.Cliente;
import gels.zap.throwable.DbConnectionException;


public class ClienteDB {
	
	private EntityManager em;
	
	public ClienteDB() throws Exception {
		em = Session.get().createEntityManager();
	}

	
	/**
	 * La clase cliente ya tiene las clases cliente estandard y cliente premium
	 * hibernate se debe encargar de actualizar lo que toque (la que no esté nul
	 * @param cliente
	 * @param tipoCliente
	 * @return
	 * @throws DbConnectionException 
	 */
	public boolean registrar(Cliente cliente) throws DbConnectionException {

		boolean totBe =false;
		if (em.isOpen()) {
		try {
			em = Session.get().createEntityManager();
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();
              totBe = true;
		}
		catch(Exception e) {
			totBe = false;
			em.getTransaction().rollback();
			e.printStackTrace();
			throw new DbConnectionException("Error al registrar articulo " + cliente.getIdCliente() + " || ERROR :" + e.getMessage());
		}
		}
		return totBe;
	}


	public List<Cliente> obtener()  {
		em = Session.get().createEntityManager();
		
	    TypedQuery <Cliente> query =  em.createNamedQuery("Cliente.findAll", Cliente.class);
		List<Cliente> cliente = query.getResultList();

		return cliente;
	}
	

	
	public List<Cliente> obtenerPorNombre(String n)  {

		TypedQuery <Cliente> query = em.createNamedQuery("Cliente.finByName", Cliente.class);
	    query.setParameter("nombre", n);
		List<Cliente> cliente = query.getResultList();

		return cliente;
	}


	public Cliente obtenerPorNif(String nif) {

		Cliente cliente=null;
		
		TypedQuery <Cliente> query = em.createNamedQuery("Cliente.finByNif", Cliente.class);
	    query.setParameter("nif", nif);
		List<Cliente> result = query.getResultList();

		//si hi ha més d'un marxem sense resultat
		if (result.size() == 1) cliente = result.get(0); 
		
		return cliente;
	}
	

	public Cliente obtenerPorId(long id) {
		return em.find(Cliente.class, id);
	}


	public boolean actualizar(Cliente cliente) throws DbConnectionException {
		boolean totBe = false;
	    try {
	        em.getTransaction().begin();
	        //obtenemos el Cliente y lo ponemos en control del entityManager con merge
	        Cliente cli =  em.find(Cliente.class, cliente.getIdCliente());
	        //actualizamos los datos

	        cli.setDomicilio(cliente.getDomicilio());
	        cli.setNif(cliente.getNif());
	        cli.setNombre(cliente.getNombre());
	        cli.setEmail(cliente.getEmail());
	        em.merge(cli);
	        cli.setClienteEstandard(cliente.getClienteEstandard());	        
	        cli.setClientePremium(cliente.getClientePremium());
	        em.persist(cli);
	        em.getTransaction().commit();
	        totBe = true; //ha ido bien
	      } catch (Exception e) {
	    	e.printStackTrace();  
	    	totBe = false;
		    em.getTransaction().rollback();
			throw new DbConnectionException("Error al actualizar Cliente" + cliente.getIdCliente() + " || ERROR : " + e.getMessage());
	      }
	
		return totBe;
	}


	public boolean eliminar(String nif) throws DbConnectionException  {
		boolean totBe = false;
	    try {
	        em.getTransaction().begin();
	        //obtenemos el Cliente y lo ponemos en control del entityManager con merge
	        Cliente cli =  this.obtenerPorNif(nif);
	        em.remove(cli);
	        em.getTransaction().commit();
	        totBe = true; //ha ido bien
	      } catch (Exception e) {
	    	totBe = false;
		    em.getTransaction().rollback();
			throw new DbConnectionException("Error al actualizar Cliente" + nif + " || ERROR : " + e.getMessage());
	      }
	
		return totBe;
	}

	

}
