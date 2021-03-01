package edu.kpi.testcourse.bigtable;

import java.util.Map;

public interface DataService {
  void addUser(String email, String password);

  String getUserPassword(String email);

  void addUrl(String alias, String url, String user);

  String getUrl(String alias);

  Map<String, String> getUserUrls(String user);
}
