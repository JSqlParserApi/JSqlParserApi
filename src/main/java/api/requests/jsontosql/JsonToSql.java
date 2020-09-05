package api.requests.jsontosql;

import json.JSqlParserJson;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsonToSql {

    @PostMapping("/sqltojson")
    public String sqlToJson(@RequestBody Body body) {
        String sql = body.getSql();
        String json = new JSqlParserJson().toJson(sql);
        return json;
    }
}
