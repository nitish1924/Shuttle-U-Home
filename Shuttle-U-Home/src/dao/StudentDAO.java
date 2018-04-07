package dao;



import org.bson.Document;

import com.mongodb.BasicDBObject;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import bean.Booking;
import bean.Student;

public class StudentDAO {
	private int id=5;
	/*private String name;
	private String address;
	private String emailId;
	private String phoneNo;
	private String password;
	private String gender;*/
	public int createStudent(Student student){
		/*name=student.getName();
		address=student.getAddress();
		emailId=student.getEmailId();
		phoneNo=Long.toString(student.getPhoneNo());
		password=student.getPassword();
		gender=student.getGender();
		System.out.println("Testing data received:"+name+address+gender+emailId);*/
		
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
	public String[] loginOTP(String email,String otp) {
		
		String sname="1234";
		String address="";
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
				address=element.getString("address");
				System.out.println(sname);
						
			}
			

		}
		catch(Exception e) {
			System.out.println(e);
		}
		String[] data= {sname,address};
		return data;
	}
	public void createBooking(Booking book) {
		try {
			MongoClient mongoclient = new MongoClient( "localhost" , 27017 );   
			MongoDatabase dbs=mongoclient.getDatabase("shuttle");
			System.out.println("connected to db");
			MongoCollection<Document> collection = dbs.getCollection("booking");
			Document dbo=new Document();
			dbo.put("name",book.getName());
			dbo.put("address",book.getAddress());
			dbo.put("emailId",book.getEmail());
			dbo.put("status","booked");
			dbo.put("date",book.getDate());
			collection.insertOne(dbo);
		    }
	 
		    catch(Exception e) {
		    	System.out.println(e);
		    }
		
	}
	public String driverLogin(String email, String password) {
		
		
		String sname="1234";
		try {
			MongoClient mongoclient = new MongoClient( "localhost" , 27017 );   
			MongoDatabase dbs=mongoclient.getDatabase("shuttle");
			MongoCollection<Document> collection = dbs.getCollection("driver");
			BasicDBObject query=new BasicDBObject();
			query.put("email",email);
			query.put("password",password);
			FindIterable<Document> cursor=collection.find(query);
			MongoCursor<Document> it = cursor.iterator();
			while(it.hasNext()){
				Document element=it.next();
				sname=element.getString("name");
				System.out.println(sname);
						
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		System.out.println("driver:"+sname);
		
		return sname;
		
	}
	public ArrayList<Booking> createList(String dname) {
		ArrayList<Booking> book=new ArrayList<Booking>();
		try {
			
			String sname="";
			String email="";
			String address="";
			String status="travelled";
			MongoClient mongoclient = new MongoClient( "localhost" , 27017 );   
			MongoDatabase dbs=mongoclient.getDatabase("shuttle");
			MongoCollection<Document> collection = dbs.getCollection("booking");
			BasicDBObject query=new BasicDBObject();
			query.put("status","booked");
			FindIterable<Document> a=collection.find(query).sort(new Document("_id",1)).limit(9);
			MongoCursor<Document> it = a.iterator();
			while(it.hasNext()){
				Booking b=new Booking();
				Document element=it.next();
				sname=element.getString("name");
				email=element.getString("emailId");
				address=element.getString("address");
				b.setName(sname);
				b.setAddress(address);
				b.setEmail(email);
				book.add(b);
				System.out.println(" booking list:"+sname+" "+email+" "+address);
				collection.updateOne(eq("_id", element.get("_id")), new Document("$set", new Document("driver", dname)));
				collection.updateOne(eq("_id", element.get("_id")), new Document("$set", new Document("status", status)));
				
						
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return book;
		
	}
	public ArrayList<Booking> viewbooklist(String email) {
		String date="";
		String address="";
		String status="";
		ArrayList<Booking> book=new ArrayList<Booking>();
		try {
			MongoClient mongoclient = new MongoClient( "localhost" , 27017 );   
			MongoDatabase dbs=mongoclient.getDatabase("shuttle");
			MongoCollection<Document> collection = dbs.getCollection("booking");
			BasicDBObject query=new BasicDBObject();
			query.put("emailId",email);
			
			FindIterable<Document> a=collection.find(query).sort(new Document("_id",-1)).limit(5);
			MongoCursor<Document> it = a.iterator();
			while(it.hasNext()){
				Document element=it.next();
				date=element.getString("date");
				address=element.getString("address");
				status=element.getString("status");
				Booking b=new Booking();
				b.setAddress(address);
				b.setDate(date);
				b.setStatus(status);
				book.add(b);
				
						
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return book;
	}

}
