package com.rubesh.Cucumber;

import java.util.Locale;
import java.util.Map;

import io.cucumber.core.api.TypeRegistry;
import io.cucumber.core.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTableType;
import io.restassured.mapper.ObjectMapper;

public class TypeRegistryConfiguration implements TypeRegistryConfigurer {

	
	@Override
	public void configureTypeRegistry(TypeRegistry typeRegistry) {
		typeRegistry.defineDataTableType(new DataTableType(Book.class,
	            (Map<String, String> row) -> new Book(
	                row.get("title"),
	                row.get("author")
	            )
	        ));

	}

}
