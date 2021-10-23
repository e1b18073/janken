package oit.is.z1652.kaizi.janken.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

  @Select("SELECT id,name from users")
  ArrayList<User> selectAllUsers();

  @Select("SELECT * from users where id = #{id}")
  User selectById(int id);

  @Select("SELECT * from users where name = #{name}")
  User selectByName(String user);

  @Insert("INSERT INTO users (name) VALUES (#{name});")
  @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
  void insertUser(User users);

}
