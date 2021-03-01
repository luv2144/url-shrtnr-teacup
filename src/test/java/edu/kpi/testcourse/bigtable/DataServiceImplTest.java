package edu.kpi.testcourse.bigtable;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class DataServiceImplTest {

  @Test
  void checkValueSaving() {
    DataServiceImpl bigTable = new DataServiceImpl();

    bigTable.put("testKey", "testValue");
    String value = bigTable.get("testKey");

    assertThat(value).isEqualTo("testValue");
  }

}
