package reusableComponents;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.jsoup.Jsoup;

import testBase.ExtentFactory;
import testBase.ExtentReportNG;

public class MailUtil {

	ExtentReportNG extentReportNG = new ExtentReportNG();
	
	public String readMail() throws InterruptedException {
		Thread.sleep(10000);
		final String username = PropertiesOperations.getPropertyValueByKey("mailUserName");
		final String password = PropertiesOperations.getPropertyValueByKey("mailPassword");
		String plainText = null;

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "outlook.office365.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			Store store = session.getStore("imaps");

			store.connect("outlook.office365.com", username, password);

			// create the folder object and open it
			Folder emailFolder = store.getFolder("Junk Email");
			emailFolder.open(Folder.READ_ONLY);

			// retrieve the messages from the folder in an array and print it
			Message[] messages = emailFolder.getMessages();
			System.out.println("messages.length---" + messages.length);

			Message message = messages[messages.length - 1];

			plainText = Jsoup.parse(message.getContent().toString()).text();
			// close the store and folder objects
			emailFolder.close(false);
			store.close();

		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(plainText);
		return plainText;
	}

	 public void sendMail() throws InterruptedException {
//	public static void main(String[] args) throws InterruptedException {

		Thread.sleep(10000);
		final String username = PropertiesOperations.getPropertyValueByKey("mailUserName");
		final String password = PropertiesOperations.getPropertyValueByKey("mailPassword");
		final String recepient = PropertiesOperations.getPropertyValueByKey("mailRecepients");
		final String recepientCC = PropertiesOperations.getPropertyValueByKey("mailrecepientCC");
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "outlook.office365.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		// 2) compose message
		try {

			Store store = session.getStore("imaps");

			store.connect("outlook.office365.com", username, password);
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recepient));
//			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
			message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(recepientCC));
			message.setSubject("Message Alert");

			// 3) create MimeBodyPart object and set your message text
			BodyPart messageBodyPart1 = new MimeBodyPart();
			messageBodyPart1.setText("Hi Team, \n Please find attached automation report for reference.");

			// 4) create new MimeBodyPart object and set DataHandler object to this object
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();

//			String filename = "C:\\Users\\Pratik Nishi\\AutomationForRPS\\NEEE\\Reports\\ExecutionReport_17-12-2021 11-55-58.html";
			String filename = ExtentReportNG.getReportPath(ExtentReportNG.actualDate);// change accordingly
			DataSource source = new FileDataSource(filename);
			messageBodyPart2.setDataHandler(new DataHandler(source));
			messageBodyPart2.setFileName("Test Result_"+ExtentReportNG.actualDate+".html");

			// 5) create Multipart object and add MimeBodyPart objects to this object
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart1);
			multipart.addBodyPart(messageBodyPart2);

			// 6) set the multiplart object to the message object
			message.setContent(multipart);

			// 7) send message
			Transport.send(message);

			System.out.println("message sent....");
		} catch (MessagingException ex) {
			ex.printStackTrace();
		}
	}

	/*
	 * try { // Create a default MimeMessage object. Message message = new
	 * MimeMessage(session);
	 * 
	 * // Set From: header field of the header. message.setFrom(new
	 * InternetAddress("pmahajan@cogitate.us"));
	 * 
	 * // Set To: header field of the header.
	 * message.setRecipients(Message.RecipientType.TO,
	 * InternetAddress.parse("pmahajan@cogitate.us"));
	 * 
	 * // Set Subject: header field message.setSubject("Testing Subject");
	 * 
	 * // Create the message part BodyPart messageBodyPart = new MimeBodyPart();
	 * 
	 * // Now set the actual message
	 * messageBodyPart.setText("This is message body");
	 * 
	 * // Create a multipar message Multipart multipart = new MimeMultipart();
	 * 
	 * // Set text message part multipart.addBodyPart(messageBodyPart);
	 * 
	 * // Part two is attachment messageBodyPart = new MimeBodyPart(); String
	 * filename =
	 * "C:\\Users\\Pratik Nishi\\AutomationForRPS\\NEEE\\Reports\\ExecutionReport_15-12-2021 18-48-03.html"
	 * ; DataSource source = new FileDataSource(filename);
	 * messageBodyPart.setDataHandler(new DataHandler(source));
	 * messageBodyPart.setFileName(filename);
	 * multipart.addBodyPart(messageBodyPart);
	 * 
	 * // Send the complete message parts message.setContent(multipart);
	 * 
	 * // Send message Transport.send(message);
	 * 
	 * System.out.println("Sent message successfully....");
	 * 
	 * } catch (MessagingException e) { throw new RuntimeException(e); } }
	 */

}
