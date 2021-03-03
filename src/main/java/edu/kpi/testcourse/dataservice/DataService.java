package edu.kpi.testcourse.dataservice;

import java.util.Map;

/**
 * Data Service manages file storage actions (e.g storing user data).
 */
public interface DataService {
  void addUser(String email, String password);

  String getUserPassword(String email);

  void addUrl(String alias, String url, String user);

  String getUrl(String alias);

  Map<String, String> getUserUrls(String user);
}
