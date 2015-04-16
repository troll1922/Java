package DAO;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Интерфейс для работы с БД
 */
public interface Idao<T> {
	
	//создает новую запись в БД
	public void create(Connection dbConnection) throws SQLException;
	//возвращает объект из БД по Id
	public void read(int id, Connection dbConnection) throws SQLException;
	//обновляет данные объекта в БД
	public void update(Connection dbConnection) throws SQLException;
	//удаляет объект из БД
	public void delete (Connection dbConnection) throws SQLException;
}
