package json;

import com.google.gson.Gson;
import json.gson.JSqlParserGsonGenerator;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.util.deparser.StatementDeParser;

public class JSqlParserJson {

    private static Gson gson = null;

    public JSqlParserJson() {
        if (gson == null) {
            gson = new JSqlParserGsonGenerator().generate();
        }
    }

    public String toJson(String sql) {
        try {
            Statement stmt = CCJSqlParserUtil.parse(sql);
            String json = gson.toJson(stmt, Statement.class);
            return json;
        } catch (JSQLParserException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String toSql(String json) {
        Statement stmtFromJson = gson.fromJson(json, Statement.class);
        StatementDeParser deParser = new StatementDeParser(new StringBuilder());
        stmtFromJson.accept(deParser);
        String sql = deParser.getBuffer().toString();
        return sql;
    }
}
