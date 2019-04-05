package com.MedAccess.Models;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.MedAccess.Models.Patient;

public class PatientRowMapper {


    public class ArticleRowMapper implements RowMapper<Patient> {
        @Override
        public Patient mapRow(ResultSet row, int rowNum) throws SQLException {
            Patient patient = new Patient();

            patient.setPatient_firstname(row.getString("patient_firstname"));
            patient.setPatient_lastname(row.getString("patient_lastname"));
            patient.setPatient_password(row.getString("patient_password"));
            patient.setPatient_email(row.getString("patient_email"));
            patient.setPatient_phone(row.getString("patient_phone"));
            patient.setPatient_suite(row.getString("patient_suite"));
            patient.setPatient_city(row.getString("patient_city"));
            patient.setPatient_street(row.getString("patient_street"));
            patient.setPatient_state(row.getString("patient_state"));
            patient.setPatient_country(row.getString("patient_country"));
            patient.setPatient_zip(row.getString("patient_zip"));
            return patient;
        }
    }
}
