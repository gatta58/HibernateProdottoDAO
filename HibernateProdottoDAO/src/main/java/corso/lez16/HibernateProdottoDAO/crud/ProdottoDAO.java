package corso.lez16.HibernateProdottoDAO.crud;

import java.util.List;

import org.hibernate.Session;

import corso.lez16.HibernateProdottoDAO.models.Prodotto;
import corso.lez16.HibernateProdottoDAO.models.db.GestoreSessioni;

public class ProdottoDAO implements Dao<Prodotto> {

	@Override
	public void insert(Prodotto t) {

		Session sessione = GestoreSessioni.getInstance().getFactory().getCurrentSession();
		
		try {
			sessione.beginTransaction();
			sessione.save(t);
			sessione.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		} finally {
			sessione.close();
		}
	}

	@Override
	public Prodotto findById(int id) {
		
		Session sessione = GestoreSessioni.getInstance().getFactory().getCurrentSession();
		
		try {
			sessione.beginTransaction();
			Prodotto temp = sessione.get(Prodotto.class, id);
			sessione.getTransaction().commit();
			return temp;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		} finally {
			sessione.close();
		}
		return null;
	}

	@Override
	public List<Prodotto> findAll() {
		
		Session sessione = GestoreSessioni.getInstance().getFactory().getCurrentSession();
		List<Prodotto> elenco = null;
		
		try {
			sessione.beginTransaction();
			elenco = sessione.createQuery("FROM Prodotto").list();	
			sessione.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		} finally {
			sessione.close();
		}
		
		return elenco;
	}

	@Override
	public boolean delete(int id) {

		Session sessione = GestoreSessioni.getInstance().getFactory().getCurrentSession();
		
		try {
			sessione.beginTransaction();
			Prodotto temp = sessione.get(Prodotto.class, id);
			sessione.delete(temp);
			sessione.getTransaction().commit();
			return true;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		} finally {
			sessione.close();
		}
		return false;
	}

	@Override
	public boolean delete(Prodotto t) {
		
		Session sessione = GestoreSessioni.getInstance().getFactory().getCurrentSession();
		
		try {
			sessione.beginTransaction();
			sessione.delete(t);
			sessione.getTransaction().commit();
			return true;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		} finally {
			sessione.close();
		}
		return false;
	}

	@Override
	public boolean update(Prodotto t) {
		
		Session sessione = GestoreSessioni.getInstance().getFactory().getCurrentSession();
		
		try {
			sessione.beginTransaction();
			sessione.update(t);
			sessione.getTransaction().commit();
			return true;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			sessione.close();
		}
		return false;
	}

}
