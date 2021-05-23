import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotaoListener implements ActionListener {

	private PainelCadastro painelCadastro;
	private Dao dao = new Dao();

	public BotaoListener(PainelCadastro painelCadastro) {
		this.painelCadastro = painelCadastro;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Filme filme = new Filme();
		filme.setTitulo(painelCadastro.getCampos().getTitulo().getText());
		filme.setSinopse(painelCadastro.getCampos().getSinopse().getText());
		filme.setGenero(String.valueOf(painelCadastro.getCampos().getGenero().getSelectedItem()));
		filme.setOndeAssistir(painelCadastro.getComponentes().getOndeAssistir().getGrupo().getSelection().getActionCommand());
		filme.setAssistido(painelCadastro.getComponentes().getAssistido().isSelected());
		filme.setAvaliacao(painelCadastro.getComponentes().getAvaliacao().getSelection() );
		
		System.out.println(filme);	
		
		dao.create(filme);

	}

}
