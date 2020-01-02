package com.globant.Firmament.weather.controller;

import com.globant.Firmament.weather.service.WeatherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(WeatherController.class)
public class WeatherControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    WeatherService weatherService;

    @Test
    public void givenCorrectData_whenGet_thenReturnRainProbability() throws Exception {
        given(weatherService.getRainProbability(anyString(),anyString())).willReturn("5%");

        MockHttpServletRequestBuilder mockHttpServletRequestBuilder= MockMvcRequestBuilders.get("/rain");
        mockHttpServletRequestBuilder.param("city","Tokyo");
        mockHttpServletRequestBuilder.param("country","jp");

        MvcResult result= mockMvc.perform(mockHttpServletRequestBuilder)
                                 .andExpect(status().isOk())
                                 .andDo(print())
                                 .andReturn();

        String content= result.getResponse().getContentAsString();

        assertEquals(content,"5%");

    }

    @Test
    public void givenCorrectData_whenGet_thenReturnForecast() throws Exception {
        given(weatherService.getForecast(anyString(),anyString())).willReturn(null);

        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.get("/forecast");
        mockHttpServletRequestBuilder.param("city","Berlin");
        mockHttpServletRequestBuilder.param("country","Germany");

        MvcResult result= mockMvc.perform(mockHttpServletRequestBuilder)
                                 .andExpect(status().isOk())
                                 .andDo(print())
                                 .andReturn();
        String content = result.getResponse().getContentAsString();

        assertEquals(content,"");
    }
}
