package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;

import db.DBConnection;

public class GetItemInformation {
	Integer type=-1;
	BufferedImage img ;
	String info=""; 
	Integer imgId;
	Integer userId;
	public GetItemInformation(Integer id) {
		this.imgId=id ;
		
	}
  public Item getinfo() throws SQLException
  {
	  
	  Connection conn =DBConnection.getActiveConnection();
	  if(conn!=null)
		{
		    String sql="SELECT * FROM facehub.reports where photoId="+imgId;
			PreparedStatement stmt ;
			stmt =conn.prepareStatement(sql);
			ResultSet resultSet= stmt.executeQuery();
			while(resultSet.next())
			{
				  type =resultSet.getInt("reportType");
				 userId =resultSet.getInt("userID");
				 info= resultSet.getString("info");
			}
			
			String path="";
			System.out.println(type);
			System.out.println(userId);
			System.out.println(info);
			
			if(type==1)
			{
				path="E:/FCI/missing/"+imgId+".png";
			}
			else if(type==2)
			{
				path="E:/FCI/found/"+imgId+".png";
			}
//			img= null;
//			try {
//			    img = ImageIO.read(new File(path));
//			} catch (IOException e) {
//			}
			conn.close();
			stmt.close();
			Item item=new Item(type, path, info, imgId, userId);
			return item;
		}
		else
		{
			return null;
		}
  }
	
	public void getImage()
	{
		
	}	
}