package org.example.generalizedOperations.configloader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.example.generalizedOperations.constants.FrameworkPathConstants;
import org.example.generalizedOperations.enums.ConfigJson;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class JsonUtils {

  private static Map < String, String > map;

  public static String getValue(String key, String filePath) {
    try {
      return JsonPath.read(new File(filePath), key);
    } catch (IOException e) {
      System.out.println("Can't Read File");
    }
    return null;
  }

  static void readJson() {
    try {
      map = new ObjectMapper().readValue(new File(FrameworkPathConstants.CONFIG_JSON_PATH),
              new TypeReference < HashMap < String, String >> () {});
    } catch (IOException e) {
      System.out.println("Exception Occurred while reading json");
    }
  }

  public static String getConfig(ConfigJson key) {
    readJson();
    if (Objects.isNull(map.get(key.name().toLowerCase()))) {
      System.out.println("Property name - " + key + " is not found. Please check the config.json");
    }
    return map.get(key.name().toLowerCase());
  }
}