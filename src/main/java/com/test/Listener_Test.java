package com.test;

import com.entity.User;
import lombok.SneakyThrows;
import java.util.*;

public class Listener_Test {

    public void lTest() {

        MyEventSource mes = new MyEventSource();
        mes.addMyEventListener(new Test2());
        MyThread mythread = new MyThread(mes);
        mythread.start();

//        new Test2();

//        testListenerExecuter test = new testListenerExecuter(TEST.select(User.class));
//        PercentListener listener = new PercentListener() {
//            @Override
//            public void updateEvent(PercentEvent dm) {
//
//            }
//
//            @Override
//            public void updateEvent(List<User> users) {
//                // System.out.println("我是获取到事件改变之后的执行的方法");
//                System.out.println("我知道User改变为 : \n" );
//                Iterator<User> it = users.iterator();
//                while (it.hasNext()){
//                    User user = it.next();
//                    System.out.println(user);
//                }
//            }
//        };
//        // 将监听器添加给该变量
//        test.addPercentListener(listener);
//        test.innerExcuter();

    }
}

class MyEvent extends EventObject {
    private Object obj;
    private List<User> users;

    public MyEvent(Object source, List<User> users) {
        super(source);
        this.obj = source;
        this.users = users;
    }

    public Object getObj() {
        return obj;
    }

    public List<User> getsUsers() {
        return users;
    }
}


interface MyEventListener extends EventListener {

    public void handleEvent(MyEvent me);

}

class MyEventSource {
    private Vector list = new Vector();
    private List<User> users;


    public MyEventSource() {
        super();
    }

    public void addMyEventListener(MyEventListener me) {
        list.add(me);
    }

    public void deleteMyEventListener(MyEventListener me) {
        list.remove(me);
    }

    public void notifyMyEvent(MyEvent me) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((MyEventListener) it.next()).handleEvent(me);
        }
    }

    public void setUsers() {
//        System.out.println("执行");
        List<User> userLists = TEST.select(User.class);
        if (this.users == null) {
            this.users = userLists;
            notifyMyEvent(new MyEvent(this, userLists));
            return;
        }
        if (userLists.size() != this.users.size()) {
            this.users = userLists;
            // 如果改变则执行事件
            notifyMyEvent(new MyEvent(this, userLists));
        }
    }


}


class Test2 implements MyEventListener {
//    public Test2() {
////        mes.setName("niu");
////        mes.setName("Jian");
////        mes.setName("niu");
////        mes.setName("23333");
//    }

    public void handleEvent(MyEvent me) {
//        System.out.println(me.getSource());
        System.out.println("有更新\n");
        System.out.println(me.getsUsers());
    }
}

class MyThread extends Thread {
    private MyEventSource clazz;

    public MyThread(MyEventSource clazz) {
        this.clazz = clazz;
    }

    @SneakyThrows
    @Override
    public void run() {
        while (true)
            clazz.setUsers();
    }

}


//
//interface PercentListener extends EventListener {
//    /**
//     * 事件变化后执行的方法,自己定义的
//     *
//     * @param dm
//     */
//    public void updateEvent(PercentEvent dm);
//    public void updateEvent(List<User> users);
//}
//
//class PercentEvent extends EventObject {
//
//    private Object source;
//
//    private int percent;
//    private List<User> users;
//
//    /**
//     * 构造方法
//     *
//     * @param source  监听的对象
//     * @param percent 监听的变量
//     */
//    public PercentEvent(Object source, int percent) {
//        super(source);
//        this.source = source;
//        this.percent = percent;
//    }
//    public PercentEvent(Object source, List<User> users) {
//        super(source);
//        this.source = source;
//        this.users = users;
//    }
//
//    public int getPercent() {
//        return percent;
//    }
//}
//
//class testListenerExecuter {
//    List<User> users;
//    PercentListener percentListener;
//    public int percent = 0;
//
//    public testListenerExecuter(List<User> users){
//        this.users = users;
//    }
//
//    public void addPercentListener(PercentListener percentListener) {
//        this.percentListener = percentListener;
//    }
//
//    public void innerExcuter() {
//        while(true) {
////            percent = i;
//            users = TEST.select(User.class);
////            System.out.println("我是 ssers 我改变成了:\n" + users);
//            // 这一步必须在改变事件中加入对percent的监听 updateEvent是变量改变之后的执行事件
//            // 这个event里面也不是非要监听percent，你也可以监听其他变量
//            if (users.size() != TEST.select(User.class).size()) {
//                percentListener.updateEvent(new PercentEvent(this, users));
//            }
//        }
//    }
//}