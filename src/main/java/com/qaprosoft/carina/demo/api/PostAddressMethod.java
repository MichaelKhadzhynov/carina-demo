package com.qaprosoft.carina.demo.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.RequestTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.Configuration;


@Endpoint(url = "${base_url}/addresses", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/address/_post/rq.json")
@ResponseTemplatePath(path = "api/address/_post/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.CREATED_201)
public class PostAddressMethod extends AbstractApiMethodV2 {

    public PostAddressMethod() {
        super("api/address/_post/rq.json",
                "api/address/_post/rs.json",
                "api/address/address.properties");

        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }

}
