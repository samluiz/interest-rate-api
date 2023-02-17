package ibm.samuelluiz.interestrateapi.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import ibm.samuelluiz.interestrateapi.exceptions.services.InvalidQueryException;
import ibm.samuelluiz.interestrateapi.exceptions.services.ResourceNotFoundException;
import ibm.samuelluiz.interestrateapi.models.MonthlyInterestRate;
import ibm.samuelluiz.interestrateapi.services.MonthlyInterestRateService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static ibm.samuelluiz.interestrateapi.common.Constants.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest()
public class MonthlyInterestRateControllerTest {

    @Autowired
    private MockMvc mock;
    @Autowired
    private ObjectMapper objMapper;
    @MockBean
    private MonthlyInterestRateService service;

    @Test
    public void createEntityReturnsCreated() throws Exception {
        when(service.create(any(MonthlyInterestRate.class))).thenReturn(ENTITY);

        mock.perform(post("/taxaJurosMensal")
                        .content(objMapper.writeValueAsString(ENTITY))
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isCreated())
                        .andExpect(jsonPath("$.Modalidade").value(ENTITY.get_modality()))
                        .andExpect(jsonPath("$.InstituicaoFinanceira").value(ENTITY.get_financialInstitution()))
                        .andExpect(jsonPath("$.TaxaJurosAoAno").value(ENTITY.get_interestRateByYear()))
                        .andExpect(jsonPath("$.TaxaJurosAoMes").value(ENTITY.get_interestRateByMonth()))
                        .andExpect(jsonPath("$.Posicao").value(ENTITY.get_position()))
                        .andExpect(jsonPath("$.anoMes").value(ENTITY.get_yearMonth()))
                        .andExpect(jsonPath("$.cnpj8").value(ENTITY.get_eightDigitsCnpj()))
                        .andExpect(jsonPath("$.Mes").value(ENTITY.get_month()));
    }

    @Test
    public void createInvalidEntityReturnsUnprocessableEntity() throws Exception {

        mock.perform(post("/taxaJurosMensal")
                        .content(objMapper.writeValueAsString(EMPTY_ENTITY))
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isUnprocessableEntity());
        mock.perform(post("/taxaJurosMensal")
                        .content(objMapper.writeValueAsString(ENTITY_NULL_VALUES))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnprocessableEntity());
        mock.perform(post("/taxaJurosMensal")
                        .content(objMapper.writeValueAsString(ENTITY_NULL_STRINGS))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnprocessableEntity());
        mock.perform(post("/taxaJurosMensal")
                        .content(objMapper.writeValueAsString(ENTITY_BLANK_STRINGS))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnprocessableEntity());
        mock.perform(post("/taxaJurosMensal")
                        .content(objMapper.writeValueAsString(ENTITY_INVALID_MONTH))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnprocessableEntity());
        mock.perform(post("/taxaJurosMensal")
                        .content(objMapper.writeValueAsString(ENTITY_INVALID_YEAR_MONTH))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnprocessableEntity());
        mock.perform(post("/taxaJurosMensal")
                        .content(objMapper.writeValueAsString(ENTITY_INVALID_CNPJ))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void updateEntityReturnsUpdated() throws Exception {
        when(service.update(any(MonthlyInterestRate.class), any(String.class)))
                .thenReturn(ENTITY);

        mock.perform(put("/taxaJurosMensal/" + RANDOM_UUID)
                        .content(objMapper.writeValueAsString(ENTITY))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.Modalidade").value(ENTITY.get_modality()))
                .andExpect(jsonPath("$.InstituicaoFinanceira").value(ENTITY.get_financialInstitution()))
                .andExpect(jsonPath("$.TaxaJurosAoAno").value(ENTITY.get_interestRateByYear()))
                .andExpect(jsonPath("$.TaxaJurosAoMes").value(ENTITY.get_interestRateByMonth()))
                .andExpect(jsonPath("$.Posicao").value(ENTITY.get_position()))
                .andExpect(jsonPath("$.anoMes").value(ENTITY.get_yearMonth()))
                .andExpect(jsonPath("$.cnpj8").value(ENTITY.get_eightDigitsCnpj()))
                .andExpect(jsonPath("$.Mes").value(ENTITY.get_month()));
    }

    @Test
    public void updateNonExistentEntityReturnsNotFound() throws Exception {
        when(service.update(any(MonthlyInterestRate.class), any(String.class)))
                .thenThrow(ResourceNotFoundException.class);

        mock.perform(put("/taxaJurosMensal/" + RANDOM_UUID)
                        .content(objMapper.writeValueAsString(ENTITY))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void updateEntityInvalidUUIDReturnsBadRequest() throws Exception {
        when(service.update(any(MonthlyInterestRate.class), any(String.class)))
                .thenThrow(InvalidQueryException.class);

        mock.perform(put("/taxaJurosMensal/invalid" + RANDOM_UUID)
                        .content(objMapper.writeValueAsString(ENTITY))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void findAllReturnsOk() throws Exception {
        Pageable pageable = PageRequest.of(0,3);
        Page<MonthlyInterestRate> result = new PageImpl<>(REAL_LIST, pageable, REAL_LIST.size());
        when(service.findAll(any(Pageable.class))).thenReturn(result);

        mock.perform(get("/taxaJurosMensal"))
                .andExpect(status().isOk());
    }

    @Test
    public void findByUUIDReturnsOk() throws Exception {
        when(service.findByUUID(any(String.class))).thenReturn(ENTITY);

        mock.perform(get("/taxaJurosMensal/" + RANDOM_UUID))
                .andExpect(status().isOk());
    }

    @Test
    public void findByUUIDReturnsNotFound() throws Exception {
        when(service.findByUUID(any(String.class))).thenThrow(ResourceNotFoundException.class);

        mock.perform(get("/taxaJurosMensal/" + RANDOM_UUID))
                .andExpect(status().isNotFound());
    }

    @Test
    public void findByUUIDReturnsBadRequest() throws Exception {
        when(service.findByUUID(any(String.class))).thenThrow(InvalidQueryException.class);

        mock.perform(get("/taxaJurosMensal/invalid" + RANDOM_UUID))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void deleteByUUIDReturnsNoContent() throws Exception {
        doNothing().when(service).delete(any(String.class));

        service.delete(RANDOM_UUID);

        verify(service, times(1)).delete(RANDOM_UUID);
    }

    @Test
    public void deleteByNonexistentUUIDReturnsNotFound() throws Exception {
        doThrow(ResourceNotFoundException.class).when(service).delete(RANDOM_UUID);

        mock.perform(delete("/taxaJurosMensal/" + RANDOM_UUID))
                .andExpect(status().isNotFound());
    }

    @Test
    public void deleteByInvalidUUIDReturnsBadRequest() throws Exception {
        doThrow(InvalidQueryException.class).when(service).delete(any(String.class));

        mock.perform(delete("/taxaJurosMensal/" + RANDOM_UUID))
                .andExpect(status().isBadRequest());
    }


}
