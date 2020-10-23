package com.example.simulator.source.number.integer;

import com.example.simulator.operation.OperationException;
import com.example.simulator.source.SourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

@Component
public class WebRandomIntegerSource implements IntegerSource {

    private static final String urlIntegerGenerator = "https://www.random.org/integers/?num=1&min=-10000&max=10000&col=1&base=10&format=plain&rnd=new";

    private final RestTemplate restTemplate;

    @Autowired
    public WebRandomIntegerSource(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Integer getValue() {
        ResponseEntity<String> response = restTemplate.getForEntity(urlIntegerGenerator, String.class);
        validateResponse(response);

        String body = response.getBody();
        String number = body.replaceAll("\\s+", "");
        return Integer.valueOf(number);
    }

    @Override
    public SourceType getSource() {
        return SourceType.WEB;
    }

    private void validateResponse(ResponseEntity<String> response) {
        if (HttpStatus.OK != response.getStatusCode()) {
            throw new OperationException("Invalid response from random.org");
        }
        String body = response.getBody();
        if (StringUtils.isEmpty(body)) {
            throw new OperationException("Empty body in response from random.org");
        }
    }
}
