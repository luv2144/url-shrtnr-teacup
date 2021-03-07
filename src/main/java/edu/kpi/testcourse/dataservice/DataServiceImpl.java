package edu.kpi.testcourse.dataservice;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Singleton;

@Singleton
class DataServiceImpl implements DataService {
  private final List<UrlAlias> urlAliases = new ArrayList<>();

  @Override
  public void addUser(String email, String passwordHash) {

  }

  @Override
  public String getUserPassword(String email) {
    return null;
  }

  @Override
  public void addUrlAlias(UrlAlias urlAlias) {
    urlAliases.add(urlAlias);
  }

  @Override
  public UrlAlias getUrlAlias(String alias) {
    for (var a : urlAliases) {
      if (a.alias().equals(alias)) {
        return a;
      }
    }

    return null;
  }

  @Override
  public List<UrlAlias> getUserAliases(String user) {
    return null;
  }
}
