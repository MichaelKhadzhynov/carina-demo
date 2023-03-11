package com.qaprosoft.carina.demo.myTests;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.api.DeleteAddressMethod;
import com.qaprosoft.carina.demo.api.GetAddressMethod;
import com.qaprosoft.carina.demo.api.PostAddressMethod;
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


}
