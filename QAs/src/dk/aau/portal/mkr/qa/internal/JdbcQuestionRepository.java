package dk.aau.portal.mkr.qa.internal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import dk.aau.portal.mkr.qa.Answer;
import dk.aau.portal.mkr.qa.Question;


public class JdbcQuestionRepository implements QuestionRepository {
	
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcInsert insertQuestion;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.insertQuestion = new SimpleJdbcInsert(dataSource)
			.withTableName("questions")
			.usingGeneratedKeyColumns("id");
	}
	
	
	@Override
	public Question findQuestion(int id) {
		String sql = "select * from questions where id = ?";
		Question question = jdbcTemplate.queryForObject(sql, new QuestionMapper(), id); 
		question.setAnswers(getAnswersForQuestion(id));
		return question;
	}

	@Override
	public List<Question> getAll() {
		String sql = "select * from questions";
		return jdbcTemplate.query(sql, new QuestionMapper());
	}
	

	@Override
	public void update(Question question) {
		String sql = "update questions SET question=? where id=?";
		//TODO: update answers?
		jdbcTemplate.update(sql, question.getQuestion(), question.getId());
	}


	@Override
	public void destroy(Question question) {
		String sql = "delete from questions where id=?";
		jdbcTemplate.update(sql, question.getId());
	}


	@Override
	public int create(Question question) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("question", question.getQuestion());
		
		Number id = insertQuestion.executeAndReturnKey(parameters);
		question.setId(id.intValue());
		
		return id.intValue();
	}
	
	
	
	List<Answer> getAnswersForQuestion(int id){
		String sql = "select * from answers where question_id = ?";
		return jdbcTemplate.query(sql, new AnswerMapper(), id);
	}
		
	private Question mapQuestion(ResultSet rs) throws SQLException{
		String question = rs.getString("question");
		int id = rs.getInt("id");
		return new Question(id, question);
	}
	
	private class QuestionMapper implements RowMapper<Question>{
		
		@Override
		public Question mapRow(ResultSet rs, int arg1) throws SQLException {
			return mapQuestion(rs);
		}
	}

	
	private Answer mapAnswer(ResultSet rs) throws SQLException{
		String question = rs.getString("answer");
		int id = rs.getInt("id");
		return new Answer(id, question);
	}
	
	private class AnswerMapper implements RowMapper<Answer>{
		
		@Override
		public Answer mapRow(ResultSet rs, int arg1) throws SQLException {
			return mapAnswer(rs);
		}
	}


}
