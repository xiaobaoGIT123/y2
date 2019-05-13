package cn.bdqn.dao;

import cn.bdqn.pojo.Message;

import java.util.List;

public interface MessageMapper {

    //(添加聊天信息)
    int addMessage(Message message);

    //(根据接收者id修改信息状态)
    int updateMessageStatus(int receiveId);

    //(根据id和状态查询未读信息条数  状态固定为0)
    int getMessageByidAndStatus(int id);

    //(根据接收者id和发送者id查询聊天记录)
    List<Message> getMessage(int sendId, int receiveId);

}
