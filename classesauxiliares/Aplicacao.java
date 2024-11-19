package eclipseExercise.classesauxiliares;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class Aplicacao {
	private MyDBHelper db ;
	private char sx = 'G';
	private Contacto p; 
	private ArrayList<? extends Contacto> contactoS;
	private JFrame frame;
	private JTextField txtCC;
	private JTextField txtNIF;
	private JTextField txtApelido;
	private JTextField txtName;
	private JTextField txtNascimento;
	private JTextField txtMorada;
	private JTextField txtTelefone;
	private JTextField txtEmail;
	private JLabel lblTitulo = new JLabel("Contacto");
	private ImageIcon ico;
	private JLabel lblFoto ;
	private JTextField txtConducao;
	private final ButtonGroup grpSexo = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater( new Runnable() {
			public void run() {
				try {
					Aplicacao window = new Aplicacao();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Aplicacao() {
		initialize();
	}
	public void enviar() {
		try {
			p = new Contacto(txtCC, txtNIF, txtName, txtApelido, txtNascimento,String.format(Locale.getDefault(),"%c" ,sx) , txtMorada, txtTelefone, txtEmail );
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 JOptionPane.showMessageDialog( frame, p.toArrayList(), String.format(Locale.getDefault(),"%s %s", p.getNome()  , p.getApelido() ) , 1 );
	}
	/**
	*
	*/
	private Boolean array2form() {
		Boolean r = false;
		try {
			contactoS.forEach ( ( c ) -> {
				txtCC.setText( c.getCC().toString() ) ; 
				txtNIF.setText( c.getNIF().toString() ) ; 
				txtName.setText( c.getNome() ) ; 
				txtApelido.setText( c.getApelido() ); 
				txtNascimento.setText( c.getNascimento().toString() ) ;
				txtMorada.setText( c.getMorada() );
				txtEmail.setText( c.getEmail() );
				txtTelefone.setText( c.getTelefone() ) ;
				ico.setImage( c.getFoto() ) ;;
				lblFoto.setIcon( ico ) ;
				System.err.println( c.getCC().toString() );
			} );			
			r = true;
		}
		catch(Exception erro) {erro.printStackTrace(); }
		finally { return r; }
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 884, 692);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		lblTitulo.setForeground(UIManager.getColor("Menu.selectionBackground"));
		lblTitulo.setVerticalAlignment(SwingConstants.TOP);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		frame.getContentPane().add(lblTitulo);

		JSeparator separator = new JSeparator();
		frame.getContentPane().add(separator);

		JLabel lblCC = new JLabel("Cartão de Cidadão");
		frame.getContentPane().add(lblCC);

		txtCC = new JTextField();
		txtCC.setText("102140219ZX9");
		lblCC.setLabelFor(txtCC);
		txtCC.setToolTipText("Cartão de Cidadão");
		frame.getContentPane().add(txtCC);
		txtCC.setColumns(10);

		JLabel lblNIF = new JLabel("Numero de Identificação Fiscal");
		frame.getContentPane().add(lblNIF);

		txtNIF = new JTextField();
		txtNIF.setText("202609952");
		lblNIF.setLabelFor(txtNIF);
		txtNIF.setToolTipText("Numero de Identificação Fiscal");
		frame.getContentPane().add(txtNIF);
		txtNIF.setColumns(10);

		JLabel lblName = new JLabel("Name");
		frame.getContentPane().add(lblName);

		txtName = new JTextField();
		txtName.setText("Rui Manuel");
		lblName.setLabelFor(txtName);
		txtName.setToolTipText("Name");
		txtName.setColumns(10);
		frame.getContentPane().add(txtName);

		JLabel lblApelido = new JLabel("Apelido");
		frame.getContentPane().add(lblApelido);

		txtApelido = new JTextField();
		txtApelido.setText("Oliveira Pereira");
		lblApelido.setLabelFor(txtApelido);
		txtApelido.setToolTipText("Apelido");
		frame.getContentPane().add(txtApelido);
		txtApelido.setColumns(10);

		JButton btnSend = new JButton("Enviar");
		btnSend.setForeground(new Color(0, 0, 255));
		btnSend.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnSend.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				enviar();
				db=new MyDBHelper() ;
				contactoS = db.consultaContacto();
				if (array2form() ) {
					// db.close();
					JOptionPane.showMessageDialog( frame, db.consultaContacto().toString() , "Titulo " , 1 );
				}
			}
		});

		JLabel lblNascimento = new JLabel("Nascimento");
		lblNascimento.setToolTipText("Nascimento");
		frame.getContentPane().add(lblNascimento);

		txtNascimento = new JTextField();
		lblNascimento.setLabelFor(txtNascimento);
		txtNascimento.setText("1973-06-12");
		txtNascimento.setToolTipText("Nascimento");
		txtNascimento.setColumns(10);
		frame.getContentPane().add(txtNascimento);

		JSeparator separator_1 = new JSeparator();
		frame.getContentPane().add(separator_1);

		JRadioButton rdMasculino = new JRadioButton("Masculino");
		rdMasculino.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getSource()==rdMasculino) { sx='M'; }
			}
		} ) ;
		grpSexo.add(rdMasculino);
		rdMasculino.setToolTipText("Masculino");
		frame.getContentPane().add(rdMasculino);

		JRadioButton rdFeminino = new JRadioButton("Feminino");
		rdFeminino.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if( e.getSource()==rdFeminino ) { sx='F'; }
			}
		} ) ;
		grpSexo.add(rdFeminino);
		rdFeminino.setToolTipText("Feminino");
		frame.getContentPane().add(rdFeminino);

		JSeparator separator_2 = new JSeparator();
		frame.getContentPane().add(separator_2);

		JLabel lblConducao = new JLabel("Condução");
		frame.getContentPane().add(lblConducao);

		txtConducao = new JTextField();
		txtConducao.setText("L-13067993");
		lblConducao.setLabelFor(txtConducao);
		txtConducao.setToolTipText("Condução");
		txtConducao.setColumns(10);
		frame.getContentPane().add(txtConducao);

		JLabel lblMorada = new JLabel("Morada");
		frame.getContentPane().add(lblMorada);

		txtMorada = new JTextField();
		txtMorada.setText("Rua Francisco Marques Pereira (Pina), Pinheiro, Nossa Senhora Da Piedade, 2490-554 OURÉM, Portugal");
		lblMorada.setLabelFor(txtMorada);
		txtMorada.setToolTipText("Morada");
		frame.getContentPane().add(txtMorada);
		txtMorada.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone");
		frame.getContentPane().add(lblTelefone);

		txtTelefone = new JTextField();
		txtTelefone.setText("00351911791682");
		lblTelefone.setLabelFor(txtTelefone);
		txtTelefone.setToolTipText("Morada");
		txtTelefone.setColumns(10);
		frame.getContentPane().add(txtTelefone);

		JLabel lblEmail = new JLabel("Email");
		frame.getContentPane().add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setText("rui.o.pereira@gmail.com");
		lblEmail.setLabelFor(txtEmail);
		txtEmail.setToolTipText("Morada");
		txtEmail.setColumns(10);
		frame.getContentPane().add(txtEmail);
		
		JLabel lblFoto = new JLabel("foto");
		lblFoto.setToolTipText("Foto");
		frame.getContentPane().add(lblFoto);

		JSeparator separator_3 = new JSeparator();
		frame.getContentPane().add(separator_3);
		btnSend.setToolTipText("Enviar os Dados");
		frame.getContentPane().add(btnSend);

		JMenuBar barMenus = new JMenuBar();
		frame.setJMenuBar(barMenus);

		JMenu mnFicheiro = new JMenu("Ficheiro");
		barMenus.add(mnFicheiro);

		JMenuItem opcFechar = new JMenuItem("New menu item");
		mnFicheiro.add(opcFechar);

		JMenu mnRegisto = new JMenu("Registo");
		barMenus.add(mnRegisto);

		JMenuItem opcPrimeiro = new JMenuItem("Primeiro");
		mnRegisto.add(opcPrimeiro);

		JMenuItem opcSeguinte = new JMenuItem("Seguinte");
		mnRegisto.add(opcSeguinte);

		JMenuItem opcAnterior = new JMenuItem("Anterior");
		mnRegisto.add(opcAnterior);

		JMenuItem opcUltimo = new JMenuItem("Ultimo");
		mnRegisto.add(opcUltimo);

		JMenu mnAjuda = new JMenu("Ajuda");
		barMenus.add(mnAjuda);

		JMenuItem opcWelcome = new JMenuItem("Conteúdos");
		mnAjuda.add(opcWelcome);
	}
}
