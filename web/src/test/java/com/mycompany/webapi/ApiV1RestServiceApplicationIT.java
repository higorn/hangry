/*
 * File:   ApiV1RestServiceApplicationIT.java
 *
 * Created on 28/05/18, 22:34
 */
package com.mycompany.webapi;

import com.mycompany.webapi.exception.DefaultExceptionHandler;
import com.mycompany.webapi.model.ApiResponse;
import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;
import org.jboss.resteasy.spi.ResteasyDeployment;
import org.jboss.resteasy.test.TestPortProvider;
import org.junit.*;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author higor
 */
@RunWith(WeldJUnit4Runner.class)
public class ApiV1RestServiceApplicationIT {
  private static final String API_V1_PATH = "/mycompany/api/v1";

  @Inject
  private ApiV1RestServiceApplication application;
  @Inject
  private DefaultExceptionHandler exceptionHandler;
  private static UndertowJaxrsServer server;
  private Client client;

  @BeforeClass
  public static void beforeClass() {
    System.setProperty("org.jboss.resteasy.port", "8082");
    server = new UndertowJaxrsServer().start();
  }

  @Before
  public void setUp() {
    ResteasyDeployment deployment = new ResteasyDeployment();
    deployment.setApplication(application);
//    deployment.setProviders(new ArrayList<>(Arrays.asList(new Object[]{exceptionHandler, interceptor})));

    Map<String, String> contextParams = new HashMap<>();
    contextParams.put("resteasy.scan", "true");

    Map<String, String> initParams = new HashMap<>();
    initParams.put("javax.ws.rs.Application", "com.higor.webapi.ApiV1RestServiceApplication");
    initParams.put("resteasy.servlet.mapping.prefix", "/api/v1");

    server.deploy(deployment, "mycompany", contextParams, initParams);
    client = ClientBuilder.newBuilder().build();
  }

  @After
  public void tearDown() {
    client.close();
  }

  @AfterClass
  public static void afterClass() {
    server.stop();
  }

  @Test
  public void itShouldReturnSomethingList() {
    Response response = client.target(TestPortProvider.generateURL(API_V1_PATH + "/something"))
        .request(MediaType.APPLICATION_JSON)
        .get();
    assertNotNull(response);
    assertEquals(200, response.getStatus());
    ApiResponse<List<LinkedHashMap>> apiResponse = response.readEntity(ApiResponse.class);
    assertNotNull(apiResponse);
    List<LinkedHashMap> somethingList = apiResponse.getData();
    assertNotNull(somethingList);
    assertEquals(3, somethingList.size());
    assertEquals(Integer.valueOf(1), somethingList.get(0).get("id"));
    assertEquals("anything1", somethingList.get(0).get("name"));
  }
}
