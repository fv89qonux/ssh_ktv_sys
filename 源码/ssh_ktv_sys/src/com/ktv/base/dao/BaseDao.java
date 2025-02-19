package com.ktv.base.dao;

import java.util.List;
import java.util.Map;

public interface BaseDao<T> {
	/**
	 * 添加对象
	 * @param t
	 * @return
	 */
	public T add(T t);
	/**
	 * 更新对象
	 * @param t
	 */
	public void update(T t);
	/**
	 * 根据id删除对象
	 * @param id
	 */
	public void delete(int id);
	/**
	 * 根据id加载对象
	 * @param id
	 * @return
	 */
	public T load(int id);
	/**
	 * 不分页列别查询
	 * @param hql
	 * @param args
	 * @return
	 */
//	public List<T> list(String hql, Object[] args);
//	public List<T> list(String hql, Object arg);
//	public List<T> list(String hql);
//	public List<T> list(String hql, Object[] args, Map<String, Object> alias);
	public List<T> listByAlias(String hql, Map<String, Object> alias);
	public T getByParams(String hql, Map<String, Object> alias);
//	/**
//	 * 分页列表
//	 * @param hql
//	 * @param args
//	 * @return
//	 */
//	public Pager<T> find(String hql, Object[] args);
//	public Pager<T> find(String hql, Object arg);
//	public Pager<T> find(String hql);
//	/**
//	 * 基于别名的查询
//	 * @param hql
//	 * @param args
//	 * @param alias
//	 * @return
//	 */
//	public Pager<T> find(String hql, Object[] args, Map<String, Object> alias);
//	public Pager<T> findByAlias(String hql, Map<String, Object> alias);
//	/**
//	 * 查询对象通过hql
//	 * @param hql
//	 * @param args
//	 * @return
//	 */
//	public Object queryObject(String hql, Object[] args);
//	public Object queryObject(String hql, Object arg);
//	public Object queryObject(String hql);
//	/**
//	 * 根据hql更新对象
//	 * @param hql
//	 * @param args
//	 */
//	public void updateByHql(String hql, Object[] args);
//	public void updateByHql(String hql, Object arg);
//	public void updateByHql(String hql);
//	/**
//	 * 基于sql查询
//	 * @param sql
//	 * @param args
//	 * @param clz
//	 * @param hasEntity
//	 * @return
//	 */
//	public <N extends Object>List<N> listBySql(String sql, Object[] args, Class<?> clz,
//			boolean hasEntity);
//	public <N extends Object>List<N> listBySql(String sql, Object arg, Class<?> clz,
//			boolean hasEntity);
//	public <N extends Object>List<N> listBySql(String sql, Class<?> clz, boolean hasEntity);
//	public <N extends Object>List<N> listBySql(String sql, Object[] args,
//			Map<String, Object> alias, Class<?> clz, boolean hasEntity);
//	public <N extends Object>List<N> listByAliasSql(String sql, Map<String, Object> alias,
//			Class<?> clz, boolean hasEntity);
//	public <N extends Object>Pager<N> findBySql(String sql, Object[] args, Class<?> clz,
//			boolean hasEntity);
//	public <N extends Object>Pager<N> findBySql(String sql, Object arg, Class<?> clz,
//			boolean hasEntity);
//	public <N extends Object>Pager<N> findBySql(String sql, Class<?> clz, boolean hasEntity);
//	public <N extends Object>Pager<N> findBySql(String sql, Object[] args,
//			Map<String, Object> alias, Class<?> clz, boolean hasEntity);
//	public <N extends Object>Pager<N> findByAliasSql(String sql, Map<String, Object> alias,
//			Class<?> clz, boolean hasEntity);
//	public Object queryObject(String hql, Object[] args,
//			Map<String, Object> alias) ;
//	public Object queryObjectByAlias(String hql, Map<String, Object> alias);
}
