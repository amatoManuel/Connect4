package Connect4;


public class Connect {
	public Cell[][] connect= new Cell[7][6];
	public int owner;
	public int turn = 0;
	
	public Connect(){
		for(int i = 0; i<7; i++)
			for(int j = 0; j<6;j++)
				connect[i][j]=new Cell();
	}

	public String startGame(){
		if (Math.random()<0.5) {
			this.owner = 1;
			return "Inizia il giocatore 1 ";
		}
		this.owner = 2;
		return "Inizia il giocatore 2";
	    }
	
	public String set(int x){
		if(connect[x][5].getOwner()!=0) return "Non puo inserire qui";
		for(int i=0; i<6; i++)
			if(connect[x][i].getOwner()==0){
				connect[x][i].setOwner(this.owner);
				if(checkWin(x,i,this.owner)) {
					this.turn = 43;
					return "Hai vinto";
				}
				break;
			}
		checkTurn(this.owner);
		this.turn++;
		if(this.turn == 42) return "Pareggio";
		return "";

	}

	public void checkTurn(int owner){
		if (this.owner == 1)
			this.owner++;
		else this.owner--;
	}
	
	public boolean checkWin(int x, int y, int owner){
		return checkSlash(x,y,owner) || checkBackSlash(x,y,owner) || checkColumn(x,y,owner) || checkRow(x, y ,owner);

	}

	public boolean checkSlash(int x, int y, int owner){
		int counter = 0;
		for(int i=1;i<4;i++) {
			if (x - i >= 0 && y - i >= 0 && connect[x - i][y - i].getOwner() == owner) counter++;
			else for (int j = 1; j < 4; j++)
				if (x + j < 7 && y + j < 6 && connect[x + j][y + j].getOwner() == owner) counter++;
				else {
					i = 4;
					break;
				}
		}
		return counter >= 3;
	}

	public boolean checkBackSlash(int x, int y, int owner){
		int counter = 0;
		for(int i=1;i<4;i++) {
			if (x-i>=0 && y+i<6 && connect[x-i][y+i].getOwner()== owner) counter++;
			else for (int j = 1; j < 4; j++)
				if (x+j<7 && y-j>=0 && connect[x+j][y-j].getOwner()== owner) counter++;
				else {
					i = 4;
					break;
				}
		}
		return counter >= 3;
	}

	public boolean checkColumn(int x, int y, int owner){
		int counter = 0;
		for(int i=1;i<4;i++) {
			if (y+i<6 && connect[x][y+i].getOwner()== owner) counter++;
			else for (int j = 1; j < 4; j++)
				if (y-j>=0 && connect[x][y-j].getOwner()== owner) counter++;
				else {
					i = 4;
					break;
				}
		}
		return counter >= 3;
	}

	public boolean checkRow(int x, int y, int owner){
		int counter = 0;
		for(int i=1;i<4;i++) {
			if (x+i<7 && connect[x+i][y].getOwner()== owner) counter++;
			else for (int j = 1; j < 4; j++)
				if (x-j>=0 && connect[x-j][y].getOwner()== owner) counter++;
				else {
					i = 4;
					break;
				}
		}
		return counter >= 3;
	}




	public void reset(){
		for(int i=0; i<6; i++)
			for (int j=0;j<7;i++)
				connect[i][j].setOwner(0);
		this.turn=0;
	}

	@Override
	public String toString() {
		String s = "";
		for(int i = 5; i>=0; i--){
			for(int j = 0; j<7;j++)

				if(j<6 && this.connect[j][i] != null) s +=" "+ this.connect[j][i]+" |";
				else if(this.connect[j][i] != null) s +=" "+ this.connect[j][i];
				else if(j<6) s +="   |";

			if(i>0) s += "\n---------------------------\n";
		}
		return s;
	}
}
