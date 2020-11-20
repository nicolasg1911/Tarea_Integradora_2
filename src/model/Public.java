package model;
public class Public extends Playlist{
	public static final int SCORING =5;
	
	private double[] calification= new double[SCORING];


	/**
	 * constructor method <br>
	 * <b> pre: we need the atribute: name </b> 
	 * @param name= playlist name
	 */
	public Public(String name){
		super(name);
		this.calification=calification;
	}
	
	/**
	 * set method <br>
	 * <b> pre: constructor method </b> 
	 * @param calification PUBLIC playlist calification
	 */
	public void setCalification(double acalification){
        boolean out=false;
        for(int i=0; i<SCORING && out!=true; i++){
            if(calification[i]==0.0){
                calification[i]=acalification;
                out=true;
            }
        }
    }

	/**
	 * calculates the average calification of the PUBLIC playlist<br>
	 * <b> pre: we need all the califications from 1 to 5 of the PUBLIC playlist </b> 
	 * @return average
	 */
	 public double calificationAverage(){
       double average=0;
       int count = 0;
       for(int i=0; i<SCORING; i++){
           if(calification[i] != 0.0){
               average+=calification[i];
               count++;
           }
       }
       return average/count;
     }

	/**
	 * add any song if it is already created, because it is public<br>
	 * <b> pre: we need the information of the song already created and that it has gone through the "addsongtoplaylist" methods in the main and in the MCS </b> 
	 * @param objsong song information
	 * @param objuser user information
	 * @return a message that say, if the song add to playlist correctly
	 */
	public String addSongtoplaylist(Song objsong, User objuser){
		String message = "";
		message = message = super.addSongtoplaylist(objsong, objuser);
		return message;
	}

	/**
	 * displays PUBLIC playlist information on screen<br>
	 * <b> pre: we need all the PUBLIC playlist information: title, during, genre and calification </b> 
	 * @return a message showing all the information of the playlist
	 */
	@Override
	public String toString(){
	
	String message=
		"\n ******Public Playlist*****" +
		"\n Title: " + getName() +
		"\n During : " +(timeSummary())+
		"\n Genre: " + totalGenre()+
		"\n Calification: " +calificationAverage ()+
		"\n *************************";
		return message;
	}
}