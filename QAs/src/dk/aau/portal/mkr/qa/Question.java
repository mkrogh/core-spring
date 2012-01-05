package dk.aau.portal.mkr.qa;

import java.util.List;


public class Question {
	
	
	private int id;
	private String question;
	private List<Answer> answers;

	public Question(int id, String question){
		setQuestion(question);
		setId(id);
	}
	
	public Question(String question){
		setQuestion(question);
	}
	
	public Question(){ };
	
	public String getQuestion(){
		return this.question;
	}
	
	public void setQuestion(String question){
		this.question = question;
	}
	
	public List<Answer> getAnswers(){
		return this.answers;
	}
	
	public void setAnswers(List<Answer> answers){
		this.answers = answers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString(){
		return this.question;
	}

}
