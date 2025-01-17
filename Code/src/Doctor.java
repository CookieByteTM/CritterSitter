import javax.swing.*;
/**
 * The Doctor class is the class that creates the doctor.
 *
 * @author Jasmine Ou and Laura Wong
 * @version 3 05.29.15
 * 
 * <p>
 * <b>name: Doctor.java </b>
 *
 * <p>
 * <b>Instance variables: </b>
 * <p>
 * <b>diseases </b> This is a String array of the diseases that the doctor can give.
 * <p>
 * <b>gavePrescription </b> This is a boolean variable that indicates if the doctor has given a prescription or not.
 * <p>
 * <b>pharmacy </b> This is a String 2D array that stores the medecine according to the name of the disease.
 */
public class Doctor extends JPanel
{
  String [] diseases;
  boolean gavePrescription;
  String [][]pharmacy;
  JLabel doctor=new JLabel ("Doctor");
  
  public Doctor()
  {
    add(doctor);
  }
  
  /**
   * The writePrescription method is for the user to write a prescription to the critter to the designated disease.
   * 
   * @param disease This is a String variable of the name of the disease the doctor will prescribe.
   * 
   * @return prescription which is the String value of the prescription the doctor gives.
   */
  public String writePrescription(String disease)
  {
    String prescription = "";
    return prescription;
  }
  
  /**
   * The checkUpHealth method is used to calculate the health of the critter and get it's foodGroupCount.
   */
  public void checkUpHealth()
  {
    /*get Critter foodGroupCount info and calculate the health*/
  }
  
  /**
   * The reportToPatient method is used to display the text on screen on speech bubble of doctor based on health check results.
   */
  public void reportToPatient()
  {
    /*display text on screen on speech bubble of doctor based on health check results*/
  }
  
  /**
   * The talkToPatient method is a chatbot where the user can talk to the doctor.
   */
  public void talkToPatient()
  {
    /*chatbot answer patient questions*/
  }
  
}
