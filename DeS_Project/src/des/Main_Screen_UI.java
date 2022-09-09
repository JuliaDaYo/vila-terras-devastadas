package des;


import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main_Screen_UI {

	Main_Screen gm;
	
	JFrame Menu;
	public JPanel bgPanel[] = new JPanel[10];
	public JLabel bgLabel[] = new  JLabel[10];
	public JButton botao;
	
	
	
	public Main_Screen_UI(Main_Screen gm) {
		
		
		this.gm = gm;
		MainScreen();
		Menu.setVisible(true);
		GerarTela();
		}
	
	
	
	
	
public void MainScreen () {
	Menu = new JFrame();
	Menu.setSize(800, 600);
	Menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Menu.getContentPane().setBackground(Color.black);
	Menu.setLayout(null);
	
}


public void createBackround() { //bgType == Qual backgroud to usando
	 //bgFile == Nome do arquivo
bgPanel [1] = new JPanel();
bgPanel[1].setBounds(0,-50, 1370, 920); //ishaalah  1390, 1070
bgPanel[1].setLayout(null);
Menu.add(bgPanel[1]);

bgLabel[1] = new JLabel();
bgLabel[1].setBounds(0,0,1400,800); //blessed numbers

 
ImageIcon bg = new ImageIcon(getClass().getClassLoader().getResource("ma1n_Screen.png"));

Image in = bg.getImage().getScaledInstance(1400, 700, Image.SCALE_DEFAULT);
bg = new ImageIcon(in);

bgLabel[1].setIcon(bg);


}


public void CriarObj( int objx, int objy, int objLargura, int obgAltura, String objFileName,
		int bX, int bY, int bW, int bH, int type) {
	
	JLabel obj = new JLabel();

	obj.setBounds(objx, objy, objLargura, obgAltura);
	ImageIcon objIcon = new ImageIcon(getClass().getClassLoader().getResource(objFileName));
	Image in = objIcon.getImage().getScaledInstance(300, 620, Image.SCALE_DEFAULT);
	objIcon = new ImageIcon(in);
	
	obj.setIcon(objIcon);
	obj.setVisible(true);
	
	
	JButton botao = new JButton();//Criação do Botao de login PARTE INTERATIVA
	botao.setBounds(bX, bY, bW, bH);
	botao.setContentAreaFilled(false);
	botao.setBorderPainted(true);
	
	
	bgPanel[1].add(botao);
	bgPanel[1].add(obj);
	
	if (type ==0) {
	
		//O QUE FAZER QUANDO O BOO FOR APERTADO(MANDAR PARA OUTRA PAGINA);
		//NAO SEI FAZER ISSO
		botao.addActionListener(new ActionListener () {
		    public void actionPerformed (ActionEvent event) {	
		    	
		    	//Link para proxima pagina
		   }
		});
		
		
	}else if (type==1) {
			
		//O QUE FAZER QUANDO O BOO FOR APERTADO(MANDAR PARA OUTRA PAGINA);
		//NAO SEI FAZER ISSO
		botao.addActionListener(new ActionListener () {
		    public void actionPerformed (ActionEvent event) {	
		    	//Link para proxima pagina
		    	
		   }
		});
		
		
	}
	


}

public void GerarTela() {
	
	createBackround();
	CriarObj(30, 30, 550, 650, "Todo_Paper.png", 50, 60, 170, 600, 0);
	CriarObj(1060, 40, 550, 650, "Village_Paper.png", 1160, 60, 170, 600, 1);
	
	bgPanel[1].add(bgLabel[1]);
}


	
}
