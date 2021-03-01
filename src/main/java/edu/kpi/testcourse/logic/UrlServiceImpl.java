package edu.kpi.testcourse.logic;

import edu.kpi.testcourse.bigtable.DataService;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class UrlServiceImpl implements UrlService {

  @Inject
  private final DataService table;

  public UrlServiceImpl(DataService table) {
    this.table = table;
  }

  @Override
  public String getUrl(String alias) {
    return table.getUrl(alias);
  }

  @Override
  public void addUrl(String alias, String url) {
    table.addUrl(alias, url, "John Doe");
  }
}
