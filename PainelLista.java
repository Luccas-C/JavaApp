import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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
	private JButton editar = new JButton("editar");
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
		botoes.add(editar);
		
		add(botoes, BorderLayout.SOUTH);
		
		carregar.addActionListener(this);
		apagar.addActionListener(this);
		editar.addActionListener(this);
		
	}
	
	public void carregarDados() {
		modelo.setNumRows(0);
		
		Dao dao = new Dao();
		List<Filme> lista = dao.query();
		
		for (Filme filme : lista) {
			String[] linha = { 
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
	
	private void editar() {
		Dao dao = new Dao();
		int linha = tabela.getSelectedRow();
		String id = tabela.getValueAt(linha, 0).toString();
		String titulo = tabela.getValueAt(linha, 1).toString();
		String sinopse = tabela.getValueAt(linha, 2).toString();
		String genero = tabela.getValueAt(linha, 3).toString();
		String ondeAssistir = tabela.getValueAt(linha, 4).toString();
		String assistido = tabela.getValueAt(linha, 5).toString();
		
		boolean foiAssistido = (assistido == "true")? true : false;
		
		String avaliacao = tabela.getValueAt(linha, 6).toString();
		Filme filme = new Filme(Long.valueOf(id) ,titulo, sinopse, genero, ondeAssistir, foiAssistido,Integer.parseInt(avaliacao));
		dao.edit(filme);
		//carregarDados();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == carregar) carregarDados();		
		if (e.getSource() == apagar) apagar();
		if (e.getSource() == editar) editar();
	}
}