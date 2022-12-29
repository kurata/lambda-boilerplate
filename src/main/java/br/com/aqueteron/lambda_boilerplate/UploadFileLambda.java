package br.com.aqueteron.lambda_boilerplate;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import software.amazon.awssdk.services.apigateway.model.GatewayResponse;

import java.util.Map;

public class UploadFileLambda implements RequestHandler<Map<String, Object>, GatewayResponse> {

    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public GatewayResponse handleRequest(final Map<String, Object> input, final Context context) {
        LambdaLogger logger = context.getLogger();

        // log execution details
        logger.log("ENVIRONMENT VARIABLES: " + this.gson.toJson(System.getenv()));
        logger.log("CONTEXT: " + this.gson.toJson(context));

        // process event
        logger.log("INPUT: " + input);

        return GatewayResponse.builder().statusCode("200").build();
    }
}
