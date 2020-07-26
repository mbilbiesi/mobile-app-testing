package com.hs.mobile.service.response;

import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.http.Headers;
import io.restassured.internal.RestAssuredResponseOptionsImpl;
import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.json.config.JsonPathConfig;
import io.restassured.path.xml.XmlPath;
import io.restassured.path.xml.config.XmlPathConfig;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ResponseDecorated extends RestAssuredResponseOptionsImpl<Response>
    implements Response {

  private final Response core;

  public ResponseDecorated(Response core) {
    this.core = core;
  }

  public ValidatableResponse then() {
    return (ValidatableResponse) this.core.then();
  }

  public String print() {
    return this.core.print();
  }

  public String prettyPrint() {
    return this.core.prettyPrint();
  }

  public Response peek() {
    return (Response) this.core.peek();
  }

  public Response prettyPeek() {
    return (Response) this.core.prettyPeek();
  }

  public <T> T as(Class<T> cls) {
    return this.core.as(cls);
  }

  public <T> T as(Class<T> cls, ObjectMapperType mapperType) {
    return this.core.as(cls, mapperType);
  }

  public <T> T as(Class<T> cls, ObjectMapper mapper) {
    return this.core.as(cls, mapper);
  }

  public JsonPath jsonPath() {
    return this.core.jsonPath();
  }

  public JsonPath jsonPath(JsonPathConfig config) {
    return this.core.jsonPath(config);
  }

  public XmlPath xmlPath() {
    return this.core.xmlPath();
  }

  public XmlPath xmlPath(XmlPathConfig config) {
    return this.core.xmlPath(config);
  }

  public XmlPath xmlPath(XmlPath.CompatibilityMode compatibilityMode) {
    return this.core.xmlPath(compatibilityMode);
  }

  public XmlPath htmlPath() {
    return this.core.htmlPath();
  }

  public <T> T path(String path, String... arguments) {
    return this.core.path(path, arguments);
  }

  public String asString() {
    return this.core.asString();
  }

  public byte[] asByteArray() {
    return this.core.asByteArray();
  }

  public InputStream asInputStream() {
    return this.core.asInputStream();
  }

  public Response andReturn() {
    return (Response) this.core.andReturn();
  }

  public Response thenReturn() {
    return (Response) this.core.thenReturn();
  }

  public ResponseBody body() {
    return this.core.body();
  }

  public ResponseBody getBody() {
    return this.core.getBody();
  }

  public Headers headers() {
    return this.core.headers();
  }

  public Headers getHeaders() {
    return this.core.getHeaders();
  }

  public String header(String name) {
    return this.core.header(name);
  }

  public String getHeader(String name) {
    return this.core.getHeader(name);
  }

  public Map<String, String> cookies() {
    return this.core.cookies();
  }

  public Cookies detailedCookies() {
    return this.core.detailedCookies();
  }

  public Map<String, String> getCookies() {
    return this.core.getCookies();
  }

  public Cookies getDetailedCookies() {
    return this.core.getDetailedCookies();
  }

  public String cookie(String name) {
    return this.core.cookie(name);
  }

  public String getCookie(String name) {
    return this.core.getCookie(name);
  }

  public Cookie detailedCookie(String name) {
    return this.core.detailedCookie(name);
  }

  public Cookie getDetailedCookie(String name) {
    return this.core.getDetailedCookie(name);
  }

  public String contentType() {
    return this.core.contentType();
  }

  public String getContentType() {
    return this.core.getContentType();
  }

  public String statusLine() {
    return this.core.statusLine();
  }

  public String getStatusLine() {
    return this.core.getStatusLine();
  }

  public String sessionId() {
    return this.core.sessionId();
  }

  public String getSessionId() {
    return this.core.getSessionId();
  }

  public int statusCode() {
    return this.core.statusCode();
  }

  public int getStatusCode() {
    return this.core.getStatusCode();
  }

  public long time() {
    return this.core.time();
  }

  public long timeIn(TimeUnit timeUnit) {
    return this.core.timeIn(timeUnit);
  }

  public long getTime() {
    return this.core.getTime();
  }

  public long getTimeIn(TimeUnit timeUnit) {
    return this.core.getTimeIn(timeUnit);
  }
}
