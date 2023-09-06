package org.example.generalizedOperations.constants;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.File;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FrameworkPathConstants {
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String TEST_RESOURCES_DIR = PROJECT_PATH + File.separator + "src/test/resources";
    public static final String ENV_FILE_DIR = TEST_RESOURCES_DIR + File.separator + "config";
    public static final String CONFIG_JSON_PATH =
            TEST_RESOURCES_DIR + File.separator + "config" + File.separator + "config.json";
    public static final String TEST_ASSETS_FILEPATH =
            TEST_RESOURCES_DIR + File.separator + "testAssets";
    public static final String TEST_ASSETS_FILEPATH_CPRO =
            TEST_ASSETS_FILEPATH + File.separator ;
    public static final String LOGIN_MODULE_TEST_DATA =
            TEST_ASSETS_FILEPATH_CPRO + File.separator + "loginModuleTestAssets//loginModuleTestData.json";
    public static final String LOGIN_IDENTIFIERS_PATH =
            TEST_ASSETS_FILEPATH_CPRO + File.separator + "loginModuleTestAssets//loginModuleIdentifiers.json";

}