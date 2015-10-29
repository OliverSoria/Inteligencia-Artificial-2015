
/*

Inteligencia Artificial 2015

Copyright 2015 Oliver Soria Pelaez

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.

*/

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ColorModel;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Inicio extends JFrame implements ActionListener {
	static JPanel[] panelArray = new JPanel[50];
	static Color gris = new Color(238, 238, 238);
	static Color crema = new Color(255, 249, 218);
	Coordenada a;
	Coordenada b1;
	Coordenada b2;
	JFrame frame;
	JPanel panel;
	JTextArea text;
	JScrollPane sp;
	JButton nuevo;
	JButton play;
	
	boolean dist_A = false;
	boolean dist_B = false;
	
	int aX;
	int aY;
	int b1x;
	int b1y;
	int b2x;
	int b2y;
	
	int flag1 = 0;
		
	Inicio() {
		myVentana();
	}
		
	public void myVentana() {
		int j = 8;
		
		aX = (int)(Math.random() * 5) + 1;
		aY = (int)(Math.random() * 5) + 1;
		b1x = (int)(Math.random() * 5) + 1;
		b1y = (int)(Math.random() * 5) + 1;
		b2x = (int)(Math.random() * 5) + 1;
		b2y = (int)(Math.random() * 5) + 1;
		
		frame = new JFrame("Inteligencia Artificial 2015");
		panel = new JPanel();
		text = new JTextArea();
		text.setBackground(crema);
		sp = new JScrollPane(text);
		// Medidas de los marcos del rededor
		panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		// Numero de filas, columnas, interlineado horizontal, interlineado vertical
		panel.setLayout(new GridLayout(7, 7, 5, 5));
		text.setLayout(null);
		text.setEditable(false);
		panel.setSize(400, 400);
		frame.setResizable(false);
		// Medidas de la ventana
		frame.setSize(750, 425);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel.setBackground(Color.WHITE);
		
		final ImageIcon pImg = new ImageIcon(getClass().getResource("/play.png"));
		final ImageIcon rImg = new ImageIcon(getClass().getResource("/reload.png"));
		
		JPanel info = new JPanel();
		JPanel rojo = new JPanel();
		JPanel azul = new JPanel();
		info.setLayout(null);
		
		JLabel lbla = new JLabel("Aspiradora");
		JLabel lblr = new JLabel("Basura");
		
		info.setBackground(Color.WHITE);
		azul.setBackground(Color.BLUE);
		rojo.setBackground(Color.RED);
				
		nuevo = new JButton(rImg);
		nuevo.setActionCommand("Nuevo");
		nuevo.addActionListener(this);
		play = new JButton(pImg);
		play.setActionCommand("Play");
		play.addActionListener(this);
						
		// Inicializacion y coloreo de los paneles
		for(int i = 1; i <= 49; i++) {
			panelArray[i] = new JPanel();
			
			if(i >= 1 && i <= 7) {
				panelArray[i].setBackground(Color.BLACK);
			}
			
			if(i >= 43 && i <= 49) {
				panelArray[i].setBackground(Color.BLACK);
			}
			
			if(i % 7 == 0) {
				panelArray[i].setBackground(Color.BLACK);
				j = i + 1;
			}
			
			if(i % j == 0) {
				panelArray[i].setBackground(Color.BLACK);
			}
			
			panel.add(panelArray[i]);
		}
		
		a = new Coordenada(aX, aY, true);
		b1 = new Coordenada(b1x, b1y, true);
		b2 = new Coordenada(b2x, b2y, true);
				
		panelArray[Metodo.conv(b1.x, b1.y)].setBackground(Color.RED);
		panelArray[Metodo.conv(b2.x, b2.y)].setBackground(Color.RED);
		panelArray[Metodo.conv(a.x, a.y)].setBackground(Color.BLUE);
		
		System.out.println("A= " + a.x + "," + a.y);
		System.out.println("B1= " + b1.x + "," + b1.y);
		System.out.println("B2= " + b2.x + "," + b2.y);
		
		double distA = Metodo.distancia(a.x, a.y, b1.x, b1.y);
		double distB = Metodo.distancia(a.x, a.y, b2.x, b2.y);
		double distC = Metodo.distancia(b1.x, b1.y, b2.x, b2.y);
		double distD = distA + distC;
		String dA = new DecimalFormat("#.##").format(distA);
		String dB = new DecimalFormat("#.##").format(distB);
		String dC = new DecimalFormat("#.##").format(distC);
		String dD = new DecimalFormat("#.##").format(distD);
		
		text.append("* * * * * * * * * * * D I S T A N C I A S * * * * * * * * * *\n");
		text.append("Aspiradora - Basura A <<" + dA + ">>\n");
		text.append("Aspiradora - Basura B <<" + dB + ">>\n");
		text.append("Basura A - Basura B <<" + dC + ">>\n");
		text.append("Camino más corto <<" + dD + ">>\n\n");
		text.append("* * * * * * P O S I C I O N E S  I N I C I A L E S * * * * *\n");
		text.append("Aspiradora (" + a.y + "," + a.x + ")\n");
		text.append("Basura A " + "(" + b1.y + "," + b1.x + ")\n");
		text.append("Basura B " + "(" + b2.y + "," + b2.x + ")\n\n");
		text.append("* * * * * * * * * * M O V I M I E N T O S * * * * * * * * *\n");
				
		nuevo.setBounds(470, 5, 60, 60);
		play.setBounds(405, 5, 60, 60);
		
		panel.setBounds(0, 0, 400, 400);
		
		info.setBounds(535, 5, 210, 60);
		azul.setBounds(10, 20, 20, 20);
		rojo.setBounds(125, 20, 20, 20);
		
		lbla.setBounds(35, 20, 130, 20);
		lblr.setBounds(150, 20, 130, 20);
		
		sp.setBounds(405, 70, 340, 325);
		
		info.add(azul);
		info.add(rojo);
		info.add(lbla);
		info.add(lblr);
		
		frame.add(panel);
		frame.add(nuevo);
		frame.add(play);
		frame.add(info);
		frame.add(sp);
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Nuevo")) {
			flag1 = 0;
			b1.estado = true;
			b2.estado = true;
			Metodo.ocultar();
			Metodo.limpiar();
			
			a.x = (int)(Math.random() * 5) + 1;
			a.y = (int)(Math.random() * 5) + 1;
			b1.x = (int)(Math.random() * 5) + 1;
			b1.y = (int)(Math.random() * 5) + 1;
			b2.x = (int)(Math.random() * 5) + 1;
			b2.y = (int)(Math.random() * 5) + 1;
			panelArray[Metodo.conv(b1.x, b1.y)].setBackground(Color.RED);
			panelArray[Metodo.conv(b2.x, b2.y)].setBackground(Color.RED);
			panelArray[Metodo.conv(a.x, a.y)].setBackground(Color.BLUE);		
			
			/*System.out.println("Nuevo");
			System.out.println("A= " + a.x + "," + a.y);
			System.out.println("B1= " + b1.x + "," + b1.y);
			System.out.println("B2= " + b2.x + "," + b2.y);	*/
			Metodo.mostrar();
			text.setText(null);
			double distA = Metodo.distancia(a.x, a.y, b1.x, b1.y);
			double distB = Metodo.distancia(a.x, a.y, b2.x, b2.y);
			double distC = Metodo.distancia(b1.x, b1.y, b2.x, b2.y);
			double distD = distA + distC;
			String dA = new DecimalFormat("#.##").format(distA);
			String dB = new DecimalFormat("#.##").format(distB);
			String dC = new DecimalFormat("#.##").format(distC);
			String dD = new DecimalFormat("#.##").format(distD);
			
			
			text.append("* * * * * * * * * * * D I S T A N C I A S * * * * * * * * * *\n");
			text.append("Aspiradora - Basura A <<" + dA + ">>\n");
			text.append("Aspiradora - Basura B <<" + dB + ">>\n");
			text.append("Basura A - Basura B <<" + dC + ">>\n");
			text.append("Camino más corto <<" + dD + ">>\n\n");
			text.append("* * * * * * P O S I C I O N E S  I N I C I A L E S * * * * *\n");
			text.append("Aspiradora (" + a.y + "," + a.x + ")\n");
			text.append("Basura A " + "(" + b1.y + "," + b1.x + ")\n");
			text.append("Basura B " + "(" + b2.y + "," + b2.x + ")\n\n");
			text.append("* * * * * * * * * * M O V I M I E N T O S * * * * * * * * *\n");
		
		//*********************************************************************************************************************	
		//*********************************************************************************************************************
		//*********************************************************************************************************************
		} else if(e.getActionCommand().equals("Play")) {
			flag1++;
			
			if(flag1 == 1) {
				//System.out.println("****BANDERA 1 CAMBIADA***");
				double distA = Metodo.distancia(a.x, a.y, b1.x, b1.y);
				double distB = Metodo.distancia(a.x, a.y, b2.x, b2.y);
				double distC = Metodo.distancia(b1.x, b1.y, b2.x, b2.y);
				double distD = distA + distC;
				
				if(distA > distB) {
					dist_B = false;
					dist_A = true;
					System.out.println("Atacar distancia A");
				} else if(distA < distB) {
					dist_A = false;
					dist_B = true;
					System.out.println("Atacar distancia B");
				} else {
					dist_B = false;
					dist_A = true;
					System.out.println("Atacar distancia B");
				}
				
			} else {
				if(b1.estado == false && b2.estado == true) {
					dist_B = false;
					dist_A = true;
				} else if(b1.estado == true && b2.estado == false) {
					dist_A = false;
					dist_B = true;
				}
			}
			
			if(dist_B) {
				if(flag1 % 2 != 0) {
					if(a.x != b1.x) {
						a.x = Metodo.moveX(a.x, b1.x);
						Metodo.ocultar();
						Metodo.limpiar();
						
						if(b1.estado) {
							panelArray[Metodo.conv(b1.x, b1.y)].setBackground(Color.RED);
						} else {
							panelArray[Metodo.conv(b1.x, b1.y)].setBackground(gris);
						}
						if(b2.estado) {
							panelArray[Metodo.conv(b2.x, b2.y)].setBackground(Color.RED);
						} else {
							panelArray[Metodo.conv(b2.x, b2.y)].setBackground(gris);
						}
						panelArray[Metodo.conv(a.x, a.y)].setBackground(Color.BLUE);
						Metodo.mostrar();
						text.append("Aspiradora movida a (" + a.y + "," + a.x + ")\n");
						
						
					} else {
						if(a.y != b1.y) {
							a.y = Metodo.moveX(a.y, b1.y);
							Metodo.ocultar();
							Metodo.limpiar();
							
							
							if(b1.estado) {
								panelArray[Metodo.conv(b1.x, b1.y)].setBackground(Color.RED);
							} else {
								panelArray[Metodo.conv(b1.x, b1.y)].setBackground(gris);
							}
							if(b2.estado) {
								panelArray[Metodo.conv(b2.x, b2.y)].setBackground(Color.RED);
							} else {
								panelArray[Metodo.conv(b2.x, b2.y)].setBackground(gris);
							}
							panelArray[Metodo.conv(a.x, a.y)].setBackground(Color.BLUE);
							Metodo.mostrar();
							
							text.append("Aspiradora movida a (" + a.y + "," + a.x + ")\n");
						}
					}
				} else {
					if(a.y != b1.y) {
						a.y = Metodo.moveX(a.y, b1.y);
						Metodo.ocultar();
						Metodo.limpiar();
						
						
						if(b1.estado) {
							panelArray[Metodo.conv(b1.x, b1.y)].setBackground(Color.RED);
						} else {
							panelArray[Metodo.conv(b1.x, b1.y)].setBackground(gris);
						}
						if(b2.estado) {
							panelArray[Metodo.conv(b2.x, b2.y)].setBackground(Color.RED);
						} else {
							panelArray[Metodo.conv(b2.x, b2.y)].setBackground(gris);
						}
						panelArray[Metodo.conv(a.x, a.y)].setBackground(Color.BLUE);
						Metodo.mostrar();
						
						text.append("Aspiradora movida a (" + a.y + "," + a.x + ")\n");
						
					} else {
						if(a.x != b1.x) {
							a.x = Metodo.moveX(a.x, b1.x);
							Metodo.ocultar();
							Metodo.limpiar();
							
							
							if(b1.estado) {
								panelArray[Metodo.conv(b1.x, b1.y)].setBackground(Color.RED);
							} else {
								panelArray[Metodo.conv(b1.x, b1.y)].setBackground(gris);
							}
							if(b2.estado) {
								panelArray[Metodo.conv(b2.x, b2.y)].setBackground(Color.RED);
							} else {
								panelArray[Metodo.conv(b2.x, b2.y)].setBackground(gris);
							}
							panelArray[Metodo.conv(a.x, a.y)].setBackground(Color.BLUE);
							Metodo.mostrar();
							
							text.append("Aspiradora movida a (" + a.y + "," + a.x + ")\n");
						}
					}
				}
			} else if(dist_A) {
				if(flag1 % 2 != 0) {
					if(a.x != b2.x) {
						a.x = Metodo.moveX(a.x, b2.x);
						Metodo.ocultar();
						Metodo.limpiar();
						
						
						if(b1.estado) {
							panelArray[Metodo.conv(b1.x, b1.y)].setBackground(Color.RED);
						} else {
							panelArray[Metodo.conv(b1.x, b1.y)].setBackground(gris);
						}
						if(b2.estado) {
							panelArray[Metodo.conv(b2.x, b2.y)].setBackground(Color.RED);
						} else {
							panelArray[Metodo.conv(b2.x, b2.y)].setBackground(gris);
						}
						panelArray[Metodo.conv(a.x, a.y)].setBackground(Color.BLUE);
						Metodo.mostrar();
						
						text.append("Aspiradora movida a (" + a.y + "," + a.x + ")\n");
					} else {
						if(a.y != b2.y) {
							a.y = Metodo.moveX(a.y, b2.y);
							Metodo.ocultar();
							Metodo.limpiar();
							
							
							if(b1.estado) {
								panelArray[Metodo.conv(b1.x, b1.y)].setBackground(Color.RED);
							} else {
								panelArray[Metodo.conv(b1.x, b1.y)].setBackground(gris);
							}
							if(b2.estado) {
								panelArray[Metodo.conv(b2.x, b2.y)].setBackground(Color.RED);
							} else {
								panelArray[Metodo.conv(b2.x, b2.y)].setBackground(gris);
							}
							panelArray[Metodo.conv(a.x, a.y)].setBackground(Color.BLUE);
							Metodo.mostrar();
							
							text.append("Aspiradora movida a (" + a.y + "," + a.x + ")\n");
						}
					}
				} else {
					if(a.y != b2.y) {
						a.y = Metodo.moveX(a.y, b2.y);
						Metodo.ocultar();
						Metodo.limpiar();
						
						
						if(b1.estado) {
							panelArray[Metodo.conv(b1.x, b1.y)].setBackground(Color.RED);
						} else {
							panelArray[Metodo.conv(b1.x, b1.y)].setBackground(gris);
						}
						if(b2.estado) {
							panelArray[Metodo.conv(b2.x, b2.y)].setBackground(Color.RED);
						} else {
							panelArray[Metodo.conv(b2.x, b2.y)].setBackground(gris);
						}
						panelArray[Metodo.conv(a.x, a.y)].setBackground(Color.BLUE);
						Metodo.mostrar();
						
						text.append("Aspiradora movida a (" + a.y + "," + a.x + ")\n");
						
					} else {
						if(a.x != b2.x) {
							a.x = Metodo.moveX(a.x, b2.x);
							Metodo.ocultar();
							Metodo.limpiar();
							
							
							if(b1.estado) {
								panelArray[Metodo.conv(b1.x, b1.y)].setBackground(Color.RED);
							} else {
								panelArray[Metodo.conv(b1.x, b1.y)].setBackground(gris);
							}
							if(b2.estado) {
								panelArray[Metodo.conv(b2.x, b2.y)].setBackground(Color.RED);
							} else {
								panelArray[Metodo.conv(b2.x, b2.y)].setBackground(gris);
							}
							panelArray[Metodo.conv(a.x, a.y)].setBackground(Color.BLUE);
							Metodo.mostrar();
							
							text.append("Aspiradora movida a (" + a.y + "," + a.x + ")\n");
						}
					}
				}
			}
			
			if(!b1.estado && !b2.estado) {
				// No hagas nada
			} else {
				if(a.x == b1.x && a.y == b1.y) {
					b1.estado = false;
					text.append("Basura *A* aspirada con exito!\n");
				}
				
				if(a.x == b2.x && a.y == b2.y) {
					b2.estado = false;
					text.append("Basura *B* aspirada con exito!\n");
				}
			}
		}
	}
		
	public static void main (String args[]) {
		/*try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Inicio();
			}
		
		});
		
	}
	
	

}
