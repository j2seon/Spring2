package com.fastcampus.ch3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository//DAO니까 Repository!!!
public class A1Dao {
    @Autowired
    DataSource ds;

    public int insert(int key, int value) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DataSourceUtils.getConnection(ds); //커넥션을 데이터 소스 도구에서 가져오고 그 소스는 ds다.
            System.out.println("conn : "+ conn);
            pstmt = conn.prepareStatement("insert into a1 values(?,?)");
            pstmt.setInt(1,key);
            pstmt.setInt(2,value);

            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.getStackTrace();
            throw e; //예외로 다시던져줘야한다.(트렌젝션..)
        }finally {
       //     close(pstmt, conn);
            close(pstmt); //애만 직접 닫아주고
            DataSourceUtils.releaseConnection(conn, ds); // 데이터소스도구를 헤제하는데 커넥션이랑 ds를 해제.
        }
    }
    private void close(AutoCloseable... acs) {
        for(AutoCloseable ac :acs) //가변인자를 선언해서 여러개가 들어갈수 있음.
            try { if(ac!=null) ac.close(); } catch(Exception e) { e.printStackTrace(); }
    }

    public void deleteAll() throws Exception {
        Connection conn = ds.getConnection(); //deleteAll은 트렌젝션이랑 별개라서 해당방법으로 커넥션가져옴
        String sql = "delete from a1";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.executeUpdate();
        close(pstmt);

    }
}

