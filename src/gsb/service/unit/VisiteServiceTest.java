/**
 * 
 */
package gsb.service.unit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gsb.modele.Localite;
import gsb.modele.Medecin;
import gsb.service.VisiteService;
import gsb.modele.Visiteur;
import junit.framework.TestCase;

/**
 * @author maxim
 *
 */
public class VisiteServiceTest extends TestCase {
	private VisiteService uneVisiteService;
	private Visiteur unVisiteur;
	private Medecin unMedecin;
	private Localite uneLocalite;

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Before
	protected void setUp() throws Exception {
		super.setUp();
		uneVisiteService = new VisiteService();
		unVisiteur = new Visiteur("02", "Dupont", "Jean", "DupontJ", "Jean56", " 1 rue de la rivière", "02-97-02-15-95", "2 Janvier 2016");
		uneLocalite = new Localite("56600","Lorient");
		unMedecin = new Medecin("M01", "Dupont","Jack","1 rue foret",uneLocalite,"02-97-05-47-48","pro","Generaliste");
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	@After
	protected void tearDown() throws Exception {
		super.tearDown();
		if (VisiteService.rechercherVisite("test")!=null) uneVisiteService.supprimerVisite("test");
	}

	@Test
	public final void testcreerVisiteNullArguments() {
		assertEquals("Resultat insertion : ", 0,uneVisiteService.creerVisite(null, null, null, null, null));
	}
	
	/**
	 * Test method VisiteService#creerVisite --> cas ref null
	 */
	@Test
	public final void testcreerVisiteRefNull() {
		assertEquals("Resultat insertion : ", 0,uneVisiteService.creerVisite(null, "01/06/2016", "unCommentaire", unVisiteur, unMedecin));
	}
	
	/**
	 * Test method VisiteService#creerVisite --> cas Visiteur existant
	 */
	@Test
	public final void testcreerVisiteDejaExistant() {
		uneVisiteService.creerVisite("106", "01/06/2016", "unCommentaire", unVisiteur, unMedecin);
		assertEquals("Resultat insertion : ", 0,uneVisiteService.creerVisite("106", "01/06/2016", "unCommentaire", unVisiteur, unMedecin));
	}
	
	/**
	 * Test method VisiteService#creerVisite --> cas Date null
	 */
	@Test
	public final void testcreerVisiteNomNull() {
		assertEquals("Resultat insertion : ", 0,uneVisiteService.creerVisite("106", null, "unCommentaire", unVisiteur, unMedecin));
	}
	
	/**
	 * Test method VisiteService#creerVisite --> cas Commentaire null
	 */
	@Test
	public final void testcreerVisiteCommNull() {
		assertEquals("Resultat insertion : ", 0,uneVisiteService.creerVisite("106", "01/06/2016", null, unVisiteur, unMedecin));
	}
	
	/**
	 * Test method VisiteService#creerVisite --> cas Visiteur null
	 */
	@Test
	public final void testcreerVisiteEffetNull() {
		assertEquals("Resultat insertion : ", 0,uneVisiteService.creerVisite("106", "01/06/2016", "unCommentaire", null, unMedecin));
	}
	
	/**
	 * Test method VisiteService#creerVisite --> cas Medecin null
	 */
	@Test
	public final void testcreerVisiteContradictionNull() {
		assertEquals("Resultat insertion : ", 0,uneVisiteService.creerVisite("106", "01/06/2016", "unCommentaire", unVisiteur, null));
	}

}
