package gels.modelo.db;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import gels.connection.Session;
import gels.modelo.jpa.Articulo;
import gels.zap.throwable.DbConnectionException;



public class ArticuloDB {
	private EntityManager em;
	
	public ArticuloDB() throws Exception {
		em = Session.get().createEntityManager();
	}

	public boolean registrar(Articulo art) throws DbConnectionException  {
		boolean totBe =false;
		if (em.isOpen()) {
			try {
	            em.getTransaction().begin();
	            Articulo articulo = em.merge(art);
	            em.persist(articulo);
	            em.getTransaction().commit(); //actualizamos la bdd
	            totBe = true;
			}
			catch(Exception e) {
				totBe = false;
				em.getTransaction().rollback();
				throw new DbConnectionException("Error al registrar articulo " + art.getIdArticulo() + " || ERROR :" + e.getMessage());
			}
		}
		return totBe;
	}


	public List<Articulo> obtener()  {
	    TypedQuery <Articulo> query =  em.createNamedQuery("Articulo.findAll", Articulo.class);
		List<Articulo> articulo = query.getResultList();
		return articulo;
	}
	

	public List<Articulo> obtenerPorDescripcion(String des)  {
	    TypedQuery <Articulo> query =  em.createNamedQuery("Articulo.finByDescription", Articulo.class);
	    query.setParameter("des", des);
		List<Articulo> articulo = query.getResultList();
		return articulo;
	}


	public Articulo obtenerPorId(int id)  {
		return em.find(Articulo.class, id);
				
	}

	public boolean actualizar(Articulo articulo) throws DbConnectionException  {
		boolean todoBien = false;
	    try {
	        em.getTransaction().begin();
	        //obtenemos el articulo y lo ponemos en control del entityManager con merge
	        Articulo art = em.find(Articulo.class, articulo.getIdArticulo());
	        
	        //actualizamos los datos
	        art.setDescripcion(articulo.getDescripcion());
	        art.setPrecioEnvio(articulo.getPrecioEnvio());
	        art.setPvp(articulo.getPvp());
	        art.setTiempoPrepEnvio(articulo.getTiempoPrepEnvio());
	        em.merge(art);
	        em.getTransaction().commit();
	    	todoBien = true;
	      } catch (Exception e) {
	    	todoBien = false;
		    em.getTransaction().rollback();
			throw new DbConnectionException("Error al actualizar articulo" + articulo.getIdArticulo() + " || ERROR : " + e.getMessage());
	      }
	
		return todoBien;
	}


	public boolean eliminar(int id_articulo) throws DbConnectionException  {
		boolean todoBien = false;
	    try {
	        em.getTransaction().begin();
	        Articulo art = em.find(Articulo.class, id_articulo); //hacemos que la entidad esté manejada por el EntityManager
	        em.remove(art);
	        em.getTransaction().commit();
	        todoBien = true;
	      } catch (Exception e) {
	    	todoBien = false;
		    em.getTransaction().rollback();
			throw new DbConnectionException("Error al eliminar articulo" + id_articulo + " || ERROR : " + e.getMessage());
	      }

		return todoBien;
	}


	public void close() {
		em.close();
	}
	
	public void flush() {
		em.flush();
	}
	
	public void clear() {
		em.clear();
	}

}
