package com.qaprosoft.carina.demo.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.RequestTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.Configuration;


@Endpoint(url="${base_url}/persons", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/persons/_post/rq.json")
@ResponseTemplatePath(path= "api/persons/_post/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.CREATED_201)

public class PostPersonMethod extends AbstractApiMethodV2 {
    public PostPersonMethod() {
        super("api/persons/_post/rq.json",
                "api/persons/_post/rs.json",
                "api/persons/persons.properties");

        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}
