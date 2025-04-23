package com.pmdevelop.propertymanagement.service;

import com.pmdevelop.propertymanagement.entity.Room;
import com.pmdevelop.propertymanagement.mapper.RoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RoomService {

    @Autowired
    private RoomMapper roomMapper;

    // 获取所有房间信息
    public List<Room> getAllRooms() {
        return roomMapper.findAll();
    }

    // 根据房间ID获取房间信息
    public Room getRoomById(Integer id) {
        return roomMapper.findById(id);
    }

    // 插入新的房间信息
    public void addRoom(Room room) {
        roomMapper.insert(room);
    }

    // 更新房间信息
    public void updateRoom(Room room) {
        roomMapper.update(room);
    }

    // 删除房间信息
    public void deleteRoom(Integer id) {
        roomMapper.delete(id);
    }

    //根据小区的Id查出该小区下所有的单元楼
    public List<Map<String, Integer>> getBuildingByCommunityId(Integer communityId) {
        // 从数据库获取同一小区下所有房间
        List<Room> roomList = roomMapper.getBuildingByCommunityId(communityId);
        // 如果没有数据，返回空列表
        if (roomList == null || roomList.isEmpty()) {
            return Collections.emptyList();
        }
        // 提取所有的 building 字段，去重后封装成 List<Map<String,Integer>>
        return roomList.stream()
                .map(Room::getBuilding)             // 取出楼号
                .distinct()                         // 去重
                .map(b -> {                         // 每个楼号封装成一个 Map
                    Map<String, Integer> m = new HashMap<>();
                    m.put("building", b);
                    return m;
                })
                .collect(Collectors.toList());
    }

    //根据小区的Id以及楼号，查询所有的单元号
    public List<Map<String, Integer>> getUnitByCommunityAndBuilding(Integer communityId, Integer building) {
         List<Room> roomList = roomMapper.getUnitByCommunityAndBuilding(communityId, building);
         if (roomList == null || roomList.isEmpty()) {
             return Collections.emptyList();
         }
         return roomList.stream()
                 .map(Room::getUnit)
                 .distinct()
                 .map(u -> {
                     Map<String, Integer> m = new HashMap<>();
                     m.put("unit", u);
                     return m;
                 })
                 .collect(Collectors.toList());
    }

    //根据小区Id楼号以及单元号获取全由房间信息
    public List<Map<String, String>> getRoomsInfo(Integer communityId, Integer building, Integer unit) {
        List<Room> roomList = roomMapper.getRoomsInfo(communityId, building, unit);
        if (roomList == null || roomList.isEmpty()) {
            return Collections.emptyList();
        }
        return roomList.stream()
                .map(Room::getRoomNum)
                .distinct()
                .map( r -> {
                    Map<String, String> m = new HashMap<>();
                    m.put("room", r);
                    return m;
                })
                .collect(Collectors.toList());
    }
}
