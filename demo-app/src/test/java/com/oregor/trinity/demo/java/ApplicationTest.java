package com.oregor.trinity.demo.java;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/** @author Trinity Scaffolder */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles({"ci"})
public class ApplicationTest {

  @Test
  public void contextLoads() {}
}
