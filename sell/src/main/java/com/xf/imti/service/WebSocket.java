package com.xf.imti.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by 874879659 on 2018/5/16.
 */
@Component
@ServerEndpoint("/webSocket")
@Slf4j
public class WebSocket {
    private Session session;

    private  static CopyOnWriteArrayList<WebSocket> webSockets= new CopyOnWriteArrayList<>();

    @OnClose
    public void onOpen(Session session){
        this.session=session;
        webSockets.add(this);
        log.info("【websocket消息】有新的连接，总数：{}",webSockets.size());
    }
    @OnMessage
    public void onMessage(String message) {
        log.info("【websocket消息】收到客户端发来的消息:{}", message);
    }


    public void sendMessage(String message) {
        for (WebSocket webSocket: webSockets) {
            log.info("【websocket消息】广播消息, message={}", message);
            try {
                webSocket.session.getBasicRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
