package model;
public class Private extends Playlist{

	private String name;
	//Relation
	private User privUser;

	/**
	 * constructor method <br>
	 * <b> pre: we need the atributes: name, propietary </b> 
	 * @param name= playlist name
	 * @param privUser= user propietary
	 */
	public Private(String name, User privUser){
		super(name);
		this.privUser = privUser;
	}


	/**
	 * check if the song could be created or not, depending on whether the data is correct<br>
	 * <b> pre: we need the information of the song already created and that it has gone through the "addsongtoplaylist" methods in the main and in the MCS </b> 
	 * @param objsong song information
	 * @param objuser user information
	 * @return a message that say, if the song add to playlist correctly or not
	 */
	public String addSongtoplaylist(Song objsong, User objuser){
		String message = "";
		if(objuser.getName().equals(privUser.getName())){

			message = super.addSongtoplaylist(objsong, objuser);
		}else {
			message = "The song could not be created in the playlist because the user is not the owner of the playlist";
		}

		return message;
	}
	
	
	/**
	 * displays PRIVATE playlist information on screen<br>
	 * <b> pre: we need all the PRIVATE playlist information: title, during, ang genre </b> 
	 * @return a message showing all the information of the playlist
	 */
	@Override
	public String toString(){
	
	String message=
		"\n ******Private Playlist*****" +
		"\n Title: " + getName() +
		"\n During : " +(timeSummary())+
		"\n Genre: " + totalGenre()+
		"\n *************************";
		return message;
	}


}