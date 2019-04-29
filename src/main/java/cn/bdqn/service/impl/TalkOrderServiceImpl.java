package cn.bdqn.service.impl;

import cn.bdqn.dao.TalkOrderMapper;
import cn.bdqn.pojo.TalkOrder;
import cn.bdqn.service.TalkOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TalkOrderServiceImpl implements TalkOrderService {

    @Resource
    TalkOrderMapper talkOrderMapper;
    @Override
    public List<TalkOrder> getTalkOrderByHouseId(int id) {
        return talkOrderMapper.getTalkOrderByHouseId(id);
    }
}
