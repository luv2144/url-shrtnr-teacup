package edu.kpi.testcourse;

import static org.quicktheories.QuickTheory.qt;
import static org.quicktheories.generators.SourceDSL.strings;

import edu.kpi.testcourse.dataservice.DataService;
import edu.kpi.testcourse.dataservice.User;
import edu.kpi.testcourse.urlservice.UrlService;
import org.junit.jupiter.api.Test;

public class shouldCreateLink {
  /**
   * Має перевірити, чи буде створене скорочене посилання для юзера.
   */
  DataService dataService;
  UrlService urlService;
  @Test
  void shouldCreateLink_propertyBased(){
    qt()
      .forAll(
        strings().basicLatinAlphabet().ofLengthBetween(5, 10),
        strings().basicLatinAlphabet().ofLengthBetween(8, 15),
        strings().basicLatinAlphabet().ofLengthBetween(10, 30)
      ).check((email, password, url) -> {
      email = normalizeEmail(email);
      User user = new User(email, password);

      try {
        dataService.addUser(user);
        urlService.addUrl(url, user.getEmail());
      } catch (Exception e) {
        return false;
      }
      return urlService.getUserAliases(user.getEmail()) != null;
    });
  }

  private String normalizeEmail(String email){
    return email + "@mail.com";
  }
}
