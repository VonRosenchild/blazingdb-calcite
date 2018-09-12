/*
 * Copyright 2018 BlazingDB, Inc.
 *     Copyright 2018 Percy Camilo Triveño Aucahuasi <percy@blazingdb.com>
 */

package com.blazingdb.calcite.schema;

import com.blazingdb.calcite.sql.parser.BlazingSqlParser;
import com.blazingdb.calcite.catalog.connection.CatalogService;
import com.blazingdb.calcite.catalog.domain.CatalogDatabase;
import com.blazingdb.calcite.catalog.domain.CatalogSchema;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.apache.calcite.linq4j.tree.Expression;
import org.apache.calcite.schema.Function;
import org.apache.calcite.schema.Schema;
import org.apache.calcite.schema.SchemaPlus;
import org.apache.calcite.schema.SchemaVersion;
import org.apache.calcite.schema.Table;
import org.apache.calcite.util.ConversionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BlazingSchema implements Schema {

	final static Logger MAPDLOGGER = LoggerFactory.getLogger(BlazingSchema.class);

	final private CatalogSchema catalogSchema;
	final private CatalogDatabase catalogDatabase;

	public BlazingSchema(CatalogSchema catalogSchema) {
		this.catalogSchema = catalogSchema;
		this.catalogDatabase = null;
	}

	@Override
	public Table getTable(String string) {
		// Table table = metaConnect.getTable(string);
		// return table;
		return null;
	}

	@Override
	public Set<String> getTableNames() {
		// Set<String> tableSet = metaConnect.getTables();
		// return tableSet;
		return null;
	}

	@Override
	public Collection<Function> getFunctions(String string) {
		Collection<Function> functionCollection = new HashSet<Function>();
		return functionCollection;
	}

	@Override
	public Set<String> getFunctionNames() {
		Set<String> functionSet = new HashSet<String>();
		return functionSet;
	}

	@Override
	public Schema getSubSchema(String string) {
		return null;
	}

	@Override
	public Set<String> getSubSchemaNames() {
		Set<String> hs = new HashSet<String>();
		return hs;
	}

	@Override
	public Expression getExpression(SchemaPlus sp, String string) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public boolean isMutable() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	// void updateMetaData(String schema, String table) {
	// metaConnect.updateMetaData(schema, table);
	// }

	@Override
	public Schema snapshot(SchemaVersion sv) {
		throw new UnsupportedOperationException("Not supported yet.");
	}
}