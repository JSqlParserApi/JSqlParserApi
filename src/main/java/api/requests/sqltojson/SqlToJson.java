package api.requests.sqltojson;

import json.JSqlParserJson;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SqlToJson {

    @PostMapping("/jsontosql")
    public String jsonToSql(@RequestBody Body body) {
        String json = body.getJson();
        String sql = new JSqlParserJson().toSql(json);
        return sql;
    }
}
