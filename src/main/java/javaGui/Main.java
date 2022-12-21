package javaGui;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;

public class Main extends JFrame {

    public Main () throws IOException {

        String[] menus = SchoolMenu.getMenu();

        JFrame jf = new JFrame();
        jf.setLocation(700,400);    //내 화면의 가운데에 오게 위치값 잡아주기
        jf.setSize(500,250);
        jf.setTitle("오늘 급식 메뉴");
        jf.setLayout(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel jl = new JLabel("급식메뉴 : ");
        jl.setSize(80, 30);
        jl.setLocation(30, 30);
        jf.add(jl);

        int cnt = -1;
        for (String menu : menus) {
            jl = new JLabel(menu);
            jl.setSize(150, 30);
            if (menu.startsWith("(")) {
                jl.setLocation(150 + jl.getWidth(), cnt * 20 + 30);
            }
            else {
                cnt ++;
                jl.setLocation(110, cnt * 20 + 30);
            }
            jf.add(jl);
        }
        jf.setVisible(true);


    }
    public static void main(String[] args) throws IOException {
        new Main();
    }
}
