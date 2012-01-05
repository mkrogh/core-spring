package dk.aau.portal.mkr;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import dk.aau.portal.mkr.qa.internal.JdbcQuestionRepositoryTest;
import dk.aau.portal.mkr.qa.web.QuestionControllerTest;

@RunWith(Suite.class)
@SuiteClasses({
	QuestionControllerTest.class,
	JdbcQuestionRepositoryTest.class
})
public class AllTests {

}
