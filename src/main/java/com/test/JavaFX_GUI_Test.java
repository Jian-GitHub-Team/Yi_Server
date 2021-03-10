package com.test;

/**
 * Created by Administrator on 2018/6/22 0022.
 * 下面这些javafx.*下面的API都是JDK8、JRE8中内置好的，直接调用即可
 */

import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.*;

import javax.swing.*;

/**
 * Java作为GUI(图形化用户界面)程序
 * 1、入口必须继承Application抽象类
 */
public class JavaFX_GUI_Test extends Application {

    public static void main(String[] args) {
        /**
         * GUI程序必须从入口的main方法进入并启动
         * launch是Application中的，调用它则可启动此GUI程序了
         */
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        try{
            BorderPane root = new BorderPane();
            Button btn = new Button("点击");
            Scene scene = new Scene(root,400,400);
            root.setCenter(btn);
            btn.setOnMouseClicked((Action)->{
                new other().start();
            });
//            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm().toString());
            primaryStage.setScene(scene);
            primaryStage.setTitle("测试");
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}

class other {

    //窗体拉伸属性
    private static boolean isRight;// 是否处于右边界调整窗口状态
    private static boolean isBottomRight;// 是否处于右下角调整窗口状态
    private static boolean isBottom;// 是否处于下边界调整窗口状态
    private final static int RESIZE_WIDTH = 5;// 判定是否为调整窗口状态的范围与边界距离
    private final static double MIN_WIDTH = 300;// 窗口最小宽度
    private final static double MIN_HEIGHT = 250;// 窗口最小高度
    private double xOffset = 0;
    private double yOffset = 0;

    public void start() {
        Stage primaryStage = new Stage();
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        BorderPane root = new BorderPane();
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 800, 450));
        primaryStage.initStyle(StageStyle.TRANSPARENT);

        root.setOnMouseMoved(event -> {
            event.consume();
            double x = event.getSceneX();
            double y = event.getSceneY();
            double width = primaryStage.getWidth();
            double height = primaryStage.getHeight();
            Cursor cursorType = Cursor.DEFAULT;// 鼠标光标初始为默认类型，若未进入调整窗口状态，保持默认类型

            // 先将所有调整窗口状态重置
            isRight = isBottomRight = isBottom = false;
            if (y >= height - RESIZE_WIDTH) {
                if (x <= RESIZE_WIDTH) {// 左下角调整窗口状态

                } else if (x >= width - RESIZE_WIDTH) {// 右下角调整窗口状态
                    isBottomRight = true;
                    cursorType = Cursor.SE_RESIZE;
                } else {// 下边界调整窗口状态
                    isBottom = true;
                    cursorType = Cursor.S_RESIZE;
                }
            } else if (x >= width - RESIZE_WIDTH) {// 右边界调整窗口状态
                isRight = true;
                cursorType = Cursor.E_RESIZE;
            }
            // 最后改变鼠标光标
            root.setCursor(cursorType);
        });

        root.setOnMouseDragged(event -> {
            double x = event.getSceneX();
            double y = event.getSceneY();
            // 保存窗口改变后的x、y坐标和宽度、高度，用于预判是否会小于最小宽度、最小高度
            double nextX = primaryStage.getX();
            double nextY = primaryStage.getY();
            double nextWidth = primaryStage.getWidth();
            double nextHeight = primaryStage.getHeight();

            if (isRight || isBottomRight) {// 所有右边调整窗口状态
                nextWidth = x;
            }
            if (isBottomRight || isBottom) {// 所有下边调整窗口状态
                nextHeight = y;
            }
            if (nextWidth <= MIN_WIDTH) {// 如果窗口改变后的宽度小于最小宽度，则宽度调整到最小宽度
                nextWidth = MIN_WIDTH;
            }
            if (nextHeight <= MIN_HEIGHT) {// 如果窗口改变后的高度小于最小高度，则高度调整到最小高度
                nextHeight = MIN_HEIGHT;
            }
            // 最后统一改变窗口的x、y坐标和宽度、高度，可以防止刷新频繁出现的屏闪情况
            primaryStage.setX(nextX);
            primaryStage.setY(nextY);
            primaryStage.setWidth(nextWidth);
            primaryStage.setHeight(nextHeight);
            if(!isBottom && !isBottomRight && !isRight)
            {
                primaryStage.setX(event.getScreenX() - xOffset);
                primaryStage.setY(event.getScreenY() - yOffset);
            }
        });

        root.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });



        primaryStage.show();
    }

}