package dk.aau.portal.mkr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dk.aau.portal.mkr.qa.Answer;
import dk.aau.portal.mkr.qa.Question;
import dk.aau.portal.mkr.qa.internal.QuestionRepository;

public class StubQuestionRepository implements QuestionRepository {

	private HashMap<Integer, Question> questionsById = new HashMap<Integer, Question>();
	private int next_id = 0;
	
	public StubQuestionRepository(){
		Question question = new Question(getNextId(), "Is the moon made of cheese");
		List<Answer> answers = new ArrayList<Answer>();
		answers.add(new Answer(0, "No"));
		question.setAnswers(answers);
		
		questionsById.put(question.getId(), question);
	}
	
	@Override
	public Question findQuestion(int id) {
		return questionsById.get(id);
	}

	@Override
	public List<Question> getAll() {
		return new ArrayList<Question>(questionsById.values());
	}

	@Override
	public void update(Question question) {
		if(questionsById.containsKey(question.getId())){
			questionsById.put(question.getId(), question);
		}
	}

	@Override
	public void destroy(Question question) {
		if(questionsById.containsKey(question.getId())){
			questionsById.remove(question.getId());
		}
	}

	@Override
	public int create(Question question) {
		int id = getNextId();
		question.setId(id);
		questionsById.put(id, question);
		return id;
	}
	
	private int getNextId(){
		return next_id++;
	}

}
