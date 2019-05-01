package Connect4;

public class Cell {
	
	private int owner;
	
	public Cell(){
		this.owner = 0;
	}

	public int getOwner() {
		return owner;
	}

	public void setOwner(int owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		if(owner==1)
			return "●";
		else if(owner == 2)
			return "○";
		else
			return "  ";
	}
}