package edu.kpi.testcourse.propertyBased;

import static org.quicktheories.QuickTheory.qt;
import static org.quicktheories.generators.SourceDSL.strings;

import edu.kpi.testcourse.dataservice.DataService;
import edu.kpi.testcourse.dataservice.User;
import org.junit.jupiter.api.Test;

public class CreateUserPropertyBased {

  DataService dataService;

  private String transformEmail(String email){
    return email + "@mail.com";
  }

  /**
   * Test to check user with random parameters was created and it is possible to find that user.
   */
  @Test
  void shouldCreateUserPropertyBased(){
    qt()
      .withExamples(10)
      .forAll(
        strings().basicLatinAlphabet().ofLengthBetween(3, 20),
        strings().basicLatinAlphabet().ofLengthBetween(8, 20)
      ).check((email, password) -> {
      email = transformEmail(email);
      User user = new User(email, password);
      dataService.addUser(user);
      return dataService.getUser(user.getEmail()) != null;
    });
  }

}
