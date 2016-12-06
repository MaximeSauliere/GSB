/**
 * 
 */
package gsb.service.unit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import gsb.modele.Medicament;
import gsb.service.MedicamentService;
import junit.framework.TestCase;

/**
 * @author maxim
 *
 */
public class MedicamentServiceTest extends TestCase {
	private Medicament unMedic;
	private MedicamentService unMedicament;
	
	/** (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Before
	protected void setUp() throws Exception {
		super.setUp();
		unMedic = new Medicament("unCode", "unNom", "unCommentaire", "unEffet", "uneContradiction", "0", "unCode", "unLibelle");
		unMedicament = new MedicamentService();
	}

	/** (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	@After
	protected void tearDown() throws Exception {
		super.tearDown();
		if (unMedicament.rechercherMedicament("test")!=null) unMedicament.supprimerMedicament("test");
	}

	@Test
	public final void testcreerMedicamentNullArguments() {
		unMedic = new Medicament(null, null, null, null, null, null, null, null);
		assertEquals("Resultat insertion : ", 0,unMedicament.creerMedicament(unMedic));
	}
	/**
	 * Test method MedicamentService#creerMedicament --> cas code null
	 */
	@Test
	public final void testcreerMedicamentRefNull() {
		unMedic = new Medicament(null, "trimycine", "triamcinolone (acetonide) + neomysine", "ce medoc est un truc fort", "si allergique c est pas bon", "106", "unCode", "unLibelle");
		assertEquals("Resultat insertion : ", 0,unMedicament.creerMedicament(unMedic));
	}
	
	/**
	 * Test method MedicamentService#creerMedicament --> cas Medicament existant
	 */
	@Test
	public final void testcreerMedicamentDejaExistant() {
		unMedic = new Medicament("3myc7", "trimycine", "triamcinolone (acetonide) + neomysine", "ce medoc est un truc fort", "si allergique c est pas bon", "106", "unCode", "unLibelle");
		unMedicament.creerMedicament(unMedic);
		assertEquals("Resultat insertion : ", 0,unMedicament.creerMedicament(unMedic));
	}
	
	/**
	 * Test method MedicamentService#creerMedicament --> cas Nom null
	 */
	@Test
	public final void testcreerMedicamentNomNull() {
		unMedic = new Medicament("3myc7", null, "triamcinolone (acetonide) + neomysine", "ce medoc est un truc fort", "si allergique c est pas bon", "106", "unCode", "unLibelle");
		assertEquals("Resultat insertion : ", 0,unMedicament.creerMedicament(unMedic));
	}
	
	/**
	 * Test method MedicamentService#creerMedicament --> cas Commentaire null
	 */
	@Test
	public final void testcreerMedicamentCommNull() {
		unMedic = new Medicament("3myc7", "trimycine", null, "ce medoc est un truc fort", "si allergique c est pas bon", "106",  "unCode", "unLibelle");
		assertEquals("Resultat insertion : ", 0,unMedicament.creerMedicament(unMedic));
	}
	
	/**
	 * Test method MedicamentService#creerMedicament --> cas Effet null
	 */
	@Test
	public final void testcreerMedicamentEffetNull() {
		unMedic = new Medicament("3myc7", "trimycine", "triamcinolone (acetonide) + neomysine", null, "si allergique c est pas bon", "106", "unCode", "unLibelle");
		assertEquals("Resultat insertion : ", 0,unMedicament.creerMedicament(unMedic));
	}
	
	/**
	 * Test method MedicamentService#creerMedicament --> cas Contradiction null
	 */
	@Test
	public final void testcreerMedicamentContradictionNull() {
		unMedic = new Medicament("3myc7", "trimycine", "triamcinolone (acetonide) + neomysine", "ce medoc est un truc fort", null, "106", "unCode", "unLibelle");
		assertEquals("Resultat insertion : ", 0,unMedicament.creerMedicament(unMedic));
	}
	
	/**
	 * Test method MedicamentService#creerMedicament --> cas Quantite null
	 */
	@Test
	public final void testcreerMedicamentQuantiteNull() {
		unMedic = new Medicament("3myc7", "trimycine", "triamcinolone (acetonide) + neomysine", "ce medoc est un truc fort", "si allergique c est pas bon", null, "unCode", "unLibelle");
		assertEquals("Resultat insertion : ", 0,unMedicament.creerMedicament(unMedic));
	}
	
	/**
	 * Test method MedicamentService#creerMedicament --> cas Famille null
	 */
	@Test
	public final void testcreerMedicamentCodeFamilleNull() {
		unMedic = new Medicament("3myc7", "trimycine", "triamcinolone (acetonide) + neomysine", "ce medoc est un truc fort", "si allergique c est pas bon", "106", null, "unLibelle");
		assertEquals("Resultat insertion : ", 0,unMedicament.creerMedicament(unMedic));
	}
	
	/**
	 * Test method MedicamentService#creerMedicament --> cas Famille null
	 */
	@Test
	public final void testcreerMedicamentLibelleFamilleNull() {
		unMedic = new Medicament("3myc7", "trimycine", "triamcinolone (acetonide) + neomysine", "ce medoc est un truc fort", "si allergique c est pas bon", "106", "unCode", null);
		assertEquals("Resultat insertion : ", 0,unMedicament.creerMedicament(unMedic));
	}

}