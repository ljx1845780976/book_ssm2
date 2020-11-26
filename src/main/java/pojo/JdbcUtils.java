//package pojo;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import com.alibaba.druid.pool.DruidDataSourceFactory;
//
//import java.io.FileInputStream;
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.Properties;
//
///**  创建与数据库的druid连接池
// *
// **/
//public class JdbcUtils {
//    private static DruidDataSource dataSource;
//    private static ThreadLocal<Connection> threadLocal=new ThreadLocal<>();
//    static {
//        Properties properties= null;
//        try {
//            properties = new Properties();
//            properties.load(new FileInputStream("D:\\code\\Web\\book\\src\\druid.properties") );
//            dataSource= (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//   public static Connection getConnection() {
//       Connection connection = threadLocal.get();//如果返回null则获取连接失败
//       if (connection == null) {
//           try {
//               connection = dataSource.getConnection();
//               threadLocal.set(connection);//保存到threadLocal对象供后面的jdbc操作使用
//               connection.setAutoCommit(false); //设置手动管理事务
//           } catch (Exception e) {
//               e.printStackTrace();
//           }
//       }
//       return connection;
//   }
//   // 提交事务并关闭连接
//   public static void commitAndClose(){
//        Connection connection=threadLocal.get();
//        if(connection!=null){ //如果不等于null 说明之前使用过连接
//            try {
//                connection.commit();
//
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }finally {
//                try {
//                    connection.close();
//                } catch (SQLException throwables) {
//                    throwables.printStackTrace();
//                }
//
//            }
//            }
//        threadLocal.remove();//一定要执行remove操作，使连接和线程解绑，因为tomcat服务器底层使用线程池技术
//
//   }
//   //回滚并关闭连接
//   public static void rollbackAndClose(){
//        Connection connection=threadLocal.get();
//        if(connection!=null){ //如果不等于null 说明之前使用过连接
//            try {
//                connection.rollback();
//
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }finally {
//                try {
//                    connection.close();
//                } catch (SQLException throwables) {
//                    throwables.printStackTrace();
//                }
//
//            }
//            }
//        threadLocal.remove();//一定要执行remove操作，否则出错，因为tomcat服务器底层使用线程池技术
//
//   }
//
//}
