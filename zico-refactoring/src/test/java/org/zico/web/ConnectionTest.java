package org.zico.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {
    public static void main(String[] args) {
        
        try {
            // 1. 드라이버 로딩
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("드라이버 로딩 성공");
            
        // forName의 인자로 전달된 주소에 드라이버가 없을 경우
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버 로딩 실패");
        }
        
        try {
            // 오라클DB에 연결
            Connection conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@127.0.0.1:1521:orcl", "mantos" , "jaeik12");
            System.out.println("커넥션 성공");
            
            // 실제 사용 코드
            
            // 커넥션은 반드시 닫아주어야 한다.
            conn.close();
            System.out.println("커넥션 종료");
        // 오라클 DB에 연결이 실패하였을때
        } catch (SQLException e) {
            System.out.println("커넥션 실패");
        } 
    }
}
