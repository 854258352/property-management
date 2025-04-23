package com.pmdevelop.propertymanagement.mapper;

import com.pmdevelop.propertymanagement.entity.Room;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoomMapper {

    // 查询所有房间信息
    List<Room> findAll();

    // 根据房间ID查询房间信息
    Room findById(Integer id);

    // 插入房间信息
    void insert(Room room);

    // 更新房间信息
    void update(Room room);

    // 删除房间信息
    void delete(Integer id);

    //根据小区的Id查出该小区下所有的单元楼
    List<Room> getBuildingByCommunityId(Integer communityId);

    //根据小区的Id以及楼号，查询所有的单元号
    List<Room> getUnitByCommunityAndBuilding(@Param("communityId") Integer communityId,
                                              @Param("building") Integer building);
    //根据小区Id楼号以及单元号获取全由房间信息
    List<Room> getRoomsInfo(@Param("communityId") Integer communityId,
                            @Param("building") Integer building,
                            @Param("unit") Integer unit);
}
