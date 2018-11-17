package com.blazingdb.calcite.application;

import org.apache.calcite.tools.ValidationException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SqlValidationException extends SqlException {
  private static final long serialVersionUID = -429299379494895888L;

  public SqlValidationException(final String queryString,
                                final ValidationException validationException) {
    super(description(queryString, validationException.getMessage()));
  }

  private static Pattern pattern = Pattern.compile(
      "From line (\\d+), column (\\d+) to line (\\d+), column (\\d+): (.*)");

  private static String description(final String queryString,
                                    final String message) {
    Matcher       matcher = pattern.matcher(message);
    StringBuilder builder = new StringBuilder();

    matcher.find();

    int    lineNum      = Integer.parseInt(matcher.group(1));
    int    columnNum    = Integer.parseInt(matcher.group(2));
    int    endLineNum   = Integer.parseInt(matcher.group(3));
    int    endColumnNum = Integer.parseInt(matcher.group(4));
    String cause        = matcher.group(0);

    builder.append("SqlValidationException\n\n");

    SqlException.pointInQueryString(
        builder,
        queryString,
        new SqlPosition(lineNum, columnNum, endLineNum, endColumnNum));

    builder.append('\n');
    builder.append(cause);

    return builder.toString();
  }
}
