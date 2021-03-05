package com.micro.lcl.common.zookeeper;

import org.apache.zookeeper.*;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * Todo
 *
 * @author Administrator
 * @date 2021/3/217:33
 */
public class JavaZkTest {
    private static final String CONNECTSTRING = "localhost:2181";
    private static final Integer SESSIONTIMEOUT = 5000;
    private static final CountDownLatch countDownLatch = new CountDownLatch(1);
    public static void main(String[] args) throws InterruptedException {
        ZooKeeper zooKeeper = null;
        try {
            zooKeeper = new ZooKeeper(CONNECTSTRING, SESSIONTIMEOUT, new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    Event.KeeperState keeperState = event.getState();
                    Event.EventType type = event.getType();
                    if (Event.KeeperState.SyncConnected == keeperState) {
                        if (Event.EventType.None == type) {
                            countDownLatch.countDown();
                            System.out.println("zk启动连接。。。");
                        }
                    }

                }
            });
            countDownLatch.await();
            String createNode = zooKeeper.create("/test666", "toov5".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

            System.out.println("节点名称："+createNode);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        } finally {
            if (zooKeeper != null) {
                zooKeeper.close();
            }
        }
    }
}
