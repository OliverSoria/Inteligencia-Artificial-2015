
/*

This file is part of "Inteligencia Artificial 2015".

"Inteligencia Artificial 2015" is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

"Inteligencia Artificial 2015" is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Inteligencia Artificial 2015.  If not, see <http://www.gnu.org/licenses/>.
"Inteligencia Artificial 2015"

*/

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;


public class Metodo {
	
	public static int conv (int x, int y) {
		
		if(x == 1 && y == 1) {
			return 9;
		} else if(x == 1 && y == 2) {
			return 10;
		} else if(x == 1 && y == 3) {
			return 11;
		} else if(x == 1 && y == 4) {
			return 12;
		} else if(x == 1 && y == 5) {
			return 13;
		} else if(x == 2 && y == 1) {
			return 16;
		} else if(x == 2 && y == 2) {
			return 17;
		} else if(x == 2 && y == 3) {
			return 18;
		} else if(x == 2 && y == 4) {
			return 19;
		} else if(x == 2 && y == 5) {
			return 20;
		} else if(x == 3 && y == 1) {
			return 23;
		} else if(x == 3 && y == 2) {
			return 24;
		} else if(x == 3 && y == 3) {
			return 25;
		} else if(x == 3 && y == 4) {
			return 26;
		} else if(x == 3 && y == 5) {
			return 27;
		} else if(x == 4 && y == 1) {
			return 30;
		} else if(x == 4 && y == 2) {
			return 31;
		} else if(x == 4 && y == 3) {
			return 32;
		} else if(x == 4 && y == 4) {
			return 33;
		} else if(x == 4 && y == 5) {
			return 34;
		} else if(x == 5 && y == 1) {
			return 37;
		} else if(x == 5 && y == 2) {
			return 38;
		} else if(x == 5 && y == 3) {
			return 39;
		} else if(x == 5 && y == 4) {
			return 40;
		} else if(x == 5 && y == 5) {
			return 41;
		}
			
		return 0;
	}
	
	public static double distancia(int x1, int y1, int x2, int y2) {
				
		int a = x2 - x1;
		a = a * a;
		int b = y2 - y1;
		b = b * b;
		
		int c = a + b;
		
		double resultado = Math.sqrt(c);
		
		
		return resultado;
	}
	
	public static int moveX (int origen, int destino) {
		if(origen == destino) {
			
		} else {
			if(destino < origen) {
				origen--;
			} else if(origen < destino) {
				origen++;
			}
		}
		
		return origen;
	}
	
	public static int moveY (int origen, int destino) throws InterruptedException {
		if(origen == destino) {
			
		} else {
			if(destino < origen) {
				origen--;
			} else if(origen < destino) {
				origen++;
			}
		}
		
		return origen;
	}
	
	public static void limpiar() {
		for(int i = 9; i <= 13; i++) {
			Inicio.panelArray[i].setBackground(Inicio.gris);
		}
		for(int i = 16; i <= 20; i++) {
			Inicio.panelArray[i].setBackground(Inicio.gris);
		}
		for(int i = 23; i <= 27; i++) {
			Inicio.panelArray[i].setBackground(Inicio.gris);
		}
		for(int i = 30; i <= 34; i++) {
			Inicio.panelArray[i].setBackground(Inicio.gris);
		}
		for(int i = 37; i <= 41; i++) {
			Inicio.panelArray[i].setBackground(Inicio.gris);
		}
	}
	
	public static void ocultar() {
		for(int i = 9; i <= 13; i++) {
			Inicio.panelArray[i].setVisible(false);
		}
		for(int i = 16; i <= 20; i++) {
			Inicio.panelArray[i].setVisible(false);
		}
		for(int i = 23; i <= 27; i++) {
			Inicio.panelArray[i].setVisible(false);
		}
		for(int i = 30; i <= 34; i++) {
			Inicio.panelArray[i].setVisible(false);
		}
		for(int i = 37; i <= 41; i++) {
			Inicio.panelArray[i].setVisible(false);
		}
	}
	
	public static void mostrar() {
		for(int i = 9; i <= 13; i++) {
			Inicio.panelArray[i].setVisible(true);
		}
		for(int i = 16; i <= 20; i++) {
			Inicio.panelArray[i].setVisible(true);
		}
		for(int i = 23; i <= 27; i++) {
			Inicio.panelArray[i].setVisible(true);
		}
		for(int i = 30; i <= 34; i++) {
			Inicio.panelArray[i].setVisible(true);
		}
		for(int i = 37; i <= 41; i++) {
			Inicio.panelArray[i].setVisible(true);
		}
	}
	
	public static void pausa() {
		Timer timer = new Timer(1800, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // Acciones  	
            }
        });
        timer.setRepeats(false);
        timer.start();
	}
	
	

}
