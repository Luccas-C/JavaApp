import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PainelLista extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private DefaultTableModel modelo = new DefaultTableModel();
	private JButton carregar = new JButton("carregar");
	private JButton apagar = new JButton("apagar");
	private JTable tabela = new JTable(modelo); 
	private JLabel lista = new JLabel("Lista de Filmes");
	
	public PainelLista() {
		init();
	}

	private void init() {
		add(lista);
		
		modelo.addColumn("ID");
		modelo.addColumn("Titulo");
		modelo.addColumn("Sinopse");
		modelo.addColumn("Genero");
		modelo.addColumn("Onde Assistir");
		modelo.addColumn("Assistido");
		modelo.addColumn("Avaliação");
		
		carregarDados();
		
		add(new JScrollPane(tabela));
		
		JPanel botoes = new JPanel();
		botoes.add(apagar);
		botoes.add(carregar);
		
		add(botoes, BorderLayout.SOUTH);
		
		carregar.addActionListener(this);
		apagar.addActionListener(this);
		
		
	}
	
	public void carregarDados() {
		modelo.setNumRows(0);
		
		Dao dao = new Dao();
		TypedQuery<Filme> lista = (TypedQuery<Filme>) dao.query();
		
		for (Filme filme : lista) {
			TypedQuery<Filme> linha = { 
				filme.getId()+"",
				filme.getTitulo(),
				filme.getSinopse(),
				filme.getGenero(),
				filme.getOndeAssistir(),
				filme.isAssistido()+"",
				filme.getAvaliacao()+""
			};
			modelo.addRow(linha);
		}	
	}
	
	private void apagar() {
		Dao dao = new Dao();
		int linha = tabela.getSelectedRow();
		String id = tabela.getValueAt(linha, 0).toString();
		Filme filme = dao.buscarPorId(Long.valueOf(id));
		int resposta = JOptionPane.showConfirmDialog(this, "Tem certeza que quer apagar o aluno selecionado?");
		//dao.apagarPeloId(Long.valueOf(id));
		if (resposta == JOptionPane.YES_OPTION) {
			dao.apagar(filme);
			carregarDados();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == carregar) carregarDados();		
		if (e.getSource() == apagar) apagar();
	}
}