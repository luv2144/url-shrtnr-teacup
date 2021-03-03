package edu.kpi.testcourse.dataservice;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.inject.Singleton;

@Singleton
class DataServiceImpl implements DataService {
  private final Map<String, String> map = new HashMap<>();

  @Override
  public void addUser(String email, String passwordHash) {

  }

  @Override
  public String getUserPassword(String email) {
    return null;
  }

  @Override
  public void addUrl(String alias, String url, String user) {
    map.put(alias, url);
  }

  @Override
  public String getUrl(String alias) {
    var url = map.get(alias);
    return Objects.requireNonNullElse(url, "default_url");
  }

  @Override
  public Map<String, String> getUserUrls(String user) {
    return null;
  }
}
