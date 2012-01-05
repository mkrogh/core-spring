package dk.aau.portal.mkr.qa.web;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.ExtendedModelMap;

import dk.aau.portal.mkr.StubQuestionRepository;
import dk.aau.portal.mkr.qa.Question;
import dk.aau.portal.mkr.qa.web.QuestionController;

public class QuestionControllerTest {

	private QuestionController controller;
	
	@Before
	public void setUp() throws Exception {
		controller = new QuestionController(new StubQuestionRepository());
	}

	@Test
	@SuppressWarnings("unchecked")
	public void testHandleQuestionsReq() {
		ExtendedModelMap model = new ExtendedModelMap();
		String viewName = controller.listQuestions(model);
		
		
		List<Question> questions = (List<Question>) model.get("questions");
		
		assertEquals(1, questions.size());
		assertEquals("listQuestions", viewName);
	}

	
	@Test
	public void testHandleShowQuestion() {
		ExtendedModelMap model = new ExtendedModelMap();
		String viewName = controller.showQuestion(0, model);
		
		Question question = (Question) model.get("question");
		
		assertEquals(0, question.getId());
		assertEquals(1, question.getAnswers().size());
		assertEquals("question", viewName);
	}
}
