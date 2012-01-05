package dk.aau.portal.mkr.qa.internal;

import static org.junit.Assert.*;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import dk.aau.portal.mkr.qa.Question;

public class JdbcQuestionRepositoryTest {

	private JdbcQuestionRepository questionRepository;
	private DataSource dataSource;

	
	@Before
	public void setUp(){
		dataSource = createTestDataSource();
		questionRepository = new JdbcQuestionRepository();
		questionRepository.setDataSource(dataSource);
	}
	
	
	@Test
	public void testGetAllQuestions() {
		List<Question> questions = questionRepository.getAll();
		
		assertEquals(3, questions.size());
	}

	@Test
	public void testFindById(){
		Question question = questionRepository.findQuestion(0);
		assertEquals(0,question.getId());
		assertEquals("When is christmas", question.getQuestion());
		assertEquals(1, question.getAnswers().size());
	}
	
	@Test
	public void testCreateQuestion(){
		Question question = new Question("What is Denmark");
		int id = questionRepository.create(question);
		
		//Should be the 4th question.
		assertEquals(3, id);
		
		Question actual = questionRepository.findQuestion(id);
		assertEquals(question.getQuestion(), actual.getQuestion());
		assertEquals(id, question.getId());
	}
	
	@Test(expected=EmptyResultDataAccessException.class)
	public void testDeleteQuestion(){
		Question question = new Question("What is that funkey sound");
		 int id = questionRepository.create(question);
		
		 //count the number of questions?
		 
		 questionRepository.destroy(question);
		 
		 //Should throw empty result exception
		 questionRepository.findQuestion(id);
	}
	
	@Test
	public void testUpdateQuestion(){
		Question question = new Question("Why has all the lemons gone");
		int id = questionRepository.create(question);
		
		question.setQuestion("Where has all the lemons gone");
		
		questionRepository.update(question);
		
		Question updatedQuestion = questionRepository.findQuestion(id);
		
		assertEquals("Where has all the lemons gone", updatedQuestion.getQuestion());
	}
		
	private DataSource createTestDataSource() {
		return new EmbeddedDatabaseBuilder()
			.setName("qa")
			.addScript("classpath:dk/aau/portal/mkr/qa/testdb/schema.sql")
			.addScript("classpath:dk/aau/portal/mkr/qa/testdb/test-data.sql")
			.build();
	}

}
