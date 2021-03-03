package edu.kpi.testcourse.dataservice;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class DataServiceImplTest {

  @Test
  void checkValueSaving() {
    DataServiceImpl bigTable = new DataServiceImpl();

    bigTable.addUrl("testKey", "testValue", "");
    String value = bigTable.getUrl("testKey");

    assertThat(value).isEqualTo("testValue");
  }

}
