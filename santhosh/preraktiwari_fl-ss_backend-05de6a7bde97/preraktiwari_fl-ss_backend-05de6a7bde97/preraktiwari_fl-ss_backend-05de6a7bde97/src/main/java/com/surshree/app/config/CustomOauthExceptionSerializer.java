package com.surshree.app.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.surshree.app.exception.CustomOauthException;

import java.io.IOException;
import java.util.Date;

public class CustomOauthExceptionSerializer extends StdSerializer<CustomOauthException> {

    public CustomOauthExceptionSerializer() {
        super(CustomOauthException.class);
    }

    @Override
    public void serialize(CustomOauthException value, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeObjectField("timestamp", new Date());
        jsonGenerator.writeObjectField("msg", value.getMessage());
        jsonGenerator.writeObjectField("details", value.getMessage());
        jsonGenerator.writeEndObject();
    }
}
