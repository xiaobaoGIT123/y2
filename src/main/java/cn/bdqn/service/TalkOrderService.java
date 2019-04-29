package cn.bdqn.service;

import cn.bdqn.pojo.TalkOrder;

import java.util.List;

public interface TalkOrderService {

    List<TalkOrder> getTalkOrderByHouseId(int id);
}
