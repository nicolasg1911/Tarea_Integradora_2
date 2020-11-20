package model;
public class MCS{

	
	public final static int MAX_SONGS = 50;
	public final static int MAX_PLAYLIST = 20;
	public final static int MAX_USER = 10;

	
	private Playlist[] playlist;
	private User[] user;
	private Song[] song;


	/**
	 * constructor method <br>
	 * <b> pre: we need the constants and relationships </b> 
	 */
	public MCS(){
		song = new Song [MAX_SONGS];
		user = new User [MAX_USER];
		playlist = new Playlist [MAX_PLAYLIST];
	}
	
	

	/**
	 * find the song we write <br>
	 * <b> pre: we need the songs to have already been created </b> 
	 * @param tittle song title
	 * @return the song the user is looking for
	 */
	public Song findSong(String tittle){
		Song objSearch=null;
		boolean findSo=false;
		for (int i=0;i<MAX_SONGS && !findSo;i++){
			if (song[i]!=null && song[i].getTittle().equalsIgnoreCase(tittle)){
				objSearch=song[i];
				findSo=true;	
			}
		}
		return objSearch;
	}
	
	/**
	 * find the user we write <br>
	 * <b> pre: we need users to have already been created </b> 
	 * @param nickname user nickname
	 * @return the user that user is looking for
	 */
	public User findUser(String nickname){
		User objSearch=null;
		boolean findUs=false;
		for (int i=0;i<MAX_USER && !findUs;i++){
			if (user[i]!=null && user[i].getName().equalsIgnoreCase(nickname)){
				objSearch=user[i];
				findUs=true;	
			}
		}
		return objSearch;
	}



	/**
	 * update the category in wich each user is located<br>
	 * <b> pre: a user created with your number of songs entered </b> 
	 * @param nickname= user name
	 */
	public void updateRank(String nickname){  
	    User objSearch = findUser(nickname); 
	    objSearch.setCategorynum(objSearch.getCategorynum()+1);

	    if(objSearch.getCategorynum() >=3 && objSearch.getCategorynum() < 10){

	        objSearch.setCategoryType(objSearch.convert("LITTLECONTRIBUTOR"));

	    }else if(objSearch.getCategorynum() >= 10 && objSearch.getCategorynum() < 30){

	        objSearch.setCategoryType(objSearch.convert("MILDCONTRIBUTOR"));

	    }else if(objSearch.getCategorynum() >= 30) {

	        objSearch.setCategoryType(objSearch.convert("STARCONTRIBUTOR"));
	    }

	}


	/**
	 * find the playlist we write <br>
	 * <b> pre: we need the playlist to have already been created, (can be; private, public, restricted) </b> 
	 * @param name playlist name
	 * @return the playlist taht user is looking for
	 */
	public Playlist findPlaylist(String name){
		Playlist objSearch=null;
		boolean finder=false;
		for (int i=0;i<MAX_PLAYLIST && !finder;i++){
			if (playlist[i]!=null && playlist[i].getName().equalsIgnoreCase(name)){
				objSearch=playlist[i];
				finder=true;	
			}
		}
		return objSearch;
	}
    
	/**
	 * add a new user <br>
	 * <b> pre: we need to know the nickname, age, and password of the user </b> 
	 * @param nickname user nickname
	 * @param age user age
	 * @param password user password
	 * @return a message, if the user could be created or could not be created
	 */
	public String addUser (String nickname, int age, String password ){
		String message="";
		boolean finder=false;
		User objSearch=findUser(nickname);
		if(objSearch!=null)
			message="Error, the user already exists";
		else{
			for (int i=0;i<MAX_USER && !finder;i++){
				if (user[i]==null){
					user[i]= new User (nickname, age, password);
					finder=true;
					message="The user has been registered";
				}
			}
			if (finder==false)
				message="limit is already exceeded";
		}
		return message;
	}
	
	/**
	 * add a new public playlist <br>
	 * <b> pre: we need the name of the playlist </b> 
	 * @param name playlist name
	 * @return a messag, if the public playlis could be created or could not be created
	 */
	public String addPlaylist(String name){
		String message="";
		boolean addPl=false;
		
		Playlist objSearch=findPlaylist(name);
		if(objSearch!=null)
			message="Error, the playlist already exists";
		else{
			for (int i=0;i<MAX_PLAYLIST && !addPl;i++){
				if (playlist[i]==null){
					playlist[i] = new Public(name);
					addPl=true;
					message="The playlist has been registered";
				}
			}
			if (addPl==false)
				message="limit is already exceeded";
		}
		return message;
	}
	
	/**
	 * saves the calification entered by each user from the PUBLIC playlist<br>
	 * <b> pre: the user or the users have entered the calification of the PUBLIC playlist </b> 
	 * @param calification= PUBLIC playlist calification
	 * @param name= playlist name
	 */
	public void calificationPublicPlaylist(double calification, String name){
    Playlist objecPlaylist = findPlaylist(name);
    if(objecPlaylist!=null){
           if(objecPlaylist instanceof Public){
               Public calificationPlaylist=(Public)objecPlaylist;

               calificationPlaylist.setCalification(calification);
           }
       }
	}
	
	
	
	/**
	 * add a new private playlist <br>
	 * <b> pre: we need the user nickname and the name of the playlist  </b> 
	 * @param name user name
	 * @param nameprivate private playlist name
	 * @return a messag, if the private playlis could be created or could not be created
	 */
	public String addPlaylist(String name, String nameprivate){
		String message="";
		boolean finder=false;
		User objuser = findUser(nameprivate);
		Playlist objSearch=findPlaylist(name);
		if(objSearch!=null)
			message="Error, the playlist already exists";
		else{
			for (int i=0;i<MAX_PLAYLIST && !finder;i++){
				if (playlist[i]==null){
					playlist[i]= new Private (name, objuser);
					finder=true;
					message="The playlist has been registered";
				}
			}
			if (finder==false)
				message="limit its already exceeded";
		}
		return message;
	}
	
	
	/**
	 * add a new restricted playlist <br>
	 * <b> pre: we need the playlist name and the name of up to 5 people  </b> 
	 * @param name user name
	 * @param resuser private playlist name 
	 * @return a messag, if the restricted playlis could be created or could not be created
	 */
	public String addPlaylist(String name, String[] resuser){
		String message="";
		boolean finder=false;
		Playlist objSearch=findPlaylist(name);
		if(objSearch !=null)
			message="Error. the playlist already exist";
		else{
			for (int i=0;i<MAX_PLAYLIST && !finder;i++){
				if (playlist[i]==null){
					playlist[i]= new Restricted (name, resuser);
					finder=true;
					message="The playlist has been registered";
				}
			}
			if (finder==false)
				message="All playlist are already created";
		}
		return message;
	}

	
	/**
	 * add a new song <br>
	 * <b> pre: we need the information of the song (name, artist, duration, release date and genre)  </b> 
	 * @param nickname nickname of the song
	 * @param duration duration of the song
	 * @param tittle tittle of the song
	 * @param artist artist song
	 * @param songGenre genre of the song
	 * @param date date of the song 
	 * @return a messag, if the song could be created or could not be created
	 */
	public String addSong (String nickname,int duration, String tittle,  String artist, String songGenre, String date ){
		User objuser=findUser(nickname);
		//objuser.addcategorynum();
		//objuser.updateCategory();
		String message="";
		boolean addSo=false;
		Song objSearch=findSong(tittle);
		if(objSearch!=null)
			message="Error. the song already exist";
		else{
			for (int i=0;i<MAX_SONGS && !addSo;i++){
				if (song[i]==null){
					song[i]=new Song (duration, tittle,  artist, songGenre, date);
					addSo=true;
					message="The song has been created";
				}
			}
			if (addSo==false)
				message="No more space to add songs";
		}
		return message;
	}
	
	
	/**
	 * add a song already created to a playlist already created<br>
	 * <b> pre: we need the name of the song already created, the username alredy created and the name of the playlist alredy created </b> 
	 * @param name playlist name
	 * @param nickname user nickname
	 * @param song song name
	 * @return a messag, if the song, the playlist or the user has not been created
	 */
	public String addSongtoplaylist(String name, String nickname, String song){
		String message ="";
		boolean validate = true;
		Playlist objplay = findPlaylist(name);
		User objuser = findUser(nickname);
		Song objsong = findSong(song);

		if(objplay == null || objuser ==null || objsong ==null){

			validate = false;
			if(objplay == null){
				message +="Doesn't exist a playlist with that name";
			}

			if(objuser == null){
				message += "Doesn't exist a user with that name";
			}
			if(objsong == null){
				message += "Doesn't exist a song with that name";
			}

          
          
		}
		else
			message =objplay.addSongtoplaylist(objsong,objuser);

		return message;
	}
	
   
	/**
	 * print the information if the user has been well created<br>
	 * <b> pre: have entered the user data correctly </b> 
	 * @return a message that say, if the user was created correctly or not
	 */
	public String showUsers(){
		String message="";
		for (int i=0;i<MAX_USER;i++){
			if (user[i] !=null){
				message+=user[i].toString();
			}
		}
		return message;
	}


	/**
	 * print the information if the song has been well created<br>
	 * <b> pre: have entered the song data correctly </b> 
	 * @return a message that say, if the song was created correctly or not
	 */
	public String showSongs(){
			String message="";
		for (int i=0;i<MAX_SONGS;i++){
			if (song[i] !=null){
				message+=song[i].toString();
			}
		}
		return message;
	}


	/**
	 * print the information if the playlist has been well created<br>
	 * <b> pre: have entered the playlist data correctly </b> 
	 * @return a message that say, if the playlist was created correctly or not
	 */
	public String showPlaylist(){
			String message="";
		for (int i=0;i<MAX_PLAYLIST;i++){
			if (playlist[i] !=null){
				message+=playlist[i].toString();
			}
		}
		return message;
	}




//______________________________________________________


	
}