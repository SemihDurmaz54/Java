package tempProject;
import java.sql.*;
public class DBConnection {
	private Connection con;
	private Statement st;
	private ResultSet rs;
    private static final String DELETE = "DELETE FROM users WHERE tc=?";
	
	public DBConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/deneme1","root","");
			st = con.createStatement();
			System.out.println("Ba�land�m");
		}
		catch(Exception e) {
			e.getStackTrace();
			System.out.println("Ba�lanamad�m");
		}
	}

	public void stokBilgisi()	//t�m stok bilgisini yazd�r�r
	{
		try {
			String query = "select * from cam1";
			rs = st.executeQuery(query);
			System.out.println("\nStok Durumu");
			
			while(rs.next()) {
			String name = rs.getString("camT�r�");
			int sto = rs.getInt("miktar");
			System.out.println("�r�n ismi: "+name+		"	 Stok: "+sto);}
			rs = st.executeQuery(query);						
		}
		catch(Exception e) {
			System.out.println("Hata");
		}
	}		
			
public void ürünEkle(String isim, int sayi) // belirlenen �r�n� ve miktar� sto�a ekler
	{ 
			try {
				int stok=0;
				System.out.println("\nEklenecek �r�n: "+isim+" \nEklenecek miktar: "+ sayi);
				String query = "SELECT miktar FROM cam1 WHERE camT�r�='" + isim + "'" ;
				rs = st.executeQuery(query);
				while(rs.next()) {
					stok = rs.getInt("miktar") ;
					System.out.println("Stok durumu:"+stok);				
					}
				String sqlUpdate = "UPDATE cam1 " + "SET miktar = ? " + "WHERE camT�r� = ?";
				PreparedStatement pstmt = con.prepareStatement(sqlUpdate);	
			//	String t�r = isim;
				int miktar = (sayi+stok);
				System.out.println("Ba�ar�yla eklendi");
				System.out.println("Yeni stok:"+miktar);
				 
				pstmt.setString(2, isim);
				pstmt.setInt(1, miktar);
				int rowAffected = pstmt.executeUpdate();
				pstmt.close();
				
			}
			
			catch(Exception e) {
				System.out.println("Hata");
			}		
		}
		
	public void ürünSil(String isim, int sayi) {

				try {
					int stok=0;
					System.out.println("\nSilinecek �r�n:"+isim+" \nSilinecek miktar:"+ sayi);
					String query = "SELECT miktar FROM cam1 WHERE camT�r�='" + isim + "'" ;
					rs = st.executeQuery(query);
					while(rs.next()) {
						stok = rs.getInt("miktar") ;
						System.out.println("Stok durumu:"+stok);
					}
					String sqlUpdate = "UPDATE cam1 " + "SET miktar = ? " + "WHERE camT�r� = ?";
					PreparedStatement pstmt = con.prepareStatement(sqlUpdate);	
				//	String t�r = isim;
					int miktar = (stok-sayi);
					System.out.println("Ba�ar�yla silindi");
					System.out.println("Yeni stok:"+miktar);
					 
					pstmt.setString(2, isim);
					pstmt.setInt(1, miktar);
					int rowAffected = pstmt.executeUpdate();
					pstmt.close();	
				}
				catch(Exception e) {
					System.out.println("Hata");
				}
			}
	
	public void KesimeGit(String isim, int sayi) {

		try {
			int stok=0;
			System.out.println("\nKesime gidecek �r�n:"+isim+" \nKesim miktar�:"+ sayi);
			String query = "SELECT miktar FROM cam1 WHERE camT�r�='" + isim + "'" ;
			rs = st.executeQuery(query);
			while(rs.next()) {
				stok = rs.getInt("miktar") ;
				System.out.println("Stok durumu:"+stok);
			}

			String sqlUpdate = "UPDATE cam1 " + "SET miktar = ? " + "WHERE camT�r� = ?";
			PreparedStatement pstmt = con.prepareStatement(sqlUpdate);	
		//	String t�r = isim;
			int miktar = (stok-sayi);
			System.out.println("�r�n kesime girdi");
			System.out.println("Yeni stok:"+miktar);
			 
			pstmt.setString(2, isim);
			pstmt.setInt(1, miktar);
			int rowAffected = pstmt.executeUpdate();
			pstmt.close();
			
		}
		
		catch(Exception e) {
			System.out.println("Hata");
		}
	}
	public void KesimiBitir(int siparisNo,String siparisAdi,String aciklama) {
		
		try {		
            	String sql = "INSERT INTO kesim " + "VALUES (' " + siparisNo + "',' " + siparisAdi+ " ',' " + aciklama+ " ')";

			PreparedStatement pstmt = con.prepareStatement(sql);	
            pstmt.executeUpdate(sql);
            System.out.println("Kesim ba�ar�yla bitirildi");
            System.out.println("Siparis No :"+siparisNo + "\nSipari� Ad�: " + siparisAdi+ "\nSipari� A��klamas�: " +aciklama );
            
			pstmt.close();
		}
		catch(Exception e) {
			System.out.println("Hata");
		}		
	}	
	
	
	public void birürünSetEt(String isim, int sayi) {
		
			try {
				String query1 = "select * from cam";
			//	System.out.println(query);
				rs = st.executeQuery(query1);
				
				System.out.println("\nEklenecek �r�n:"+isim);

				while(rs.next()) {
		     	int sto = rs.getInt("miktar") ;
			//	System.out.println("�r�n ismi:"+isim+"  Stok:"+sto);
				
				}
				String sqlUpdate = "UPDATE cam " + "SET miktar = ? " + "WHERE camT�r� = ?";
				PreparedStatement pstmt = con.prepareStatement(sqlUpdate);	
				String tür = isim;
		//		int sto = rs.getInt("miktar");
				int miktar = (sayi);
				System.out.println("miktar:"+miktar);
				 
				pstmt.setString(2, isim);
				pstmt.setInt(1, miktar);
				int rowAffected = pstmt.executeUpdate();
				pstmt.close();
				}
			
			catch(Exception e) {
				System.out.println("Hata");
			}
	}
	
	public void delete(int id) {
		 
        try {
        //	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/deneme1","root","password");
            PreparedStatement ps = con.prepareStatement(DELETE);
 
            ps.setInt(1, id);
 
            ps.executeUpdate();
            ps.close();
 
            System.out.println("User with id: " + id + " was sucesfully deleted from DB.");
 
        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
 
    }
}
