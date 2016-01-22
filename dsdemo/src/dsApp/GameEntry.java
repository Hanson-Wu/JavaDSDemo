package dsApp;

public class GameEntry {
	private String name;
	private int score;
	/*construct a game entry with given parameters*/
	public GameEntry(String n, int s){
		name = n;
		score = s;
	}
	//return the name field
	public String getName(){
		return name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "GameEntry [name=" + name + ", score=" + score + "]";
	}
	
}
