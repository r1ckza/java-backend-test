package com.backend.hoover.testutils;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public final class JsonFileToStringConverter {

    private JsonFileToStringConverter() {}

    public static String getJson(String jsonFileName) {
        InputStream inputStream = JsonFileToStringConverter.class.getClassLoader().getResourceAsStream(jsonFileName);
        try {
            return IOUtils.toString(inputStream, Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
