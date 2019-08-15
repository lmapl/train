package com.train.service.common.impl;

import com.train.dao.declare.AddrAreaDao;
import com.train.domain.bean.AreaInfo;
import com.train.domain.entity.AddrArea;
import com.train.service.common.AreaService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by ma peiliang
 * Create Date: 2019/8/5 20:14
 * Description: ${DESCRIPTION}
 */
@Service
public class AreaServiceImpl implements AreaService {

    @Resource
    private AddrAreaDao addrAreaDao;

    @Override
    public List<AreaInfo> getArea(Integer scope) {

        List<AddrArea> addrAreaList = addrAreaDao.getValidAreaByType(scope);
        if(CollectionUtils.isEmpty(addrAreaList)){
            return new ArrayList<>();
        }
        List<AreaInfo> list = new ArrayList<>();
        AreaInfo info ;
        for(AddrArea addrArea : addrAreaList){
            info = new AreaInfo();
            info.setId(addrArea.getId());
            info.setName(addrArea.getAddrName());
            list.add(info);
        }
        list = improveChildArea(list);

        return list;
    }

    List<AreaInfo> improveChildArea(List<AreaInfo> source){


        List<Integer> idList = source.stream().map(AreaInfo::getId).collect(Collectors.toList());

        //根据父id查询有效子地址
        List<AddrArea> addrAreaList = addrAreaDao.getValidAreaByFather(idList);
        if(CollectionUtils.isEmpty(addrAreaList)){
            return source;
        }

        //按fatherId划分
        Map<Integer,List<AddrArea>> map = new HashMap<>();
        List<AddrArea> tempList;
        for(AddrArea addrArea : addrAreaList){
            tempList = map.get(addrArea.getFatherId());
            if(tempList != null){
                tempList.add(addrArea);
            }else{
                tempList = new ArrayList<>();
                tempList.add(addrArea);
            }
            map.put(addrArea.getFatherId(),tempList);
        }

        List<AddrArea> list1 ;
        AreaInfo info ;
        List<AreaInfo> childAreaList;
        List<AreaInfo> sourceChange = new ArrayList<>();

        for(AreaInfo areaInfo : source){
            list1 = map.get(areaInfo.getId());
            if(!CollectionUtils.isEmpty(list1)){
                childAreaList = new ArrayList<>();
                for(AddrArea addrArea : addrAreaList){
                    info = new AreaInfo();
                    info.setId(addrArea.getId());
                    info.setName(addrArea.getAddrName());
                    childAreaList.add(info);
                }
                childAreaList = improveChildArea(childAreaList);

                areaInfo.setChildAreaList(childAreaList);
            }
            sourceChange.add(areaInfo);
        }


        return sourceChange;
    }
}
