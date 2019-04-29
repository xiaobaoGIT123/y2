package cn.bdqn.dao;

import cn.bdqn.pojo.TalkOrder;

import java.util.List;

public interface TalkOrderMapper {

    //(根据房子id查看评论，显示评论)
    List<TalkOrder> getTalkOrderByHouseId(int id);

    //(根据房子id查看评论，返回条数)
    int getTalkOrderByHouseId(int houseId,int messageStatus);

    //(添加评论)
    int addTalkOrder(TalkOrder talkOrder);
}
