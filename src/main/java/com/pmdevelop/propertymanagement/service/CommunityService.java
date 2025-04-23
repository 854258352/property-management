package com.pmdevelop.propertymanagement.service;

import com.pmdevelop.propertymanagement.entity.Community;
import com.pmdevelop.propertymanagement.mapper.CommunityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommunityService {

    @Autowired
    private CommunityMapper communityMapper;

    public List<Community> getAllCommunities() {
        return communityMapper.findAll();
    }

    public Community getCommunityById(Integer id) {
        Community community = communityMapper.findById(id);
        return community;
    }

    public void saveCommunity(Community community) {
        communityMapper.insert(community);
    }

    public void deleteCommunity(Integer id) {
        communityMapper.delete(id);
    }
}
