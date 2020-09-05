# JSqlParserApi

## Listen:
```
./gradlew bootRun
```

## SQL to JSqlParser JSON:

### Path:
```
POST /sqltojson
```

### Request example:
```
curl -H "Content-Type: application/json" \
-d '{ "sql": "SELECT * FROM    tab1 WHERE        country = 'Brazil' AND city = 'Rio'" }' \
localhost:8080/sqltojson
```

## JSqlParser JSON to SQL:

### Path:
```
POST /jsontosql
```

### Request example:
```
curl -H "Content-Type: application/json" \
-d '{ "json": "{\"type\":\"Select\",\"selectBody\":{\"type\":\"PlainSelect\",\"selectItems\":[{\"type\":\"AllColumns\"}],\"fromItem\":{\"type\":\"Table\",\"database\":{\"server\":{}},\"name\":\"tab1\"},\"where\":{\"type\":\"AndExpression\",\"leftExpression\":{\"type\":\"EqualsTo\",\"oldOracleJoinSyntax\":0,\"oraclePriorPosition\":0,\"leftExpression\":{\"type\":\"Column\",\"table\":{\"database\":{}},\"columnName\":\"country\"},\"rightExpression\":{\"type\":\"Column\",\"table\":{\"database\":{}},\"columnName\":\"Brazil\"},\"not\":false},\"rightExpression\":{\"type\":\"EqualsTo\",\"oldOracleJoinSyntax\":0,\"oraclePriorPosition\":0,\"leftExpression\":{\"type\":\"Column\",\"table\":{\"database\":{}},\"columnName\":\"city\"},\"rightExpression\":{\"type\":\"Column\",\"table\":{\"database\":{}},\"columnName\":\"Rio\"},\"not\":false},\"not\":false},\"oracleSiblings\":false}}" }' \
localhost:8080/jsontosql
```

