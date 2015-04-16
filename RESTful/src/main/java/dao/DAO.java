package dao;

import java.sql.SQLException;

/**
 * Интерфейс для работы с БД
 */
public interface DAO<T> {
	
	//создает новую запись в БД
	public void add(T object) throws SQLException; 
	//возвращает объект из БД по Id
	public T get(int id) throws SQLException;
	//обновляет данные объекта в БД
	public void update(T object) throws SQLException;
	//удаляет объект из БД
	public void delete (T object) throws SQLException;
}
