package dk.aau.portal.mkr.qa;


public class Answer {
	
	private String answer;
	private int id;

	
	public Answer(int id, String answer){
		this.setAnswer(answer);
		this.setId(id);
	}
	
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public String getAnswer(){
		return this.answer;
	}
	
	public void setAnswer(String answer){
		this.answer = answer;
	}

	
	@Override
	public String toString(){
		return this.answer;
	}
}
