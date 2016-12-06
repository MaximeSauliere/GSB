package gsb.vue;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gsb.modele.Stockage;
import gsb.service.MedicamentService;
import gsb.service.StockageService;
import gsb.service.VisiteurService;

public class JIFMedicamentAjout extends JInternalFrame implements ActionListener{
	
	protected JPanel p;  
	protected JPanel pTexte;
	protected JPanel pBoutons;
	
	protected JButton JBouton;
	
	protected JLabel JLdepotLegal;
	protected JLabel JLcodeVisiteur;
	protected JLabel JLquantite;
	
	protected JTextField JTdepotLegal;
	protected JTextField JTcodeVisiteur;
	protected JTextField JTquantite;
	
	public JIFMedicamentAjout (MenuPrincipal menuPrincipal){
		p = new JPanel();  // panneau principal de la fenêtre
        pBoutons = new JPanel();    // panneau supportant les boutons
        pTexte = new JPanel(new GridLayout(9,2));
    	
    	JLdepotLegal = new JLabel("depotLegal");
        JLcodeVisiteur = new JLabel("codeVisiteur");
        JLquantite = new JLabel("quantité");
         
        JTdepotLegal = new JTextField(20);
        JTdepotLegal.setMaximumSize(JTdepotLegal.getPreferredSize());
        JTcodeVisiteur = new JTextField();
        JTquantite = new JTextField();    
        
        pTexte.add(JLdepotLegal);
        pTexte.add(JTdepotLegal);
        pTexte.add(JLcodeVisiteur);
        pTexte.add(JTcodeVisiteur);
        pTexte.add(JLquantite);
        pTexte.add(JTquantite);
        
        JBouton = new JButton("Ajout quantité");
        JBouton.addActionListener(this);
        pBoutons.add(JBouton);
        p.add(pTexte);
        p.add(pBoutons);
        
        Container contentPane = getContentPane();
        contentPane.add(p);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Object source = arg0.getSource();
   		if (source == JBouton){
   			if(pTexte != null){
   				Stockage unStockage = new Stockage(JTquantite.getText(),VisiteurService.rechercherVisiteur(JTcodeVisiteur.getText()), MedicamentService.rechercherMedicament(JTdepotLegal.getText()));
   				StockageService.creerStockage(unStockage);
   			}
   		}
	}
}














