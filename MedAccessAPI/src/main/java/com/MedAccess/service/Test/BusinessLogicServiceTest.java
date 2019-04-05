package com.MedAccess.service.Test;

import com.MedAccess.Dao.BusinessLogicDAO;
import com.MedAccess.Dao.PatientDAO;
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
@PrepareForTest({BusinessLogicServiceTest.class, BusinessLogicService.class, BusinessLogicDAO.class})
public class BusinessLogicServiceTest {

    @Spy
    private BusinessLogicDAO mockBusinessLogicDAO;

    @InjectMocks
    private BusinessLogicService businessLogicService;

    @Test
    public void getBusinessLogicTest(){
        List<BusinessLogic> list = new ArrayList<BusinessLogic>();
        BusinessLogic mockBusinessLogic = new BusinessLogic();
        mockBusinessLogic.setEmail_pattern("/@#$*/");
        mockBusinessLogic.setLogic_id("21");
        mockBusinessLogic.setPassword_pattern("/@#$*A-Z/");
        mockBusinessLogic.setPhone_pattern("/0-9");
        mockBusinessLogic.setSuite_pattern("/00-@#$/");
        mockBusinessLogic.setZipcode_pattern("/B-Z*/,2-9/");

        list.add(mockBusinessLogic);
        Mockito.doReturn(list).when(mockBusinessLogicDAO).getBusinessLogic();

        //Method call
        List<BusinessLogic> result = businessLogicService.getBusinessLogic();
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
