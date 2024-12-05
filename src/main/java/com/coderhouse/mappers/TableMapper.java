package com.coderhouse.mappers;

import com.coderhouse.dtos.TableReqDTO;
import com.coderhouse.dtos.TableResDTO;
import com.coderhouse.models.Table;


public class TableMapper {

	public Table toTable(TableReqDTO table) {
		Table newTable = new Table();
		
		newTable.setCapacity(table.getCapacity());
		
		return newTable;
	}
	
	public TableResDTO toDTO(Table table) {
		return new TableResDTO(table.getId(), table.getCapacity());
	}
}
