package des;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.print.DocFlavor.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.util.Timer;
import java.util.TimerTask;

public class Village_UI {

	Village gm;
	
	JFrame window;
	public JPanel bgPanel[] = new JPanel[10];
	public JLabel bgLabel[] = new  JLabel[10];
	public JButton botao;
	public JLabel obj = new JLabel();
	public Timer timer = new Timer();
	
	
	public Village_UI(Village gm) {
		this.gm = gm;

		MainField();
		
		//Valores teste!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		//**************************************************
		int CoinAmnt =20, prizeAmnt = 0, villagetype =8;
		boolean prize = false;
		//********************************
		
	
		//********************************
	
	do {CoinAmnt = CoinAmnt - 5; 	prizeAmnt++;	}while (CoinAmnt >= 0);
		
		CoinAmnt = CoinAmnt + 5;	prizeAmnt--;	villagetype = villagetype + prizeAmnt;			
													// Camada da vila + os novos premios
	if (prizeAmnt > 0) {prize = true;}
						
						
	
	//System.out.println("VillageType:" + villagetype);
	//System.out.println("How many prizes:" + prizeAmnt);
	//System.out.println("Coin Amount:" + CoinAmnt);
		//********************************
		
		
		
		//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
							GerarVilla(prize, villagetype, CoinAmnt);
		//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		
		window.setVisible(true);
		
	}
	
	public void MainField () {
		window = new JFrame();
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		
	}
	
	//******************************************************************************************
	//*******************************CRIAR TELA DA VILA**************************************
	public void createBackround(int bgType, String bgFile) { //bgType == Qual backgroud to usando
															 //bgFile == Nome do arquivo
		bgPanel [bgType] = new JPanel();
		bgPanel[bgType].setBounds(0, -190, 1390, 1070); //ishaalah 
		bgPanel[bgType].setLayout(null);
		window.add(bgPanel[1]);
		
		bgLabel[bgType] = new JLabel();
		bgLabel[bgType].setBounds(0,0,1390,1070); //blessed numbers
		
		
		ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource(bgFile));
		bgLabel[1].setIcon(bgIcon);
		
		
	}
	
	//******************************************************************************************
	//	*********************CRIAR OBJETOS***************************************
	public void CreateObj (int bgType, int objx, int objy, int objLargura, //main Onject
			int obgAltura, String objFileName, int ButtonOp, int CoinQuant) {
		
		JLabel obj = new JLabel();
		JLabel objRe = new JLabel();
		//obj.setBounds(10, -130, 800, 800);
		obj.setBounds(objx, objy, objLargura, obgAltura);
		
		ImageIcon objIcon = new ImageIcon(getClass().getClassLoader().getResource(objFileName));
		obj.setIcon(objIcon);
		obj.setVisible(true);
		
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		//BOTAO TIPO 0: SE A CAIXA ESTIVER PRONTA A SER ABERTA_________________________________
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		 if(ButtonOp == 0){
		
			JButton botao = new JButton();//Cria豫o do Botao de login PARTE INTERATIVA
			botao.setBounds(555, 430, 340, 240);
			botao.setContentAreaFilled(false);
			botao.setBorderPainted(true);
			bgPanel[bgType].add(botao);
			
			//--------------------------------IMAGEM DE ITERA플O---------------------------
			objRe.setBounds(500,150, 700, 800); //OBEJTO 1 CRIA플O
    		ImageIcon objIconRe = new ImageIcon(getClass().getClassLoader().getResource("CoinBox_PrizeAlert.gif"));
    		objRe.setIcon(objIconRe);
    		objRe.setVisible(true);	
			
    		JLabel objRe2 = new JLabel();//OBJETO 2
    		objRe2.setBounds(500,55, 700, 800);
    		ImageIcon objIconRe2 = new ImageIcon(getClass().getClassLoader().getResource("CoinBox_Opening.gif"));
    		objRe2.setIcon(objIconRe2);
    		objRe2.setVisible(false);
    		bgPanel[bgType].add(objRe2);
    		
    		JLabel objRe3 = new JLabel();// OBJETO 3
    		objRe3.setBounds(500,55, 700, 800);
    		ImageIcon objIconRe3 = new ImageIcon(getClass().getClassLoader().getResource("CoinBox_Open.gif"));
    		objRe3.setIcon(objIconRe3);
    		objRe3.setVisible(false);
    		
    		bgPanel[bgType].add(objRe3);
    		bgPanel[1].add(objRe);
    		bgPanel[1].add(obj);
    		
    		//PUBLIC DELAYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY
								TimerTask task = new TimerTask() {
										public void run() {
										objRe2.setVisible(false);	
										objRe3.setVisible(true);
															} };
															
															TimerTask task2 = new TimerTask() {
																public void run() {
																obj.setVisible(false);
																objRe2.setVisible(false);	
																objRe3.setVisible(false);
																					} };
			botao.addActionListener(new ActionListener () {
			    public void actionPerformed (ActionEvent event) {	
			    	
			    	botao.setBounds(500, 430, 0, 0);
			    	objRe.setVisible(false);
			    		objRe2.setVisible(true);
			    		 timer.schedule(task, 1200);
			    		 
			    		 timer.schedule(task2, 3000);
			    		 
			    		 
			     
			   }
			});
			
			//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			//BOTAO TIPO 1 == MOSTRAR ANIM플O DA MOEDAS NA CAIXA_____________________________________________
			//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			
		}else if(ButtonOp == 1){if (CoinQuant == 0) {bgPanel[1].add(obj);}else if (CoinQuant > 0) {
			
								
			
			objRe.setBounds(465,59, 700, 800); //OBEJTO 1 CRIA플O
    		ImageIcon objIconRe = new ImageIcon(getClass().getClassLoader().getResource("CoinBox_CoinInsert.gif"));
    		objRe.setIcon(objIconRe);
    		objRe.setVisible(true);	
    		
    		JLabel objRe2 = new JLabel();//OBJETO 2
    		objRe2.setBounds(500,150, 700, 800);
    		ImageIcon objIconRe2 = new ImageIcon(getClass().getClassLoader().getResource("CoinBox.png"));
    		objRe2.setIcon(objIconRe2);
    		objRe2.setVisible(false);
    		
    		bgPanel[1].add(objRe2);
    		bgPanel[1].add(objRe);
    		bgPanel[1].add(obj);
    		
    		
    		TimerTask task = new TimerTask() {
				public void run() {
					obj.setVisible(true);
					objRe.setVisible(false);
					objRe2.setVisible(true);	

					
											} };
												 		
    		
    		TimerTask task2 = new TimerTask() {
				public void run() {
					obj.setVisible(false);
					objRe2.setVisible(false);
									} };
									

    		 int time = 1260;
    		 
    		if (CoinQuant==1) {time = 1200;}else if (CoinQuant == 2) {time = 2010;}else if(CoinQuant==3) {time=3000;}else if(CoinQuant==4) {time=3800;}
    		
   		
    		timer.schedule(task,time);
    		timer.schedule(task2,(time + 1000));
    		
    		
		
									}	}else if (ButtonOp == 2) {
										//--------------------------------IMAGEM DE ITERA플O
											bgPanel[bgType].add(obj);	        
										        obj.setVisible(true);
	        
										        //System.out.println("It works!!");

												
									} //"}" DO TIPO 3
			
	}
	

	
	public void GerarVilla (boolean verify, int Villagetype, int CoinQuant) {
		
		
		
		switch (Villagetype) {
		case 1:createBackround(1, "field_dayBare.gif");break;
		case 2:createBackround(1, "field_day_1.gif");break;
		case 3:createBackround(1, "field_day_1.gif");break;//casa
		case 4:createBackround(1, "field_day_2.gif");break;
		case 5:createBackround(1, "field_day_3.gif");break;
		case 6:createBackround(1, "field_day_3.gif");break;//moinho
		case 7:createBackround(1, "field_day_final.gif");break;
		case 8:createBackround(1, "field_day_final.gif");break;//pessoa
		case 9:createBackround(1, "field_day_final.gif");break;//porco
		case 10:createBackround(1, "field_day_final.gif");break;//vaca
		case 11:createBackround(1, "field_day_final.gif");break;//porco
		case 12:createBackround(1, "field_day_final.gif");break;	}//vaca
		
			
		
		// Numero no final                             ***aqui****
		if (verify == true) {
			CreateObj(1, 0, 0, 1390, 1070, "darken_bg.png", 0, CoinQuant);//0 = caixa vai abrir
			//CreateObj(1,10,-130, 800, 800, "CoinBox_Idle.png", 2);
			
		}else if (verify == false && CoinQuant == 0) {
			CreateObj(1,10,-130, 800, 800, "CoinBox_Idle.png", 2, CoinQuant);//2= valor qualquer pra n estrar nos ifs
		}else if (verify == false && CoinQuant > 0) {
			CreateObj(1, -20, 0, 1390, 1070, "darken_bg.png", 1, CoinQuant);// 1 = moeda inserir na caixa		
		}else {}
		
		
		//CONDI플O IF PARA ADICIONAR OS SERRES, 1 CASA E O MOINHO
		if (Villagetype >= 3 && Villagetype <= 5) {
			CreateObj(1, 50, 50, 1390, 1070, "house_day.png", 2, 0);
			
		}else if (Villagetype >= 6 && Villagetype <= 7) {
			CreateObj(1, 330, 100, 1390, 1070, "house_day.png", 2, 0);
			CreateObj(1, 700, -20, 1690, 1070, "WindMill1.gif", 2, 0);
			
		}else if (Villagetype == 8) {
			CreateObj(1, 330, 200, 1390, 1070, "villager_1Idle.gif", 2, 0);
			CreateObj(1, 330, 100, 1390, 1070, "house_day.png", 2, 0);
			CreateObj(1, 700, -20, 1690, 1070, "WindMill1.gif", 2, 0);
			
		}else if (Villagetype == 9) {
			CreateObj(1, 330, 200, 1390, 1070, "villager_1Idle.gif", 2, 0);
			CreateObj(1, 700, 140, 1390, 1070, "pig_idle.gif", 2, 0);
			CreateObj(1, 330, 100, 1390, 1070, "house_day.png", 2, 0);
			CreateObj(1, 700, -20, 1690, 1070, "WindMill1.gif", 2, 0);
			
			
		}else if (Villagetype == 10) {
			CreateObj(1, 330, 200, 1390, 1070, "villager_1Idle.gif", 2, 0);
			CreateObj(1, 700, 140, 1390, 1070, "pig_idle.gif", 2, 0);
			CreateObj(1, 1200, 140, 1390, 1070, "cow_idle.gif", 2, 0);
			CreateObj(1, 700, -20, 1690, 1070, "WindMill1.gif", 2, 0);	
			CreateObj(1, 330, 100, 1390, 1070, "house_day.png", 2, 0);
		}else if (Villagetype == 11) {
			CreateObj(1, 330, 200, 1390, 1070, "villager_1Idle.gif", 2, 0);
			CreateObj(1, 700, 140, 1390, 1070, "pig_idle.gif", 2, 0);
			CreateObj(1, 1200, 140, 1390, 1070, "cow_idle.gif", 2, 0);
			CreateObj(1, 1140, 170, 1390, 1070, "pig_idle.gif", 2, 0);
			CreateObj(1, 700, -20, 1690, 1070, "WindMill1.gif", 2, 0);	
			CreateObj(1, 330, 100, 1390, 1070, "house_day.png", 2, 0);
			
			
		}else if (Villagetype == 12) {
			CreateObj(1, 330, 200, 1390, 1070, "villager_1Idle.gif", 2, 0);
			CreateObj(1, 700, 140, 1390, 1070, "pig_idle.gif", 2, 0);
			CreateObj(1, 1200, 140, 1390, 1070, "cow_idle.gif", 2, 0);
			CreateObj(1, 1140, 170, 1390, 1070, "pig_idle.gif", 2, 0);
			CreateObj(1, 200, 140, 1390, 1070, "cow_idle.gif", 2, 0);
			CreateObj(1, 700, -20, 1690, 1070, "WindMill1.gif", 2, 0);	
			CreateObj(1, 330, 100, 1390, 1070, "house_day.png", 2, 0);
			
		}
		
		
		bgPanel[1].add(bgLabel[1]);
			
	}
	
	
	
	
	
}
