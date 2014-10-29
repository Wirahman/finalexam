import id.web.skyforce.bank.model.Address;
import id.web.skyforce.bank.model.Customer;
import id.web.skyforce.bank.util.HibernateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MyBank {

			private static Session session;
			private static Transaction transaction;

			public static void main(String[] args) throws ParseException {

				Scanner input = new Scanner(System.in);
				int nomor = 0;
				
				while (nomor!=5){
					
					System.out.println("Management Alamat Pelanggan");
					System.out.println("===========================");
					System.out.println("1. Tambah Pelanggan");
					System.out.println("2. Ubah Alamat Pelanggan");
					System.out.println("3. Hapus Alamat Pelanggan");
					System.out.println("4. Daftar Alamat Pelanggan");
					System.out.println("5. Keluar");
					nomor = input.nextInt();
					
					if (nomor == 1){
						tambah();
					
						
					}
				}
				
			}
			
			public static void tambah() throws ParseException{
				session = (Session) HibernateUtil.openSession();
				transaction = session.beginTransaction();

				Scanner tambah = new Scanner(System.in);
				System.out.println("Menu Tambah Daftar Pelanggan");
				System.out.println("=============================");
				System.out.println("Masukkan Nomor ID Pelanggan");
				String idz = tambah.nextLine();
				int id = (int) Long.parseLong(idz);
				System.out.println("Masukkan Nama Depan Anda: ");
				String firstName = tambah.nextLine();
				System.out.println("Masukkan Nama Belakang Anda: ");
				String lastName = tambah.nextLine();
				System.out.println("Masukkan Jenis Kelamin Anda: ");
				String gender = tambah.nextLine();
				System.out.println("Masukkan Alamat Anda");
				String alamat = tambah.nextLine();
				System.out.println("Masukkan Kota Tempat Tinggal Anda");
				String kota = tambah.nextLine();
				System.out.println("Masukan Kode Pos Alamat Anda");
				String kodePos = tambah.nextLine();
				System.out.println("Masukkan Tanggal Lahir Anda (Masukkan dalam format (hari-bulan-tahun)) : ");
				String birthDate = tambah.nextLine();
				System.out.println("Masukkan Alamat E-mail Anda: ");
				String email = tambah.nextLine();
				System.out.println("Masukkan no.KTP Anda: ");
				String idNumber = tambah.nextLine();
				
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
				String ultahPars = birthDate;
				Date ultahParsing = formatter.parse(ultahPars);
				
				//Menghubungkan class CustomerManagement dengan class Customer dan Address
				Customer customer = new Customer();
				customer.setId(id);
				customer.setFirstName(firstName);
				customer.setLastName(lastName);
				customer.setGender(gender);
				customer.setBirthDate(birthDate);
				customer.setIdNumber(idNumber);
				
				Address address = new Address();
				address.setStreet(alamat);
				address.setCity(kota);
				address.setPostalCode(kodePos);
				
				session.save(customer);
				//session.save(address);
				transaction.commit();
				session.close();
				
				System.out.println("Selamat Bergabung "+firstName+" "+lastName);
			}
}
