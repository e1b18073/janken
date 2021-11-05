package oit.is.z1652.kaizi.janken.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface MatchInfoMapper {
  @Select("SELECT * FROM matchinfo where id = #{id}")
  MatchInfo selectById(int id);

  @Select("SELECT * FROM matchinfo where isActive = #{b}")
  ArrayList<MatchInfo> selectAllByActive(boolean b);

  @Select("select * from matchinfo where isActive=true and user1=#{user2} and user2=#{user1}")
  MatchInfo selectByMatchInfo(MatchInfo m);


  @Insert("INSERT INTO matchinfo (user1,user2,user1Hand,isActive) VALUES (#{user1},#{user2},#{user1Hand},#{isActive});")
  @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
  void insertMatchinfo(MatchInfo matchinfo);

  @Update("UPDATE matchinfo SET isActive=false Where id = #{id}")
  void updateById(MatchInfo m);
}
