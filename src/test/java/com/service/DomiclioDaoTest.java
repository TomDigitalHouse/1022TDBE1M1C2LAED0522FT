package com.service;

import com.digitalhouse.ej1.model.Domicilio;
import com.digitalhouse.ej1.repository.DomicilioDAO;
import com.digitalhouse.ej1.repository.H2Helper;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DomiclioDaoTest {

    @Test
    public void test1() throws SQLException {
        //GIVEN
        var domicilio = new Domicilio(105,"Calle",55,"localidad","prov");
        var dao = new DomicilioDAO();
        //WHEN
        dao.darDeAlta(domicilio);
        //THEN
        var con = H2Helper.getConnection();
        var rs = con.createStatement().executeQuery("SELECT * FROM domicilio WHERE id = 105");
        assertTrue(rs.next());
    }

}
