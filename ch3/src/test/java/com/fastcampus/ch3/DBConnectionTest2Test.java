//package com.fastcampus.ch3;
//
//import junit.framework.TestCase;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.GenericXmlApplicationContext;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import javax.sql.DataSource;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.Date;
//
//@RunWith(SpringJUnit4ClassRunner.class) //이게 있어서 ApplicationContext 객체를 만들지 않아도 생성해줌
//                                        //그러고 context.xml에 bean으로 DataSource의 내용을 정해주면 됌
//@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})//xml설정파일 위치 지정
//public class DBConnectionTest2Test extends TestCase {
//    @Autowired
//    DataSource ds; //Autowired 로 가져오려면 @RunWith과 @ContextConfiguration을 적어야한다.
//
//    //테스트메서드 : 테스트메서드의 경우 인스턴스 변수의 값을 공유하지 않는다~
//    @Test
//    public void insertUserTest() throws Exception{
//        //객체를 만든다음에
//        User user = new User("qwew","1111","abc","aaa@sas",new Date() ,"fb", new Date());
//
//        deleteAll();
//        //insert를 한다.
//        int rowCnt = insertUser(user);
//
//        assertTrue(rowCnt==1);
//
//    }
//
//    @Test
//    public void selectUserTest() throws Exception{
//        deleteAll(); //모든데이터를 삭제하고
//        //유저를 생성해서
//        User user = new User("qwew","1111","abc","aaa@sas",new Date() ,"fb", new Date());
//        int rowCnt = insertUser(user);
//        User user2 = selectUser("qwew");
//
//        assertTrue(user.getId().equals("qwew"));
//    }
//
//    @Test
////    public void deleteUserTest() throws Exception{
////        deleteAll();
////        int rowcnt= deleteUser("aaa");
////        assertTrue(rowcnt==0);//삭제하면 없으니까 0 반환
////        User user = new User("qwew","1111","abc","aaa@sas",new Date() ,"fb", new Date());
////
////        rowcnt = insertUser(user); //인서트성공시 1
////        assertTrue(rowcnt == 1);
////
////        rowcnt = deleteUser(user.getId()); //삭제성공시 1
////        assertTrue(rowcnt==1);
////
////        //위에서 지웠으니까 User selectUser(String id)는 null이여한다.
////        assertTrue(selectUser(user.getId())==null);
////
////    }
//    //매개변수로 받은 사용자 정보로 user_info 테이블을 update함.
//    public int updateUser(User user)throws Exception{
//        Connection conn = ds.getConnection();
//
//        String sql= "update user_info set pwd= ?, name= ?, email= ?, birth= ?,sns=?,reg_date=? "+
//                "where id=?";
//        PreparedStatement pstmt = conn.prepareStatement(sql);
//        pstmt.setString(1,user.getPwd());
//        pstmt.setString(2, user.getName());
//        pstmt.setString(3, user.getEmail());
//        pstmt.setDate(4, new java.sql.Date(user.getBirth().getTime()));
//        pstmt.setString(5,user.getSns());
//        pstmt.setTimestamp(6,new java.sql.Timestamp(user.getReg_date().getTime()));
//        pstmt.setString(7, user.getId());
//
//         return pstmt.executeUpdate();
//    }
//
//
// //   insert into user_info (id, pwd, name, email, birth, sns, reg_date)
////    values ('aaa', '1212', 'sksk', 'ee@eee.com', '2022-01-01', 'inst', now());
//
//
////    public int deleteUser(String id)throws Exception{ //아이디를 주면 아이디에 해당하는 유저삭제
////        Connection conn = ds.getConnection();
////
////        String sql = "delete from user_infod where id = ?";
////        PreparedStatement pstmt = conn.prepareStatement(sql); //sql injection 공격, 성능향상.
////        pstmt.setString(1, id);
////        //int rowCnt =  pstmt.executeUpdate();
////        // return rowCnt;
////        return pstmt.executeUpdate();
////
////    }
//
//
//
//    // 테이블 전부 읽어오기
//    public User selectUser(String id) throws Exception{
//        Connection conn = ds.getConnection();
//
//        String sql="select * from user_info where id= ?";
//
//        PreparedStatement pstmt = conn.prepareStatement(sql); //sql injection 공격, 성능향상.
//        pstmt.setString(1,id);
//        ResultSet rs = pstmt.executeQuery();
//
//        if(rs.next()){
//            User user = new User();
//            user.setId(rs.getString(1));
//            user.setPwd(rs.getString(2));
//            user.setName(rs.getString(3));
//            user.setEmail(rs.getString(4));
//            user.setBirth(new Date(rs.getDate(5).getTime()));
//            user.setSns(rs.getString(6));
//            user.setReg_date(new Date(rs.getDate(7).getTime()));
//
//            return user;
//        }
//
//
//        return null;
//    }
//
//    // 테이블의 내용을 전부삭제함.
//    private void deleteAll() throws Exception{
//        Connection conn = ds.getConnection();
//
//        String sql="delete from user_info";
//
//        PreparedStatement pstmt = conn.prepareStatement(sql); //sql injection 공격, 성능향상.
//         pstmt.executeUpdate();
//
//
//
//    }
//
//
//    //사용자정보를 user_info 에 저장하는 메서드
//    @Test
//    public void transactionTest() throws Exception{
//        //데이터베이스에 연결을 해야겠지?
//        Connection conn=null;
//        try {
//            deleteAll();
//             conn = ds.getConnection();
//             conn.setAutoCommit(false);
//
////        insert into user_info (id, pwd, name, email, birth, sns, reg_date)
////        values ('aaa', '1212', 'sksk', 'ee@eee.com', '2022-01-01', 'inst', now());
//
//            String sql="insert into user_info values (?, ?, ?, ?, ?, ?, now());";
//
//            PreparedStatement pstmt = conn.prepareStatement(sql); //sql injection 공격, 성능향상.
//            pstmt.setString(1, "asdf");
//            pstmt.setString(2, "asdf");
//            pstmt.setString(3, "asdf");
//            pstmt.setString(4,"asdf");
//            pstmt.setDate(5, new java.sql.Date(new D.getTime()));
//            pstmt.setString(6, "fb");
//
//            int rowCnt = pstmt.executeUpdate();
//
//            pstmt.setString(1,"asdf1");
//
//            rowCnt =pstmt.executeUpdate();
//
//            conn.commit();
//            //실패면 0이 반환된다.
//            } catch (Exception e) {
//                conn.rollback();
//            }finally {
//
//            }
//    }
//
//    public void insertUser() throws Exception{
//        //데이터베이스에 연결을 해야겠지?
//        Connection conn=null;
//        try {
//            deleteAll();
//            conn = ds.getConnection();
//            conn.setAutoCommit(false);
//
////        insert into user_info (id, pwd, name, email, birth, sns, reg_date)
////        values ('aaa', '1212', 'sksk', 'ee@eee.com', '2022-01-01', 'inst', now());
//
//            String sql="insert into user_info values (?, ?, ?, ?, ?, ?, now());";
//
//            PreparedStatement pstmt = conn.prepareStatement(sql); //sql injection 공격, 성능향상.
//            pstmt.setString(1, "asdf");
//            pstmt.setString(2, "asdf");
//            pstmt.setString(3, "asdf");
//            pstmt.setString(4,"asdf");
//            pstmt.setDate(5, new java.sql.Date(user.getD));
//            pstmt.setString(6, "fb");
//
//            int rowCnt = pstmt.executeUpdate();
//
//            pstmt.setString(1,"asdf1");
//
//            rowCnt =pstmt.executeUpdate();
//
//            conn.commit();
//            //실패면 0이 반환된다.
//        } catch (Exception e) {
//            conn.rollback();
//        }finally {
//
//        }
//
//    @Test //메서드 이름은 아무꺼나해도상관없음
//    public void testspringJdbcConnectionTest() throws Exception{
//
////        ApplicationContext ac = new GenericXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/**/root-context.xml");
////        DataSource ds = ac.getBean(DataSource.class);
//
//        Connection conn = ds.getConnection(); // 데이터베이스의 연결을 얻는다.
//
//        System.out.println("conn = " + conn);
//
//        //중요 asserTrue가 꼭 들어가야한다.테스트의 성공여부를 확인하기위함
//        assertTrue(conn!=null); //괄호안의 조건식이 true면 테스트 성공 아니면 실패
//
//
//    }
//}