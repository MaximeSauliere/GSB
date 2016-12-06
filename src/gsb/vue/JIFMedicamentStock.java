package gsb.vue;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import gsb.modele.Medicament;
import gsb.modele.Stockage;
import gsb.modele.dao.StockageDao;

public class JIFMedicamentStock extends JInternalFrame implements ActionListener {

	protected JTextField JTcodeStockage;
	protected JPanel p;
	protected JScrollPane scrollPane;
	protected JPanel pSaisie;
	protected MenuPrincipal fenetreContainer;
	protected JTable table;
	private HashMap<String, Stockage> diccoStockage;
	
	public JIFMedicamentStock(MenuPrincipal uneFenetreContainer) {
		// TODO Auto-generated constructor stub
		
		fenetreContainer = uneFenetreContainer;
		// récupération des données Stockage dans la collection
		//lesStockages = StockageDao.retournerCollectionDesStockage();
	
		//int nbLignes = lesStockages.size();
		diccoStockage = StockageDao.retournerDictionnaireDesStockage();
		int nbLignes= diccoStockage.size();
		
		p = new JPanel(); // panneau principal de la fenêtre
	
		int i=0;
		String[][] data = new String[nbLignes][3] ;
		//for(Stockage unStockage : lesStockages){
		
		for (Entry<String, Stockage> uneEntree : diccoStockage.entrySet()){
			data[i][0] = uneEntree.getValue().getLeVisiteur().getMatricule();
			data[i][1] = uneEntree.getValue().getLeMedicament().getNomCommercial();
			data[i][2] = uneEntree.getValue().getQte();
			i++;
			}
		String[] columnNames = {"Matricule","NomCommercial","Quantite"};
		table = new JTable(data, columnNames);
		table.getSelectionModel().addListSelectionListener(table);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(400, 200));
		p.add(scrollPane);
		
		//pSaisie = new JPanel();
		//JTcodeStockage = new JTextField(20);
		//JTcodeStockage.setMaximumSize(JTcodeStockage.getPreferredSize());
		//pSaisie.add(JTcodeStockage);
		//p.add(pSaisie);
		
		// mise en forme de la fenêtre
		Container contentPane = getContentPane();
		contentPane.add(p);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	;
}
