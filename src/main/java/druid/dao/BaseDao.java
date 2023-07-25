package druid.dao;

import druid.entity.User;
import druid.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {

    private QueryRunner queryRunner = new QueryRunner();

    //根据id查找
    public User selectOne(String sql, Integer uid){
        Connection connect = JdbcUtils.getConnect();
        try {
            return queryRunner.query(connect,sql,new BeanHandler<User>(User.class),uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.closeConnect(connect);
        }
        return null;
    }

    //查找所有用户
    public List<User> selectAll(String sql){
        Connection connect = JdbcUtils.getConnect();
        List<User> query = null;
        try {
            query = queryRunner.query(connect, sql, new BeanListHandler<User>(User.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.closeConnect(connect);
        }
        return query;
    }
    //根据id删除用户
    public int delete(String sql,Integer uid){
        Connection connect = JdbcUtils.getConnect();
        try {
            return queryRunner.update(connect,sql,uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.closeConnect(connect);
        }
        return -1;
    }

    //根据id更改用户信息
    public int update(String sql,Object... args){

        Connection connect = JdbcUtils.getConnect();
        try {
            return queryRunner.update(connect,sql,args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.closeConnect(connect);
        }
        return -1;
    }

    public User selectUserAndPassword(String sql,String username,String password){

        Connection conn = JdbcUtils.getConnect();
        try {
             return queryRunner.query(conn, sql, new BeanHandler<User>(User.class), username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

}
