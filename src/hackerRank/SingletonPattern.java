package hackerRank;

public class SingletonPattern {

	/**
	 * Create private static instance of the class
	 * Also create private default constructor
	 * The call this instance through static method to return the class object
	 */
	private static SingletonPattern instance = new SingletonPattern();
	
	private SingletonPattern() {
		// TODO Auto-generated constructor stub
	}
	
    static SingletonPattern getSingleInstance(){
        return instance;
    }
}
