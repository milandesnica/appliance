package se.midlogic.appliances.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ApplianceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetAllAppliancesSortedByConnectionsAsc() throws Exception {
        // Add test data to the database
        addTestData();

        // Perform GET request
        mockMvc.perform(MockMvcRequestBuilders.get("/api/appliances/sortedByConnections"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].applianceId").value("YS2R4011"))
                .andExpect(jsonPath("$[1].applianceId").value("YS2R4066"))
                .andExpect(jsonPath("$[2].applianceId").value("YS2R4055"));
    }

    @Test
    public void testGetAllAppliancesSortedByConnectionsDesc() throws Exception {
        // Add test data to the database
        addTestData();

        // Perform GET request
        mockMvc.perform(MockMvcRequestBuilders.get("/api/appliances/sortedByConnections?order=desc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].applianceId").value("YS2R4055"))
                .andExpect(jsonPath("$[1].applianceId").value("YS2R4066"))
                .andExpect(jsonPath("$[2].applianceId").value("YS2R4011"));
    }
    private void addTestData() throws Exception {
        // Add test data to the database using the admin endpoint
        List<ApplianceRecord> testData = List.of(
                new ApplianceRecord("YS2R4011", "JKL012"),
                new ApplianceRecord("YS2R4066", "PQR678"),
                new ApplianceRecord("YS2R4055", "STU901")
        );

        mockMvc.perform(MockMvcRequestBuilders.post("/api/admin/appliance/load?testDataConnections=true")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(testData)))
                .andExpect(status().isOk());
    }
}
