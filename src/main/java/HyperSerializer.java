import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.List;

public class HyperSerializer extends JsonSerializer<List<Hyperparameter>> {

    @Override
    public void serialize(List<Hyperparameter> value, JsonGenerator jgen,
                          SerializerProvider provider) throws IOException {
        jgen.writeStartArray();
        for (Hyperparameter model : value) {
            jgen.writeStartObject();
            jgen.writeObjectField("model", model);
            jgen.writeEndObject();
        }
        jgen.writeEndArray();
    }
}
