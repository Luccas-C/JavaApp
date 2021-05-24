
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
	
	public List<Filme> query() {
		
		TypedQuery<Filme> query =  manager.createQuery("SELECT f FROM Filme f" , Filme.class);
		return   query.getResultList();
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
	
	public void edit(Filme filme) {
		Filme antigo = manager.find(Filme.class,filme.getId());
		manager.getTransaction().begin();
		antigo.setTitulo(filme.getTitulo());
		antigo.setSinopse(filme.getSinopse());
		antigo.setGenero(filme.getGenero());
		antigo.setOndeAssistir(filme.getOndeAssistir());
		antigo.setAssistido(filme.isAssistido());
		antigo.setAvaliacao(filme.getAvaliacao());
		manager.getTransaction().commit();
		
	}
	
}
