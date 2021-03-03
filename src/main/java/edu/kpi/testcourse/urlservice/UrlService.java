package edu.kpi.testcourse.urlservice;

/**
 * Url Service manages url actions...
 * TODO: Update this javadoc
 */
public interface UrlService {
  String  getUrl(String alias);

  void addUrl(String alias, String url);
}
