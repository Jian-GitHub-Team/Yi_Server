package com.mapper;

import com.entity.Friend;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Qi
 * @Date 2021/5/3 8:24 下午
 */

@Mapper
@Repository
public interface Friend_Mapper {
    @Select("select id,userName,isOnLine,isAvatar\n" +
            "from yi.user\n" +
            "where id = (\n" +
            "\tselect userId\n" +
            "\tfrom yi.friendship\n" +
            "\twhere userId = (\n" +
            "\t\t\t\tselect friendId\n" +
            "\t\t\t\tfrom yi.friendship\n" +
            "\t\t\t\twhere userId = #{ID}\n" +
            "\t\t\t) \n" +
            "            and friendId = #{ID}\n" +
            ")")
    List<Friend> selectFriendsByID(int ID);
}
