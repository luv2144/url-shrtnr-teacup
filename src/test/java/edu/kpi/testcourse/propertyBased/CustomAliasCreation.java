package edu.kpi.testcourse.propertyBased;

import static org.quicktheories.QuickTheory.qt;
import static org.quicktheories.generators.SourceDSL.strings;
import edu.kpi.testcourse.dataservice.DataService;
import edu.kpi.testcourse.dataservice.DataServiceImpl;
import edu.kpi.testcourse.dataservice.UrlAlias;
import edu.kpi.testcourse.dataservice.User;
import org.junit.jupiter.api.Test;

public class CustomAliasCreation {
  /**
   * Adding custom random alias to the url
   * */

  DataService dataService = new DataServiceImpl();
  User testUser = new User("testUser", "testPass");

  static String AliasString(int n) {
    String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
      + "0123456789"
      + "abcdefghijklmnopqrstuvxyz";
    StringBuilder sb = new StringBuilder(n);

    for (int i = 0; i < n; i++) {
      int index
        = (int)(AlphaNumericString.length()
        * Math.random());
      sb.append(AlphaNumericString
        .charAt(index));
    }

    return sb.toString();
  }

  @Test
  void shouldAddRandomAlias() {
    int aliasStringLength = 15;
    String CreateRandomAlias = CustomAliasCreation.AliasString(aliasStringLength);
    dataService.addUser(testUser);
    qt()
      .withExamples(10)
      .forAll(
      strings().basicLatinAlphabet().ofLengthBetween(1, 10)
      ).check((url) -> {
      try {
        UrlAlias testUrlAlias = new UrlAlias(CreateRandomAlias, url, testUser.getEmail());
        dataService.addUrlAlias(testUrlAlias);
      } catch (NullPointerException e) {
        return false;
      }
      return dataService.getUserAliases(testUser.getEmail()) != null;
    });
  }
}
