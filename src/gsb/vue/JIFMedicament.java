package gsb.vue;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gsb.modele.Medicament;

public class JIFMedicament extends JInternalFrame {
	protected JPanel p;  
	protected JPanel pTexte;
	protected JPanel pBoutons;
	

	protected JLabel JLdepotLegal;
	protected JLabel JLnomCommercial;
	protected JLabel JLcomposition;
	protected JLabel JLeffets;
	protected JLabel JLcontreIndication;
    protected JLabel JLprixEchantillon;
    protected JLabel JLcodeFamille;
    protected JLabel JLlibelleFamille;
    
	protected JTextField JTdepotLegal;
	protected JTextField JTnomCommercial;
	protected JTextField JTcomposition;
	protected JTextField JTeffets;
	protected JTextField JTcontreIndication;
    protected JTextField JTprixEchantillon;
    protected JTextField JTcodeFamille;
    protected JTextField JTlibelleFamille;
	
    public JIFMedicament() {
    	p = new JPanel();  // panneau principal de la fenêtre
        pBoutons = new JPanel();    // panneau supportant les boutons
        pTexte = new JPanel(new GridLayout(9,2));
    	
    	 JLdepotLegal = new JLabel("depotLegal");
         JLnomCommercial = new JLabel("nomCommercial");
         JLcomposition = new JLabel("Prénom");
         JLeffets = new JLabel("effets");
         JLcontreIndication = new JLabel("contreIndication");
         JLprixEchantillon = new JLabel("prixEchantillon");
         JLcodeFamille = new JLabel("codeFamille");
         JLlibelleFamille = new JLabel("libelleFamille");
         
         JTdepotLegal = new JTextField(20);
         JTdepotLegal.setMaximumSize(JTdepotLegal.getPreferredSize());
         JTnomCommercial = new JTextField();
         JTcomposition = new JTextField();
         JTeffets = new JTextField();    
         JTcontreIndication = new JTextField();
         JTprixEchantillon = new JTextField();
         JTcodeFamille = new JTextField();
         JTlibelleFamille = new JTextField();
         
         pTexte.add(JLdepotLegal);
         pTexte.add(JTdepotLegal);
         pTexte.add(JLnomCommercial);
         pTexte.add(JTnomCommercial);
         pTexte.add(JLcomposition);
         pTexte.add(JTcomposition);
         pTexte.add(JLeffets);
         pTexte.add(JTeffets);
         pTexte.add(JLcontreIndication);
         pTexte.add(JTcontreIndication);
         pTexte.add(JLprixEchantillon);
         pTexte.add(JTprixEchantillon);
         pTexte.add(JLcodeFamille);
         pTexte.add(JTcodeFamille);
         pTexte.add(JLlibelleFamille);
         pTexte.add(JTlibelleFamille);
		
        // mise en forme de la fenêtre

         p.add(pTexte);
         p.add(pBoutons);
         Container contentPane = getContentPane();
         contentPane.add(p);

	}
    
    public void remplirText(Medicament unMedicament) 	
    {  // méthode qui permet de remplir les zones de texte à partir des valeurs passées en paramètres
        JTdepotLegal.setText(unMedicament.getDepotLegal());        
        JTnomCommercial.setText(unMedicament.getNomCommercial());
        JTcomposition.setText(unMedicament.getComposition());
        JTeffets.setText(unMedicament.getEffets());    
        JTcontreIndication.setText(unMedicament.getContreIndication());
        JTprixEchantillon.setText(unMedicament.getPrixEchantillon());
        JTcodeFamille.setText(unMedicament.getCodeFamille());
        JTlibelleFamille.setText(unMedicament.getLibelleFamille());
     }
     
      public void viderText() 	
    {  // méthode qui permet de vider les zones de texte 
        JTdepotLegal.setText("");        
        JTnomCommercial.setText("");
        JTcomposition.setText("");
        JTeffets.setText("");    
        JTcontreIndication.setText("");
        JTprixEchantillon.setText("");
        JTcodeFamille.setText("");
        JTlibelleFamille.setText("");
     } 
}
