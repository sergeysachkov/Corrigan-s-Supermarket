
package com.ait.corrigan.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ait.corrigan.models.shop.Category;
import java.sql.Statement;

public class CategoryDAOImpl implements CategoryDao {
	   @Override
	    public long getNewId() throws SQLException {
	        String sql = "SELECT cateID FROM Categories ORDER BY cateID DESC LIMIT 1";
	        Connection con = DaoUtil.getConnection();
	        Statement st = con.createStatement();
	        ResultSet rs = st.executeQuery(sql);
	        if (rs.next()) {
	            long id = rs.getLong(1);
	            con.close();
	            return ++id;
	        } else {
	            con.close();
	            return 1;
	        }
	    }
	   @Override
	      public void addCategory(long id, String name) throws SQLException {
	        String sql = "INSERT INTO Categories (cateID, cate_name) VALUES (?,?)";
	        Connection con = DaoUtil.getConnection();
	       PreparedStatement pst = con.prepareStatement(sql);
	       pst.setLong(1, id);
	       pst.setString(2, name);
	       pst.executeUpdate();
	       con.close();
	    }
	   
		@Override
		public void updateCategory(Category category) throws SQLException {
			 String sql="UPDATE Categories SET "
		                + "cateID=?,cate_name=?"
		                + "WHERE cateID=?";
		        Connection con=DaoUtil.getConnection();
		        PreparedStatement pst=con.prepareCall(sql);
		        pst.setLong(1, category.getCateID());
		        pst.setString(2, category.getCate_name());
		        pst.executeUpdate();
		        con.close();
		        
			
		}
		
		  @Override
		
	    public void deleteCategory(long categoryId) throws SQLException {
	    	//String sql = "DELETE FROM Categories (cateID, cate_name) VALUES (?,?) Where (cateID= ?)";
	    	// Connection con = DaoUtil.getConnection();
	        // PreparedStatement pst = con.prepareStatement(sql);
	        // pst.setLong(1, categoryId);       
	        // pst.executeUpdate();
	         //con.close();
	       // Category category = null;
	   	   // try(Connection connection = DaoUtil.getConnection();
	 	   // PreparedStatement stmt=connection.prepareStatement("DELETE FROM Categories WHERE cateID=? "
	 	   //  ,Statement.RETURN_GENERATED_KEYS)){
	   	   //stmt.setLong(1, categoryId); 
	       //stmt.executeUpdate();
	       //} catch (SQLException ex) {
	       // System.err.println("\nSQLException");
	       //ex.printStackTrace();
	       //}
			    String sql="DELETE FROM Categories WHERE  cateID=?";
		        Connection con=DaoUtil.getConnection();
		        PreparedStatement pst=con.prepareCall(sql);
		        pst.setLong(1, categoryId);
		        pst.executeUpdate();
		        con.close();
	   		  
	   		  
	   	  }
	    

	    @Override
	    public List<Category> getAllCategories() throws SQLException {

	        List<Category> allCategories = new ArrayList<Category>();
	        Category cat = null;
	        Connection con = null;
	        try {
	            con = DaoUtil.getConnection();
	            //we may also want the id of the categories
	            String sql = "select * from Categories";

	            PreparedStatement pstmt = con.prepareStatement(sql);
	            ResultSet rs = pstmt.executeQuery();
	            while (rs.next()) {
	                cat = new Category(rs.getInt(1),rs.getString(2));
	                allCategories.add(cat);
	            }

	        } catch (SQLException e) {

	            e.printStackTrace();
	        } finally {
	            con.close();
	        }
	        return allCategories;

	    }


	    //@Override
	  //  public void deleteCategory(long categoryId) throws SQLException {
	    //	String sql = "DELETE FROM Categories (cateID, cate_name) VALUES (?,?) Where (cateID= ?)";
	    	// Connection con = DaoUtil.getConnection();
	        // PreparedStatement pst = con.prepareStatement(sql);
	         //pst.setLong(1, categoryId);       
	         //pst.executeUpdate();
	         //con.close();
	    //}

	    //@Override
	   // public void updateCategory(long id, String name) throws SQLException {
	    	//String sql = "UPDATE FROM Categories (cateID, cate_name) VALUES (?,?) Where (cateID= ?)";
	    	// Connection con = DaoUtil.getConnection();
	         //PreparedStatement pst = con.prepareStatement(sql);
	        // pst.setLong(1, id);
	        // pst.setString(2, name);
	         //pst.executeUpdate();
	        // con.close();
	   // }



 
    @Override
    public void addCategory(Category category ) throws SQLException {
    	 String sql="INSERT INTO Categories (cateID, cate_name) VALUES (?,?)";
         Connection con =DaoUtil.getConnection();
         PreparedStatement pst=con.prepareStatement(sql);
         pst.setLong(1, category.getCateID());
         pst.setString(2,category.getCate_name() );
         pst.executeUpdate();
         con.close();
    }
    
    


    @Override
    public void updateCategory(long id, String name) throws SQLException {
    	//String sql = "UPDATE FROM Categories (cateID, cate_name) VALUES (?,?) Where (cateID= ?)";
    	 //Connection con = DaoUtil.getConnection();
         //PreparedStatement pst = con.prepareStatement(sql);
         //pst.setLong(1, id);
         //pst.setString(2, name);
         //pst.executeUpdate();
         //con.close();
    	  Category category = null;
    	  try(Connection connection = DaoUtil.getConnection();
  	            PreparedStatement stmt=connection.prepareStatement("UPDATE FROM Categories WHERE cateID=? "
  	                    ,Statement.RETURN_GENERATED_KEYS)) {
  	           
  	            stmt.executeUpdate();
  	        } catch (SQLException e) {
  				// TODO Auto-generated catch block
  				e.printStackTrace();
  			}
  	       
    	//To change body of generated methods, choose Tools | Templates.
    }


 


   
    @Override
    public Category getCategory(long categoryId) throws SQLException {
    	
    	Category category = null;
//鹏哥你可以的，你家的查询语句长这样
//    	String sql = "SELECT FROM Categories (cateID, cate_name) VALUES (?,?) Where (cateID= ?)";
        String sql="SELECT * FROM Categories WHERE cateID=?";
   	    Connection con = DaoUtil.getConnection();
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setLong(1, categoryId);
//聂鹏我真服了你
//        pst.executeUpdate();
//        con.close();
        ResultSet rs=pst.executeQuery();
        if(rs.next()){
            category=new Category(rs.getInt(1), rs.getString(2));
        }
        con.close();
        return category;
    	
    }


}

