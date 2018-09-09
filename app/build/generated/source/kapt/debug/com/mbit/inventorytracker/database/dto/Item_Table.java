package com.mbit.inventorytracker.database.dto;

import android.content.ContentValues;
import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.sql.QueryBuilder;
import com.raizlabs.android.dbflow.sql.language.OperatorGroup;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;
import com.raizlabs.android.dbflow.sql.language.property.Property;
import com.raizlabs.android.dbflow.structure.ModelAdapter;
import com.raizlabs.android.dbflow.structure.database.DatabaseStatement;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.FlowCursor;
import java.lang.Class;
import java.lang.Double;
import java.lang.IllegalArgumentException;
import java.lang.Long;
import java.lang.Number;
import java.lang.Override;
import java.lang.String;

/**
 * This is generated code. Please do not modify */
public final class Item_Table extends ModelAdapter<Item> {
  /**
   * Primary Key AutoIncrement */
  public static final Property<Long> id = new Property<Long>(Item.class, "id");

  public static final Property<String> code = new Property<String>(Item.class, "code");

  public static final Property<String> supportCode = new Property<String>(Item.class, "supportCode");

  public static final Property<String> shortName = new Property<String>(Item.class, "shortName");

  public static final Property<String> name = new Property<String>(Item.class, "name");

  public static final Property<String> oldLocation = new Property<String>(Item.class, "oldLocation");

  public static final Property<Double> startNumber = new Property<Double>(Item.class, "startNumber");

  public static final Property<Double> endNumber = new Property<Double>(Item.class, "endNumber");

  public static final Property<String> itemState = new Property<String>(Item.class, "itemState");

  public static final Property<String> user = new Property<String>(Item.class, "user");

  public static final IProperty[] ALL_COLUMN_PROPERTIES = new IProperty[]{id,code,supportCode,shortName,name,oldLocation,startNumber,endNumber,itemState,user};

  public Item_Table(DatabaseDefinition databaseDefinition) {
    super(databaseDefinition);
  }

  @Override
  public final Class<Item> getModelClass() {
    return Item.class;
  }

  @Override
  public final String getTableName() {
    return "`Item`";
  }

  @Override
  public final Item newInstance() {
    return new Item();
  }

  @Override
  public final Property getProperty(String columnName) {
    columnName = QueryBuilder.quoteIfNeeded(columnName);
    switch ((columnName)) {
      case "`id`":  {
        return id;
      }
      case "`code`":  {
        return code;
      }
      case "`supportCode`":  {
        return supportCode;
      }
      case "`shortName`":  {
        return shortName;
      }
      case "`name`":  {
        return name;
      }
      case "`oldLocation`":  {
        return oldLocation;
      }
      case "`startNumber`":  {
        return startNumber;
      }
      case "`endNumber`":  {
        return endNumber;
      }
      case "`itemState`":  {
        return itemState;
      }
      case "`user`":  {
        return user;
      }
      default: {
        throw new IllegalArgumentException("Invalid column name passed. Ensure you are calling the correct table's column");
      }
    }
  }

  @Override
  public final void updateAutoIncrement(Item model, Number id) {
    model.setId(id.longValue());
  }

  @Override
  public final Number getAutoIncrementingId(Item model) {
    return model.getId();
  }

  @Override
  public final String getAutoIncrementingColumnName() {
    return "id";
  }

  @Override
  public final IProperty[] getAllColumnProperties() {
    return ALL_COLUMN_PROPERTIES;
  }

  @Override
  public final void bindToInsertValues(ContentValues values, Item model) {
    values.put("`code`", model.getCode() != null ? model.getCode() : null);
    values.put("`supportCode`", model.getSupportCode() != null ? model.getSupportCode() : null);
    values.put("`shortName`", model.getShortName() != null ? model.getShortName() : null);
    values.put("`name`", model.getName() != null ? model.getName() : null);
    values.put("`oldLocation`", model.getOldLocation() != null ? model.getOldLocation() : null);
    values.put("`startNumber`", model.getStartNumber());
    values.put("`endNumber`", model.getEndNumber());
    values.put("`itemState`", model.getItemState() != null ? model.getItemState() : null);
    values.put("`user`", model.getUser() != null ? model.getUser() : null);
  }

  @Override
  public final void bindToContentValues(ContentValues values, Item model) {
    values.put("`id`", model.getId());
    bindToInsertValues(values, model);
  }

  @Override
  public final void bindToInsertStatement(DatabaseStatement statement, Item model, int start) {
    statement.bindStringOrNull(1 + start, model.getCode());
    statement.bindStringOrNull(2 + start, model.getSupportCode());
    statement.bindStringOrNull(3 + start, model.getShortName());
    statement.bindStringOrNull(4 + start, model.getName());
    statement.bindStringOrNull(5 + start, model.getOldLocation());
    statement.bindDouble(6 + start, model.getStartNumber());
    statement.bindDouble(7 + start, model.getEndNumber());
    statement.bindStringOrNull(8 + start, model.getItemState());
    statement.bindStringOrNull(9 + start, model.getUser());
  }

  @Override
  public final void bindToStatement(DatabaseStatement statement, Item model) {
    int start = 0;
    statement.bindLong(1 + start, model.getId());
    bindToInsertStatement(statement, model, 1);
  }

  @Override
  public final void bindToUpdateStatement(DatabaseStatement statement, Item model) {
    statement.bindLong(1, model.getId());
    statement.bindStringOrNull(2, model.getCode());
    statement.bindStringOrNull(3, model.getSupportCode());
    statement.bindStringOrNull(4, model.getShortName());
    statement.bindStringOrNull(5, model.getName());
    statement.bindStringOrNull(6, model.getOldLocation());
    statement.bindDouble(7, model.getStartNumber());
    statement.bindDouble(8, model.getEndNumber());
    statement.bindStringOrNull(9, model.getItemState());
    statement.bindStringOrNull(10, model.getUser());
    statement.bindLong(11, model.getId());
  }

  @Override
  public final void bindToDeleteStatement(DatabaseStatement statement, Item model) {
    statement.bindLong(1, model.getId());
  }

  @Override
  public final String getInsertStatementQuery() {
    return "INSERT INTO `Item`(`code`,`supportCode`,`shortName`,`name`,`oldLocation`,`startNumber`,`endNumber`,`itemState`,`user`) VALUES (?,?,?,?,?,?,?,?,?)";
  }

  @Override
  public final String getCompiledStatementQuery() {
    return "INSERT INTO `Item`(`id`,`code`,`supportCode`,`shortName`,`name`,`oldLocation`,`startNumber`,`endNumber`,`itemState`,`user`) VALUES (?,?,?,?,?,?,?,?,?,?)";
  }

  @Override
  public final String getUpdateStatementQuery() {
    return "UPDATE `Item` SET `id`=?,`code`=?,`supportCode`=?,`shortName`=?,`name`=?,`oldLocation`=?,`startNumber`=?,`endNumber`=?,`itemState`=?,`user`=? WHERE `id`=?";
  }

  @Override
  public final String getDeleteStatementQuery() {
    return "DELETE FROM `Item` WHERE `id`=?";
  }

  @Override
  public final String getCreationQuery() {
    return "CREATE TABLE IF NOT EXISTS `Item`(`id` INTEGER PRIMARY KEY AUTOINCREMENT, `code` TEXT, `supportCode` TEXT, `shortName` TEXT, `name` TEXT, `oldLocation` TEXT, `startNumber` REAL, `endNumber` REAL, `itemState` TEXT, `user` TEXT)";
  }

  @Override
  public final void loadFromCursor(FlowCursor cursor, Item model) {
    model.setId(cursor.getLongOrDefault("id"));
    model.setCode(cursor.getStringOrDefault("code"));
    model.setSupportCode(cursor.getStringOrDefault("supportCode"));
    model.setShortName(cursor.getStringOrDefault("shortName"));
    model.setName(cursor.getStringOrDefault("name"));
    model.setOldLocation(cursor.getStringOrDefault("oldLocation"));
    model.setStartNumber(cursor.getDoubleOrDefault("startNumber"));
    model.setEndNumber(cursor.getDoubleOrDefault("endNumber"));
    model.setItemState(cursor.getStringOrDefault("itemState"));
    model.setUser(cursor.getStringOrDefault("user"));
  }

  @Override
  public final boolean exists(Item model, DatabaseWrapper wrapper) {
    return model.getId() > 0
    && SQLite.selectCountOf()
    .from(Item.class)
    .where(getPrimaryConditionClause(model))
    .hasData(wrapper);
  }

  @Override
  public final OperatorGroup getPrimaryConditionClause(Item model) {
    OperatorGroup clause = OperatorGroup.clause();
    clause.and(id.eq(model.getId()));
    return clause;
  }
}
