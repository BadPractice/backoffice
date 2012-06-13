package mydefault;

import interfaces.DataAccessable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import dataobjects.Buchung;
import dataobjects.Contact;
import dataobjects.Offer;
import dataobjects.Rechnung;


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

	public boolean addContact(Contact argContact) {
		PreparedStatement cmd= null;
		try {
			cmd = db.prepareStatement("INSERT INTO kontakt (vname, nname, telephon, anfang, kunde) VALUES (?, ?, ?, ?, ?)");
			cmd.setString(1, argContact.getName());
			cmd.setString(2, argContact.getNName());
			cmd.setString(3, argContact.getPhone());
			cmd.setDate(4, argContact.getDate());
			cmd.setBoolean(5, argContact.isCustomer());
			cmd.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean updateContact(Contact argContact){ //on database error return 1
		PreparedStatement cmd= null;
			String myStatement = new String("Update kontakt " +
										" Set vname = ?, " +
										" nname = ?, " +
										" telephon = ?, " +
										" anfang = ? ," +
										" kunde = ? " +
										" WHERE id = ?");
			try {
				cmd = db.prepareStatement(myStatement );
			
			cmd.setString(1, argContact.getName());
			cmd.setString(2, argContact.getNName());
			cmd.setString(3, argContact.getPhone());
			cmd.setDate(4, argContact.getDate());
			cmd.setBoolean(5, argContact.isCustomer());
			cmd.setInt(6, argContact.getId());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				cmd.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
					mycontact = new Contact();
					mycontact.setId(rd.getInt(1));
					mycontact.setName(rd.getString(2));
					mycontact.setNName(rd.getString(3));
					mycontact.setPhone(rd.getString(4));
					mycontact.setDate(rd.getDate(5));
					mycontact.setCustomer(rd.getBoolean(6));
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
	
	

	@Override
	public boolean addOffer(Offer argOffer) {
		PreparedStatement cmd= null;
		try {
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
											"Set chance = ?, " +
											" sum = ?, " +
											" date = ?, " +
											" duration = ?, " +
											" customerid = ?, " +
											" projectid = ? " +
											" WHERE id = ?");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
			cmd.setFloat(1, argOffer.getChance());
			
				cmd.setFloat(2, argOffer.getSum());
			
			cmd.setDate(3, argOffer.getDate());
			cmd.setString(4, argOffer.getDuration());
			cmd.setInt(5, argOffer.getCustomerId());
			cmd.setInt(6, argOffer.getProjectId());
			cmd.setInt(7, argOffer.getId());
} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		

			try {
				cmd.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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

	@Override
	public boolean addInRechnung(Rechnung argContact) {
		addRechnung(argContact, 0);
		return true;
	}

	@Override
	public boolean addOutRechnung(Rechnung argContact) {
		addRechnung(argContact,1);
		return true;
	}

	@Override
	public boolean deleteInRechnung(Rechnung row) {
		deleteRechnung(row,0);
		return true;
	}

	@Override
	public boolean deleteOutRechnung(Rechnung row) {
		deleteRechnung(row,1);
		return true;
	}

	@Override
	public Vector<Rechnung> getOutRechnung() {
		return  getRechnung(1);
	}

	@Override
	public boolean updateInRechnung(Rechnung argContact) {
		return updateRechnung(argContact,0);
	}

	@Override
	public boolean updateOutRechnung(Rechnung argContact) {
		return updateRechnung(argContact,1);		
	}
	
	@Override
	public Vector<Rechnung> getInRechnung() {
		return getRechnung(0);
	}

	public Vector<Rechnung> getRechnung(Integer arg) {
		PreparedStatement cmd= null;
		Rechnung myoffer = null;
		Vector<Rechnung> result= new Vector<Rechnung>();
			try {
				cmd = db.prepareStatement("Select id, sum, date  FROM "+ rechnungType(arg)+" ORDER BY id");
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
					myoffer = new Rechnung();
					myoffer.setId(rd.getInt(1));
					myoffer.setSum(rd.getInt(2));
					myoffer.setDate(rd.getDate(3));
					result.add(myoffer);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		return result;
	}

	public boolean addRechnung(Rechnung argRechnung,Integer argType) {
		PreparedStatement cmd= null;
		try {
			cmd = db.prepareStatement("INSERT INTO "+ rechnungType(argType)+"(sum, date) VALUES (?, ?)");
			cmd.setInt(1, argRechnung.getSum());
			cmd.setDate(2, argRechnung.getDate());
			cmd.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	private boolean updateRechnung(Rechnung argRechnung, Integer argType){
		PreparedStatement cmd= null;
		try {
			cmd = db.prepareStatement("Update"+ rechnungType(argType) +
										"Set sum = ? " +
										"AND date = ? " +
										" WHERE id = ?");
			cmd.setInt(1, argRechnung.getSum());
			cmd.setDate(2, argRechnung.getDate());
			cmd.setInt(3, argRechnung.getId());
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
	
	public boolean deleteRechnung(Rechnung argRechnung, Integer argType) {
		PreparedStatement cmd= null;
		try {
			cmd = db.prepareStatement("Delete from "+rechnungType(argType)+" where id = ?");
			cmd.setInt(1, argRechnung.getId());
			cmd.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	private String rechnungType(Integer arg){
		switch(arg)
		{
			case 0:
				return "inrechnung";
			case 1:
				return "outrechnung";
			default:
				return null;
		}
	}


	@Override
	public boolean addInBuchung(Buchung argContact) {
		addBuchung(argContact, 0);
		return true;
	}

	@Override
	public boolean addOutBuchung(Buchung argContact) {
		addBuchung(argContact,1);
		return true;
	}

	@Override
	public boolean deleteInBuchung(Buchung row) {
		deleteBuchung(row,0);
		return true;
	}

	@Override
	public boolean deleteOutBuchung(Buchung row) {
		deleteBuchung(row,1);
		return true;
	}

	@Override
	public Vector<Buchung> getOutBuchung() {
		return  getBuchung(1);
	}

	@Override
	public boolean updateInBuchung(Buchung argContact) {
		return updateBuchung(argContact,0);
	}

	@Override
	public boolean updateOutBuchung(Buchung argContact) {
		return updateBuchung(argContact,1);		
	}
	
	@Override
	public Vector<Buchung> getInBuchung() {
		return getBuchung(0);
	}

	public Vector<Buchung> getBuchung(Integer arg) {
		PreparedStatement cmd= null;
		Buchung myoffer = null;
		Vector<Buchung> result= new Vector<Buchung>();
			try {
				cmd = db.prepareStatement("Select id, sum, date, rechnungid  FROM "+ buchungType(arg)+" ORDER BY id");
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
					myoffer = new Buchung();
					myoffer.setId(rd.getInt(1));
					myoffer.setSum(rd.getInt(2));
					myoffer.setDate(rd.getDate(3));
					myoffer.setRechnungId(rd.getInt(4));
					result.add(myoffer);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		return result;
	}

	public boolean addBuchung(Buchung argBuchung,Integer argType) {
		PreparedStatement cmd= null;
		try {
			System.out.println(argBuchung.getSum()+" "+argBuchung.getDate()+" "+argBuchung.getRechnungId());
			cmd = db.prepareStatement("INSERT INTO "+ buchungType(argType)+
					" (sum, date, rechnungid) VALUES (?, ?, ?)");
			cmd.setInt(1, argBuchung.getSum());
			cmd.setDate(2, argBuchung.getDate());
			cmd.setInt(3, argBuchung.getRechnungId());
			cmd.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	private boolean updateBuchung(Buchung argBuchung, Integer argType){
		PreparedStatement cmd= null;
		try {
			cmd = db.prepareStatement("Update"+ buchungType(argType) +
										"Set sum = ? " +
										"AND date = ? " +
										"And rechnungid = ?" +
										" WHERE id = ?");
			cmd.setInt(1, argBuchung.getSum());
			cmd.setDate(2, argBuchung.getDate());
			cmd.setInt(3, argBuchung.getRechnungId());
			cmd.setInt(4, argBuchung.getId());
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
	
	public boolean deleteBuchung(Buchung arg, Integer argType) {
		PreparedStatement cmd= null;
		try {
			cmd = db.prepareStatement("Delete from "+buchungType(argType)+" where id = ?");
			cmd.setInt(1, arg.getId());
			cmd.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	private String buchungType(Integer arg){
		switch(arg)
		{
			case 0:
				return "inbuchung";
			case 1:
				return "outbuchung";
			default:
				return null;
		}
	}


}
