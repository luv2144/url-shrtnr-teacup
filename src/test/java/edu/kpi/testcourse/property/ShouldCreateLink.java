package edu.kpi.testcourse.property;

import static org.quicktheories.QuickTheory.qt;
import static org.quicktheories.generators.SourceDSL.strings;
import edu.kpi.testcourse.dataservice.DataService;
import edu.kpi.testcourse.dataservice.DataServiceImpl;
import edu.kpi.testcourse.dataservice.UrlAlias;
import edu.kpi.testcourse.dataservice.User;
import org.junit.jupiter.api.Test;

public class ShouldCreateLink {

  /**
   * Має перевірити, чи буде створене скорочене посилання для юзера.
   */
  DataService dataService = new DataServiceImpl();
  User testUser = new User("testUsername", "testPassword");

  @Test
  void shouldCreateLink_propertyBased() {
    dataService.addUser(testUser);
    qt()
      .withExamples(10)
      .forAll(
        strings().basicLatinAlphabet().ofLengthBetween(1, 10)
      ).check((url) -> {
      try {
        UrlAlias testUrlAlias = new UrlAlias(url, url, testUser.getEmail());
        dataService.addUrlAlias(testUrlAlias);
      } catch (NullPointerException e) {
        return false;
      }
      return dataService.getUserAliases(testUser.getEmail()) != null;
    });
  }

}
