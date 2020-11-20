package model;
public abstract class Playlist {

	
	private String name;

	
	private Song[] songplay;
	private Genre[] genreplay;
	
	
	/**
	 * constructor method <br>
	 * <b> pre: we need the atributes </b> 
	 * @param name playlist name
	 */
	public Playlist(String name) {
	this.name = name;
	this.songplay = new Song[MCS.MAX_SONGS];
	this.genreplay = new Genre[7];
	}
	

	/**
	 * get method <br>
	 * <b> pre: constructor method </b> 
	 * @return playlist name
	 */
	public String getName() {
	return name;
	}

	

	/**
	 * set constructor <br>
	 * <b> pre: constructor method </b> 
	 * @param name playlist
	 */
	public void setName(String name) {

		this.name = name;
	}

	/**
	 * is in charge of verifying if the song was added correctly<br>
	 * <b> pre: we need the information of the song already created and that it has gone through the "addsongtoplaylist" methods in the main and in the MCS </b> 
	 * @param objsong song information
	 * @param objuser user information
	 * @return a message that say, if the song add to playlist correctly or not
	 */

	public String addSongtoplaylist(Song objsong, User objuser){
		String message = "";
		boolean addSong = false;
		for (int i= 0; i < MCS.MAX_SONGS && !addSong; i++){

			if(songplay[i] == null){
				addSong = true;

				songplay[i] = objsong;
				message = "Added the song correctly";

				//totalGenre();
			}
			return message;
		}

		if(addSong == false){
			message = "Could not create song in playlist";
		}
		return message;
	}


	/**
	 * add the durations of the songs and converts them into minutes and seconds<br>
	 * <b> pre: the user has entered the duration of the songs in seconds </b> 
	 * @return a message in which it shows the minutes and seconds that each song lasts
	 */
	public String timeSummary(){
		int sum=0;
		int num=0,min=0,seg=0;
        String message="";
		for (int i=0;i<songplay.length;i++){
			if (songplay[i] !=null)
				sum+=songplay[i].getTime();
		}

        num=sum;
        min=num/60;
        seg=num-(min*60);
        message=(": "+min+"m "+seg+"s\n");
   		return message;
	}

	/**
	 * add the genres of each of the songs to the playlist<br>
	 * <b> pre: the user has entered each of the genres of the songs </b> 
	 * @return a message in which the genres of the songs entered in that playlist are in the playlist
	 */
	public String totalGenre(){
		String message="";
		for (int i=0;i<songplay.length;i++){
			
			if (songplay[i] !=null){
				
				message+=(songplay[i].getGenre()+"; ");
			}
		}
		return message;
	}
	//______________________________________________________


	


	/**
	 * displays playlist information on screen<br>
	 * <b> pre: we need all the PUBLIC playlist information: title, during, and genre </b> 
	 * @return a message showing all the information of the playlist
	 */
	@Override
	public String toString(){
	
	String message=
		"\n *******Playlist********" +
		"\n Title: " + name +
		"\n During : " +(timeSummary())+
		"\n Genre: " + totalGenre()+
		"\n *************************";
		return message;
	}


}