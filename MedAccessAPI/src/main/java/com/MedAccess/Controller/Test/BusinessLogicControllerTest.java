package com.MedAccess.Controller.Test;

import static org.junit.Assert.*;

import com.MedAccess.Controller.BusinessLogicController;
import com.MedAccess.Controller.PatientController;
import com.MedAccess.Models.BusinessLogic;
import com.MedAccess.service.BusinessLogicService;
import com.MedAccess.service.PatientService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
@PrepareForTest({BusinessLogicControllerTest.class,BusinessLogicController.class,BusinessLogicService.class})
public class BusinessLogicControllerTest {

    @Spy
    private BusinessLogicService mockBusinessLogicService;

    @InjectMocks
    private BusinessLogicController businessLogicController;

    @Test
    public void testGetBusinessLogic() {
        List<BusinessLogic> list = new ArrayList<BusinessLogic>();
        BusinessLogic mockBusinessLogic = new BusinessLogic();
        mockBusinessLogic.setEmail_pattern("/@#$*/");
        mockBusinessLogic.setLogic_id("21");
        mockBusinessLogic.setPassword_pattern("/@#$*A-Z/");
        mockBusinessLogic.setPhone_pattern("/0-9");
        mockBusinessLogic.setSuite_pattern("/00-@#$/");
        mockBusinessLogic.setZipcode_pattern("/B-Z*/,2-9/");

        list.add(mockBusinessLogic);
        Mockito.doReturn(list).when(mockBusinessLogicService).getBusinessLogic();

        //Method call
        ResponseEntity<List<BusinessLogic>> response = businessLogicController.getBusinessLogic();
        List<BusinessLogic> result = response.getBody();
        BusinessLogic result1 = result.get(0);

        assertNotNull(result1);
        assertNotNull(result1.getEmail_pattern());
        assertNotNull(result1.getLogic_id());
        assertNotNull(result1.getPassword_pattern());
        assertNotNull(result1.getPhone_pattern());
        assertNotNull(result1.getSuite_pattern());
        assertNotNull(result1.getZipcode_pattern());

        assertEquals(mockBusinessLogic.getZipcode_pattern(),result1.getZipcode_pattern());
        assertEquals(mockBusinessLogic.getEmail_pattern(),result1.getEmail_pattern());
        assertEquals(mockBusinessLogic.getLogic_id(),result1.getLogic_id());
        assertEquals(mockBusinessLogic.getPassword_pattern(),result1.getPassword_pattern());
        assertEquals(mockBusinessLogic.getPhone_pattern(),result1.getPhone_pattern());
        assertEquals(mockBusinessLogic.getSuite_pattern(),result1.getSuite_pattern());
    }

}
