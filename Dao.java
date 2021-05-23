
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class Dao {
	
	EntityManager manager = JPAUtil.getManager();
	
	public void create(Filme filme) {
		
		manager.getTransaction().begin();
		manager.persist(filme);
		manager.getTransaction().commit();
		
		//manager.close();
	}
	
	public TypedQuery<Filme> query() {
		
		TypedQuery<Filme> query =  manager.createQuery("SELECT f FROM Filme f" , Filme.class);
		return  (TypedQuery<Filme>) query.getResultList();
	}
	
	public void apagar(Filme filme) {
		manager.getTransaction().begin();
		manager.remove(filme);
		manager.getTransaction().commit();
		}
		
	public void apagar(Long id) {
			apagar(buscarPorId(id));
	}
	
	public Filme buscarPorId(Long id) {
		return manager.find(Filme.class, id);
	}
	
	
}
