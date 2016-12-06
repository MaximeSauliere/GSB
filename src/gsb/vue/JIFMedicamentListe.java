package gsb.vue;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import gsb.modele.Medicament;
import gsb.modele.dao.MedicamentDao;

public class JIFMedicamentListe extends JInternalFrame implements ActionListener {
	private HashMap<String,Medicament> diccoMedicament;

	protected JPanel p;
	protected JScrollPane scrollPane;
	protected JPanel pSaisie;
	protected JTextField JTcodeMedicament;
	protected JButton JBafficherFiche;
	protected MenuPrincipal fenetreContainer;
	protected JTable table;

	public JIFMedicamentListe(MenuPrincipal uneFenetreContainer) {

		fenetreContainer = uneFenetreContainer;
		// r�cup�ration des donn�es Medicament dans la collection
		//lesMedicaments = MedicamentDao.retournerCollectionDesMedicament();

		//int nbLignes = lesMedicaments.size();
		diccoMedicament = MedicamentDao.retournerDictionnaireDesMedicament();
		int nbLignes= diccoMedicament.size();
		
		p = new JPanel(); // panneau principal de la fen�tre

		int i=0;
		String[][] data = new String[nbLignes][3] ;
		//for(Medicament unMedicament : lesMedicaments){
		
		for (Map.Entry<String,Medicament> uneEntree : diccoMedicament.entrySet()){
			data[i][0] = uneEntree.getValue().getDepotLegal();
			data[i][1] = uneEntree.getValue().getNomCommercial();
			data[i][2] = uneEntree.getValue().getLibelleFamille();
			i++;
			}
		String[] columnNames = {"DepotLegal","NomCommercial","LibelleFamille"};
		table = new JTable(data, columnNames);
		table.getSelectionModel().addListSelectionListener(table);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(400, 200));
		p.add(scrollPane);
		
		pSaisie = new JPanel();
		JTcodeMedicament = new JTextField(20);
		JTcodeMedicament.setMaximumSize(JTcodeMedicament.getPreferredSize());
		JBafficherFiche = new JButton("Afficher Fiche Medicament");
		JBafficherFiche.addActionListener(this); // source d'�venement
		pSaisie.add(JTcodeMedicament);
		pSaisie.add(JBafficherFiche);
		p.add(pSaisie);
		
		// mise en forme de la fen�tre
		Container contentPane = getContentPane();
		contentPane.add(p);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
   		if (source == JBafficherFiche){
   			if (diccoMedicament.containsKey(JTcodeMedicament.getText())){
   	   			Medicament unMedicament = diccoMedicament.get(JTcodeMedicament.getText());
   	   			fenetreContainer.ouvrirFenetre(new JIFMedicamentFiche(unMedicament));
   			}
   		}
   		if(source == table){
   			JTcodeMedicament.setText((String)table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()));
   			
   		}
	}
}