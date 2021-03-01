package edu.kpi.testcourse.rest;

import edu.kpi.testcourse.Main;
import edu.kpi.testcourse.logic.UrlService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;

import javax.inject.Inject;

/**
 * REST API controller that provides logic for Micronaut framework.
 */
@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller
public class ApiController {

  @Inject
  private final UrlService urlService;

  record ExampleClass(String first, String second) {}

  public ApiController(UrlService urlService){
    this.urlService = urlService;
  }

  @Get(value = "/hello", produces = MediaType.APPLICATION_JSON)
  public String hello() {
    return Main.getGson().toJson(new ExampleClass("Hello", "world!"));
  }

  @Get(value = "/url/{alias}", produces = MediaType.TEXT_PLAIN, consumes = MediaType.TEXT_PLAIN)
  public String getUrl(String alias) {return urlService.getUrl(alias);}

  @Post(value = "/url/{alias}={url}", consumes = MediaType.TEXT_PLAIN)
  public void addUrl(String alias, String url) {urlService.addUrl(alias, url);}
}
