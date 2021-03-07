package edu.kpi.testcourse.dataservice;


import java.util.List;

/**
 * Data Service manages file storage actions (e.g storing user data).
 */
public interface DataService {
  void addUser(String email, String password);

  String getUserPassword(String email);

  void addUrlAlias(UrlAlias urlAlias);

  UrlAlias getUrlAlias(String alias);

  List<UrlAlias> getUserAliases(String user);
}
