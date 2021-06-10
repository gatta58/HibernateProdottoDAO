package corso.lez16.HibernateProdottoDAO;

import corso.lez16.HibernateProdottoDAO.models.Prodotto;

import java.util.List;

import corso.lez16.HibernateProdottoDAO.crud.ProdottoDAO;

public class App 
{
    public static void main( String[] args )
    {
        ProdottoDAO proDao = new ProdottoDAO();
        
//        // --------------------Inserimento ------------------------------------------
       Prodotto kinderBrioss = new Prodotto("KB123456", "Kinder Brioss", 2.69f);
		Prodotto kinderFAA = new Prodotto("KB123457", "Kinder Fetta al Latte", 2.69f);
		Prodotto KinderDelice = new Prodotto("KB123458", "Kinder Delice", 2.69f);
		
        proDao.insert(KinderDelice);
        proDao.insert(kinderBrioss);
        proDao.insert(kinderFAA);
        
//        // --------------------FindBtId ------------------------------------------
        System.out.println("----FindById");
        Prodotto findPro = proDao.findById(1);
        System.out.println(findPro.toString());
        
//        // --------------------Update ------------------------------------------
        Prodotto updProd = proDao.findById(2);
        updProd.setCodice("abcnaslllls");
        updProd.setNome("Kinder deliziosa!");
        if(proDao.update(updProd)) {
        	System.out.println("Update effettuato");
        	System.out.println(updProd.toString());
        }
        else {
        	System.out.println("Errore in update");
        }
        
        // --------------------FindAll ------------------------------------------
        List elenco = proDao.findAll();
        
        for(int i=0; i<elenco.size(); i++) {
			Prodotto temp = (Prodotto) elenco.get(i);
			System.out.println(temp.toString());
		  }
        
       // --------------------Delete con ID ------------------------------------------
        
        if(proDao.delete(2)) {
        	System.out.println("Eliminazione byID efettuata");
        }
        else {
        	System.out.println("Errore in eliminazione byID");
        }
        
        // --------------------Delete con ID ------------------------------------------
        
        Prodotto delPro = proDao.findById(3);
        if(proDao.delete(delPro)) {
        	System.out.println("Eliminazione con prodotto efettuata");
        }
        else {
        	System.out.println("Errore in eliminazione con prodotto");
        }
        
        // --------------------FindAll ------------------------------------------
        elenco = proDao.findAll();
        
        for(int i=0; i<elenco.size(); i++) {
			Prodotto temp = (Prodotto) elenco.get(i);
			System.out.println(temp.toString());
		  }
    }
}
