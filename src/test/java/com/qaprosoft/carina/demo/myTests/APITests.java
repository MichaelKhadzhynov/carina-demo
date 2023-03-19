package com.qaprosoft.carina.demo.myTests;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.api.*;
import com.qaprosoft.carina.demo.api.pojoclasses.AddressPojo;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class APITests implements IAbstractTest {

    @Test()
    @MethodOwner(owner = "Khadzhynov Michael")
    public void testGetAddress() {
        GetAddressMethod getAddressMethod = new GetAddressMethod();
        getAddressMethod.addParameter("id", "3");
        getAddressMethod.callAPI();
        getAddressMethod.validateResponseAgainstSchema("api/address/_get/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "Khadzhynov Michael")
    public void testGetAddresses() {
        GetAddressMethod getAddressMethod = new GetAddressMethod();

        List<AddressPojo> addresses = getAddressMethod.callAPIExpectSuccess()
                .then()
                .extract()
                .body()
                .jsonPath()
                .getList("", AddressPojo.class);

        getAddressMethod.validateResponseAgainstSchema("api/address/_get/rs.schema");


        Assert.assertFalse(addresses.stream().allMatch(e->e.getPhone().toString().isEmpty()));
    }

    @Test()
    @MethodOwner(owner = "Khadzhynov Michael")
    public void testPostAddresses() {
        PostAddressMethod postAddressMethod = new PostAddressMethod();

        postAddressMethod.setProperties("api/address/address.properties");

        postAddressMethod.callAPIExpectSuccess();
        postAddressMethod.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "Khadzhynov Michael")
    public void testPostAddresses1() {
        AddressPojo address = new AddressPojo(
                14,
                "Ukraine",
                "Lviv",
                "home address",
                13124,
                380987989L
                );

        PostAddressMethod postAddressMethod = new PostAddressMethod();

        postAddressMethod.setRequestBody(address);
        postAddressMethod.callAPIExpectSuccess();
    }

    @Test()
    @MethodOwner(owner = "Khadzhynov Michael")
    public void testDeleteAddressMethod(){

        DeleteAddressMethod deleteAddressMethod = new DeleteAddressMethod();
        deleteAddressMethod.callAPIExpectSuccess();
        deleteAddressMethod.validateResponse();

    }

    @Test()
    @MethodOwner(owner = "Khadzhynov Michael")
    public void testPutAddressMethod(){
        PutAddressMethod putAddressMethod = new PutAddressMethod();
        putAddressMethod.setProperties("api/address/address.properties");
        putAddressMethod.callAPIExpectSuccess();
        putAddressMethod.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "Khadzhynov Michael")
    public void testPostPersonMethod(){

        PostPersonMethod postPersonMethod = new PostPersonMethod();
        postPersonMethod.setProperties("api/persons/persons.properties");
        postPersonMethod.callAPIExpectSuccess();
        postPersonMethod.validateResponse();

    }

    @Test()
    @MethodOwner(owner = "Khadzhynov Michael")
    public void testGetPersonMethod(){
        GetPersonMethod getPersonMethod = new GetPersonMethod();
        getPersonMethod.addParameter("id", "11");
        getPersonMethod.callAPIExpectSuccess();
        getPersonMethod.validateResponseAgainstSchema("api/persons/_get/rs.schema");

    }
}
