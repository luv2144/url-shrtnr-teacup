package edu.kpi.testcourse.logic;

public interface UrlService {
  String  getUrl(String alias);

  void addUrl(String alias, String url);
}
