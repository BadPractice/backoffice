package mydefault;

import interfaces.DataAccessable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import dataobjects.Contact;
import dataobjects.Offer;


public class MysqlDatabase implements DataAccessable {
	Connection db = null;
	public MysqlDatabase(){
		try {
			db = DriverManager.getConnection("jdbc:mysql://localhost/backoffice","java","java");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Cannot connect to Database!");
		}
	}

	public boolean updateContact(Contact argContact){ //on database error return 1
		PreparedStatement cmd= null;
		try {
			cmd = db.prepareStatement("Update kontakt " +
										"Set vname = ? " +
										"AND nname = ? " +
										"AND telephon = ? " +
										"AND date = ?" +
										" WHERE id = ?");
			cmd.setString(1, argContact.getName());
			cmd.setString(2, argContact.getNName());
			cmd.setString(3, argContact.getPhone());
			cmd.setDate(4, argContact.getDate());
			cmd.setInt(5, argContact.getId());
		} catch (SQLException e) {
			return false; //Database error
		}
		try {
			cmd.executeUpdate();

		} catch (SQLException e) {
			return false;//Database error
		}
		return true;
	}

	@Override
	public Vector<Contact> getContact() {
		PreparedStatement cmd= null;
		Contact mycontact = null;
		Vector<Contact> result= new Vector<Contact>();		
			try {
				cmd = db.prepareStatement("Select *  FROM kontakt ORDER BY id");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ResultSet rd = null;
			try {
				rd = cmd.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				while(rd.next())
				{
					System.out.println(rd.getInt(1)+rd.getString(2)+rd.getString(3)+rd.getDate(5));
					mycontact = new Contact();
					mycontact.setId(rd.getInt(1));
					mycontact.setName(rd.getString(2));
					mycontact.setNName(rd.getString(3));
					mycontact.setPhone(rd.getString(4));
					mycontact.setDate(rd.getDate(5));
					result.add(mycontact);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return result;
	}
	
	@Override
	public boolean deleteContact(Contact argContact) {
		PreparedStatement cmd= null;
		try {
			//cmd = db.prepareStatement("Delete from [kontakt] where [id] = ?");
			cmd = db.prepareStatement("Delete from kontakt where id = ?");
			cmd.setInt(1, argContact.getId());
			cmd.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	public boolean addContact(Contact argContact) {
		PreparedStatement cmd= null;
		try {
			//cmd = db.prepareStatement("INSERT INTO [kontakt] ([vname], [nname], [telephon], [anfang]) VALUES (?, ?, ?, ?)");
			cmd = db.prepareStatement("INSERT INTO kontakt (vname, nname, telephon, anfang) VALUES (?, ?, ?, ?)");
			System.out.println(argContact.getName()+argContact.getNName()+argContact.getPhone());
			cmd.setString(1, argContact.getName());
			cmd.setString(2, argContact.getNName());
			cmd.setString(3, argContact.getPhone());
			cmd.setDate(4, argContact.getDate());
			cmd.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean addOffer(Offer argOffer) {
		PreparedStatement cmd= null;
		try {
			//cmd = db.prepareStatement("INSERT INTO [kontakt] ([vname], [nname], [telephon], [anfang]) VALUES (?, ?, ?, ?)");
			cmd = db.prepareStatement("INSERT INTO offer (chance, sum, date, duration, customerid, projectid) VALUES (?, ?, ?, ?, ?, ?)");
			cmd.setFloat(1, argOffer.getChance());
			cmd.setInt(2, argOffer.getSum());
			cmd.setDate(3, argOffer.getDate());
			cmd.setString(4, argOffer.getDuration());
			cmd.setInt(5,argOffer.getProjectId());
			cmd.setInt(6,argOffer.getCustomerId());
			cmd.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteOffer(Offer argOffer) {
		PreparedStatement cmd= null;
		try {
			//cmd = db.prepareStatement("Delete from [kontakt] where [id] = ?");
			cmd = db.prepareStatement("Delete from offer where id = ?");
			cmd.setInt(1, argOffer.getId());
			cmd.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean updateOffer(Offer argOffer) {
		PreparedStatement cmd= null;
		try {
			cmd = db.prepareStatement("Update offer " +
										"Set chance = ? " +
										"AND summe = ? " +
										"AND datum = ? " +
										"AND dauer = ?" +
										"AND kundenid = ?" +
										"AND projektid = ?" +
										" WHERE id = ?");
			cmd.setFloat(1, argOffer.getChance());
			cmd.setFloat(2, argOffer.getSum());
			cmd.setDate(3, argOffer.getDate());
			cmd.setString(4, argOffer.getDuration());
			cmd.setInt(5, argOffer.getCustomerId());
			cmd.setInt(6, argOffer.getProjectId());
			cmd.setInt(7, argOffer.getId());
		} catch (SQLException e) {
			return false; //Database error
		}
		try {
			cmd.executeUpdate();

		} catch (SQLException e) {
			return false;//Database error
		}
		return true;
	}
	
	public Vector<Offer> getOffer() {
		PreparedStatement cmd= null;
		Offer myoffer = null;
		Vector<Offer> result= new Vector<Offer>();
			try {
				cmd = db.prepareStatement("Select *  FROM offer ORDER BY id");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ResultSet rd = null;
			try {
				rd = cmd.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				while(rd.next())
				{
					//System.out.println(rd.getInt(2));
					myoffer = new Offer();
					myoffer.setId(rd.getInt(1));
					myoffer.setChance(rd.getFloat(3));
					myoffer.setSum(rd.getInt(2));
					myoffer.setDate(rd.getDate(4));
					myoffer.setDuration(rd.getString(5));
					myoffer.setProjectId(rd.getInt(6));
					myoffer.setCustomerId(rd.getInt(7));
					result.add(myoffer);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return result;
	}

}