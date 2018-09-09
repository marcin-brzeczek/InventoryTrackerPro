package com.mbit.inventorytracker.database.dto;

import android.content.ContentValues;
import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.config.DatabaseHolder;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.converter.TypeConverter;
import com.raizlabs.android.dbflow.converter.UUIDConverter;
import com.raizlabs.android.dbflow.sql.QueryBuilder;
import com.raizlabs.android.dbflow.sql.language.OperatorGroup;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;
import com.raizlabs.android.dbflow.sql.language.property.Property;
import com.raizlabs.android.dbflow.sql.language.property.TypeConvertedProperty;
import com.raizlabs.android.dbflow.sql.language.property.TypeConvertedProperty.TypeConverterGetter;
import com.raizlabs.android.dbflow.structure.ModelAdapter;
import com.raizlabs.android.dbflow.structure.database.DatabaseStatement;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.FlowCursor;
import java.lang.Class;
import java.lang.IllegalArgumentException;
import java.lang.Override;
import java.lang.String;
import java.util.UUID;

/**
 * This is generated code. Please do not modify */
public final class User_Table extends ModelAdapter<User> {
  public static final Property<String> name = new Property<String>(User.class, "name");

  /**
   * Primary Key */
  public static final TypeConvertedProperty<String, UUID> id = new TypeConvertedProperty<String, UUID>(User.class, "id", true,
  new TypeConvertedProperty.TypeConverterGetter() {
  @Override
  public TypeConverter getTypeConverter(Class<?> modelClass) {
    User_Table adapter = (User_Table) FlowManager.getInstanceAdapter(modelClass);
  return adapter.global_typeConverterUUIDConverter;
  }
  });

  public static final IProperty[] ALL_COLUMN_PROPERTIES = new IProperty[]{name,id};

  private final UUIDConverter global_typeConverterUUIDConverter;

  public User_Table(DatabaseHolder holder, DatabaseDefinition databaseDefinition) {
    super(databaseDefinition);
    global_typeConverterUUIDConverter = (UUIDConverter) holder.getTypeConverterForClass(UUID.class);
  }

  @Override
  public final Class<User> getModelClass() {
    return User.class;
  }

  @Override
  public final String getTableName() {
    return "`User`";
  }

  @Override
  public final User newInstance() {
    return new User();
  }

  @Override
  public final Property getProperty(String columnName) {
    columnName = QueryBuilder.quoteIfNeeded(columnName);
    switch ((columnName)) {
      case "`name`":  {
        return name;
      }
      case "`id`":  {
        return id;
      }
      default: {
        throw new IllegalArgumentException("Invalid column name passed. Ensure you are calling the correct table's column");
      }
    }
  }

  @Override
  public final IProperty[] getAllColumnProperties() {
    return ALL_COLUMN_PROPERTIES;
  }

  @Override
  public final void bindToInsertValues(ContentValues values, User model) {
    values.put("`name`", model.getName() != null ? model.getName() : null);
    String refid = model.getId() != null ? global_typeConverterUUIDConverter.getDBValue(model.getId()) : null;
    values.put("`id`", refid != null ? refid : null);
  }

  @Override
  public final void bindToInsertStatement(DatabaseStatement statement, User model, int start) {
    statement.bindStringOrNull(1 + start, model.getName());
    String refid = model.getId() != null ? global_typeConverterUUIDConverter.getDBValue(model.getId()) : null;
    statement.bindStringOrNull(2 + start, refid);
  }

  @Override
  public final void bindToUpdateStatement(DatabaseStatement statement, User model) {
    statement.bindStringOrNull(1, model.getName());
    String refid = model.getId() != null ? global_typeConverterUUIDConverter.getDBValue(model.getId()) : null;
    statement.bindStringOrNull(2, refid);
    statement.bindStringOrNull(3, refid);
  }

  @Override
  public final void bindToDeleteStatement(DatabaseStatement statement, User model) {
    String refid = model.getId() != null ? global_typeConverterUUIDConverter.getDBValue(model.getId()) : null;
    statement.bindStringOrNull(1, refid);
  }

  @Override
  public final String getCompiledStatementQuery() {
    return "INSERT INTO `User`(`name`,`id`) VALUES (?,?)";
  }

  @Override
  public final String getUpdateStatementQuery() {
    return "UPDATE `User` SET `name`=?,`id`=? WHERE `id`=?";
  }

  @Override
  public final String getDeleteStatementQuery() {
    return "DELETE FROM `User` WHERE `id`=?";
  }

  @Override
  public final String getCreationQuery() {
    return "CREATE TABLE IF NOT EXISTS `User`(`name` TEXT, `id` TEXT, PRIMARY KEY(`id`))";
  }

  @Override
  public final void loadFromCursor(FlowCursor cursor, User model) {
    model.setName(cursor.getStringOrDefault("name"));
    int index_id = cursor.getColumnIndex("id");
    if (index_id != -1 && !cursor.isNull(index_id)) {
      model.setId(global_typeConverterUUIDConverter.getModelValue(cursor.getString(index_id)));
    } else {
      model.setId(global_typeConverterUUIDConverter.getModelValue(null));
    }
  }

  @Override
  public final boolean exists(User model, DatabaseWrapper wrapper) {
    return SQLite.selectCountOf()
    .from(User.class)
    .where(getPrimaryConditionClause(model))
    .hasData(wrapper);
  }

  @Override
  public final OperatorGroup getPrimaryConditionClause(User model) {
    OperatorGroup clause = OperatorGroup.clause();
    String refid = model.getId() != null ? global_typeConverterUUIDConverter.getDBValue(model.getId()) : null;
    clause.and(id.invertProperty().eq(refid));
    return clause;
  }
}
