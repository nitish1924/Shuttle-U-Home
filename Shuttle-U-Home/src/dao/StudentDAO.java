package dao;



import org.bson.Document;

import com.mongodb.BasicDBObject;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;

import bean.Student;

public class StudentDAO {
	private int id=5;
	private String name;
	private String address;
	private String emailId;
	private String phoneNo;
	private String password;
	private String gender;
	public int createStudent(Student student){
		name=student.getName();
		address=student.getAddress();
		emailId=student.getEmailId();
		phoneNo=Long.toString(student.getPhoneNo());
		password=student.getPassword();
		gender=student.getGender();
		System.out.println("Testing data received:"+name+address+gender+emailId);
		
		 try {
				MongoClient mongoclient = new MongoClient( "localhost" , 27017 );   
				MongoDatabase dbs=mongoclient.getDatabase("shuttle");
				System.out.println("connected to db");
				MongoCollection<Document> collection = dbs.getCollection("student");
				Document dbo=new Document();
				dbo.put("name",student.getName());
				dbo.put("address",student.getAddress());
				dbo.put("emailId",student.getEmailId());
				dbo.put("phoneNo",Long.toString(student.getPhoneNo()));
				dbo.put("password",student.getPassword());
				dbo.put("gender",student.getGender());
				collection.insertOne(dbo);
			    }
		 
			    catch(Exception e) {
			    	System.out.println(e);
			    }
		return id;
		
	}
	public String login(String emailId, String password) {
		String sname="1234";
		try {
			MongoClient mongoclient = new MongoClient( "localhost" , 27017 );   
			MongoDatabase dbs=mongoclient.getDatabase("shuttle");
			MongoCollection<Document> collection = dbs.getCollection("student");
			BasicDBObject query=new BasicDBObject();
			query.put("emailId",emailId);
			query.put("password",password);
			FindIterable<Document> cursor=collection.find(query);
			MongoCursor<Document> it = cursor.iterator();
			while(it.hasNext()) {
				Document element=it.next();
				sname=element.getString("name");
				System.out.println(sname);
						
			}
			

		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return sname;
	}
	public void insertOTP(String otp, String email) {
		MongoClient mongoclient = new MongoClient( "localhost" , 27017 );   
		MongoDatabase dbs=mongoclient.getDatabase("shuttle");
		MongoCollection<Document> collection = dbs.getCollection("student");
		collection.updateOne(eq("emailId", email), new Document("$set", new Document("otp", otp)));
		
	}
	public String loginOTP(String email,String otp) {
		
		String sname="1234";
		try {
			MongoClient mongoclient = new MongoClient( "localhost" , 27017 );   
			MongoDatabase dbs=mongoclient.getDatabase("shuttle");
			MongoCollection<Document> collection = dbs.getCollection("student");
			BasicDBObject query=new BasicDBObject();
			query.put("emailId",email);
			query.put("otp",otp);
			FindIterable<Document> cursor=collection.find(query);
			MongoCursor<Document> it = cursor.iterator();
			while(it.hasNext()) {
				Document element=it.next();
				sname=element.getString("name");
				System.out.println(sname);
						
			}
			

		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return sname;
	}

}
