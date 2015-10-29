
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

public class Coordenada {
	int x;
	int y;
	boolean estado;
	
	Coordenada(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	Coordenada(int x, int y, boolean estado) {
		this.x = x;
		this.y = y;
		this.estado = estado;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
