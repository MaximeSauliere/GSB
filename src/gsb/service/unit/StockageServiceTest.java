/**
 * 
 */
package gsb.service.unit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gsb.modele.Medicament;
import gsb.modele.Stockage;
import gsb.modele.Visiteur;
import gsb.service.StockageService;
import gsb.service.VisiteService;
import junit.framework.TestCase;

/**
 * @author maxim
 *
 */
public class StockageServiceTest extends TestCase {
	private StockageService unStockage;
	private Visiteur unVisiteur;
	private Medicament unMedicament;
	private Stockage unStock;
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Before
	protected void setUp() throws Exception {
		super.setUp();
		unMedicament = new Medicament("unCode", "unNom", "unCommentaire", "unEffet", "uneContradiction", "0", "unCode", "unLibelle");
		unVisiteur = new Visiteur("02", "Dupont", "Jean", "DupontJ", "Jean56", " 1 rue de la rivière", "02-97-02-15-95", "2 Janvier 2016");
		unStockage = new StockageService();
		unStock = new Stockage("106",unVisiteur,unMedicament);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	@After
	protected void tearDown() throws Exception {
		super.tearDown();
		if (StockageService.rechercherStockage("test")!=null) unStockage.supprimerStockage("test");
	}
	public final void testcreerStockageNullArguments() {
		unStock = new Stockage(null, null, null);
		assertEquals("Resultat insertion : ", 0,unStockage.creerStockage(unStock));
	}
	
	/**
	 * Test method VisiteService#creerStockage --> cas ref null
	 */
	@Test
	public final void testcreerStockageQteNull() {
		unStock = new Stockage(null,unVisiteur,unMedicament);
		assertEquals("Resultat insertion : ", 0,unStockage.creerStockage(unStock));
	}
	
	/**
	 * Test method VisiteService#creerStockage --> cas Visiteur existant
	 */
	@Test
	public final void testcreerStockageDejaExistant() {
		unStock = new Stockage("106",unVisiteur,unMedicament);
		unStockage.creerStockage(unStock);
		assertEquals("Resultat insertion : ", 0,unStockage.creerStockage(unStock));
	}
	
	/**
	 * Test method VisiteService#creerStockage --> cas Date null
	 */
	@Test
	public final void testcreerStockageVisiteurNull() {
		unStock = new Stockage("106",null,unMedicament);
		assertEquals("Resultat insertion : ", 0,unStockage.creerStockage(unStock));
	}
	
	/**
	 * Test method VisiteService#creerStockage --> cas Commentaire null
	 */
	@Test
	public final void testcreerStockageMedicamentNull() {
		unStock = new Stockage("106",unVisiteur,null);
		assertEquals("Resultat insertion : ", 0,unStockage.creerStockage(unStock));
	}


}
