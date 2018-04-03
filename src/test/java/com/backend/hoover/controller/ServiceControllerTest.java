package com.backend.hoover.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import com.backend.hoover.model.Output;
import com.backend.hoover.testutils.JsonFileToStringConverter;
import com.google.gson.Gson;
import com.backend.hoover.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class ServiceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private static final Gson GSON = new Gson();
    private static final String INPUT = "requests/input.json";
    private static final String INPUT_3_4_START_2_3 = "requests/input_size_3_4_start_2_3.json";
    private static final String SERVICE_CONTROLLER_ENDPOINT = "/hoover";

    @Test
    public void givenInputRequestExpectCorrectOutput() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(
                post(SERVICE_CONTROLLER_ENDPOINT).contentType(MediaType.APPLICATION_JSON)
                        .content(getRequestJson(INPUT))).andReturn().getResponse();
        Output result = GSON.fromJson(response.getContentAsString(), Output.class);

        assertThat(result.getCoords()).containsExactly(1,3);
        assertThat(result.getPatches()).isEqualTo(1);
    }

    @Test
    public void givenInputRequestExpectOutputWithOnePatchCountAtCoordinateOneXTwoY() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(
                post(SERVICE_CONTROLLER_ENDPOINT).contentType(MediaType.APPLICATION_JSON)
                        .content(getRequestJson(INPUT_3_4_START_2_3))).andReturn().getResponse();
        Output result = GSON.fromJson(response.getContentAsString(), Output.class);

        assertThat(result.getCoords()).containsExactly(1,2);
        assertThat(result.getPatches()).isEqualTo(1);
    }

    private String getRequestJson(String jsonFile) {
        return JsonFileToStringConverter.getJson(jsonFile);
    }

}
