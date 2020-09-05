package json.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;
import net.sf.jsqlparser.expression.*;
import net.sf.jsqlparser.expression.operators.arithmetic.*;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.expression.operators.conditional.OrExpression;
import net.sf.jsqlparser.expression.operators.relational.*;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.alter.Alter;
import net.sf.jsqlparser.statement.create.table.CreateTable;
import net.sf.jsqlparser.statement.create.view.CreateView;
import net.sf.jsqlparser.statement.delete.Delete;
import net.sf.jsqlparser.statement.drop.Drop;
import net.sf.jsqlparser.statement.insert.Insert;
import net.sf.jsqlparser.statement.replace.Replace;
import net.sf.jsqlparser.statement.select.*;
import net.sf.jsqlparser.statement.truncate.Truncate;
import net.sf.jsqlparser.statement.update.Update;

public class JSqlParserGsonGenerator {

    public Gson generate() {
        return new GsonBuilder()
                .registerTypeAdapterFactory(RuntimeTypeAdapterFactory
                        .of(Statement.class, "type")
                        .registerSubtype(Select.class)
                        .registerSubtype(Drop.class)
                        .registerSubtype(Truncate.class)
                        .registerSubtype(Replace.class)
                        .registerSubtype(Update.class)
                        .registerSubtype(CreateTable.class)
                        .registerSubtype(Insert.class)
                        .registerSubtype(Delete.class)
                        .registerSubtype(Alter.class)
                        .registerSubtype(CreateView.class))
                .registerTypeAdapterFactory(RuntimeTypeAdapterFactory
                        .of(SelectBody.class, "type")
                        .registerSubtype(PlainSelect.class)
                        .registerSubtype(SetOperationList.class)
                        .registerSubtype(WithItem.class))
                .registerTypeAdapterFactory(RuntimeTypeAdapterFactory
                        .of(SelectItem.class, "type")
                        .registerSubtype(SelectExpressionItem.class)
                        .registerSubtype(AllTableColumns.class)
                        .registerSubtype(AllColumns.class))
                .registerTypeAdapterFactory(RuntimeTypeAdapterFactory
                        .of(FromItem.class, "type")
                        .registerSubtype(SubJoin.class)
                        .registerSubtype(Table.class)
                        .registerSubtype(SubSelect.class)
                        .registerSubtype(LateralSubSelect.class)
                        .registerSubtype(ValuesList.class))
                .registerTypeAdapterFactory(RuntimeTypeAdapterFactory
                        .of(Expression.class, "type")
                        .registerSubtype(BinaryExpression.class)
                        .registerSubtype(OldOracleJoinBinaryExpression.class)
                        .registerSubtype(BitwiseXor.class)
                        .registerSubtype(Multiplication.class)
                        //.registerSubtype(LikeExpression.class)
                        .registerSubtype(Concat.class)
                        .registerSubtype(Division.class)
                        .registerSubtype(BitwiseOr.class)
                        .registerSubtype(BitwiseAnd.class)
                        .registerSubtype(RegExpMatchOperator.class)
                        .registerSubtype(Subtraction.class)
                        .registerSubtype(Addition.class)
                        .registerSubtype(AndExpression.class)
                        .registerSubtype(OrExpression.class)
                        .registerSubtype(Modulo.class)
                        .registerSubtype(EqualsTo.class)
                        .registerSubtype(Matches.class)
                        .registerSubtype(GreaterThanEquals.class)
                        .registerSubtype(NotEqualsTo.class)
                        .registerSubtype(GreaterThan.class)
                        .registerSubtype(MinorThanEquals.class)
                        .registerSubtype(MinorThan.class)
                        .registerSubtype(ExistsExpression.class)
                        .registerSubtype(InExpression.class)
                        .registerSubtype(CaseExpression.class)
                        .registerSubtype(AnalyticExpression.class)
                        .registerSubtype(Column.class)
                        .registerSubtype(Function.class)
                        .registerSubtype(DoubleValue.class)
                        .registerSubtype(CastExpression.class)
                        .registerSubtype(AllComparisonExpression.class)
                        .registerSubtype(ExtractExpression.class)
                        .registerSubtype(OracleHierarchicalExpression.class)
                        .registerSubtype(AnyComparisonExpression.class)
                        .registerSubtype(SignedExpression.class)
                        .registerSubtype(IsNullExpression.class)
                        .registerSubtype(NullValue.class)
                        .registerSubtype(SubSelect.class)
                        .registerSubtype(JdbcNamedParameter.class)
                        .registerSubtype(WhenClause.class)
                        .registerSubtype(IntervalExpression.class)
                        .registerSubtype(JdbcParameter.class)
                        .registerSubtype(LongValue.class)
                        .registerSubtype(TimeValue.class)
                        .registerSubtype(TimestampValue.class)
                        .registerSubtype(DateValue.class)
                        .registerSubtype(Between.class)
                        .registerSubtype(StringValue.class)
                        .registerSubtype(Parenthesis.class))
                .create();
    }
}
