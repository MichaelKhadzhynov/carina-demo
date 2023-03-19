package com.qaprosoft.carina.demo.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.RequestTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.Configuration;


@Endpoint(url = "${base_url}/addresses/14", methodType = HttpMethodType.PUT)
@RequestTemplatePath(path = "api/address/_put/rq.json")
@ResponseTemplatePath(path = "api/address/_put/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class PutAddressMethod extends AbstractApiMethodV2 {

    public PutAddressMethod() {
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}
