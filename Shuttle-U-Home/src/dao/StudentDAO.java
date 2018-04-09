package dao;



import org.bson.Document;

import com.mongodb.BasicDBObject;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import bean.Booking;
import bean.Employee;
import bean.Student;

public class StudentDAO {
	private int id=5;
	public int createStudent(Student student){
		
		 try {
				MongoClient mongoclient = new MongoClient( "localhost" , 27017 );   
				MongoDatabase dbs=mongoclient.getDatabase("shuttle");
				System.out.println("connected to db");
				MongoCollection<Document> collection = dbs.getCollection("student");
				
				BasicDBObject query=new BasicDBObject();
				query.put("emailId",student.getEmailId());
				FindIterable<Document> cursor=collection.find(query);
				MongoCursor<Document> it = cursor.iterator();
				while(it.hasNext()){
					System.out.println("inside iterator");
					id=0;
					break;
							
				}
				if(id==5) {
				Document dbo=new Document();
				dbo.put("name",student.getName());
				dbo.put("address",student.getAddress());
				dbo.put("emailId",student.getEmailId());
				dbo.put("phoneNo",Long.toString(student.getPhoneNo()));
				dbo.put("password",student.getPassword());
				dbo.put("gender",student.getGender());
				collection.insertOne(dbo);
			    }
				else {
					System.out.println("user with "+student.getEmailId()+" already registered");
				}
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
		String waitTime="";
		String timestamp="";
				
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
			
			MongoCollection<Document> collection1 = dbs.getCollection("WaitingTime");
			FindIterable<Document> cursor1=collection1.find();
			MongoCursor<Document> it1 = cursor1.iterator();
			while(it1.hasNext()) {
				Document element=it1.next();
				waitTime=element.getString("waitTime");
				timestamp=element.getString("time");
				
				
						
			}
			

		}
		catch(Exception e) {
			System.out.println(e);
		}
		String[] data= {sname,address,waitTime,timestamp};
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
	public void cancel(String email) {
		MongoClient mongoclient = new MongoClient( "localhost" , 27017 );   
		MongoDatabase dbs=mongoclient.getDatabase("shuttle");
		MongoCollection<Document> collection = dbs.getCollection("booking");
		BasicDBObject query=new BasicDBObject();
		query.put("emailId",email);
		query.put("status","booked");
		collection.updateOne(query, new Document("$set", new Document("status", "cancelled")));
	}
	public int createEmployee(Employee emp) {
		
		MongoClient mongoclient = new MongoClient( "localhost" , 27017 );   
		MongoDatabase dbs=mongoclient.getDatabase("shuttle");
		System.out.println("connected to db");
		MongoCollection<Document> collection = dbs.getCollection("driver");
		
		BasicDBObject query=new BasicDBObject();
		query.put("email",emp.getEmailId());
		FindIterable<Document> cursor=collection.find(query);
		MongoCursor<Document> it = cursor.iterator();
		while(it.hasNext()){
			System.out.println("inside iterator");
			id=0;
			break;
					
		}
		if(id==5) {
		Document dbo=new Document();
		dbo.put("name",emp.getName());
		
		dbo.put("email",emp.getEmailId());
		
		dbo.put("password",emp.getPassword());
		dbo.put("phoneNo",Long.toString(emp.getPhoneNo()));
	
		collection.insertOne(dbo);
	    }
		else {
			System.out.println("user with "+emp.getEmailId()+" already registered");
		}
 
 
	  
return id;


	}
	
	
	public void addTripTime(int triptime) {
		String t=Integer.toString(triptime);
		DateFormat df1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		String sysdate1= df1.format(new java.util.Date());
		MongoClient mongoclient = new MongoClient( "localhost" , 27017 );   
		MongoDatabase dbs=mongoclient.getDatabase("shuttle");
		System.out.println("connected to db");
		MongoCollection<Document> collection = dbs.getCollection("WaitingTime");
		collection.updateOne(eq("name", "admin"), new Document("$set", new Document("waitTime", t)));
		collection.updateOne(eq("name", "admin"), new Document("$set", new Document("time", sysdate1)));
		
		
	}

}
